package web.dao;

import org.springframework.stereotype.Repository;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao {

    private List<Car> carList;

    {
        carList = new ArrayList<>();
        carList.add(new Car(1, "Kia", 10));
        carList.add(new Car(2, "Honda", 20));
        carList.add(new Car(3, "Toyota", 30));
        carList.add(new Car(4, "BMW", 40));
        carList.add(new Car(5, "Lada", 50));
    }
    public List<Car> getCars() {
        return carList;
    }

    public List<Car> getCars(int count) {
        return carList.stream().limit(count).toList();
    }
}

