package com.sudal.home.domain.map.service;

import com.sudal.home.domain.map.dto.request.MapSearchRequestDto;
import com.sudal.home.domain.map.dto.response.MapDetailResponseDto;
import com.sudal.home.domain.map.dto.response.MapListResponseDto;
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
}
