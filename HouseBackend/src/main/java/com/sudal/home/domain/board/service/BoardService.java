package com.sudal.home.domain.board.service;

import com.sudal.home.domain.board.dto.BoardDto;
import com.sudal.home.domain.board.entity.Board;

import java.util.ArrayList;

public interface BoardService {

    Integer createBoard(Integer userIdx, BoardDto boardRequestDto);
    Integer deleteByBoardIdx(Integer boardIdx);
//    Board updateBoard(Integer boardIdx, BoardDto boardRequestDto);
    ArrayList<Board> selectAll();
    ArrayList<Board> selectByTitle(String title);
    ArrayList<Board> selectByContent(String content);
    Board selectByBoardIdx(Integer boardIdx);
    Integer updateHit(Integer boardIdx);
}
