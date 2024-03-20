package com.restaurant.Service;

import com.restaurant.Dto.DishDto;
import com.restaurant.Entity.DishEntity;
import com.restaurant.Repository.DishRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class DishService {

    private final DishRepository dishRepository;
    private final ModelMapper modelMapper;

    public Optional<DishDto> getSingleDish(long id) {
        return dishRepository.findById(id)
                .map(o -> modelMapper.map(o, DishDto.class));
    }

    public List<DishDto> getAllDishes() {
        return dishRepository.findAll().stream()
                .map(o -> modelMapper.map(o, DishDto.class))
                .collect(Collectors.toList());
    }

    public boolean addDish(DishDto dishDto) {
        if(dishRepository.findById(dishDto.dishId()).isEmpty()) {
            dishRepository.save(modelMapper.map(dishDto, DishEntity.class));
            return true;
        }
        return false;
    }

    public Optional<DishDto> updateDish(DishDto dishDto) {
        dishRepository.save(modelMapper.map(dishDto, DishEntity.class));
        return Optional.of(dishDto);
    }

    public boolean deleteDish(long dishId){
        return dishRepository.findById(dishId).map(dish -> {
            dishRepository.delete(dish);
            return true;
        }).orElse(false);
    }
}
