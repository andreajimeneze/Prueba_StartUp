package cl.praxis.startup3.services.impl;

import cl.praxis.startup3.dao.ISupplierDAO;
import cl.praxis.startup3.dao.impl.SupplierDAO;
import cl.praxis.startup3.models.SupplierDTO;
import cl.praxis.startup3.services.ISupplierService;

import java.sql.SQLException;
import java.util.List;

public class SupplierService implements ISupplierService {

    private final ISupplierDAO objSupplierDAO;

    public SupplierService() throws SQLException {
        this.objSupplierDAO = new SupplierDAO();
    }
    @Override
    public List<SupplierDTO> getAllSuppliers() {
        return objSupplierDAO.getAllSuppliers();
    }
}
