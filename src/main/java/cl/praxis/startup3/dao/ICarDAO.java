package cl.praxis.startup3.dao;

import cl.praxis.startup3.models.CarDTO;

import java.util.List;

public interface ICarDAO {
    List<CarDTO> getAllCars();
}
