package com.sudal.home.domain.user.entity;

import lombok.*;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer userIdx;
    private String userId;
    private String userName;
    private String userPass;
    private String userEmail;
}
