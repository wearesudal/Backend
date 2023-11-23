package com.sudal.home.util;

import com.sudal.home.domain.user.dto.UserDto;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@NoArgsConstructor
public class SecurityUtil {
    private static final Logger logger = LoggerFactory.getLogger(SecurityUtil.class);

    public static Integer getCurrentUserIdx() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null) {
            logger.info("Security Context에 인증 정보가 없습니다.");
            throw new RuntimeException("인증되지 않은 사용자입니다.");
        }

        Integer userIdx = null;
        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDto springSecurityUser = (UserDto) authentication.getPrincipal();
            userIdx = springSecurityUser.getUserIdx();
        } else if (authentication.getPrincipal() instanceof String) {
            userIdx = (Integer) authentication.getPrincipal();
        }

        return userIdx;
    }
}