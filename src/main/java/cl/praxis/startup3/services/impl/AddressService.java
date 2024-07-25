package cl.praxis.startup3.services.impl;
import cl.praxis.startup3.dao.IAddressDAO;
import cl.praxis.startup3.dao.impl.AddressDAO;
import cl.praxis.startup3.models.AddressDTO;
import cl.praxis.startup3.services.IAddressService;

import java.sql.SQLException;

public class AddressService implements IAddressService {
    private IAddressDAO objAddressDAO;

    public AddressService() throws SQLException {
        this.objAddressDAO = new AddressDAO();

    }
    @Override
    public AddressDTO insertAddress(AddressDTO address) {
        return objAddressDAO.insertAddress(address);
    }

    @Override
    public AddressDTO getAddress(int userId) {
        return objAddressDAO.getAddress(userId);
    }
}
