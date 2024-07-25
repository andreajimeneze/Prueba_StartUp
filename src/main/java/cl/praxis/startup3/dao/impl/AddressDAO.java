package cl.praxis.startup3.dao.impl;

import cl.praxis.startup3.connections.MySqlConnection;
import cl.praxis.startup3.dao.IAddressDAO;
import cl.praxis.startup3.models.AddressDTO;

import java.sql.*;

public class AddressDAO implements IAddressDAO {
    private Connection connection;

    public AddressDAO() throws SQLException {
        connection = MySqlConnection.getInstance().getConnection();
    }

    @Override
    public AddressDTO insertAddress(AddressDTO address) {

        String query = "INSERT INTO direcciones (calle, numeracion, usuario_id) VALUES (?, ?, ?)";
        AddressDTO newAddress = null;
        try {
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, address.getStreet());
            ps.setInt(2, address.getNumber());
            ps.setNull(3, java.sql.Types.INTEGER);
            if(address.getUserId() == 0) {
                ps.setNull(3, java.sql.Types.INTEGER);
            } else {
                ps.setInt(3, address.getUserId());
            }

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if(rs.next()) {
                int id = rs.getInt(1);

                newAddress = new AddressDTO(id, address.getStreet(), address.getNumber(), address.getUserId());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return newAddress;
    }

    @Override
    public AddressDTO getAddress(int userId) {
        AddressDTO address = null;

        String query = "SELECT calle, numeracion FROM direcciones WHERE usuario_id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                String street = rs.getString(1);
                int number =  rs.getInt(2);


                address = new AddressDTO(street, number, userId);
                // imprimir
                System.out.println(address);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return address;
    }
}
