package com.sudal.home.domain.map.mapper;

import com.sudal.home.domain.map.dto.request.MapSearchRequestDto;
import com.sudal.home.domain.map.dto.response.MapDetailResponseDto;
import com.sudal.home.domain.map.dto.response.MapListResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface MapMapper {
    ArrayList<MapListResponseDto> selectByCondition(MapSearchRequestDto mapSearchRequestDto);
    MapDetailResponseDto selectByNo(Long no);
}
