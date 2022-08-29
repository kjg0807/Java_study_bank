package com.naver.start.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager
{
	// 1번 방법
	// autowired 쓰고 개발자가 직접 만들면 적용안됨
	// @Autowired
	// private ServletContext servletContext;

	// save
	public String saveFile(ServletContext servletContext, String path, MultipartFile multipartFile) throws Exception
	{ // 2번 servlet 직접 선언
		// 1. 실제 경로
		String realPath = servletContext.getRealPath(path); // path : 서비스에서 입력한 경로 가져옴
		// 다른 클래스의 realPath를 가져오기 위해 servletcontext 선언
		System.out.println(realPath);

		// 2. 폴더(directory) 체크
		File file = new File(realPath);

		if (!file.exists()) // 파일이 존재하지 않으면
		{
			file.mkdirs();
		}

		// 3. 저장할 파일명 생성
		String fileName = UUID.randomUUID().toString();
		fileName = fileName + "_" + multipartFile.getOriginalFilename();

		// 4. HDD 저장
		file = new File(file, fileName);
		multipartFile.transferTo(file);

		return fileName;
	}
}
