package com.sudal.home.domain.board.mapper;

import com.sudal.home.domain.board.dto.BoardCreateDto;
import com.sudal.home.domain.board.dto.BoardTitleSearchDto;
import com.sudal.home.domain.board.dto.BoardContentSearchDto;
import com.sudal.home.domain.board.entity.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface BoardMapper {

    Integer createBoard(BoardCreateDto boardCreateDto);
    Integer deleteByBoardIdx(Long boardIdx);
    Integer updateBoard(Board board);
    ArrayList<Board> selectAll();
    ArrayList<Board> selectByTitle(BoardTitleSearchDto boardTitleSearchDto);
    ArrayList<Board> selectByContent(BoardContentSearchDto boardContentSearchDto);
    ArrayList<Board> selectByCategory(Integer categoryIdx);
    Board selectByBoardIdx(Long boardIdx);
    Integer updateHit(Long boardIdx);
}
