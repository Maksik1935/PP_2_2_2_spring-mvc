package web.service;

import web.model.Car;

import java.util.*;

public interface CarService {
    List<Car> getCarsWithCount(Integer count);
}
