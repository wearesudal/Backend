package com.sudal.home.domain.board.controller;

import com.sudal.home.common.ResponseCode;
import com.sudal.home.common.GeneralResponse;
import com.sudal.home.domain.board.dto.request.BoardCreateRequestDto;
import com.sudal.home.domain.board.dto.request.BoardUpdateRequestDto;
import com.sudal.home.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
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
        return GeneralResponse.successWithoutData(ResponseCode.BOARD_CREATED);
    }

    @GetMapping("")
    public ResponseEntity<GeneralResponse> selectAll() {
        return GeneralResponse.success(ResponseCode.BOARD_LOOKUP_SUCCESS,boardService.selectAll());
    }

    @GetMapping("/search/{boardIdx}")
    public ResponseEntity<GeneralResponse> selectByBoardIdx(@PathVariable Long boardIdx) {
        return GeneralResponse.success(ResponseCode.BOARD_LOOKUP_SUCCESS,boardService.selectByBoardIdx(boardIdx));
    }

    @GetMapping("/title")
    public ResponseEntity<GeneralResponse> selectByTitle(@RequestParam String category, @RequestParam String title) {
        return GeneralResponse.success(ResponseCode.BOARD_LOOKUP_SUCCESS,boardService.selectByTitle(category,title));
    }

    @GetMapping("/content")
    public ResponseEntity<GeneralResponse> selectByContent(@RequestParam String category, @RequestParam String content) {
        return GeneralResponse.success(ResponseCode.BOARD_LOOKUP_SUCCESS,boardService.selectByContent(category,content));
    }

    @GetMapping("/category")
    public ResponseEntity<GeneralResponse> selectByCategory(@RequestParam String category) {
        return GeneralResponse.success(ResponseCode.BOARD_LOOKUP_SUCCESS,boardService.selectByCategory(category));
    }

    @DeleteMapping("")
    public ResponseEntity<GeneralResponse> deleteByBoardIdx(@RequestParam Long boardIdx) {
        boardService.deleteByBoardIdx(boardIdx);
        return GeneralResponse.successWithoutData(ResponseCode.BOARD_DELETED);
    }

    @PutMapping("")
    public ResponseEntity<GeneralResponse> updateBoard(@RequestBody BoardUpdateRequestDto boardUpdateRequestDto) {
        // TODO : userIdx 값 제대로 넣기
        return GeneralResponse.success(ResponseCode.SUCCESS,boardService.updateBoard(1,boardUpdateRequestDto));
    }

    @PatchMapping("")
    public ResponseEntity<GeneralResponse> updateHitCount(@RequestParam Long boardIdx) {
        boardService.updateHit(boardIdx);
        return GeneralResponse.successWithoutData(ResponseCode.SUCCESS);
    }
}
