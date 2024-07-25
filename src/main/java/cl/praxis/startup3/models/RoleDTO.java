package cl.praxis.startup3.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {
    private int id;
    private String name;

    public RoleDTO(String name) {
        this.name = name;
    }
}
