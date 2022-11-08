package com.bjh.webservice.web.controller;

import com.bjh.webservice.domain.posts.PostsRepository;
import com.bjh.webservice.web.DTO.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsRepository postsRepository;
    private Environment env;

    @PostMapping("/posts")
    public boolean savePosts(@RequestBody PostsSaveRequestDto dto){
        postsRepository.save(dto.toEntity());
        return true;
    }

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @GetMapping("/profile")
    public String getProfile () {
        return Arrays.stream(env.getActiveProfiles())
                .filter(e -> "set1".equals(e) || "set2".equals(e))
                        .findFirst()
                        .orElse("");
    }

}