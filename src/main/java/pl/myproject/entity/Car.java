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
    private String paliwo;
    private int przebieg;
    private String ostatni_przeglad;

    public Car() {

    }

    @Override
    public String toString() {
        return "Car [id=" + id +
                ",marka=" + marka +
                ",model=" + model +
                ",pojemnosc=" + pojemnosc +
                ",paliwo=" + paliwo +
                ",przebieg=" + przebieg +
                ",ostatni_przeglad=" + ostatni_przeglad + "]";
    }

}
