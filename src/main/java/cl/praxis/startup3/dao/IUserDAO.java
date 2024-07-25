package cl.praxis.startup3.dao;

import cl.praxis.startup3.models.UserDTO;

import java.util.List;

public interface IUserDAO {
    List<UserDTO> getAllUsers();
    UserDTO getUser(String email);
    boolean userExists(String email);
    UserDTO insertUser(UserDTO user);
    UserDTO updateUser(UserDTO user);
    void deleteUser(int id);
    boolean validateLogin(String email, String password);

    public UserDTO getUserbyId(int id);
}
