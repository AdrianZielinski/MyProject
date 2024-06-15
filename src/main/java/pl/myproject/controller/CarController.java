package pl.myproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.myproject.dao.CarDao;
import pl.myproject.entity.Car;
import java.util.List;

@Controller
public class CarController {
    public CarDao carDao;

    public CarController(CarDao carDao) {
        this.carDao = carDao;
    }

    //wyświetlanie formularza
    @RequestMapping(value = "/car", method = RequestMethod.GET)
    public String showCarForm(Model model) {
        model.addAttribute("car", new Car());
        return "/carAdd";
    }

    //wysyłanie danych z formularza
    @RequestMapping(value = "/car", method = RequestMethod.POST)
    public String carForm(@ModelAttribute Car car) {
        carDao.save(car);
        return "redirect:/car/user";
    }

    @RequestMapping("/car/list")
    public String findAll(Model model) {
        List<Car> all = carDao.find();
        model.addAttribute("cars", all);
        return "/carList";
    }

    @GetMapping("/car/delete")
    public String deleteCar(@ModelAttribute Car car) {
        carDao.delete(car);
        return "redirect:/car/list";
    }

    @RequestMapping(value = "/car/edit", method = RequestMethod.GET)
    public String editCarForm(Model model) {
        model.addAttribute("car", new Car());
        return "/carAdd";
    }

    @RequestMapping(value = "/car/edit", method = RequestMethod.POST)
    public String carEditForm(@ModelAttribute Car car) {
        carDao.update(car);
        return "redirect:/car/list";

    }
}


