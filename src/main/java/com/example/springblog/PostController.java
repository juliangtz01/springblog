package com.example.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController
{
    @GetMapping("/posts")
    @ResponseBody
    public String posts()
    {
        return "posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String posts(@PathVariable int id)
    {
        return "view an individual post";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String postsCreate()
    {
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String postsPostCreate()
    {
        return "create a new post";
    }
}
