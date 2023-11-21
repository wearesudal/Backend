package com.sudal.home.domain.map.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MapSearchRequestDto {

    private String sidoName;
    private String gugunName;
    private String dongName;
    private Integer dealYear;
    private Integer dealMonth;
}
