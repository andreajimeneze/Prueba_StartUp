package cl.praxis.startup3.services;
import cl.praxis.startup3.models.UserDTO;

import java.util.List;

public interface IUserService {
    List<UserDTO> getAllUsers();
    UserDTO getUser(String email);

    UserDTO getUserById(int id);
    String validateUser(String email, UserDTO user);
    UserDTO updateUser(UserDTO user);
    void deleteUser(int id);
    String validateLogin(String email, String password);
    UserDTO insertedUser(String email, UserDTO user);
    boolean userExists(String email);
}
