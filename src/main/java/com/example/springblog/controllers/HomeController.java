package com.example.springblog.controllers;

import com.example.springblog.models.Ad;
import com.example.springblog.models.Post;
import com.example.springblog.repositories.AdRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    // Establish adsDao instance property
    private final AdRepository adsDao;
    // Anytime this controller is used, inject the adsDao so we can use it!
    public HomeController(AdRepository adsDao) {
        this.adsDao = adsDao;
    }

    @GetMapping("/")
    @ResponseBody
    public String landing() {
        return "This is the landing page!";
    }

    @GetMapping("/dogpark")
    public String dogpark(Model model) {
        List<String> dogs = new ArrayList<>();
        dogs.add("Bubbles");
        dogs.add("Spot");
        dogs.add("Ezekial");

        model.addAttribute("dogs", dogs);
        return "dogPark";
    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/ads")
    public String allAds(Model model) {
        List<Ad> ads = adsDao.findAll();
        for (Ad ad: ads){
            System.out.println("This ad title: " + ad.getTitle());
            System.out.println("This ad description: " + ad.getDescription());
            System.out.println("Owner: " + ad.getOwner().getFirstName() + " " + ad.getOwner().getLastName());
        }
        // Other methods to note:
        // .save() - insert new record, or update a record.
        // .delete() - delete a record
        // .findById() - find record by id


        model.addAttribute("ads", ads);

        return "ads";

    }

    @GetMapping("/ads/{id}")
    public String singlePost(@PathVariable long id, Model model)
    {
        Post singlePost = new Post(id, "First Post!", "This is the first time I've ever uses Spring");
        model.addAttribute("post", singlePost);
        return "posts/show";
    }

    @GetMapping("/ads/create")
    public String showCreateForm() {
        return "ads/create";
    }

    @PostMapping("/ads/create")
    public String create(@RequestParam(name = "title") String title, @RequestParam(name = "description") String description)
    {
        Ad ad = new Ad();
        ad.setTitle(title);
        ad.setDescription(description);
        // save the ad...
        return "red"
    }


}