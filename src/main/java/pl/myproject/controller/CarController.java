package pl.myproject.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.myproject.dao.CarDao;
import pl.myproject.entity.Car;
import java.util.List;

@Controller
public class CarController {
    public CarDao carDao;

    public CarController(CarDao carDao) {
        this.carDao = carDao;
    }
    private static final Logger logger = LoggerFactory.getLogger(CarController.class);

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
        return "redirect:/user";
    }

    @RequestMapping("/car/list")
    @ResponseBody
    public String findAll() {
        List<Car> all = carDao.find();
        all.forEach(b -> logger.info(b.toString()));
        return all.toString();
    }

}


