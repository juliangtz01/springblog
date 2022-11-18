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
    private final AdRepository adsDao;
    public HomeController(AdRepository adsDao)
    {
        this.allAds = adsDao;
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

        model.addAttribute("ads", ads);
        return "ads";
    }
}
