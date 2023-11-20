package com.sudal.home.domain.board.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class BoardUpdateResponseDto {

    private Long postIdx;
    private Integer categoryIdx;
    private Integer userIdx;
    private String title;
    private String content;
    private Long hit;
    private LocalDateTime createTime;
}
