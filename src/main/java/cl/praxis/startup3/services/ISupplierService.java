package cl.praxis.startup3.services;

import cl.praxis.startup3.models.SupplierDTO;

import java.util.List;

public interface ISupplierService {
    List<SupplierDTO> getAllSuppliers();
}
