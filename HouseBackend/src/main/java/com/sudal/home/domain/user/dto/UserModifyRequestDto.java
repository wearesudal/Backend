package com.sudal.home.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserModifyRequestDto {
	private String userName;
    private String userPass;
    private String userEmail;
}
