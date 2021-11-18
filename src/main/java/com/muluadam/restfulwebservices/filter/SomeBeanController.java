package com.muluadam.restfulwebservices.filter;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomeBeanController {

   @GetMapping("/static-filter")
    public  SomeBean getData(){
        return new SomeBean("value1", "value2", "value3");
    }


    @GetMapping("/dynamic-filter")
    public  MappingJacksonValue getDataf(){
        SomeBean someBean= new SomeBean("value1", "value2", "value3");

        //Omly field2 and field3 are send
        SimpleBeanPropertyFilter filter=
                SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");

        FilterProvider filters= new
                SimpleFilterProvider()
                .addFilter("SomeBeanFilter",filter);
        MappingJacksonValue mapping= new MappingJacksonValue(someBean);
        mapping.setFilters(filters);
        return  mapping;
    }

}
