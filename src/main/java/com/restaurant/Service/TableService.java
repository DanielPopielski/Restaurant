package com.restaurant.Service;

import com.restaurant.Dto.DishDto;
import com.restaurant.Dto.TableDto;
import com.restaurant.Entity.DishEntity;
import com.restaurant.Entity.TableEntity;
import com.restaurant.Repository.TableRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TableService {

    private final TableRepository tableRepository;
    private final ModelMapper modelMapper;

    public Optional<TableDto> getSingleTable(long id) {
        return tableRepository.findById(id)
                .map(o -> modelMapper.map(o, TableDto.class));
    }

    public List<TableDto> getAllTables() {
        return tableRepository.findAll().stream()
                .map(o -> modelMapper.map(o, TableDto.class))
                .collect(Collectors.toList());
    }

    public boolean addTable(TableDto tableDto) {
        if(tableRepository.findById(tableDto.getTableId()).isEmpty()) {
            tableRepository.save(modelMapper.map(tableDto, TableEntity.class));
            return true;
        }
        return false;
    }

    public Optional<TableDto> updateTable(TableDto tableDto) {
        tableRepository.save(modelMapper.map(tableDto, TableEntity.class));
        return Optional.of(tableDto);
    }

    public boolean deleteTable(long tableId){
        return tableRepository.findById(tableId).map(table -> {
            tableRepository.delete(table);
            return true;
        }).orElse(false);
    }
}
