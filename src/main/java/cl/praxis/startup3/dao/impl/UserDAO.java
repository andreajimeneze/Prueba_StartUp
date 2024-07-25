package cl.praxis.startup3.dao.impl;

import cl.praxis.startup3.connections.MySqlConnection;
import cl.praxis.startup3.dao.IUserDAO;
import cl.praxis.startup3.models.UserDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDAO implements IUserDAO {

    private Connection connection = MySqlConnection.getInstance().getConnection();
    private static final String GET_ALL_USERS = "SELECT email, nick, nombre FROM usuarios";
    private static final String VALIDATE_USER = "SELECT COUNT(idUser) FROM usuarios WHERE  email = ?";
    private static final String INSERT_USER = "INSERT INTO usuarios (email, nick, nombre, password, peso) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_USER = "UPDATE usuarios SET email = ?, nick = ?, nombre = ?, password = ?, peso = ?";
    private static final String DELETE_USER = "DELETE FROM usuarios WHERE idUser = ?";
    private static final String GET_USER_BY_EMAIL = "SELECT idUser, email, nick, nombre FROM usuarios WHERE email = ? ";
    private static final String GET_USER_BY_ID = "SELECT idUser, email, nombre FROM usuarios WHERE idUser = ?";

    private static final String VALIDATE_LOGIN = "SELECT COUNT(idUser)  FROM usuarios WHERE email = ? AND password = ?";

    public UserDAO() throws SQLException {
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> listUsers = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement(GET_ALL_USERS);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idUser");
                String email = rs.getString("email");
                Date createdAt = rs.getDate("created_at");
                String nick = rs.getString("nick");
                String name = rs.getString("nombre");
                int weight = rs.getInt("peso");
                Date updatedAt = rs.getDate("updated_at");

                listUsers.add(new UserDTO(id, email, createdAt, nick, name, weight, updatedAt));
            }

        } catch(SQLException e) {
               throw new RuntimeException(e);
        }
        return listUsers;
    }

    @Override
    public UserDTO getUser(String email) {
        UserDTO user = null;

        try {
            PreparedStatement ps = connection.prepareStatement(GET_USER_BY_EMAIL);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                int id = rs.getInt(1);
                String nick = rs.getString(2);
                String name = rs.getString(3);

                user = new UserDTO(id, email, nick, name);
            }

        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public UserDTO getUserbyId(int id) {
        UserDTO user = null;

        try {
            PreparedStatement ps = connection.prepareStatement(GET_USER_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                String email = rs.getString(2);
                String nick = rs.getString(3);
                String name = rs.getString(4);

                user = new UserDTO(id, email, nick, name);
            }

        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public boolean userExists(String email) {
        try {
            PreparedStatement ps = connection.prepareStatement(VALIDATE_USER);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                if(rs.getInt(1) > 0) {
                    return true;
                }
            }

        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public UserDTO insertUser(UserDTO user) {
        UserDTO newUser = null;

        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);
            ps.setString(3, user.getName());
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getNick());
            ps.setString(4, user.getPassword());
            ps.setInt(5, user.getWeight());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();


            if (rs.next()) {
                int id = rs.getInt(1);
                Date createdAt = new Date();
                Date updatedAt = new Date();

                newUser = new UserDTO(id,
                        user.getEmail(),
                        createdAt,
                        user.getNick(),
                        user.getName(),
                        user.getPassword(),
                        user.getWeight(),
                        updatedAt);

System.out.println("el usuario insertado es: " + newUser);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return newUser;
    }
    @Override
    public UserDTO updateUser(UserDTO user) {
        return user;
    }

    @Override
    public void deleteUser(int id) {
        try {
        PreparedStatement ps = connection.prepareStatement(DELETE_USER);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean validateLogin(String email, String password) {
        try {
        PreparedStatement ps = connection.prepareStatement(VALIDATE_LOGIN);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                if(rs.getInt(1) > 0) {
                    return true;
                }
            }
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
