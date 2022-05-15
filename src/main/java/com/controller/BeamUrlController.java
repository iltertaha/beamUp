package com.controller;

import com.beamUp.dto.BeamUrlDto;
import com.beamUp.dto.converter.BeamUrlDtoConverter;
import com.beamUp.model.BeamUrl;
import com.beamUp.request.BeamUrlRequest;
import com.beamUp.request.converter.BeamUrlRequestConverter;
import com.service.BeamUrlService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping()
public class BeamUrlController {

    private final BeamUrlDtoConverter beamUrlDtoConverter;
    private final BeamUrlRequestConverter beamUrlRequestConverter;
    private final BeamUrlService service;

    public BeamUrlController(BeamUrlDtoConverter beamUrlDtoConverter, BeamUrlRequestConverter beamUrlRequestConverter, BeamUrlService service) {
        this.beamUrlDtoConverter = beamUrlDtoConverter;
        this.beamUrlRequestConverter = beamUrlRequestConverter;
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<BeamUrlDto>> getAllUrls(){
        return new ResponseEntity<List<BeamUrlDto>>(
            beamUrlDtoConverter.convertToDto(service.getAllBeamUrl()),
                HttpStatus.OK
        );
    }

    @GetMapping("show/{code}")
    public ResponseEntity<BeamUrlDto> getUrlByCode(@Valid @NotEmpty @PathVariable String code){
        return new ResponseEntity<BeamUrlDto>(beamUrlDtoConverter.convertToDto(service.getUrlByCode(code))
                                            , HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<BeamUrlDto> redirect(@Valid @NotEmpty @PathVariable String code) throws URISyntaxException {

        BeamUrl beamUrl = service.getUrlByCode(code);

        URI uri = new URI(beamUrl.getUrl());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);

        return new ResponseEntity<>(
            httpHeaders,HttpStatus.SEE_OTHER
                );
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody BeamUrlRequest beamUrlRequest){
        BeamUrl beamUrl = beamUrlRequestConverter.convertToEntity(beamUrlRequest);
        return new ResponseEntity<BeamUrlDto>(beamUrlDtoConverter.convertToDto(service.create(beamUrl))
                , HttpStatus.CREATED);

    }
}
