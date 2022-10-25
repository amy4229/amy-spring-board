package com.amy.springboard.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("Spring data rest API 테스트")
@AutoConfigureMockMvc
@Transactional
@SpringBootTest
public class DataRestTest {

    private final MockMvc mvc;


    public DataRestTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[api] 게시글리스트가져오기_정상")
    @Test
    void test_getPosts_normal() throws Exception {
        //Given

        //when and then
        mvc.perform(get("/api/posts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("[api] 게시글(id=1)가져오기_정상")
    @Test
    void test_getPost_normal() throws Exception {
        //Given

        //when and then
        mvc.perform(get("/api/posts/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")))
                .andDo(print());
    }

    @DisplayName("[api] 특정게시글(id=1)의 댓글리스트가져오기_정상")
    @Test
    void test_getPostComments_by_postId_normal() throws Exception {
        //Given

        //when and then
        mvc.perform(get("/api/posts/1/postComments"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")))
                .andDo(print());
    }


    @DisplayName("[api] 댓글리스트가져오기_정상")
    @Test
    void test_getPostComments_normal() throws Exception {
        //Given

        //when and then
        mvc.perform(get("/api/postComments"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("[api] 댓글(id=1)가져오기_정상")
    @Test
    void test_getPostComment_normal() throws Exception {
        //Given

        //when and then
        mvc.perform(get("/api/postComments/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }
    
    
}
