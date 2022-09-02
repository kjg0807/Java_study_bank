package com.naver.start.bankAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.start.bankMember.BankMembersDTO;
import com.naver.start.util.DBConnector;

@Repository
public class BankAccountsDAO
{
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.naver.start.bankAccount.BankAccountsDAO.";

	public int add(BankAccountDTO bankAccountDTO) throws Exception
	{
		Connection con = DBConnector.getConnection();
		// 2. regions占쎌벥 占쎈쑓占쎌뵠占쎄숲 揶쏉옙占쎌죬占쎌궎疫뀐옙
		String sql = "insert into bankaccount values(account_seq.nextval, ?, ?, sysdate)";
		// 3. Query�눧占� 沃섎챶�봺 占쎌읈占쎈꽊
		PreparedStatement st = con.prepareStatement(sql);
		// 4. ? 占쎌벥 揶쏉옙 占쎄쉭占쎈샒
		st.setString(1, bankAccountDTO.getUserID());
		st.setLong(2, bankAccountDTO.getBookNum());
		// 5. 筌ㅼ뮇伊� 占쎌읈占쎈꽊 占쎌뜎 野껉퀗�궢�몴占� 筌ｌ꼶�봺
		int rs = st.executeUpdate();

		DBConnector.disConnect(st, con);

		return rs;
	}

	// public List<BankAccountDTO> getListByUserName(BankMembersDTO bankMembersDTO) throws Exception
	// {
	// return sqlSession.selectList(NAMESPACE + "getListByUserName", bankMembersDTO);
	// }

	public List<BankAccountDTO> getListByUserName(BankMembersDTO bankMembersDTO) throws Exception
	{
		return sqlSession.selectList(NAMESPACE + "getListByUserName", bankMembersDTO);
	}
}
