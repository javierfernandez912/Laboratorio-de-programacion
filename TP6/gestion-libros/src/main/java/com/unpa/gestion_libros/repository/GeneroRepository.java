package com.unpa.gestion_libros.repository;
import com.unpa.gestion_libros.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer> {}