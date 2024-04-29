package com.inn.qms.service;

import com.inn.qms.model.Capa;

import java.util.List;
import java.util.Optional;

public interface ICCapaService {

    List<Capa> getAllCapas();

    Optional<Capa> getCapaById(Long id);

    Capa createCapa(Capa capa);

    Capa updateCapa(Capa capa);

    void deleteCapa(Long id);

}
