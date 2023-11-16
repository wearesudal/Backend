package com.sudal.home.domain.user.mapper;

import com.sudal.home.domain.user.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;

@Mapper
public interface UserMapper {
    int idCheck(String userId) throws SQLException;
	void joinUser(UserDto userDto) throws SQLException;
	UserDto loginUser(@Param("userId") String userId, @Param("userPass") String userPass) throws SQLException;
	int edit(UserDto userDto) throws SQLException;
	UserDto getUserInfo(String userId) throws SQLException;

}
