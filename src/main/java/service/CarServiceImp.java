package service;

import dao.CarDaoImp;
import model.Car;
import dao.CarDao;

import java.util.List;

public class CarServiceImp implements CarService {
    CarDao carDao = new CarDaoImp();
    @Override
    public List<Car> setCarsList() {
        return carDao.setCarsList();
    }

    public List<Car> getCarsFromList(List<Car> carsList, int quantity) {
        return carDao.getCarsFromList(carsList, quantity);
    }
}
