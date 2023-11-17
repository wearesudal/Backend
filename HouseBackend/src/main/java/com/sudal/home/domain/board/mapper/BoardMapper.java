package com.sudal.home.domain.board.mapper;

import com.sudal.home.domain.board.dto.BoardCreateDto;
import com.sudal.home.domain.board.dto.BoardDto;
import com.sudal.home.domain.board.entity.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface BoardMapper {

    Integer createBoard(BoardCreateDto boardCreateDto);
    Integer deleteByBoardIdx(Integer boardIdx);
//    Board updateBoard(Integer boardIdx, BoardDto boardDto);
    ArrayList<Board> selectAll();
    ArrayList<Board> selectByTitle(String title);
    ArrayList<Board> selectByContent(String content);
    Board selectByBoardIdx(Integer boardIdx);
    Integer updateHit(Integer boardIdx);
}
