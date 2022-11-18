package com.example.springblog.controllers;

import com.example.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController
{
    @GetMapping("/posts")
    public String postsIndex()
    {
        List<Post> allPost = new ArrayList<>();
        Post p1 = new Post(1L, "Test Title", "test body");
        Post p2 = new Post(2L, "Exam Title", "exam body");
        Post p3 = new Post(3L, "Assesment Title", "assessment body");
        Post p4 = new Post(4L, "Final Title", "final body");

        allPost.add(p1);
        allPost.add(p2);
        allPost.add(p3);
        allPost.add(p4);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String singlePost(@PathVariable long id, Model model)
    {
        Post singlePost = new Post(id, "First Post!", "This is my first post");
        model.addAttribute("post", singlePost);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String showCreateForm()
    {
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String submitPost()
    {
        return "create a new post";
    }
}
