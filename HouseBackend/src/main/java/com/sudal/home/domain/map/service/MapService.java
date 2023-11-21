package com.sudal.home.domain.map.service;

import com.sudal.home.domain.map.dto.request.MapSearchRequestDto;
import com.sudal.home.domain.map.dto.response.MapDetailResponseDto;
import com.sudal.home.domain.map.dto.response.MapListResponseDto;

import java.util.ArrayList;

public interface MapService {

    ArrayList<MapListResponseDto> selectByCondition(MapSearchRequestDto mapSearchRequestDto);
    MapDetailResponseDto selectByno(Long no);
}
