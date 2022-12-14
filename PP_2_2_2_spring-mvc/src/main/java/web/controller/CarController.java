package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.service.CarServiceImp;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    private final CarServiceImp carServiceImp;
    @Autowired
    public CarController(CarServiceImp carServiceImp) {
        this.carServiceImp = carServiceImp;
    }

    @GetMapping( "/cars")
    public String getCarsByCount(@RequestParam(value = "count", defaultValue = "0") int count, Model model) {
        if(count == 0) {
            model.addAttribute("all", carServiceImp.getCars());
        } else {
            model.addAttribute("cou", carServiceImp.getCars(count));
        }
        return "cars";
    }
}

    /*
    @GetMapping( "/cars")
    public String getCars(Model model) {
        model.addAttribute("all", carServiceImp.getCars());
        return "cars";
    }
    */
        /*
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(1, "Kia",10));
        carList.add(new Car(2, "Honda",20));
        carList.add(new Car(3, "Toyota",30));
        carList.add(new Car(4, "BMW",40));
        carList.add(new Car(5, "Lada",50));
        model.addAttribute("carList", carList);

        if(count = 0) {
            return "cars";
        } else if (count = 2) {

        } else if (count = 3) {

        } else if (count = 4) {

        } else (count >= 5) {
            return "cars";
        }

         */