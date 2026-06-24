package com.unpa.gestion_libros.repository;
import com.unpa.gestion_libros.model.LibroDigital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroDigitalRepository extends JpaRepository<LibroDigital, Integer> {}
