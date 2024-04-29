package com.inn.qms.repository;

import com.inn.qms.model.Capa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICapaRepository extends JpaRepository<Capa, Long> {
    Capa findTopByOrderByIdDesc(); // Find the latest record

}
