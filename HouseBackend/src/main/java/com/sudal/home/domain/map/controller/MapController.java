package com.sudal.home.domain.map.controller;

import com.sudal.home.common.GeneralResponse;
import com.sudal.home.common.ResponseCode;
import com.sudal.home.domain.map.dto.request.MapDongInfoRequestDto;
import com.sudal.home.domain.map.dto.request.MapSearchRequestDto;
import com.sudal.home.domain.map.service.MapService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/map")
@RequiredArgsConstructor
public class MapController {

    private final MapService mapService;
    @GetMapping("")
    public ResponseEntity<GeneralResponse> selectByCondition(@RequestParam("sidoName") String sidoName,
                                                             @RequestParam("gugunName") String gugunName,
                                                             @RequestParam("dongName") String dongName,
                                                             @RequestParam("dealYear") Integer dealYear,
                                                             @RequestParam("dealMonth") Integer dealMonth) {
        return GeneralResponse.success(ResponseCode.SUCCESS, mapService.selectByCondition(new MapSearchRequestDto(sidoName, gugunName, dongName, dealYear, dealMonth)));
    }

    @GetMapping("/detail/{no}")
    public ResponseEntity<GeneralResponse> selectByNo(@PathVariable Long no) {
        return GeneralResponse.success(ResponseCode.SUCCESS, mapService.selectByno(no));
    }

    @GetMapping("/info/city")
    public ResponseEntity<GeneralResponse> selectAllCityName() {
        return GeneralResponse.success(ResponseCode.SUCCESS, mapService.selectAllCityName());
    }

    @GetMapping("/info/gugun")
    public ResponseEntity<GeneralResponse> selectAllGugunName(@RequestParam String cityName) {
        return GeneralResponse.success(ResponseCode.SUCCESS, mapService.selectAllGugunName(cityName));
    }

    @GetMapping("/info/dong")
    public ResponseEntity<GeneralResponse> selectAllDongName(@RequestParam String cityName, @RequestParam String gugunName) {
        return GeneralResponse.success(ResponseCode.SUCCESS, mapService.selectAllDongName(new MapDongInfoRequestDto(cityName, gugunName)));
    }
}
