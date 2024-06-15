package pl.myproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@AllArgsConstructor
public class CarReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String data_przegladu;
    private String uwagi;
    private double price;
    private String status;


    public CarReview() {

    }

    @Override
    public String toString() {
        return "carReview [id=" + id +
                ",data_przeglądu=" + data_przegladu +
                ",uwagi=" + uwagi +
                ",price=" + price +
                ",status=" + status + "]";
    }

}
