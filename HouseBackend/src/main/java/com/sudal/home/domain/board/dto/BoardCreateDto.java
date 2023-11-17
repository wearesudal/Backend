package com.sudal.home.domain.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardCreateDto {

    private Integer categoryIdx;
    private Integer userIdx;
    private String title;
    private String content;
}
