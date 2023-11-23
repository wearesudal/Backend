package com.sudal.home.domain.map.mapper;

import com.sudal.home.domain.map.dto.request.MapDongInfoRequestDto;
import com.sudal.home.domain.map.dto.request.MapSearchRequestDto;
import com.sudal.home.domain.map.dto.response.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface MapMapper {
    ArrayList<MapListResponseDto> selectByCondition(MapSearchRequestDto mapSearchRequestDto);
    MapDetailResponseDto selectByNo(Long no);
    ArrayList<MapCityResponseDto> selectAllDistinctCityName();
    ArrayList<MapGugunResponseDto> selectAllDistinctGugunName(String cityName);
    ArrayList<MapDongResponseDto> selectAllDistinctDongName(MapDongInfoRequestDto mapDongInfoRequestDto);
}
