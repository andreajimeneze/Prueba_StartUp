package cl.praxis.startup3.services.impl;

import cl.praxis.startup3.dao.IRoleUserDAO;
import cl.praxis.startup3.dao.impl.RoleUserDAO;
import cl.praxis.startup3.services.IRoleUserService;

import java.sql.SQLException;

public class RolUserService implements IRoleUserService {

    private final IRoleUserDAO objRoleUserDAO;

    public RolUserService() throws SQLException {
        this.objRoleUserDAO = new RoleUserDAO();
    }
    @Override
    public String roleUser(int userId) {
        String roleName = objRoleUserDAO.roleUser(userId);
        return roleName;
    }
}
