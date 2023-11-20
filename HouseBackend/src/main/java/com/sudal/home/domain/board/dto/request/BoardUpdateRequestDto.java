package com.sudal.home.domain.board.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardUpdateRequestDto {

    private Long postIdx;
    private String category;
    private String title;
    private String content;
}
