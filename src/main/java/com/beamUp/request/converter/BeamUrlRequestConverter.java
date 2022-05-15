package com.beamUp.request.converter;

import com.beamUp.model.BeamUrl;
import com.beamUp.request.BeamUrlRequest;
import org.springframework.stereotype.Component;

@Component
public class BeamUrlRequestConverter {
    public BeamUrl convertToEntity(BeamUrlRequest beamUrlRequest){
        return BeamUrl.builder()
                .url(beamUrlRequest.getUrl())
                .code(beamUrlRequest.getCode())
                .build();
    }
}
