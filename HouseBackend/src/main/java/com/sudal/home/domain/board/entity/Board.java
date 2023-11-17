package com.sudal.home.domain.board.entity;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Board {

    private Long postIdx;
    private Integer categoryIdx;
    private Integer userIdx;
    private String title;
    private String content;
    private Long hit;
    private LocalDateTime createTime;
}
