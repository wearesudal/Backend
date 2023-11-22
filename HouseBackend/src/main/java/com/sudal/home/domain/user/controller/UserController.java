package com.sudal.home.domain.user.controller;

import com.sudal.home.domain.user.dto.TokenDto;
import com.sudal.home.domain.user.dto.UserDto;
import com.sudal.home.domain.user.dto.UserLoginDto;
import com.sudal.home.domain.user.dto.UserModifyRequestDto;
import com.sudal.home.domain.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final HttpSession session;

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

	@ApiOperation(value = "로그아웃", notes = "로그인한 상태에서 로그아웃을 수행합니다.")
	@PostMapping("/logout")
	private ResponseEntity<?> logout() {
		session.invalidate();
		return ResponseEntity.ok("로그아웃 되었습니다.");
	}

	@ApiOperation(value = "회원 정보 수정", notes = "로그인한 상태에서 회원 정보를 수정합니다. 로그인이 되어있어야 합니다.")
	@PutMapping("/edit")
	private ResponseEntity<?> edit(@RequestBody UserModifyRequestDto userModifyRequestDto) throws Exception {
		userService.edit(userModifyRequestDto);
		return ResponseEntity.ok("회원 정보가 수정되었습니다.");
	}

	@ApiOperation(value = "회원 정보 조회", notes = "로그인한 상태에서 회원 정보를 조회합니다. 로그인이 되어있어야 합니다.")
	@GetMapping("/info")
	private ResponseEntity<?> getUserInfo() throws Exception {
		UserDto dto = userService.getUserInfo();
		return ResponseEntity.ok(dto);
	}

}
