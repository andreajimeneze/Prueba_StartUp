package cl.praxis.startup3.dao.impl;

import cl.praxis.startup3.connections.MySqlConnection;
import cl.praxis.startup3.dao.IRoleDAO;
import cl.praxis.startup3.models.RoleDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO implements IRoleDAO {

    private Connection connection;
    private  static final String GET_ALL_ROLES = "SELECT nombre FROM roles";
    public RoleDAO() throws SQLException {
        connection = MySqlConnection.getInstance().getConnection();
    }

    @Override
    public List<RoleDTO> getAllRoles() {
        List<RoleDTO> roles;
        try {
            roles = new ArrayList<>();
            PreparedStatement ps = connection.prepareStatement(GET_ALL_ROLES);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("nombre");
                roles.add(new RoleDTO(name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return roles;
    }
}
