package com.restaurant.Controller;

import com.restaurant.Dto.DishDto;
import com.restaurant.Service.DishService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dishes")
@AllArgsConstructor
public class DishController {

    private final DishService dishService;

    @GetMapping
    public ResponseEntity getAllDishes() {
        return new ResponseEntity(dishService.getAllDishes(), HttpStatus.OK);
    }

    @GetMapping("/{Id}")
    public ResponseEntity getSingleDish(@PathVariable long Id) {
        return dishService.getSingleDish(Id)
                .map(dishDto -> new ResponseEntity(dishDto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity("There is no Dish with the given id " + Id, HttpStatus.BAD_REQUEST));
    }

    @PostMapping(value = "save")
    public boolean addDish(@RequestBody DishDto dishDto) {
        if (dishService.getSingleDish(dishDto.getDishId()).isEmpty()) {
            dishService.addDish(dishDto);
            return true;
        }
        return false;
    }

    @PutMapping
    public ResponseEntity editDish(@RequestBody DishDto updatedDishDto) {
        return dishService.updateDish(updatedDishDto)
                .map(dish -> new ResponseEntity(dish, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity("There is no dish with the given id " + updatedDishDto.getDishId(), HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{Id}")
    public ResponseEntity deleteAuthor(@PathVariable long Id) {
        if (dishService.getSingleDish(Id).isPresent()) {
            dishService.deleteDish(Id);
            return new ResponseEntity("Dish with id " + Id + " has been deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity("Dish with id " + Id + " does not exist", HttpStatus.NOT_FOUND);
        }
    }
}
