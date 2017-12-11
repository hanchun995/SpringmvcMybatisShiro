package com.duowan.service;

import com.duowan.pojo.User;

public interface UserService {
	public User findByNameAndPwd(String uSERNAME, String pASSWORD);
}
