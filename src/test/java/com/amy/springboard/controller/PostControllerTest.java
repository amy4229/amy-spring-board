package com.amy.springboard.controller;

import com.amy.springboard.config.SecurityConfig;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("게시글 뷰 엔드포인트 테스트")
@Import(SecurityConfig.class)
@WebMvcTest(PostController.class)
class PostControllerTest {
    private final MockMvc mvc;

    public PostControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @Test
    @DisplayName("게시글 리스트 페이지 [GET][정상]")
    public void getPosts_list_normal() throws Exception {
        mvc.perform(get("/posts"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("posts"));
    }

    @Test
    @DisplayName("게시글 상세페이지[GET][정상]")
    public void getPost_detail_normal() throws Exception {
        mvc.perform(get("/posts/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("posts/detail"))
                .andExpect(model().attributeExists("post"))
                .andExpect(model().attributeExists("postComments"));
    }
    @Test
    @Disabled("구현전")
    @DisplayName("게시글 키워드검색페이지[GET][정상]")
    public void getPost_search_keyword_normal() throws Exception {
        mvc.perform(get("/posts/search"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML));
    }
    @Test
    @Disabled("구현전")
    @DisplayName("게시글 해시태그 검색 페이지[GET][정상]")
    public void getPost_search_tag_normal() throws Exception {
        mvc.perform(get("/posts/search-tag"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML));
    }

}
