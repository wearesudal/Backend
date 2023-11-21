package com.sudal.home.domain.map.controller;

import com.sudal.home.common.GeneralResponse;
import com.sudal.home.common.ResponseCode;
import com.sudal.home.domain.map.dto.request.MapSearchRequestDto;
import com.sudal.home.domain.map.service.MapService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/map")
@RequiredArgsConstructor
public class MapController {

    private final MapService mapService;

    @GetMapping("")
    public ResponseEntity<GeneralResponse> selectByCondition(@RequestBody MapSearchRequestDto mapSearchRequestDto) {
        return GeneralResponse.success(ResponseCode.SUCCESS, mapService.selectByCondition(mapSearchRequestDto));
    }

    @GetMapping("/detail/{no}")
    public ResponseEntity<GeneralResponse> selectByNo(@PathVariable Long no) {
        return GeneralResponse.success(ResponseCode.SUCCESS, mapService.selectByno(no));
    }
}
