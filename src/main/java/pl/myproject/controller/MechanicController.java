package pl.myproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.myproject.dao.MechanicDao;
import pl.myproject.entity.Car;
import pl.myproject.entity.Mechanic;

@Controller
public class MechanicController {
    private final MechanicDao mechanicDao;

    public MechanicController(MechanicDao mechanicDao) {
        this.mechanicDao = mechanicDao;
    }

    @RequestMapping(value = "/mechanic", method = RequestMethod.GET)
    public String showMechanicForm(Model model) {
        model.addAttribute("mechanic", new Mechanic());
        return "/mechanicAdd"; }

    //wysyłanie danych z formularza

    @RequestMapping(value = "/mechanic", method = RequestMethod.POST)
    public String mechanicForm(@ModelAttribute Mechanic mechanic) {
        mechanicDao.save(mechanic);
        return "redirect:/";
    }
}
