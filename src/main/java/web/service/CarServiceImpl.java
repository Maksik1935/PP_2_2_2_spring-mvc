package web.service;

import org.springframework.stereotype.*;
import web.model.*;

import java.util.*;
import java.util.stream.*;

@Service
public class CarServiceImpl implements CarService{
    List<Car> cars = new ArrayList<>(List.of(
            new Car("name1", 10, true),
            new Car("name2", 11, true),
            new Car("name3", 12, false),
            new Car("name4", 13, false),
            new Car("name5", 14, true)));
    @Override
    public List<Car> getCarsWithCount(Integer count) {
        if (count == null) {
            return cars;
        }
        return cars.stream().limit(count).toList();
    }
    }
