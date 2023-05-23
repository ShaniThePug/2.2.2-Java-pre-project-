package web.controller;

import model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CarServiceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class CarController {
    private CarServiceImpl csm = new CarServiceImpl();

    @GetMapping(value = "/cars")
    public String cars(@RequestParam(value = "count", defaultValue = "5") int count, Model model) {
        ArrayList<Car> cars = new ArrayList<>();
        Collections.addAll(cars,
                new Car("Chevrolet", 2023, "Unicorn"),
                new Car("Mazda", 6, "Red"),
                new Car("Haval", 2023, "Blue"),
                new Car("Porsche", 718, "Yellow"),
                new Car("Bugatti", 110, "Silver"));

        if (count < 0) {
            count = 0;
        }
        if (count > 5) {
            count = 5;
        }

        List<Car> limitCars = csm.countOfCars(cars, count);
        model.addAttribute("limitCars", limitCars);
        return "cars";
    }


}
