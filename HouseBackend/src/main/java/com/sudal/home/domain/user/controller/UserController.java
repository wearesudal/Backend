package com.sudal.home.domain.user.controller;

import com.sudal.home.domain.user.dto.UserDto;
import com.sudal.home.domain.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@ApiOperation(value = "회원 등록", notes = "입력한 사용자 정보를 바탕으로 회원 등록을 진행합니다.")
	@PostMapping("")
	private ResponseEntity<?> join(@RequestBody UserDto userDto) throws Exception {
		if (userService.idCheck(userDto.getUserId()) == 1) {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body("이미 존재하는 아이디입니다.");
		}
		userService.joinUser(userDto);
		return ResponseEntity.ok("success join");
	}

	@ApiOperation(value = "로그인", notes = "아이디와 비밀번호를 입력하여 로그인 합니다.")
	@PostMapping("/login")
	private ResponseEntity<?> login(@RequestBody UserDto userDto, @ApiIgnore HttpSession session) throws Exception {
		String userId = userDto.getUserId();
		String userPass = userDto.getUserPass();
		if (userId == null || userPass == null)
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body("ID와 Password를 입력해주세요.");

		UserDto uDto = userService.loginUser(userId, userPass);
		if (uDto != null) {
			session.setAttribute("userinfo", uDto);
			return ResponseEntity.ok("로그인 성공 !");
		} else {
			return ResponseEntity
					.status(HttpStatus.UNAUTHORIZED)
					.body("ID나 Password가 틀렸습니다.");
		}
	}

	@ApiOperation(value = "로그아웃", notes = "로그인한 상태에서 로그아웃을 수행합니다.")
	@GetMapping("/logout")
	private ResponseEntity<?> logout(HttpSession session) {
		session.invalidate();
		return ResponseEntity.ok("success logout");
	}

	@ApiOperation(value = "회원 정보 수정", notes = "로그인한 상태에서 회원 정보를 수정합니다. 로그인이 되어있어야 합니다.")
	@PutMapping("")
	private ResponseEntity<?> edit(@RequestBody UserDto userDto, @ApiIgnore HttpSession session) throws Exception {
		UserDto uDto = (UserDto) session.getAttribute("userinfo");
		if (uDto == null)
			return ResponseEntity
					.status(HttpStatus.UNAUTHORIZED)
					.body("Unauthorized user.");
		userDto.setUserId(uDto.getUserId());
		int cnt = userService.edit(userDto);
		if (cnt == 0)
			return ResponseEntity
					.status(HttpStatus.UNAUTHORIZED)
					.body("Invalid ID");
		return ResponseEntity.ok("success login");
	}

	@ApiOperation(value = "회원 정보 조회", notes = "로그인한 상태에서 회원 정보를 조회합니다. 로그인이 되어있어야 합니다.")
	@GetMapping("/info")
	private ResponseEntity<?> getUserInfo(@ApiIgnore HttpSession session) throws Exception {
		UserDto userDto = (UserDto) session.getAttribute("userinfo");
		if (userDto == null)
			return null;
		UserDto dto = userService.getUserInfo(userDto.getUserId());
		return ResponseEntity.ok(dto);
	}

}
