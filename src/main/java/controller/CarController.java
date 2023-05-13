package controller;

import model.Car;
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
    private List<Car> carsList = carService.setCarsList();

    @GetMapping(value = "/cars")
    public String printWelcome(Model model, HttpServletRequest request) {
        model.addAttribute("header", "This is our cars");
        String countRequest = request.getParameter("count");

        if (countRequest != null) {
            int count = Integer.parseInt(countRequest);
            if ((count > 0) && (count <= 5)) {
                List<Car> carsSubList = carService.getCarsFromList(carsList, count);
                model.addAttribute("carsList", carsSubList);
            } else {
                model.addAttribute("carsList", carsList);
            }
        } else {
            model.addAttribute("carsList", carsList);
        }

        return "cars";

    }
}
