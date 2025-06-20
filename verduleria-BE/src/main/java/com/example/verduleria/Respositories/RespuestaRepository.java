package com.example.verduleria.Respositories;

import com.example.verduleria.Entities.RespuestaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespuestaRepository extends JpaRepository<RespuestaEntity,Long> {
}
