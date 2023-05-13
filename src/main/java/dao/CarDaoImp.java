package dao;

import model.Car;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImp implements CarDao{
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
}
