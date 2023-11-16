package com.sudal.home.domain.user.service;

import com.sudal.home.domain.user.dto.UserDto;
import com.sudal.home.domain.user.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserServiceImpl implements UserService{
    private final UserMapper userMapper;

	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public int idCheck(String userId) throws SQLException {
		return userMapper.idCheck(userId);
	}

	@Override
	public void joinUser(UserDto userDto) throws SQLException {
		userMapper.joinUser(userDto);
	}

	@Override
	public UserDto loginUser(String userId, String userPass) throws SQLException {
		System.out.println(userId + ":" + userPass);
		return userMapper.loginUser(userId, userPass);
	}

	@Override
	public int edit(UserDto userDto) throws SQLException {
		return userMapper.edit(userDto);
	}

	@Override
	public UserDto getUserInfo(String userId) throws SQLException {
		return userMapper.getUserInfo(userId);
	}


}
