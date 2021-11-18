package com.muluadam.restfulwebservices.user;

import com.muluadam.restfulwebservices.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController()

public class UserController {
    @Autowired
            UserDaoService userDaoService;

    @GetMapping("/user")
        public List<User> getAll(){
        return  userDaoService.findAll();
        }

    @GetMapping("/user/{id}")
    public User getOne(@PathVariable int id){
User user= userDaoService.findOne(id);
    if (user==null){
        throw new UserNotFoundException("User Not Found Exception ");
    }
    return user;
    }
    @PostMapping("/user")
    public ResponseEntity<Object> addUser(@RequestBody User user){
       // System.out.println(user);
User savedUser=userDaoService.save(user);
       URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
         return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable int id){
        User deletedUser=userDaoService.delete(id);
        URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("").buildAndExpand("").toUri();
        return ResponseEntity.ok(location);
    }
}
