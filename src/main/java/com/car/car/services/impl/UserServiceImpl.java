package com.car.car.services.impl;

import com.car.car.constants.ConstantAPI;
import com.car.car.entities.User;
import com.car.car.repositories.UserRepository;
import com.car.car.services.UserService;
import com.car.car.utils.UtilAPI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        log.info("Registro interno de un usuario {}", requestMap);
        try{
            if(validateSignUp(requestMap)){
                User user = userRepository.findByEmail(requestMap.get("email"));
                if(Objects.isNull(user)){
                    userRepository.save(getUserFromMap(requestMap));
                    return UtilAPI.getResponseEntity("EL usuario se ha registrado con exito.", HttpStatus.CREATED);
                }else{
                    return UtilAPI.getResponseEntity("EL usuario ya existe con ese email", HttpStatus.BAD_REQUEST);
                }
            }else{
                return UtilAPI.getResponseEntity(ConstantAPI.INVALID_DATA, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return UtilAPI.getResponseEntity(ConstantAPI.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private boolean validateSignUp(Map<String, String> requestMap){
        if (requestMap.containsKey("nombre") &&
                requestMap.containsKey("numeroContacto") &&
                requestMap.containsKey("email") &&
                requestMap.containsKey("password"))
            return true;
        return false;
    }

    private User getUserFromMap(Map<String, String> requestMap){
        User user = new User();
        user.setNombre( requestMap.get("nombre"));
        user.setNumeroContacto( requestMap.get("numeroContacto"));
        user.setEmail( requestMap.get("email"));
        user.setPassword( requestMap.get("password"));
        user.setStatus( requestMap.get("false"));
        user.setRole( requestMap.get("user"));
        return user;
    }
}
