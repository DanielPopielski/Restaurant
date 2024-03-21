package com.restaurant.Service;

import com.restaurant.Dto.DishDto;
import com.restaurant.Dto.UserDto;
import com.restaurant.Entity.DishEntity;
import com.restaurant.Entity.UserEntity;
import com.restaurant.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    public Optional<UserDto> getSingleUser(long Id) {
        return userRepository.findById(Id)
                .map(user -> modelMapper.map(user, UserDto.class));
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(o -> modelMapper.map(o, UserDto.class))
                .collect(Collectors.toList());
    }

    public boolean addUser(UserDto userDto) {
        if(userRepository.findById(userDto.getUserId()).isEmpty()) {
            userDto.setRole("ROLE_USER");
            userRepository.save(modelMapper.map(userDto, UserEntity.class));
            return true;
        }
        return false;
    }

    public Optional<UserDto> updateUser(UserDto userDto) {
        userRepository.save(modelMapper.map(userDto, UserEntity.class));
        return Optional.of(userDto);
    }

    public boolean deleteUser(long userId){
        return userRepository.findById(userId).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
    }
}
