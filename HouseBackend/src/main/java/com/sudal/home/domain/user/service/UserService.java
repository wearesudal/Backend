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
	void edit(UserModifyRequestDto userModifyRequestDto, Integer userIdx) throws SQLException;
	//UserDto getUserInfoById(String userId) throws SQLException;
	UserDto getUserInfoByIdx(Integer userIdx) throws SQLException;
	Integer getUserIdxByToken (String token) throws SQLException;
}
