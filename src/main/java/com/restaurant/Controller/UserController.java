package com.restaurant.Controller;

import com.restaurant.Dto.DishDto;
import com.restaurant.Dto.UserDto;
import com.restaurant.Service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
@AllArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping(value = "save")
    public boolean addUser(@RequestBody UserDto userDto) {
        if (userService.getSingleUser(userDto.getUserId()).isEmpty()) {
            userService.addUser(userDto);
            return true;
        }
        return false;
    }

    @PutMapping
    public ResponseEntity editUser(@RequestBody UserDto updatedUserDto) {
        return userService.updateUser(updatedUserDto)
                .map(user -> new ResponseEntity(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity("There is no user with the given id " + updatedUserDto.getUserId(), HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{Id}")
    public ResponseEntity deleteUser(@PathVariable long Id) {
        if (userService.getSingleUser(Id).isPresent()) {
            userService.deleteUser(Id);
            return new ResponseEntity("User with id " + Id + " has been deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity("User with id " + Id + " does not exist", HttpStatus.NOT_FOUND);
        }
    }
}
