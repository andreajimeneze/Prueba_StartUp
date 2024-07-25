package cl.praxis.startup3.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int id;
    private String email;
    private Date  createdAt;
    private String nick;
    private String name;
    private String password;
    private int weight;
    private Date updatedAt;
    private AddressDTO address;
    private RoleDTO role;

    public UserDTO(int id, String email, Date createdAt, String nick, String name, int weight, Date updatedAt) {
        this.id = id;
        this.email = email;
        this.createdAt = createdAt;
        this.nick = nick;
        this.name = name;
        this.weight = weight;
        this.updatedAt = updatedAt;
    }

    public UserDTO(String email, String nick, String name) {
        this.email = email;
        this.nick = nick;
        this.name = name;
    }

    public UserDTO(int id, String email, Date createdAt, String nick, String name, String password, int weight, Date updatedAt) {
        this.id = id;
        this.email = email;
        this.createdAt = createdAt;
        this.nick = nick;
        this.name = name;
        this.password = password;
        this.weight = weight;
        this.updatedAt = updatedAt;
    }


    public UserDTO(int id, String email, String nick, String name) {
        this.id= id;
        this.email = email;
        this.nick = nick;
        this.name = name;
    }
}
