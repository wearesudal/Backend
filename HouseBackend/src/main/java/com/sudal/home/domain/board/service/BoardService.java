package com.sudal.home.domain.board.service;

import com.sudal.home.domain.board.dto.request.BoardCreateRequestDto;
import com.sudal.home.domain.board.dto.request.BoardUpdateRequestDto;
import com.sudal.home.domain.board.dto.response.BoardUpdateResponseDto;
import com.sudal.home.domain.board.entity.Board;

import java.util.ArrayList;

public interface BoardService {

    Integer createBoard(Integer userIdx, BoardCreateRequestDto boardRequestDto);
    Integer deleteByBoardIdx(Long boardIdx);
    BoardUpdateResponseDto updateBoard(Integer userIdx, BoardUpdateRequestDto boardUpdateRequestDto);
    ArrayList<Board> selectAll();
    ArrayList<Board> selectByTitle(String category,String title);
    ArrayList<Board> selectByContent(String category,String content);
    ArrayList<Board> selectByCategory(String category);
    Board selectByBoardIdx(Long boardIdx);
    Integer updateHit(Long boardIdx);
}
