package com.example.springblog.controllers;

import com.example.springblog.models.Post;
import com.example.springblog.models.User;
import com.example.springblog.repositories.PostRepository;
import com.example.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class PostController
{
    private final PostRepository postDao;

    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao)
    {
        this.postDao = postDao;
        this.userDao = userDao;
    }
    @GetMapping("/posts")
    public String postsIndex(Model model)
    {
        // Instantiate the list to hold all the Post objects
//        List<Post> allPosts = new ArrayList<>();
//        // Instantiate new Post objects
//        Post p1 = new Post(1, "Test Title", "test body");
//        Post p2 = new Post(2, "Exam Title", "exam body");
//        Post p3 = new Post(3, "Assessment Title", "assessment body");
//        Post p4 = new Post(4, "Final Title", "final body");
//
//        // Add newly instantiated Posts to the list
//        allPosts.add(p1);
//        allPosts.add(p2);
//        allPosts.add(p3);
//        allPosts.add(p4);

        List<Post> allPosts = postDao.findAll();

        // Add the list of Posts as a model attribute to send to the template for rendering
        model.addAttribute("allPosts", allPosts);
        // return the template
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String singlePost(@PathVariable long id, Model model)
    {
        Post singlePost = postDao.getById(id);
        model.addAttribute("post", singlePost);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model model)
    {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String submitPost(@ModelAttribute Post post)
    {
        User user = userDao.getById(1L);
        post.setUser(user);
        postDao.save(post);

        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, Model model)
    {
        Post post = postDao.getById(id);
        model.addAttribute("post", post);
//        model.addAttribute("post", postDao.getReferenceById(id));
        return "posts/edit";
    }

    @PostMapping("/posts/edit")
    public String editPost(@ModelAttribute Post post)
    {
        postDao.save(post);
        return "redirect:/posts";
    }
}
