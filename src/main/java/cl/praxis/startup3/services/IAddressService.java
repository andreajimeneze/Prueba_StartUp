package cl.praxis.startup3.services;

import cl.praxis.startup3.models.AddressDTO;

public interface IAddressService {
    AddressDTO insertAddress(AddressDTO address);
    AddressDTO getAddress(int id);
}
