package com.amy.springboard.service;


import com.amy.springboard.constant.SearchType;
import com.amy.springboard.domain.Post;
import com.amy.springboard.dto.PostDto;
import com.amy.springboard.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> getAllPosts () {
        return postRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Page<PostDto> searchPosts(SearchType type, String keyword) {
        return Page.empty();
    }


    public PostDto findPost(long id) throws Exception{
        Post post= postRepository.findById(id).orElseThrow(()->new Exception("해당 게시글을 찾을 수 없습니다."));
        return null;
    }
}
