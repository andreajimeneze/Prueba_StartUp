package cl.praxis.startup3.dao.impl;

import cl.praxis.startup3.connections.MySqlConnection;
import cl.praxis.startup3.dao.ISupplierDAO;
import cl.praxis.startup3.models.SupplierDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAO implements ISupplierDAO {
    private Connection connection;
    public SupplierDAO() throws SQLException {
        connection = MySqlConnection.getInstance().getConnection();
    }
    private static final String GET_ALL_SUPPLIERS = "SELECT id_proveedor, nombre FROM proveedores";

    @Override
    public List<SupplierDTO> getAllSuppliers() {
        List<SupplierDTO> suppliers = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(GET_ALL_SUPPLIERS);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("id_proveedor");
                String name = rs.getString("nombre");

                suppliers.add(new SupplierDTO(id, name));
            }
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return suppliers;
    }
}
