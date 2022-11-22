package com.example.springblog.controllers;

import com.example.springblog.models.Post;
import com.example.springblog.models.User;
import com.example.springblog.repositories.PostRepository;
import com.example.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
//        Post singlePost = new Post(id, "First Post!", "This is the first time I've ever uses Spring");
        Post singlePost = postDao.getReferenceById(id);
        model.addAttribute("post", singlePost);
        return "posts/show";
    }

    // NOT USING FORM MODEL BINDING
//    @GetMapping("/posts/create")
//    public String showCreateForm()
//    {
//        return "posts/create";
//    }

    //USING FORM MODEL BINDING
    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    // NOT USING FROM MODEL BINDING
//    @PostMapping("/posts/create")
//    public String submitPost(String title, String body)
//    {
//        System.out.println(title);
//        System.out.println(body);
//        Post newPost = new Post(title, body);
//        postDao.save(newPost);
//        return "redirect:/posts";
//    }

//    USING FORM MODEL BINDING
    @PostMapping("/posts/create")
    public String create(@ModelAttribute Post post){
        User user = userDao.getById(1L);
        post.setUser(user);
        postDao.save(post);
        return "redirect:/posts";
    }
}
