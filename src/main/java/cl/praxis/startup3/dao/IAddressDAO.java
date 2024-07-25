package cl.praxis.startup3.dao;

import cl.praxis.startup3.models.AddressDTO;

public interface IAddressDAO {
    AddressDTO insertAddress(AddressDTO address);
    AddressDTO getAddress(int id);
}
