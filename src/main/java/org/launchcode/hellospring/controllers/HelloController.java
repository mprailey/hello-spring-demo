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
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language){
        return language  + name +"!";
    }
    
    //Handles requests of the form name = /hello/LaunchCode

    @GetMapping("hello/{name}")
    public String helloWithPathVariable(@PathVariable String name){
        return "Hello, " + name +"!";
}

    @GetMapping("form")
    public String createMessage(String name, String language){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +
                "<label> Name <input type='text' name='name'/></label>" +
                "<label> Language <select name='language'>" +
                   "<option value='Hello, '>English </option>" +
                    "<option value='Bonjour, '>French</option>" +
                    "<option value='Hola, '>Spanish</option>" +
                    "<option value='Ciao, '>Italian</option>" +
                    "<option value= 'Habari, '>Swahili</option>" +
                    "</select>" +
                "</label>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
