package cl.praxis.startup3.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    private int id;
    private String street;
    private int number;
    private int userId;

    public AddressDTO(String street, int number, int userId) {
        this.street = street;
        this.number = number;
        this.userId = userId;
    }
}
