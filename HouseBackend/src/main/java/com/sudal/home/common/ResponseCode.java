package com.sudal.home.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ResponseCode {

    /**
     * COMMON
     */
    //SUCCESS
    CREATED(HttpStatus.CREATED, "생성 성공"),
    SUCCESS(HttpStatus.OK, "요청 작업 성공"),

    //ERROR
    USER_NOT_MATCH(HttpStatus.BAD_REQUEST, "사용자 권한이 맞지 않습니다."),

    /**
     * BOARD
     */

    //SUCCESS
    BOARD_CREATED(HttpStatus.CREATED, "게시물이 작성되었습니다."),
    BOARD_LOOKUP_SUCCESS(HttpStatus.OK, "게시물 조회에 성공했습니다."),
    BOARD_DELETED(HttpStatus.OK, "요청하신 게시물이 삭제되었습니다."),

    //ERROR
    BOARD_NOT_EXIST(HttpStatus.BAD_REQUEST, "요청하신 게시물을 찾을 수 없습니다."),

    /**
     * CATEGORY
     */

    //SUCCESS
    CATEGORY_CREATED(HttpStatus.CREATED, "카테고리가 생성되었습니다."),
    CATEGORY_LOOKUP_SUCCESS(HttpStatus.OK, "카테고리 조회에 성공했습니다."),

    //ERROR
    CATEGORY_NOT_EXIST(HttpStatus.BAD_REQUEST, "입력한 카테고리가 존재하지 않습니다."),


    /*
    * USER
    * */
    //ERROR
    USER_DUPLICATE(HttpStatus.BAD_REQUEST, "아이디나 비밀번호가 일치하지 않습니다."),
    USER_NOT_EXIST(HttpStatus.BAD_REQUEST, "아이디나 비밀번호가 일치하지 않습니다."),
    USER_UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "로그인이 필요합니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
