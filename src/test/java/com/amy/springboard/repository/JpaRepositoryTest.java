package com.amy.springboard.repository;

import com.amy.springboard.config.JpaConfig;
import com.amy.springboard.domain.Post;
import com.amy.springboard.domain.PostComment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.time.LocalDateTime;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

@DisplayName("jpa연결테스트")
@DataJpaTest
@Import(JpaConfig.class)
class JpaRepositoryTest {
    private Logger logger = LoggerFactory.getLogger(JpaRepositoryTest.class);
    private final PostRepository postRepository;
    private final PostCommentRepository postCommentRepository;

    public JpaRepositoryTest(@Autowired PostRepository postRepository, @Autowired PostCommentRepository postCommentRepository) {
        this.postRepository = postRepository;
        this.postCommentRepository = postCommentRepository;
    }

    @DisplayName("select")
    @Test
    void select_normal_sample_data_case(){
        //given

        //when
        List<Post> posts = postRepository.findAll();
        List<PostComment> postComments = postCommentRepository.findAll();

        //then
        assertThat(posts).isNotNull().hasSize(111);
        assertThat(postComments).isNotNull().hasSize(1000);
    }


    @DisplayName("post insert")
    @Test
    void insert_post(){
        //given
        Post input = Post.of("Title1","content1","#tag1");
        //when
        Post output = postRepository.save(input);

        logger.debug(output.toString());
        //then
        assertThat(output).isNotNull();
        assertThat(output.getTitle()).isEqualTo(input.getTitle());
        assertThat(output.getContent()).isEqualTo(input.getContent());
        assertThat(output.getTag()).isEqualTo(input.getTag());
        assertThat(output.getCreatedAt()).isNotNull();
        assertThat(output.getCreatedBy()).isEqualTo("amy");
        assertThat(output.getModifiedAt()).isNotNull();
        assertThat(output.getCreatedBy()).isNotNull().isEqualTo("amy");
    }


    @DisplayName("post update")
    @Test
    void update_post_normal(){
        //given
        Post input = postRepository.findById(1L).orElseThrow();
        logger.debug(input.toString());
        String updateTag = "update tag";
        String inputCreatedBy = input.getCreatedBy();
        LocalDateTime inputCreatedAt = input.getCreatedAt();
        String inputModifiedBy = input.getModifiedBy();
        LocalDateTime inputModifiedAt = input.getModifiedAt();

        input.setTag(updateTag);
        //when
        Post output = postRepository.saveAndFlush(input);

        logger.debug(output.toString());
        //then
        assertThat(output).isNotNull();
        assertThat(output.getTitle()).isEqualTo(input.getTitle());
        assertThat(output.getContent()).isEqualTo(input.getContent());
        assertThat(output.getTag()).isEqualTo(updateTag);
        assertThat(output.getCreatedAt().compareTo(inputCreatedAt)).isEqualTo(0);
        assertThat(output.getCreatedBy()).isEqualTo(inputCreatedBy);
        assertThat(output.getModifiedAt().compareTo(inputModifiedAt)).isNotEqualTo(0);
        assertThat(output.getModifiedBy()).isNotEqualTo(inputModifiedBy);

    }

    @DisplayName("post delete")
    @Test
    void delete_post_normal(){
        //given
        Post input = postRepository.findById(2L).orElseThrow();
        long prePostCnt = postRepository.count();
        long prePostCommentCnt = postCommentRepository.count();
        int will_deleted_prePostCommentCnt = input.getPostComments().size();
        logger.debug(input.toString());
        input.getPostComments().forEach(c->logger.debug(c.toString()));

        //when
        postRepository.delete(input);

        //then
        assertThat(postRepository.count()).isEqualTo(prePostCnt-1);
        assertThat(postCommentRepository.count()).isEqualTo(prePostCommentCnt-will_deleted_prePostCommentCnt);

    }




}
