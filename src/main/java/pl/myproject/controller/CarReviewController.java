package pl.myproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.myproject.dao.CarReviewDao;
import pl.myproject.entity.CarReview;

@Controller
public class CarReviewController {
    private final CarReviewDao carReviewDao;

    public CarReviewController(CarReviewDao carReviewDao) {
        this.carReviewDao = carReviewDao;
    }

    @RequestMapping(value = "/carReview", method = RequestMethod.GET)
    public String showReviewForm(Model model) {
        model.addAttribute("carReview", new CarReview());
        return "carReview"; }

    //wysyłanie danych z formularza

    @RequestMapping(value = "/carReview", method = RequestMethod.POST)
    public String carReviewForm(@ModelAttribute CarReview carReview) {
        carReviewDao.save(carReview);
        return "redirect:/";
    }

}
