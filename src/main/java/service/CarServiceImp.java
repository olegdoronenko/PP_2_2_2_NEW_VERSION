package service;

import model.Car;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Service
public class CarServiceImp implements CarService {

    @Override
    public List<Car> setCarsList() {
        List<Car> carsList = new ArrayList<>(5);
        carsList.add(0, new Car("BMW", "X5", "black"));
        carsList.add(1, new Car("Lincoln", "Navigator", "pearl-white"));
        carsList.add(2, new Car("Ford", "Bronco", "green"));
        carsList.add(3, new Car("Pagani", "Zonda", "silver"));
        carsList.add(4, new Car("Toyota", "Mark II", "blue"));

        return carsList;
    }

    @Override
    public List<Car> getCarsFromList(List<Car> carsList, int quantity) {
        return carsList.subList(0, quantity);
    }

    @Override
    public List<Car> getCarsListForPage(HttpServletRequest request) {
        List<Car> carsList;
        String countRequest = request.getParameter("count");
        if (countRequest != null) {
            int count = Integer.parseInt(countRequest);
            if ((count > 0) && (count <= 5)) {
                carsList = getCarsFromList(setCarsList(), count);
            } else {
                carsList = setCarsList();
            }
        } else {
            carsList = setCarsList();
        }
        return carsList;
    }
}
