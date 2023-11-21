package com.sudal.home.domain.map.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MapListResponseDto {

    private Long no;
    private String apartmentName;
    private String floor;
    private String area;
    private String dong;
    private String dealAmount;
    private String lng;
    private String lat;
}
