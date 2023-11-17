package com.sudal.home.domain.board.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardDto {

    private String category;
    private String title;
    private String content;
}
