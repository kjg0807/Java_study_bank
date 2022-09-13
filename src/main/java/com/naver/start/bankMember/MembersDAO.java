package com.naver.start.bankMember;

import java.util.List;

public interface MembersDAO
{
	// bankMembers �쉶�썝媛��엯
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception;

	// 寃��깋�뼱瑜� �엯�젰�빐�꽌 ID瑜� 李얘린
	public List<BankMembersDTO> getSearchByID(String search) throws Exception;

	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception;

	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO) throws Exception;
}
