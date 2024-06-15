package pl.myproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.myproject.dao.MenuViewDao;
import pl.myproject.entity.MenuView;

import java.util.List;

@Controller
public class MenuViewController {
    public MenuViewDao menuViewDao;

    public MenuViewController(MenuViewDao menuViewDao) {
        this.menuViewDao = menuViewDao;
    }

    @RequestMapping("/car/menu")
    public String findAll(Model model) {
        List<MenuView> all = menuViewDao.find();
        model.addAttribute("cars", all);
        return "/menuView";
    }
}
