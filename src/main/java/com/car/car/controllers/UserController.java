package com.car.car.controllers;

import com.car.car.constants.ConstantAPI;
import com.car.car.services.UserService;
import com.car.car.utils.UtilAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody(required = true) Map<String, String> requestMap){
        try {
            userService.signUp(requestMap);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return UtilAPI.getResponseEntity(ConstantAPI.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
