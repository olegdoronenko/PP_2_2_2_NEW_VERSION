package service;

import dao.CarDaoImp;
import model.Car;
import dao.CarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Repository
@Service
public class CarServiceImp implements CarService {
    @Autowired
    private CarDao carDao = new CarDaoImp();
    @Override
    public List<Car> setCarsList() {
        return carDao.setCarsList();
    }

    @Override
    public List<Car> getCarsFromList(List<Car> carsList, int quantity) {
        return carDao.getCarsFromList(carsList, quantity);
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
