package com.sudal.home.domain.user.service;

import com.sudal.home.domain.user.dto.TokenDto;
import com.sudal.home.domain.user.dto.UserDto;
import com.sudal.home.domain.user.dto.UserLoginDto;
import com.sudal.home.domain.user.dto.UserModifyRequestDto;

import java.sql.SQLException;

public interface UserService {
    int idCheck(String userId) throws SQLException;
	void joinUser(UserDto userDto) throws SQLException;
	TokenDto loginUser(UserLoginDto userLoginDto) throws SQLException;
	void edit(UserModifyRequestDto userModifyRequestDto) throws SQLException;
	UserDto getUserInfo(String userId) throws SQLException;

}
