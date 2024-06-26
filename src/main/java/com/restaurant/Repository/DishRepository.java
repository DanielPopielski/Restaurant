package com.restaurant.Repository;

import com.restaurant.Entity.DishEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DishRepository extends JpaRepository<DishEntity, Long> {
    Optional<DishEntity> findByNameOfTheDish(String nameOfTheDish);
    Optional<DishEntity> findById(long dishId);
}
