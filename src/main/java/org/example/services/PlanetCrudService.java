package org.example.services;

import org.example.dao.PlanetDao;
import org.example.dao.PlanetDaoImpl;
import org.example.entities.Planet;

import java.util.List;

public class PlanetCrudService {
    private PlanetDao planetDao = new PlanetDaoImpl();

    public void savePlanet(Planet planet) {
        planetDao.save(planet);
    }

    public Planet findPlanetById(String id) {
        return planetDao.findById(id);
    }

    public List<Planet> getAllPlanets () {return planetDao.getAllPlanets();}

    public void updatePlanet(Planet planet) {
        planetDao.update(planet);
    }

    public void deletePlanet(Planet planet) {
        planetDao.delete(planet);
    }
}
