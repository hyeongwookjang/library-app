package com.dolog.service;

import com.dolog.domain.Post;
import com.dolog.repository.PostRepository;
import com.dolog.request.PostCreate;
import com.dolog.response.PostResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void write(PostCreate postCreate) {
        // postCreate -> Entity
//        Post post = new Post(postCreate.getTitle(), postCreate.getContent());
        Post post = Post.builder()
                .title(postCreate.getTitle())
                .content(postCreate.getContent())
                .build();

        postRepository.save(post);
    }

    public PostResponse get(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 글입니다."));

        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
        /**
         * PostController -> WebPostService, PostService -> Reponsitory
         */
    }

    // 글이 너무 많으면 비용이 너무 많이 든다.
    // 글이 -> 100,000,000 -> DB 모두 조회하는 경우 -> DB가 뻗을 수 있다.
    // DB -> 어플리케이션 서버로 전달하는 시간, 트래픽비용 등이 많이 발생할 수 있다.



//     public List<PostResponse> getList() {
//     return postRepository.findAll().stream()
//             .map(post -> new PostResponse(post))
//            .collect(Collectors.toList());
//     }

   /** 위와 같이 간결하게 변환
    public List<PostResponse> getList() {
        return postRepository.findAll().stream()
                .map(post -> PostResponse.builder()
                            .id(post.getId())
                            .title(post.getTitle())
                            .content(post.getContent())
                            .build())
                .collect(Collectors.toList());
    }*/
}
