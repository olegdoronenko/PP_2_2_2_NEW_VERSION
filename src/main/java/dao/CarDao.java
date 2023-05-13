package dao;

import model.Car;
import java.util.List;

public interface CarDao {
    public List<Car> setCarsList();
    public List<Car> getCarsFromList(List<Car> carsList, int quantity);
}