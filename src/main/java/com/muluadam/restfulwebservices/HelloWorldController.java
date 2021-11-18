package com.muluadam.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    //GET
    //URL /helloworld
    //method- "Hello World"
   // @GetMapping("/helloworld")
    @RequestMapping(method = RequestMethod.GET,path = "/helloworld")
    public  String helloWorld(){
        return "Hello World";
    }

}
