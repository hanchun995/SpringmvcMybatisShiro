package com.duowan.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.duowan.mapper.UserMapper;
import com.duowan.pojo.User;
import com.duowan.service.UserService;


@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper usermapper;

	@Override
	public User findByNameAndPwd(String uSERNAME, String pASSWORD) {
		User user=new User();
		user.setUsername(uSERNAME);
		user.setPassword(pASSWORD);
		return usermapper.findByNameAndPassword(user);
	}
}
