package com.amy.springboard.service;

import com.amy.springboard.constant.SearchType;
import com.amy.springboard.dto.PostDto;
import com.amy.springboard.repository.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;

import static org.assertj.core.api.Assertions.assertThat;



@DisplayName("게시글정보 서비스 테스트")
@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    private final Logger logger = LoggerFactory.getLogger(PostServiceTest.class);
    @InjectMocks private PostService postService;

    @Mock private PostRepository postRepository;

    @Test
    @DisplayName("게시글검색하면, 검색결과페이지 가져오기")
    void keyword_search_getResults () {
        //given
        //when
        Page<PostDto> posts = postService.searchPosts(SearchType.TITLE, "Big Game");
        //then
        assertThat(posts).isNotNull();
        logger.debug(posts.toString());
    }

    @Test
    @DisplayName("게시글 조회(ID)하면, 게시글 가져오기")
    void searchByID_getResults () throws Exception{
        //given
        //when
        PostDto post = postService.findPost(1L);
        //then
        assertThat(post.title()).isEqualTo("Perfume of the Lady in Black, The (Il profumo della signora in nero)");
        logger.debug(post.toString());
    }

}
