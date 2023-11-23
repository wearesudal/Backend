package com.sudal.home.domain.user.service;

import com.sudal.home.common.BaseException;
import com.sudal.home.common.ResponseCode;
import com.sudal.home.domain.user.dto.*;
import com.sudal.home.domain.user.mapper.UserMapper;
import com.sudal.home.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

	private final UserMapper userMapper;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final TokenProvider tokenProvider;
	private final HttpSession session;

	@Override
	public int idCheck(String userId) throws SQLException {
		return userMapper.idCheck(userId);
	}

	@Override
	public void joinUser(UserDto userDto) throws SQLException {
		if (idCheck(userDto.getUserId()) == 1) {
			throw new BaseException(ResponseCode.USER_DUPLICATE);
		}
		// 토큰 정보 추가해야도이 ..?
		UserDto user = UserDto.builder()
						.userName(userDto.getUsername())
						.userId(userDto.getUserId())
						.userPass(bCryptPasswordEncoder.encode(userDto.getUserPass()))
						.userEmail(userDto.getUserEmail())
						.build();

		userMapper.joinUser(user);
		UserDto uDto = userMapper.getUserInfoById(user.getUserId());
		userMapper.addUser(uDto.getUserIdx());
	}

	// 입력받은 유저정보 - DB 정보 맞는지 확인
//	public UserDto validateUserInfo(UserLoginDto userLoginDto) throws SQLException {
//		System.out.println(userLoginDto);
//		return userMapper.validateUserInfo(userLoginDto);
//	}

	// 토큰 생성용 (response로 토큰을 보냄)
	@Override
	public TokenDto loginUser(UserLoginDto userLoginDto) throws SQLException {
		String userId = userLoginDto.getUserId();
		String userPass = userLoginDto.getUserPass();
		if (userId == null || userPass == null) {
			throw new RuntimeException("다시 입력해주세요.");
		}

		UserDto uDto = userMapper.getUserInfoById(userLoginDto.getUserId());

		if(uDto == null)
			throw new BaseException(ResponseCode.USER_NOT_EXIST);

		// DB에 저장된 비밀번호와 입력 받은 비밀번호 비교
		if (!bCryptPasswordEncoder.matches(userPass, uDto.getUserPass()))
			throw new RuntimeException("비밀번호가 다릅니다.");

		//토큰 발급 및 DB저장
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Integer uIndex = uDto.getUserIdx();
		TokenDto token  = new TokenDto(tokenProvider.createToken(authentication, uIndex), uIndex);
		userMapper.saveToken(token);
		System.out.println(userLoginDto);
		System.out.println(token);

		return token;
	}

	@Override
	public void edit(UserModifyRequestDto userModifyRequestDto, Integer userIdx) throws SQLException {
		//현재 사용자 토큰으로 userIdx 추출 --> userIdx로 user 확인
		System.out.println(userModifyRequestDto);
		UserModifyDto userModifyDto = UserModifyDto.builder()
												.userIdx(userIdx)
												.userName(userModifyRequestDto.getUserName())
												.userPass(bCryptPasswordEncoder.encode(userModifyRequestDto.getUserPass()))
												.userEmail(userModifyRequestDto.getUserEmail())
												.build();
		userMapper.edit(userModifyDto);
		System.out.println("수정 성공 : " + userIdx + " " + userModifyDto);
	}

	@Override
	public UserDto getUserInfoByIdx(Integer userIdx) throws SQLException {
		return userMapper.getUserInfoByIdx(userIdx);
	}

}
