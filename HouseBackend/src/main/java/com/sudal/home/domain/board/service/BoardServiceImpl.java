package com.sudal.home.domain.board.service;

import com.sudal.home.common.BaseException;
import com.sudal.home.domain.board.dto.BoardCreateDto;
import com.sudal.home.domain.board.dto.BoardDto;
import com.sudal.home.domain.board.entity.Board;
import com.sudal.home.domain.board.mapper.BoardMapper;
import com.sudal.home.domain.category.dto.CategoryDto;
import com.sudal.home.domain.category.entity.Category;
import com.sudal.home.domain.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;
    private final CategoryService categoryService;

    @Override
    public Integer createBoard(Integer userIdx, BoardDto boardDto) {
        Category category = categoryService.selectByCategory(CategoryDto.builder().category(boardDto.getCategory()).build());
        if(category==null) {
            throw new BaseException("카테고리명을 제대로 입력하세요");
        }
        Integer categoryIdx = category.getCategoryIdx();
        BoardCreateDto boardCreateDto = BoardCreateDto.builder()
                .categoryIdx(categoryIdx)
                .userIdx(userIdx)
                .title(boardDto.getTitle())
                .content(boardDto.getContent())
                .build();
        return boardMapper.createBoard(boardCreateDto);
    }

    @Override
    public Integer deleteByBoardIdx(Integer boardIdx) {
        Board board = boardMapper.selectByBoardIdx(boardIdx);
        if(board==null) {
            throw new BaseException("boardIdx에 해당하는 게시글이 없습니다.");
        } else if(board.getUserIdx()!=1) {
            // TODO : userIdx 지금 로그인한 유저의 것 잘 가져와서 넣기, 로그인 유무 구분 오류 처리
            throw new BaseException("자신이 작성한 글만 삭제할수 있습니다.");
        }
        return boardMapper.deleteByBoardIdx(boardIdx);
    }

    @Override
    public Board updateBoard(Integer boardIdx, BoardDto boardRequestDto) {
    }

    @Override
    public ArrayList<Board> selectAll() {
        return boardMapper.selectAll();
    }

    @Override
    public ArrayList<Board> selectByTitle(String title) {
        return boardMapper.selectByTitle(title);
    }

    @Override
    public ArrayList<Board> selectByContent(String content) {
        return boardMapper.selectByContent(content);
    }

    @Override
    public Board selectByBoardIdx(Integer boardIdx) {
        return boardMapper.selectByBoardIdx(boardIdx);
    }

    @Override
    public Integer updateHit(Integer boardIdx) {
        return boardMapper.updateHit(boardIdx);
    }
}
