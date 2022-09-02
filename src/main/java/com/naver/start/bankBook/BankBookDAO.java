package com.naver.start.bankBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;

import com.naver.start.util.DBConnector;

@Repository
public class BankBookDAO implements BookDAO
{

	// Bankbook table�뿉 Insert
	// BookNum: �쁽�옱�떆媛꾩쓣 諛�由ъ꽭而⑥쫰濡� 蹂��솚�빐�꽌 �엯�젰
	// BookSale : 1濡� �엯�젰
	@Override
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception
	{
		// 1. DB�뿰寃� - 濡쒓렇�씤
		Connection DBConn = DBConnector.getConnection();
		// 2. regions�쓽 �뜲�씠�꽣 媛��졇�삤湲�
		String sql = "insert into bankbook values(?, ?, ?, ?)";
		// 3. Query臾� 誘몃━ �쟾�넚
		PreparedStatement st = DBConn.prepareStatement(sql);
		// 4. ? �쓽 媛� �꽭�똿
		st.setLong(1, bankBookDTO.getBookNum());
		st.setString(2, bankBookDTO.getBookName());
		st.setDouble(3, bankBookDTO.getBookRate());
		st.setInt(4, bankBookDTO.getBookSale());
		// 5. 理쒖쥌 �쟾�넚 �썑 寃곌낵瑜� 泥섎━
		int rs = st.executeUpdate();

		System.out.println("BookNum: " + bankBookDTO.getBookNum() + ", BookName: " + bankBookDTO.getBookName() + ", BookRate: "
				+ bankBookDTO.getBookRate() + ", BookSale: " + bankBookDTO.getBookSale());

		DBConnector.disConnect(st, DBConn);

		return rs;
	}

	// bankbook 紐⑤뱺 �뜲�씠�꽣 議고쉶 - 理쒖떊�닚�쑝濡�
	@Override
	public ArrayList<BankBookDTO> getList() throws Exception
	{
		// 1. DB�뿰寃� - 濡쒓렇�씤
		Connection DBConn = DBConnector.getConnection();
		// 2. regions�쓽 �뜲�씠�꽣 媛��졇�삤湲�
		String sql = "select * from bankbook order by booknum desc";
		// 3. Query臾� 誘몃━ �쟾�넚
		PreparedStatement st = DBConn.prepareStatement(sql);
		// 4. ? �쓽 媛� �꽭�똿
		// 5. 理쒖쥌 �쟾�넚 �썑 寃곌낵瑜� 泥섎━
		ResultSet rs = st.executeQuery();

		ArrayList<BankBookDTO> ar = new ArrayList();
		BankBookDTO bankBookDTO = null;
		while (rs.next())
		{
			bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookNum(rs.getInt("booknum"));
			bankBookDTO.setBookName(rs.getString("bookname"));
			bankBookDTO.setBookRate(rs.getDouble("bookrate"));
			bankBookDTO.setBookSale(rs.getInt("booksale"));
			ar.add(bankBookDTO);

			// System.out.println("BookNum: " + bankBookDTO.getBookNum() + ", BookName: " + bankBookDTO.getBookName() + ", BookRate: "
			// + bankBookDTO.getBookRate() + ", BookSale: " + bankBookDTO.getBookSale());
		}

		DBConnector.disConnect(rs, st, DBConn);

		return ar;
	}

	// Sale�쓽 媛� 蹂�寃�
	@Override
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception
	{
		// 1. DB�뿰寃� - 濡쒓렇�씤
		Connection DBConn = DBConnector.getConnection();
		// 2. regions�쓽 �뜲�씠�꽣 媛��졇�삤湲�
		String sql = "update bankbook set booksale = 0 where booknum = ?";
		// 3. Query臾� 誘몃━ �쟾�넚
		PreparedStatement st = DBConn.prepareStatement(sql);
		// 4. ? �쓽 媛� �꽭�똿
		st.setLong(1, bankBookDTO.getBookNum());
		// 5. 理쒖쥌 �쟾�넚 �썑 寃곌낵瑜� 泥섎━
		int rs = st.executeUpdate();

		// 6. �뿰寃� �빐�젣
		DBConnector.disConnect(st, DBConn);

		return rs;
	}

