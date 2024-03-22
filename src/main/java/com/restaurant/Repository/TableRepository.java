package com.restaurant.Repository;

import com.restaurant.Entity.TableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TableRepository extends JpaRepository<TableEntity, Long> {

    Optional<TableEntity> findById(long Id);
}
