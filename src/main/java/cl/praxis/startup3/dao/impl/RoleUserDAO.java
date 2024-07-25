package cl.praxis.startup3.dao.impl;

import cl.praxis.startup3.connections.MySqlConnection;
import cl.praxis.startup3.dao.IRoleUserDAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class RoleUserDAO implements IRoleUserDAO {

    private Connection connection;

    public RoleUserDAO() throws SQLException {
        connection = MySqlConnection.getInstance().getConnection();
    }

    @Override
    public String roleUser(int userId) {
        String query = "SELECT r.nombre AS rol_nombre FROM roles_usuarios ru JOIN roles r ON r.idrol = ru.rol_id  WHERE ru.usuario_id = ?";

        String roleName = null;
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                roleName = rs.getString("rol_nombre");
                System.out.println(roleName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return roleName;
    }
}
