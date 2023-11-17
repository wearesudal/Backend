package com.sudal.home.domain.board.controller;

import com.sudal.home.common.GeneralResponse;
import com.sudal.home.domain.board.dto.BoardDto;
import com.sudal.home.domain.board.entity.Board;
import com.sudal.home.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("")
    public GeneralResponse<Integer> createBoard(@RequestBody BoardDto boardDto) {
        // TODO : userIdx 제대로 불러와서 넣기
        boardService.createBoard(1,boardDto);
        return GeneralResponse.successWithoutData("게시글 등록 성공");
    }

    @GetMapping("")
    public GeneralResponse<ArrayList<Board>> selectAll() {
        return GeneralResponse.success(boardService.selectAll(), "게시글 전체 조회 성공");
    }

    @GetMapping("/search/{boardIdx}")
    public GeneralResponse<Board> selectByBoardIdx(@PathVariable Integer boardIdx) {
        return GeneralResponse.success(boardService.selectByBoardIdx(boardIdx),"board postIdx로 게시글 단일 조회 성공");
    }

    @GetMapping("/title")
    public GeneralResponse<ArrayList<Board>> selectByTitle(@RequestParam String title) throws UnsupportedEncodingException {
        return GeneralResponse.success(boardService.selectByTitle(title), "title로 검색 성공");
    }

    @GetMapping("/content")
    public GeneralResponse<ArrayList<Board>> selectByContent(@RequestParam String content) {
        return GeneralResponse.success(boardService.selectByContent(content), "content로 검색 성공");
    }

    @DeleteMapping("")
    public GeneralResponse<Integer> deleteByBoardIdx(@RequestParam Integer boardIdx) {
        boardService.deleteByBoardIdx(boardIdx);
        return GeneralResponse.successWithoutData("게시글 삭제 성공");
    }

//    public GeneralResponse<Integer> updateBoard(@RequestBody ) {
//
//    }

    @PutMapping("")
    public GeneralResponse<Integer> updateHitCount(@RequestParam Integer boardIdx) {
        boardService.updateHit(boardIdx);
        return GeneralResponse.successWithoutData("조회수 1 올리기 성공");
    }
}
