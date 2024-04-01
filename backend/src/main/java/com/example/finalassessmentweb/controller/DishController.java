package com.example.finalassessmentweb.controller;

import com.example.finalassessmentweb.beans.ResponseHandler;
import com.example.finalassessmentweb.entity.Dish;
import com.example.finalassessmentweb.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dishes")
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping("/")
    public ResponseEntity<Object> getAllDishes() {
        List<Dish> dishes = dishService.getAllDishes();
        return ResponseHandler.createResponse("", HttpStatus.OK, dishes);
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<?> getDishById(@PathVariable Long id) {
        Dish dish = dishService.getDishById(id);
        return ResponseHandler.createResponse("Dish found", HttpStatus.OK,  dish);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createDish(@RequestBody Dish dish) {
        Object createdDish = dishService.createDish(dish);
        return ResponseHandler.createResponse("New Dish is created", HttpStatus.CREATED, createdDish);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDishById(@PathVariable Long id) {
        Dish dish = dishService.getDishById(id);
        dishService.deleteDishById(id);
        return ResponseHandler.createResponse("Dish Deleted", HttpStatus.OK,  dish);
    }

    @PutMapping("/update")
    public  Object updateDish(@RequestBody Dish dish){
        Object updateDish = dishService.updateDish(dish);
        return ResponseHandler.createResponse("Dish name is updated", HttpStatus.OK, updateDish);
    }
}
