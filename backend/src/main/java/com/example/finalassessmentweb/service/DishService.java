package com.example.finalassessmentweb.service;

import com.example.finalassessmentweb.entity.Dish;
import com.example.finalassessmentweb.exceptions.EntityIsAlreadyExistException;
import com.example.finalassessmentweb.exceptions.EntityNotFoundException;
import com.example.finalassessmentweb.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishService {

    @Autowired
    private DishRepository dishRepository;

    // fetch all dishes
    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    // fetch dishes by it's id
    public Dish getDishById(Long id) {
        Optional<Dish> dish = dishRepository.findById(id);
        if (dish.isPresent()) {
            return dish.get();
        }
        throw new EntityNotFoundException("Dish with given ID is not present");
    }

    // create new restaurant
    public Dish createDish(Dish dish) {
        Dish newDish = dishRepository.save(dish);
        return newDish;
    }

    // delete the dish item by it's id
    public void deleteDishById(Long id) {
        Optional<Dish> dish = dishRepository.findById(id);
        if (dish.isPresent()) {
            dishRepository.deleteById(id);
        }
    }

    // update the restaurants details
    public Dish updateDish(Dish dish) {

        Optional<Dish> optionalDish = dishRepository.findById(dish.getId());

        if (optionalDish.isPresent()) {
            optionalDish.get().setName(dish.getName());
            Dish updatedDish = dishRepository.save(optionalDish.get());
            return updatedDish;
        } else {
            throw new EntityIsAlreadyExistException("Dish is not exist");
        }
    }
}
