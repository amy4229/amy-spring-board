package com.amy.springboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {
    /**
     * TODO
     * /posts/search
     * /posts/search-tag
     * */

    @GetMapping
    public String posts(ModelMap map){
        map.addAttribute("posts", List.of());
        return "posts/index";
    }

    @GetMapping("/{postId}")
    public String posts(@PathVariable long postId, ModelMap map){
        map.addAttribute("post", null );
        map.addAttribute("postComments", List.of());
        return "posts/detail";
    }
}
