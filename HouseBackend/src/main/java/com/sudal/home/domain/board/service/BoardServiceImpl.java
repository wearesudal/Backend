package com.sudal.home.domain.board.service;

import com.sudal.home.common.BaseException;
import com.sudal.home.common.ResponseCode;
import com.sudal.home.domain.board.dto.BoardCreateDto;
import com.sudal.home.domain.board.dto.request.BoardCreateRequestDto;
import com.sudal.home.domain.board.dto.request.BoardUpdateRequestDto;
import com.sudal.home.domain.board.dto.response.BoardUpdateResponseDto;
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
    public Integer createBoard(Integer userIdx, BoardCreateRequestDto boardCreateRequestDto) {
        Category category = categoryService.selectByCategory(CategoryDto.builder().category(boardCreateRequestDto.getCategory()).build());
        if(category==null) {
            throw new BaseException(ResponseCode.CATEGORY_NOT_EXIST);
        }
        Integer categoryIdx = category.getCategoryIdx();
        BoardCreateDto boardCreateDto = BoardCreateDto.builder()
                .categoryIdx(categoryIdx)
                .userIdx(userIdx)
                .title(boardCreateRequestDto.getTitle())
                .content(boardCreateRequestDto.getContent())
                .build();
        return boardMapper.createBoard(boardCreateDto);
    }

    @Override
    public Integer deleteByBoardIdx(Long boardIdx) {
        Board board = boardMapper.selectByBoardIdx(boardIdx);
        if(board==null) {
            throw new BaseException(ResponseCode.BOARD_NOT_EXIST);
        } else if(board.getUserIdx()!=1) {
            // TODO : userIdx 지금 로그인한 유저의 것 잘 가져와서 넣기, 로그인 유무 구분 오류 처리
            throw new BaseException(ResponseCode.USER_NOT_MATCH);
        }
        return boardMapper.deleteByBoardIdx(boardIdx);
    }

    @Override
    public BoardUpdateResponseDto updateBoard(Integer userIdx, BoardUpdateRequestDto boardUpdateRequestDto) {
        Board board = boardMapper.selectByBoardIdx(boardUpdateRequestDto.getPostIdx());
        if(board==null) { //postIdx에 해당하는 게시글이 없을 때
            throw new BaseException(ResponseCode.BOARD_NOT_EXIST);
        } else if(!userIdx.equals(board.getUserIdx())) { //수정 요청자와 게시글 작성자가 다를 때
            throw new BaseException(ResponseCode.USER_NOT_MATCH);
        }
        Category category = categoryService.selectByCategory(CategoryDto.builder()
                .category(boardUpdateRequestDto.getCategory())
                .build());
        if(category==null) {
            throw new BaseException(ResponseCode.CATEGORY_NOT_EXIST);
        }
        board.setCategoryIdx(category.getCategoryIdx());
        board.setTitle(boardUpdateRequestDto.getTitle());
        board.setContent(boardUpdateRequestDto.getContent());
        boardMapper.updateBoard(board);
        return BoardUpdateResponseDto.builder()
                .postIdx(board.getPostIdx())
                .userIdx(board.getUserIdx())
                .categoryIdx(board.getCategoryIdx())
                .title(board.getTitle())
                .content(board.getContent())
                .hit(board.getHit())
                .createTime(board.getCreateTime())
                .build();
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
    public Board selectByBoardIdx(Long boardIdx) {
        return boardMapper.selectByBoardIdx(boardIdx);
    }

    @Override
    public Integer updateHit(Long boardIdx) {
        return boardMapper.updateHit(boardIdx);
    }
}
