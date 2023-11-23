package com.sudal.home.domain.user.controller;

import com.sudal.home.domain.user.dto.TokenDto;
import com.sudal.home.domain.user.dto.UserDto;
import com.sudal.home.domain.user.dto.UserLoginDto;
import com.sudal.home.domain.user.dto.UserModifyRequestDto;
import com.sudal.home.domain.user.service.UserService;
import com.sudal.home.jwt.TokenProvider;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;
	private final HttpSession session;
	private final TokenProvider tokenProvider;


	@ApiOperation(value = "회원 등록", notes = "입력한 사용자 정보를 바탕으로 회원 등록을 진행합니다.")
	@PostMapping("/signup")
	private void join(@RequestBody UserDto userDto) throws Exception {
		userService.joinUser(userDto);
		//return ResponseEntity.ok("success join");
	}

	@ApiOperation(value = "로그인", notes = "아이디와 비밀번호를 입력하여 로그인 합니다.")
	@PostMapping("/login")
	private TokenDto login(@RequestBody UserLoginDto userLoginDto) throws Exception {
		return userService.loginUser(userLoginDto);
	}

	//로그아웃 시 토큰으로 사용자 확인하도록 .. .
	@ApiOperation(value = "로그아웃", notes = "로그인한 상태에서 로그아웃을 수행합니다.")
	@PostMapping("/logout")
	private ResponseEntity<?> logout(@RequestHeader("Authorization") String accessToken) {
		return ResponseEntity.ok("로그아웃 되었습니다.");
	}

	@ApiOperation(value = "회원 정보 수정", notes = "로그인한 상태에서 회원 정보를 수정합니다. 로그인이 되어있어야 합니다.")
	@PutMapping("/edit")
	private ResponseEntity<?> edit(@RequestHeader("Authorization") String accessToken, @RequestBody UserModifyRequestDto userModifyRequestDto) throws Exception {
		Integer userIdx = tokenProvider.getUserIdx(accessToken);
		userService.edit(userModifyRequestDto, userIdx);
		return ResponseEntity.ok("회원 정보가 수정되었습니다.");
	}

	@ApiOperation(value = "회원 정보 조회", notes = "로그인한 상태에서 회원 정보를 조회합니다. 로그인이 되어있어야 합니다.")
	@GetMapping("/info")
	private ResponseEntity<?> getUserInfo(@RequestHeader("Authorization") String accessToken) throws Exception {
		System.out.println("token : " + accessToken);
		//logger.info("발급된 accessToken 확인 " + token);
		Integer userIdx = tokenProvider.getUserIdx(accessToken);
		logger.info("USER IDX: " + userIdx);
		UserDto userDto = userService.getUserInfoByIdx(userIdx);
		return ResponseEntity.ok(userDto);
	}

}
