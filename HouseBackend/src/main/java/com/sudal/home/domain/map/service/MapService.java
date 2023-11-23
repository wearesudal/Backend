package com.sudal.home.domain.map.service;

import com.sudal.home.domain.map.dto.request.MapDongInfoRequestDto;
import com.sudal.home.domain.map.dto.request.MapSearchRequestDto;
import com.sudal.home.domain.map.dto.response.*;

import java.util.ArrayList;

public interface MapService {

    ArrayList<MapListResponseDto> selectByCondition(MapSearchRequestDto mapSearchRequestDto);
    MapDetailResponseDto selectByno(Long no);
    ArrayList<MapCityResponseDto> selectAllCityName();
    ArrayList<MapGugunResponseDto> selectAllGugunName(String cityName);
    ArrayList<MapDongResponseDto> selectAllDongName(MapDongInfoRequestDto mapDongInfoRequestDto);
}
