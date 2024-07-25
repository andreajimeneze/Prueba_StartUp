package cl.praxis.startup3.services.impl;
import cl.praxis.startup3.dao.IAddressDAO;
import cl.praxis.startup3.dao.IUserDAO;
import cl.praxis.startup3.dao.impl.AddressDAO;
import cl.praxis.startup3.dao.impl.UserDAO;
import cl.praxis.startup3.models.UserDTO;
import cl.praxis.startup3.services.IUserService;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService {
    private final IUserDAO objUserDAO;
    private final IAddressDAO objAddressDAO;

    public UserService() throws SQLException {
        this.objUserDAO = new UserDAO();
        this.objAddressDAO = new AddressDAO();
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return objUserDAO.getAllUsers();
    }

    @Override
    public UserDTO getUser(String email) {

        return objUserDAO.getUser(email);
    }

    @Override
    public UserDTO getUserById(int id) {
        return objUserDAO.getUserbyId(id);
    }

    @Override
    public boolean userExists(String email) {
        UserDTO user;
        user = objUserDAO.getUser(email);

        if(user != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String validateUser (String email, UserDTO user) {
      boolean userExists = objUserDAO.userExists(email);

      if(!userExists)
          return "Operación exitosa";
      return "";
    }

    public UserDTO insertedUser(String email, UserDTO user) {
        boolean userExists = objUserDAO.userExists(email);
        if(!userExists) {
            return objUserDAO.insertUser(user);
        }
        return null;
    }

    @Override
    public UserDTO updateUser(UserDTO user) {
        return objUserDAO.updateUser(user);
    }

    @Override
    public void deleteUser(int id) {
        objUserDAO.deleteUser(id);
    }

    @Override
    public String validateLogin(String email, String password) {
        boolean userExists = objUserDAO.validateLogin(email, password);
        if(userExists) {
            return "";
        }
        return "Usuario y/o contraseña incorrectas. Intente nuevamente";
    }
}
