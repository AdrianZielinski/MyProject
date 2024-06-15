package pl.myproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "menuView")
public class MenuView {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String marka;
    private String model;
    private String numerRejestracyjny;
    private String price;
    private String status;
    private String mechanicFirstName;

    public MenuView() {

    }

    @Override
    public String toString() {
        return "Car [id=" + id +
                ",marka=" + firstName +
                ",model=" + lastName +
                ",pojemnosc=" + marka +
                ",pojemnosc=" + model +
                ",paliwo=" + numerRejestracyjny +
                ",pojemnosc=" + price +
                ",pojemnosc=" + status +
                ",mechanicFirstName=" + mechanicFirstName + "]";
    }
}
