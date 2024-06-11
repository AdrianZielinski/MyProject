package pl.myproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.myproject.dao.UserDao;
import pl.myproject.entity.User;

@Controller
public class UserController {

    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String showUserForm(Model model) {
        model.addAttribute("user", new User());
        return "/userAdd"; }

    //wysyłanie danych z formularza

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String userForm(@ModelAttribute User user) {
        userDao.save(user);
        return "userAdd";
    }
}