	// bookNum 媛믪쑝濡� 議고쉶
	@Override
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception
	{
		// 1. DB�뿰寃� - 濡쒓렇�씤
		Connection DBConn = DBConnector.getConnection();
		// 2. regions�쓽 �뜲�씠�꽣 媛��졇�삤湲�
		String sql = "select * from bankbook where bookNum = ?";
		// �쟾泥� 異쒕젰 -> select * from bankmembers where userid = ? -> 寃��깋
		// 3. Query臾� 誘몃━ �쟾�넚
		PreparedStatement st = DBConn.prepareStatement(sql);
		// 4. ? �쓽 媛� �꽭�똿
		st.setLong(1, bankBookDTO.getBookNum());
		// st.setString(1, "%" + search + "%"); // 寃��깋�븯�젮硫� 二쇱꽍 �빐�젣
		// 5. 理쒖쥌 �쟾�넚 �썑 寃곌낵瑜� 泥섎━
		ResultSet rs = st.executeQuery();

		// BankBookDTO bankBookDTO2 = null;
		if (rs.next())
		{
			// bankBookDTO2 = new BankBookDTO();
			bankBookDTO.setBookNum(rs.getInt("booknum"));
			bankBookDTO.setBookName(rs.getString("bookname"));
			bankBookDTO.setBookRate(rs.getDouble("bookrate"));
			bankBookDTO.setBookSale(rs.getInt("booksale"));
		}

		// System.out.println("BookNum: " + bankBookDTO.getBookNum() + ", BookName: " + bankBookDTO.getBookName() + ", BookRate: "
		// + bankBookDTO.getBookRate() + ", BookSale: " + bankBookDTO.getBookSale());

		DBConnector.disConnect(rs, st, DBConn);

		return bankBookDTO;
	}

	@Override
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception
	{
		// 1. DB�뿰寃� - 濡쒓렇�씤
		Connection DBConn = DBConnector.getConnection();
		// 2. regions�쓽 �뜲�씠�꽣 媛��졇�삤湲�
		String sql = "update bankbook set bookname = ?, bookrate = ? where booknum = ?";
		// 3. Query臾� 誘몃━ �쟾�넚
		PreparedStatement st = DBConn.prepareStatement(sql);
		// 4. ? �쓽 媛� �꽭�똿
		st.setString(1, bankBookDTO.getBookName());
		st.setDouble(2, bankBookDTO.getBookRate());
		st.setLong(3, bankBookDTO.getBookNum());
		// 5. 理쒖쥌 �쟾�넚 �썑 寃곌낵瑜� 泥섎━
		int rs = st.executeUpdate();

		// 6. �뿰寃� �빐�젣
		DBConnector.disConnect(st, DBConn);

		return rs;
	}

	@Override
	public int setDelete(BankBookDTO bankBookDTO) throws Exception
	{
		// 1. DB�뿰寃� - 濡쒓렇�씤sss
		Connection DBConn = DBConnector.getConnection();
		// 2. regions�쓽 �뜲�씠�꽣 媛��졇�삤湲�
		String sql = "delete bankbook where booknum = ?";
		// 3. Query臾� 誘몃━ �쟾�넚
		PreparedStatement st = DBConn.prepareStatement(sql);
		// 4. ? �쓽 媛� �꽭�똿
		st.setLong(1, bankBookDTO.getBookNum());
		// 5. 理쒖쥌 �쟾�넚 �썑 寃곌낵瑜� 泥섎━
		int rs = st.executeUpdate();

		// 6. �뿰寃� �빐�젣
		DBConnector.disConnect(st, DBConn);

		return rs;
	}

}
