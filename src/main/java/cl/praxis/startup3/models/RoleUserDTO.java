package cl.praxis.startup3.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleUserDTO {
    private int userId;
    private int roleId;
}
