package pl.myproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.myproject.dao.CarListDao;


@Controller
public class CarListController {
    private final CarListDao carListDao;

    private CarListController(CarListDao carListDao) {
        this.carListDao = carListDao;
    }





}
