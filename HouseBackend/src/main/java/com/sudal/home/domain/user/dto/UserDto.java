package com.sudal.home.domain.user.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {
    private String userId;
	private String userName;
	private String userPass;
	private String userEmail;
}
