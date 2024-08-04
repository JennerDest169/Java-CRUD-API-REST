package com.example.CursoSpring.repositories;

import com.example.CursoSpring.entities.producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productoRepository extends JpaRepository<producto,Long> {

}
