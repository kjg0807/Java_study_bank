package com.naver.start.bankMember;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.start.util.DBConnector;

@Repository("mydao") // 媛앹껜 �깮�꽦
public class BankMembersDAO implements MembersDAO
{
	@Autowired // 留뚮뱾�뼱吏� 媛앹껜瑜� 二쇱엯
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.naver.start.bankMember.BankMembersDAO."; // final - �긽�닔泥섎읆 �궗�슜 - 媛� 蹂�寃퐔

	public int setAddFile(BankMembersFileDTO bankMembersFileDTO) throws Exception
	{
		return sqlSession.insert(NAMESPACE + "setAddFile", bankMembersFileDTO);
	}

	@Override
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception
	{
		return sqlSession.selectOne(NAMESPACE + "getLogin", bankMembersDTO);
	}

	@Override
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception
	{
		// 1. DB�뿰寃� - 濡쒓렇�씤
		Connection DBConn = DBConnector.getConnection();
		// 2. regions�쓽 �뜲�씠�꽣 媛��졇�삤湲�
		String sql = "insert into bankmembers values(?,?,?,?,?)";
		// 3. Query臾� 誘몃━ �쟾�넚
		PreparedStatement st = DBConn.prepareStatement(sql);
		// 4. ? �쓽 媛� �꽭�똿
		st.setString(1, bankMembersDTO.getUserid());
		st.setString(2, bankMembersDTO.getPwd());
		st.setString(3, bankMembersDTO.getName());
		st.setString(4, bankMembersDTO.getEmail());
		st.setString(5, bankMembersDTO.getPhone());
		// 5. 理쒖쥌 �쟾�넚 �썑 寃곌낵瑜� 泥섎━
		int rs = st.executeUpdate();

		DBConnector.disConnect(st, DBConn);

		return rs;
	}

	@Override
	public List<BankMembersDTO> getSearchByID(String search) throws Exception
	{// 寃��깋�븯�젮硫� () �븞�뿉 -> String search
		// 1. DB�뿰寃� - 濡쒓렇�씤
		Connection DBConn = DBConnector.getConnection();
		// 2. regions�쓽 �뜲�씠�꽣 媛��졇�삤湲�
		String sql = "select * from bankmembers where name like ? order by name desc";
		// �쟾泥� 異쒕젰 -> select * from bankmembers where userid = ? -> 寃��깋
		// 3. Query臾� 誘몃━ �쟾�넚
		PreparedStatement st = DBConn.prepareStatement(sql);
		// 4. ? �쓽 媛� �꽭�똿
		st.setString(1, "%" + search + "%"); // 寃��깋�븯�젮硫� 二쇱꽍 �빐�젣
		// 5. 理쒖쥌 �쟾�넚 �썑 寃곌낵瑜� 泥섎━
		ResultSet rs = st.executeQuery();

		ArrayList<BankMembersDTO> ar = new ArrayList();
		while (rs.next())
		{
			BankMembersDTO bankMembersDTO = new BankMembersDTO();
			bankMembersDTO.setUserid(rs.getString("userid"));
			bankMembersDTO.setPwd(rs.getString("pwd"));
			bankMembersDTO.setName(rs.getString("name"));
			bankMembersDTO.setEmail(rs.getString("email"));
			bankMembersDTO.setPhone(rs.getString("phone"));
			ar.add(bankMembersDTO);

			System.out.println("USERID: " + bankMembersDTO.getUserid() + ", PWD: " + bankMembersDTO.getPwd() + ", NAME: " + bankMembersDTO.getName()
					+ ", Email: " + bankMembersDTO.getEmail() + ", PHONE: " + bankMembersDTO.getPhone());
			// System.out.println("Name: " + bankMembersDTO.getName());
		}
		DBConnector.disConnect(rs, st, DBConn);

		return ar;

		// return sqlSession.selectList(NAMESPACE + "getSearchByID" + search);
		// (NAMESPACE + "getSearchByID" + search)
	}

	// login
	public BankMembersDTO getLoginTest(BankMembersDTO bankMembersDTO) throws Exception
	{
		return sqlSession.selectOne(NAMESPACE + "getLoginTest", bankMembersDTO);
	}

	// join
	public int setJoinTest(BankMembersDTO bankMembersDTO) throws Exception
	{
		return sqlSession.insert(NAMESPACE + "setJoinTest", bankMembersDTO);
	}

	// search
	public List<BankMembersDTO> getSearchTest(String string)
	{
		ArrayList<BankMembersDTO> ar = new ArrayList<BankMembersDTO>();

		return ar;
	}

	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO) throws Exception
	{
		return sqlSession.selectOne(NAMESPACE + "getMyPage", bankMembersDTO);
	}
}
