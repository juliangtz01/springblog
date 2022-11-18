package com.example.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FirstController
{
    @GetMapping("/test")
    @ResponseBody
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

    @GetMapping("/greeting/{name}/{lastName}")
    @ResponseBody
    public String greeting(@PathVariable String name, @PathVariable String lastName)
    {
        return "Greetings " + name + " " + lastName;
    }
}
