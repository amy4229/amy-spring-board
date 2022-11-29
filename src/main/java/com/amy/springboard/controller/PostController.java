package com.amy.springboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {
    /**
     * TODO
     * /posts/{post-id}
     * /posts/search
     * /posts/search-tag
     * */

    @GetMapping
    public String posts(ModelMap map){
        map.addAttribute("posts", List.of());
        return "posts/index";
    }
}
