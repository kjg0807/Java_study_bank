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
	private final String NAMESPACE = "com.naver.start.bankAccount.BankAccountsDAO";

	public int add(BankAccountDTO bankAccountDTO) throws Exception
	{
		Connection con = DBConnector.getConnection();
		// 2. regions�쓽 �뜲�씠�꽣 媛��졇�삤湲�
		String sql = "insert into bankaccount values(account_seq.nextval, ?, ?, sysdate)";
		// 3. Query臾� 誘몃━ �쟾�넚
		PreparedStatement st = con.prepareStatement(sql);
		// 4. ? �쓽 媛� �꽭�똿
		st.setString(1, bankAccountDTO.getUserID());
		st.setLong(2, bankAccountDTO.getBookNum());
		// 5. 理쒖쥌 �쟾�넚 �썑 寃곌낵瑜� 泥섎━
		int rs = st.executeUpdate();

		DBConnector.disConnect(st, con);

		return rs;
	}

	public List<BankAccountDTO> getListByUserName(BankMembersDTO bankMembersDTO) throws Exception
	{
		return sqlSession.selectList(NAMESPACE + "getListByUserName", bankMembersDTO);
	}
}
