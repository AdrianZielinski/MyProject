package pl.myproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.myproject.dao.UserDao;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Setter
@Getter
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String numberOfTelephone;
    private String email;
    private String adres;
    private String city;

    public User() {

    }


}
