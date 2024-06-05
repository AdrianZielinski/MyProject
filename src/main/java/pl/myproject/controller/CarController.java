package pl.myproject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.myproject.dao.CarDao;
import pl.myproject.entity.Car;

import java.util.Arrays;
import java.util.List;

@Controller
public class CarController {

    private final CarDao carDao;

    public CarController(CarDao carDao) {
        this.carDao = carDao;
    }
//wyświetlanie formularza
    @RequestMapping(value = "/car", method = RequestMethod.GET)
    public String showCarForm(Model model) {
        model.addAttribute("car", new Car());
        return "/carAdd"; }

    //wysyłanie danych z formularza

    @RequestMapping(value = "/car", method = RequestMethod.POST)
    public String carForm(@ModelAttribute Car car) {
        carDao.save(car);
        return "redirect:/";
    }

    @ModelAttribute("paliwo")
    public List<String> checkOptions() {
        String[] paliwo = new String[] {"benzyna", "diesel", "LPG", "elektryczny", "inne"};
        return Arrays.asList(paliwo);
    }

    //dodawanie auta
    //edycja auta
    //usuwanie auta
    //wyświetlanie wszystkich aut
}
