package pl.myproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.myproject.dao.CarReviewDao;
import pl.myproject.entity.Car;
import pl.myproject.entity.CarReview;

import java.util.List;

@Controller
public class CarReviewController {
    private final CarReviewDao carReviewDao;


    public CarReviewController(CarReviewDao carReviewDao) {
        this.carReviewDao = carReviewDao;
    }

    @RequestMapping(value = "/car/review", method = RequestMethod.GET)
    public String showReviewForm(Model model) {
        model.addAttribute("carReview", new CarReview());
        return "/reviewAdd"; }

    //wysyłanie danych z formularza

    @RequestMapping(value = "/car/review", method = RequestMethod.POST)
    public String carReviewForm(@ModelAttribute CarReview carReview) {
        carReviewDao.save(carReview);
        return "redirect:/car/mechanic";
    }

    @RequestMapping("/car/review/list")
    public String findAll(Model model) {
        List<CarReview> all = carReviewDao.find();
        model.addAttribute("reviews", all);
        return "/reviewList";
    }

    @GetMapping("/car/review/delete")
    public String deleteCar(@ModelAttribute CarReview carReview) {
        carReviewDao.delete(carReview);
        return "redirect:/car/review/list";
    }

    @RequestMapping(value = "/car/review/edit", method = RequestMethod.GET)
    public String editReviewForm(Model model) {
        model.addAttribute("carReview", new CarReview());
        return "/reviewAdd";
    }

    @RequestMapping(value = "/car/review/edit", method = RequestMethod.POST)
    public String editCarReviewForm(@ModelAttribute CarReview carReview) {
        carReviewDao.update(carReview);
        return "redirect:/car/review/list";

    }

}
