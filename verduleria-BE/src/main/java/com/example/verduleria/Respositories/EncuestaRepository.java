package com.example.verduleria.Respositories;

import com.example.verduleria.Entities.EncuestaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncuestaRepository extends JpaRepository<EncuestaEntity,Long> {
}
