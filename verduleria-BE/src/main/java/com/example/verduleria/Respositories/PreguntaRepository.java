package com.example.verduleria.Respositories;

import com.example.verduleria.Entities.PreguntaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreguntaRepository extends JpaRepository<PreguntaEntity,Long> {
}
