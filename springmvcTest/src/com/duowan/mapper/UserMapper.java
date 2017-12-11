package com.duowan.mapper;

import com.duowan.pojo.User;

public interface UserMapper {
	public User findByNameAndPassword(User user);
}
