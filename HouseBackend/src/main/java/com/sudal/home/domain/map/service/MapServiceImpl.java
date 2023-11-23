package com.sudal.home.domain.map.service;

import com.sudal.home.domain.map.dto.request.MapGugunInfoRequestDto;
import com.sudal.home.domain.map.dto.request.MapDongInfoRequestDto;
import com.sudal.home.domain.map.dto.request.MapSearchRequestDto;
import com.sudal.home.domain.map.dto.response.*;
import com.sudal.home.domain.map.mapper.MapMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MapServiceImpl implements MapService {

    private final MapMapper mapMapper;

    @Override
    public ArrayList<MapListResponseDto> selectByCondition(MapSearchRequestDto mapSearchRequestDto) {
        return mapMapper.selectByCondition(mapSearchRequestDto);
    }

    @Override
    public MapDetailResponseDto selectByno(Long no) {
        return mapMapper.selectByNo(no);
    }

    @Override
    public ArrayList<MapCityResponseDto> selectAllCityName() {
        return mapMapper.selectAllDistinctCityName();
    }

    @Override
    public ArrayList<MapGugunResponseDto> selectAllGugunName(MapGugunInfoRequestDto mapCityInfoRequestDto) {
        return mapMapper.selectAllDistinctGugunName(mapCityInfoRequestDto.getCityName());
    }

    @Override
    public ArrayList<MapDongResponseDto> selectAllDongName(MapDongInfoRequestDto mapDongInfoRequestDto) {
        return mapMapper.selectAllDistinctDongName(mapDongInfoRequestDto);
    }
}
