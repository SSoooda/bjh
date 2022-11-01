package com.bjh.webservice.service;

import com.bjh.webservice.domain.posts.Posts;
import com.bjh.webservice.domain.posts.PostsRepository;
import com.bjh.webservice.web.DTO.PostsSaveRequestDto;
import com.bjh.webservice.web.service.PostsService;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void Dto데이터가_posts테이블에_저장된다(){
        //given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .title("테스트 타이틀")
                .author("ssoooooda@gmail.com")
                .content("테스트")
                .build();
        //when
        postsService.save(dto);

        //then
        Posts posts = postsRepository.findAll().get(0);
        Assertions.assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
        Assertions.assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
        Assertions.assertThat(posts.getContent()).isEqualTo(dto.getContent());
    }

}
