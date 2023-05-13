package service;

import model.Car;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface CarService {
    List<Car> setCarsList();
    List<Car> getCarsFromList(List<Car> carsList, int quantity);
    List<Car> getCarsListForPage(HttpServletRequest request);

}