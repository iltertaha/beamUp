package com.repository;

import com.beamUp.model.BeamUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BeamUrlRepository extends JpaRepository<BeamUrl,Long> {

    Optional<BeamUrl> findAllByCode(String code);

}
