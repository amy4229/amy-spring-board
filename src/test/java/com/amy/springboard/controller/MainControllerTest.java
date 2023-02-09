package com.amy.springboard.controller;

import com.amy.springboard.config.SecurityConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import(SecurityConfig.class)
@DisplayName("디포트 url에 대한 테스트")
@WebMvcTest
class MainControllerTest {

    private final MockMvc mvc;

    public MainControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @Test
    @DisplayName("루트경로는 게시판 경로로 리달이렉트 된다")
    void requestRootPage_redirectPostsPage () throws Exception {
        mvc.perform(get("/"))
                .andExpect(status().is3xxRedirection());
    }

}