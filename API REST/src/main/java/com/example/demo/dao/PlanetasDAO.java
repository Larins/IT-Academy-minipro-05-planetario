package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Planeta;

public interface PlanetasDAO extends JpaRepository<Planeta,Long> {


}
