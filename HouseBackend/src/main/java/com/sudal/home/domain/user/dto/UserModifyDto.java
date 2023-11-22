package com.sudal.home.domain.user.dto;

import lombok.*;

@Builder
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserModifyDto {
    private Integer userIdx;
    private String userName;
    private String userPass;
    private String userEmail;

}
