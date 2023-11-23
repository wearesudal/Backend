package com.sudal.home.domain.user.mapper;

import com.sudal.home.domain.user.dto.TokenDto;
import com.sudal.home.domain.user.dto.UserDto;
import com.sudal.home.domain.user.dto.UserModifyDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;

@Mapper
public interface UserMapper {
    int idCheck(String userId) throws SQLException;
	void joinUser(UserDto userDto) throws SQLException;
//	UserDto selectByUserId(String userId)throws SQLException;
//	UserDto validateUserInfo(UserLoginDto userLoginDto) throws SQLException;
	void addUser(Integer userIdx)throws SQLException;
//	TokenDto loginUser(UserLoginDto userLoginDto) throws SQLException;
	void saveToken(TokenDto token)throws SQLException;

	void edit(UserModifyDto userModifyDto) throws SQLException;

	UserDto getUserInfoById(String userId) throws SQLException;
	UserDto getUserInfoByIdx(Integer userIdx) throws SQLException;
	Integer getUserIdxByToken (String token) throws SQLException;
}
