package org.example.dao;

import org.example.entities.Planet;

import java.util.List;

public interface PlanetDao {
    boolean save(Planet planet);
    Planet findById(String id);
    List<Planet> getAllPlanets ();
    boolean update(Planet planet);
    boolean delete(Planet planet);
}
