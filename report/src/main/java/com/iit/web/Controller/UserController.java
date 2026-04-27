package com.iit.web.Controller;

import com.iit.web.Dto.UserInfoForAccusedDto;
import com.iit.web.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController
{
    @Autowired
    UserRepo userRepo;

    @GetMapping("/users")
    public List<UserInfoForAccusedDto> getUsersForAccused(@RequestParam String query){
        return userRepo.findByName(query);
    }
}
