package cl.praxis.startup3.dao.impl;

import cl.praxis.startup3.connections.MySqlConnection;
import cl.praxis.startup3.dao.ICarDAO;
import cl.praxis.startup3.models.CarDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAO implements ICarDAO {

    private Connection connection;
    private static final String GET_ALL_CARS = "SELECT a.id_autos, a.url, a.modelo, a.proveedor_id, p.nombre FROM autos a JOIN proveedores p ON p.id_proveedores = a.proveedor_id";
    public CarDAO() throws SQLException {
        connection = MySqlConnection.getInstance().getConnection();
    }

    @Override
    public List<CarDTO> getAllCars() {
        List<CarDTO> cars = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement(GET_ALL_CARS);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("id_autos");
                String url = rs.getString("url");
                String model = rs.getString("modelo");
                String supplierName = rs.getString("nombre");

                cars.add(new CarDTO(id, url, model, supplierName));
                System.out.println("LA LISTA: " + cars);
            }
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return cars;
    }
}
