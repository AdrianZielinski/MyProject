package pl.myproject.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CarList {
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
