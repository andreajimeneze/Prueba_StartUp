package cl.praxis.startup3.services;

import cl.praxis.startup3.models.CarDTO;

import java.util.List;

public interface ICarService {
    List<CarDTO> getAllCars();
}
