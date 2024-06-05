package pl.myproject.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.myproject.entity.Car;

public interface CarRepository extends JpaRepository<Car,Long> {

}
