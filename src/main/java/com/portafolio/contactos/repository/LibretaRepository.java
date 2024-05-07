package com.portafolio.contactos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portafolio.contactos.entities.Libreta;

@Repository
public interface LibretaRepository extends JpaRepository<Libreta, Long> {

}
