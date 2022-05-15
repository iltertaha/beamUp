package com.service;

import com.beamUp.model.BeamUrl;
import com.repository.BeamUrlRepository;
import com.util.RandomCodeGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeamUrlService {

    private final BeamUrlRepository repository;
    private final RandomCodeGenerator randomCodeGenerator;

    public BeamUrlService(BeamUrlRepository repository, RandomCodeGenerator randomCodeGenerator) {
        this.repository = repository;
        this.randomCodeGenerator = randomCodeGenerator;
    }

    public List<BeamUrl> getAllBeamUrl() {
        return repository.findAll();
    }

    public BeamUrl getUrlByCode(String code) {
        return repository.findAllByCode(code).orElseThrow(
                () -> new RuntimeException("Code not Found")
        );
    }

    public BeamUrl create(BeamUrl beamUrl) {

        // Auto-generate code for url
        if(beamUrl.getCode() == null || beamUrl.getCode().isEmpty()){
            beamUrl.setCode(generateCode());
        }
        // Check code from db for possible duplication
        else if(repository.findAllByCode(beamUrl.getCode()).isPresent()){
             throw new RuntimeException("Code already exists in db");
        }

        beamUrl.setCode(beamUrl.getCode().toUpperCase());
        return repository.save(beamUrl);

    }

    private String generateCode() {
        String code;

        // Create new code if newly generated code is already exists in the db
        do {
            code = randomCodeGenerator.generateRandomCode();
        }while (repository.findAllByCode(code).isPresent());

        return code;
    }
}
