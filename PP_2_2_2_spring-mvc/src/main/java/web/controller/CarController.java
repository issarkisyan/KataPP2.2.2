package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.service.CarServiceImp;



@Controller
public class CarController {

    private final CarServiceImp carServiceImp;

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

