package com.naver.start.bankAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.naver.start.util.DBConnector;

public class BankAccountsDAO
{
	public int add(BankAccountDTO bankAccountDTO) throws Exception
	{
		Connection con = DBConnector.getConnection();
		// 2. regions의 데이터 가져오기
		String sql = "insert into bankaccounts values(account_seq.nextval, ?, ?, sysdate)";
		// 3. Query문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		// 4. ? 의 값 세팅
		st.setString(1, bankAccountDTO.getUserID());
		st.setLong(2, bankAccountDTO.getBookNum());
		// 5. 최종 전송 후 결과를 처리
		int rs = st.executeUpdate();

		DBConnector.disConnect(st, con);

		return rs;
	}
}
