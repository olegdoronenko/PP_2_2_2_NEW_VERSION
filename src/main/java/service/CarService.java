package service;

import model.Car;

import java.util.List;

public interface CarService {
    List<Car> setCarsList();
    List<Car> getCarsFromList(List<Car> carsList, int quantity);
}