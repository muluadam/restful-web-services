package com.muluadam.restfulwebservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {

    //Used to read  properties file;
@Autowired
    private MessageSource messageSource;

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

    @RequestMapping(method = RequestMethod.GET,path = "/helloworld-inter")
    public  String helloWorldInter(@RequestHeader(name="Accept-Language",required = false) Locale locale){
        //en Hello world
        //am Welcom
        return  messageSource.getMessage("good.message",null, locale);
       // return "Hello World";
    }
    @RequestMapping(method = RequestMethod.GET,path = "/helloworld-inter2")
    public  String helloWorldInter1(){
        //en Hello world
        //am Welcom
        return  messageSource.getMessage("good.message",null, LocaleContextHolder.getLocale());

    }
}
