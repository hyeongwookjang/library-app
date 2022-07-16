package com.dolog.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class PostCreate {

    @NotBlank(message = "타이틀을 입력해주세요.")
    private String title;

    @NotBlank(message = "컨텐트를 입력해주세요.")
    private String content;

    @Builder
    public PostCreate(String title, String content) {
        this.title = title;
        this.content = content;
    }


   /**
    public PostCreate changeTitle(String title) {
        return PostCreate.builder()
                .title(title)
                .content(content)
                .build();
    빌더의 장점
    - 가독성에 좋다. (값 생성 유연함)
    - 필요한 값만 받을 수 있다. -> 오버로딩 가능 조간 찾아볼 것
    - 객체의 불변성


    }*/
}