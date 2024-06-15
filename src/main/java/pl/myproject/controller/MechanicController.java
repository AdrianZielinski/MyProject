package pl.myproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.myproject.dao.MechanicDao;
import pl.myproject.entity.Mechanic;

import java.util.List;

@Controller
public class MechanicController {
    private final MechanicDao mechanicDao;

    public MechanicController(MechanicDao mechanicDao) {
        this.mechanicDao = mechanicDao;
    }

    @RequestMapping(value = "/car/mechanic", method = RequestMethod.GET)
    public String showMechanicForm(Model model) {
        model.addAttribute("mechanic", new Mechanic());
        return "/mechanicAdd"; }

    //wysyłanie danych z formularza

    @RequestMapping(value = "/car/mechanic", method = RequestMethod.POST)
    public String mechanicForm(@ModelAttribute Mechanic mechanic) {
        mechanicDao.save(mechanic);
        return "redirect:/car/list";
    }

    @RequestMapping("/car/mechanic/list")
    public String findAll(Model model) {
        List<Mechanic> all = mechanicDao.find();
        model.addAttribute("mechanics", all);
        return "/mechanicList";
    }
    @GetMapping("/car/mechanic/delete")
    public String deleteCar(@ModelAttribute Mechanic mechanic) {
        mechanicDao.delete(mechanic);
        return "redirect:/car/mechanic/list";
    }

    @RequestMapping(value = "/car/mechanic/edit", method = RequestMethod.GET)
    public String editMechanicForm(Model model) {
        model.addAttribute("mechanic", new Mechanic());
        return "/mechanicAdd";
    }

    @RequestMapping(value = "/car/mechanic/edit", method = RequestMethod.POST)
    public String editCarMechanicForm(@ModelAttribute Mechanic mechanic) {
        mechanicDao.update(mechanic);
        return "redirect:/car/mechanic/list";

    }


}
