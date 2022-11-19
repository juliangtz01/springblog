package com.example.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// Controller - informing our compiler that this class contains methods for our URL pattern
@Controller
public class FirstController
{
    //GetMapping - controls get requests made to a specific URL pattern
    @GetMapping("/test")
    //ResponseBody - which returns a string as the response when visiting the URL pattern
    @ResponseBody
    // The method that is executed when visiting the URL Pattern
    public String test()
    {
        return "Hello from Spring";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/bubbles")
    @ResponseBody
    public String bubbles()
    {
        return "bbububub!";
    }

    // Establishing Path Variables in the URL pattern with curly braces
    @GetMapping("/greeting/{name}/{lastName}")
    @ResponseBody
    // PathVariables Annotation used to grab the value of the path variable
    public String greeting(@PathVariable String name, @PathVariable String lastName)
    {
        // Implementing the path variables via concatenation
        return "Greetings " + name + " " + lastName;
    }
}
