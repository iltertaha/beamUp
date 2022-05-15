package com.beamUp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BeamUrlDto {
    private Long id;
    private String url;
    private String code;

}
