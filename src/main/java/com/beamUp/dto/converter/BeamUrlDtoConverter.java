package com.beamUp.dto.converter;

import com.beamUp.dto.BeamUrlDto;
import com.beamUp.model.BeamUrl;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

// Init as component to be able to inject
@Component
public class BeamUrlDtoConverter {

    public BeamUrlDto convertToDto(BeamUrl beamUrl){
        return BeamUrlDto.builder()
                .id(beamUrl.getId())
                .url(beamUrl.getUrl())
                .code(beamUrl.getCode())
                .build();
    }

    public List<BeamUrlDto> convertToDto(List<BeamUrl> beamUrls){
        return beamUrls.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
