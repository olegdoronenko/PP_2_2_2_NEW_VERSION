package controller;

import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import service.CarService;
import service.CarServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class CarController {

    private CarService carService = new CarServiceImp();

    @GetMapping(value = "/cars")
    public String printWelcome(Model model, HttpServletRequest request) {
        List<Car> carsList = carService.getCarsListForPage(request);
        model.addAttribute("carsList", carsList);

        return "cars";

    }
}
