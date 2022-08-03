package com.naver.start.bank;

import java.util.Date;

public class BankTradeDTO
{
	private int tradeNum; // auto increments
	private int tradeAmount; // 거래 금액
	private int tradeBalance; // 거래 후 금액
	private Date tradeDate; // 거래일
	private boolean tradeIO; // input, output
	private int accountNum; // 일련번호
}
