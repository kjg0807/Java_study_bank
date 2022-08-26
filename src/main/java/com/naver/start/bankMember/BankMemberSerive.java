package com.naver.start.bankMember;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.naver.start.bankAccount.BankAccountDTO;
import com.naver.start.bankAccount.BankAccountsDAO;

@Service // 객체 생성, Service 역할
@Repository("myservice") // 객체 생성, DAO 역할
public class BankMemberSerive
{
	@Autowired
	@Qualifier("mydao")
	private BankMembersDAO bankMembersDAO;
	@Autowired
	private ServletContext servletContext;

	@Autowired
	private BankAccountsDAO bankAccountsDAO;

	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception
	{
		return bankMembersDAO.getLogin(bankMembersDTO);
	}

	public int setJoin(BankMembersDTO bankMembersDTO, MultipartFile photo) throws Exception
	{
		int rs = bankMembersDAO.setJoin(bankMembersDTO);
		// 1. HDD에 파일 저장
		// - 파일 저장시 경로는 Tomcat기준이 아니라 OS의 기준으로 설정
		// 1) 파일 저장 위치
		// /resources/upload/member
		// 2) 저장할 폴더의 실제경로 반환(OS 기준)
		String realPath = servletContext.getRealPath("resources/upload/member");		
		System.out.println("RealPath: " + realPath);
		// 3) 저장할 폴더의 정보를 가지는 자바 객체 생성
		File file = new File(realPath);
		// System.out.println(file.isDirectory());
		// System.out.println(file.exists());

		// *** file 첨부가 없을 때 구분 ***
		if (!photo.isEmpty()) // true false 있는지 없는지, !photo.isEmpty() -> photo가 비어있지 않다
		{
			if (!file.exists())
			{
				file.mkdirs(); // mkdir하면 member만 만들어짐 mkdirs하면 upload/member만듬
			}
			// 4) 중복되지 않는 파일명 생성
			// -- Time, Java API...
			String fileName = UUID.randomUUID().toString();
			// System.out.println(fileName);

			Calendar ca = Calendar.getInstance();
			Long time = ca.getTimeInMillis();
			System.out.println(time);

			fileName = fileName + "_" + photo.getOriginalFilename();
			System.out.println(fileName);

			// 2. HDD에 파일 저장 방법
			// 어느 폴더에 어떤 이름으로 저장할 File 객체 생성
			file = new File(file, fileName);
			// 1) MultipartFile 클래스의 transferInTo 메서드 이용
			photo.transferTo(file);
			// 2) FileCopyUtils 클래스의 copy 메서드 이용

			// 3. 저장된 파일 정보를 DB에 저장
			BankMembersFileDTO bankMembersFileDTO = new BankMembersFileDTO();
			bankMembersFileDTO.setUserid(bankMembersDTO.getUserid());
			bankMembersFileDTO.setFileName(fileName);
			bankMembersFileDTO.setOriName(photo.getOriginalFilename());
			bankMembersDAO.setAddFile(bankMembersFileDTO);
		}
		return rs;
		// return 0;
	}

	public List<BankMembersDTO> getSearchByID(String search) throws Exception
	{
		return bankMembersDAO.getSearchByID(search);
	}

	// Map<String, Object>
	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO) throws Exception
	{
		// Map<String, Object> map = new HashMap<String, Object>();
		// List<BankAccountDTO> ar = bankAccountsDAO.getListByUserName(bankMembersDTO);
		// bankMembersDTO = bankMembersDAO.getMyPage(bankMembersDTO);
		// map.put("list", ar);
		// map.put("dto", bankMembersDTO);
		//
		// return map;

		return bankMembersDAO.getMyPage(bankMembersDTO);
	}
	// public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO) throws Exception
	// {
	// return bankMembersDAO.getMyPage(bankMembersDTO);
	// }
}
