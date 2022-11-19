package com.example.springblog.controllers;

import com.example.springblog.models.Ad;
import com.example.springblog.repositories.AdRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class HomeController
{
    // Establish adsDao instance property
    private final AdRepository adsDao;
    // Anytime this controller is used, inject the adsDao, so we can use it!
    public HomeController(AdRepository adsDao)
    {
        this.adsDao = adsDao;
    }

    @GetMapping("/")
    @ResponseBody
    public String home()
    {
        return "This is the landing page!";
    }

    @GetMapping("/ads")
    public String allAds(Model model)
    {
        List<Ad> ads = adsDao.findAll();
        // Other methods to note:
        // .save() - insert new record, or update a record
        // .delete() - delete a record
        // .findById() - find record by id

        model.addAttribute("ads", ads);
        return "ads";
    }
}
