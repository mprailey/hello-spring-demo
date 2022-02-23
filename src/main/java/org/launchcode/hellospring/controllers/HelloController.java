package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

//    Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }
    //Handles request at path /goodbye
    @GetMapping("goodbye")
     public String goodbye() {
        return "Goodbye, Spring!";
    }
    //Handles request of the form /hello?name=LaunchCode
    @RequestMapping(method={RequestMethod.GET,RequestMethod.POST}, value="hello")
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name +"!";
    }
    
    //Handles requests of the form name = /hello/LaunchCode

    @GetMapping("hello/{name}")
    public String helloWithPathVariable(@PathVariable String name){
        return "Hello, " + name +"!";
}

    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
