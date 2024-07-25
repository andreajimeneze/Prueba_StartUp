package cl.praxis.startup3.services.impl;

import cl.praxis.startup3.dao.ICarDAO;
import cl.praxis.startup3.dao.impl.CarDAO;
import cl.praxis.startup3.models.CarDTO;
import cl.praxis.startup3.services.ICarService;

import java.sql.SQLException;
import java.util.List;

public class CarService implements ICarService {
    private final ICarDAO objCarDAO;

    public CarService() throws SQLException {
        this.objCarDAO = new CarDAO();
    }
    @Override
    public List<CarDTO> getAllCars() {
        List<CarDTO> cars = objCarDAO.getAllCars();
        System.out.println("Esta otra: " + cars);
        return cars;
    }
}
