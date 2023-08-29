package com.kosa.restservice.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloController {

    @Autowired
    private MessageSource messageSource; //message와 관련된 정보를 가지고 있는 객체

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World!!!";
    }

    @GetMapping("hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("hello douzon!!!");
    }

    @GetMapping("hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBean2(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello WorldBean, %s",name));
    }

    @GetMapping("/hello-world-international")
    public String helloWorldInternational(
            @RequestHeader(name="Accept-Language", required = false)
            Locale locale){
        return messageSource.getMessage("greeting.message", null, locale);
    }
//_en, _fn 처럼 지정되어있다.
}
