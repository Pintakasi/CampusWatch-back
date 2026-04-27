package com.iit.web.Controller;

import com.iit.web.Dto.UserInfoForAccusedDto;
import com.iit.web.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController
{
    private final UserRepo userRepo;

    @Autowired
    public UserController(UserRepo userRepo)
    {
        this.userRepo = userRepo;
    }

    @GetMapping("/find")
    public List<UserInfoForAccusedDto> getUsersForAccused(@RequestParam String query){
        return userRepo.findByName(query);
    }
}
