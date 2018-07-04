package com.apolinaro.cobranca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apolinaro.cobranca.model.Titulo;

public interface Titulos extends JpaRepository<Titulo, Long> {

}
