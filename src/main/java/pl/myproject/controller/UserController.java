package pl.myproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.myproject.dao.UserDao;
import pl.myproject.entity.Mechanic;
import pl.myproject.entity.User;

import java.util.List;

@Controller
public class UserController {

    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping(value = "/car/user", method = RequestMethod.GET)
    public String showUserForm(Model model) {
        model.addAttribute("user", new User());
        return "/userAdd"; }

    //wysyłanie danych z formularza

    @RequestMapping(value = "/car/user", method = RequestMethod.POST)
    public String userForm(@ModelAttribute User user) {
        userDao.save(user);
        return "redirect:/car/review";
    }

    @RequestMapping("/car/user/list")
    public String findAll(Model model) {
        List<User> all = userDao.find();
        model.addAttribute("users", all);
        return "/userList";
    }

    @GetMapping("/car/user/delete")
    public String deleteCar(@ModelAttribute User user) {
        userDao.delete(user);
        return "redirect:/car/user/list";
    }

    @RequestMapping(value = "/car/user/edit", method = RequestMethod.GET)
    public String editUserForm(Model model) {
        model.addAttribute("user", new User());
        return "/userAdd";
    }

    @RequestMapping(value = "/car/user/edit", method = RequestMethod.POST)
    public String editCarUserForm(@ModelAttribute User user) {
        userDao.update(user);
        return "redirect:/car/user/list";
    }
}
