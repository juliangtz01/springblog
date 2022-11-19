package com.example.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController
{
    @GetMapping("/")
    @ResponseBody
    public String home()
    {
        return "This is the landing page!";
    }

    @GetMapping("/dogPark")
    public String dogPark(Model model)
    {
        List<String> dogs = new ArrayList<>();
        dogs.add("Bubbles");
        dogs.add("Spot");
        dogs.add("Ezekial");
        model.addAttribute("dogs", dogs);
        return "dogPark";
    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model)
    {
        model.addAttribute("name", name);
        return "hello";
    }
}
