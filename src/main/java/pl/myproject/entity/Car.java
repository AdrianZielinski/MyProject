package pl.myproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cars")
@Getter
@Setter
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String marka;
    private String model;
    private double pojemnosc;
    private int power;
    private String paliwo;
    private String numerRejestracyjny;
    private String vin;
    private int przebieg;

    public Car() {

    }


    @Override
    public String toString() {
        return "Car [id=" + id +
                ",marka=" + marka +
                ",model=" + model +
                ",pojemnosc=" + pojemnosc +
                ",pojemnosc=" + power +
                ",paliwo=" + paliwo +
                ",pojemnosc=" + numerRejestracyjny +
                ",pojemnosc=" + vin +
                ",przebieg=" + przebieg + "]";
    }

}
