package com.sudal.home.domain.board.controller;

import com.sudal.home.common.GeneralResponse;
import com.sudal.home.domain.board.dto.request.BoardCreateRequestDto;
import com.sudal.home.domain.board.dto.request.BoardUpdateRequestDto;
import com.sudal.home.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("")
    public ResponseEntity<GeneralResponse> createBoard(@RequestBody BoardCreateRequestDto boardCreateRequestDto) {
        // TODO : userIdx 제대로 불러와서 넣기
        boardService.createBoard(1, boardCreateRequestDto);
        return GeneralResponse.successWithoutData(HttpStatus.CREATED, "게시글 작성 성공");
    }

    @GetMapping("")
    public ResponseEntity<GeneralResponse> selectAll() {
        return GeneralResponse.success(HttpStatus.OK,boardService.selectAll(), "게시글 전체 조회 성공");
    }

    @GetMapping("/search/{boardIdx}")
    public ResponseEntity<GeneralResponse> selectByBoardIdx(@PathVariable Long boardIdx) {
        return GeneralResponse.success(HttpStatus.OK,boardService.selectByBoardIdx(boardIdx),"게시글 단일 조회 성공");
    }

    @GetMapping("/title")
    public ResponseEntity<GeneralResponse> selectByTitle(@RequestParam String title) {
        return GeneralResponse.success(HttpStatus.OK,boardService.selectByTitle(title), "제목으로 검색 성공");
    }

    @GetMapping("/content")
    public ResponseEntity<GeneralResponse> selectByContent(@RequestParam String content) {
        return GeneralResponse.success(HttpStatus.OK,boardService.selectByContent(content), "content로 검색 성공");
    }

    @DeleteMapping("")
    public ResponseEntity<GeneralResponse> deleteByBoardIdx(@RequestParam Long boardIdx) {
        boardService.deleteByBoardIdx(boardIdx);
        return GeneralResponse.successWithoutData(HttpStatus.OK,"게시글 삭제 성공");
    }

    @PutMapping("")
    public ResponseEntity<GeneralResponse> updateBoard(@RequestBody BoardUpdateRequestDto boardUpdateRequestDto) {
        // TODO : userIdx 값 제대로 넣기
        return GeneralResponse.success(HttpStatus.OK,boardService.updateBoard(2,boardUpdateRequestDto),"게시글 수정 성공");
    }

    @PatchMapping("")
    public ResponseEntity<GeneralResponse> updateHitCount(@RequestParam Long boardIdx) {
        boardService.updateHit(boardIdx);
        return GeneralResponse.successWithoutData(HttpStatus.OK,"조회수 1 올리기 성공");
    }
}
