package com.gonzalez.choferes.dao;

import com.gonzalez.choferes.models.Chofer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IChoferesDao extends JpaRepository<Chofer, Long> {



}
