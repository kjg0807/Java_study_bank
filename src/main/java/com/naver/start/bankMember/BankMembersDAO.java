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

@Repository("mydao") // 揶쏆빘猿� 占쎄문占쎄쉐
public class BankMembersDAO implements MembersDAO
{
	@Autowired // 筌띾슢諭억옙堉깍쭪占� 揶쏆빘猿쒐몴占� 雅뚯눘�뿯
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.naver.start.bankMember.BankMembersDAO."; // final - 占쎄맒占쎈땾筌ｌ꼶�쓥 占쎄텢占쎌뒠 - 揶쏉옙 癰귨옙野껎릶

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
		// 1. DB占쎈염野껓옙 - 嚥≪뮄�젃占쎌뵥
		Connection DBConn = DBConnector.getConnection();
		// 2. regions占쎌벥 占쎈쑓占쎌뵠占쎄숲 揶쏉옙占쎌죬占쎌궎疫뀐옙
		String sql = "insert into bankmembers values(?,?,?,?,?)";
		// 3. Query�눧占� 沃섎챶�봺 占쎌읈占쎈꽊
		PreparedStatement st = DBConn.prepareStatement(sql);
		// 4. ? 占쎌벥 揶쏉옙 占쎄쉭占쎈샒
		st.setString(1, bankMembersDTO.getUserid());
		st.setString(2, bankMembersDTO.getPwd());
		st.setString(3, bankMembersDTO.getName());
		st.setString(4, bankMembersDTO.getEmail());
		st.setString(5, bankMembersDTO.getPhone());
		// 5. 筌ㅼ뮇伊� 占쎌읈占쎈꽊 占쎌뜎 野껉퀗�궢�몴占� 筌ｌ꼶�봺
		int rs = st.executeUpdate();

		DBConnector.disConnect(st, DBConn);

		return rs;
	}

	@Override
	public List<BankMembersDTO> getSearchByID(String search) throws Exception
	{// 野껓옙占쎄퉳占쎈릭占쎌젻筌롳옙 () 占쎈툧占쎈퓠 -> String search
		// 1. DB占쎈염野껓옙 - 嚥≪뮄�젃占쎌뵥
		Connection DBConn = DBConnector.getConnection();
		// 2. regions占쎌벥 占쎈쑓占쎌뵠占쎄숲 揶쏉옙占쎌죬占쎌궎疫뀐옙
		String sql = "select * from bankmembers where name like ? order by name desc";
		// 占쎌읈筌ｏ옙 �빊�뮆�젾 -> select * from bankmembers where userid = ? -> 野껓옙占쎄퉳
		// 3. Query�눧占� 沃섎챶�봺 占쎌읈占쎈꽊
		PreparedStatement st = DBConn.prepareStatement(sql);
		// 4. ? 占쎌벥 揶쏉옙 占쎄쉭占쎈샒
		st.setString(1, "%" + search + "%"); // 野껓옙占쎄퉳占쎈릭占쎌젻筌롳옙 雅뚯눘苑� 占쎈퉸占쎌젫
		// 5. 筌ㅼ뮇伊� 占쎌읈占쎈꽊 占쎌뜎 野껉퀗�궢�몴占� 筌ｌ꼶�봺
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
