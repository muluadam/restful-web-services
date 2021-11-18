package com.muluadam.restfulwebservices;

import org.springframework.web.bind.annotation.*;

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
@GetMapping("/helloworldbean")
    public HelloWorldBean helloWorldBean(){
        return  new HelloWorldBean("Hello World Beab");
    }
    @GetMapping("/hellobeantostring")
    public String bean(){
        return new HelloWorldBean("Hello Muluadam").toString();
    }

    @GetMapping("/hellobeantostring/path-variable/{name}")
    public String beanwithvarialble(@PathVariable  String name){
        return new HelloWorldBean(name ).toString();
    }

}
