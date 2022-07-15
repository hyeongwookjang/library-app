package com.dolog.controller;


import com.dolog.request.PostCreate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class PostController {
/**
     Http Method (https://developer.mozilla.org/ko/docs/Web/HTTP/Methods)
     GET, HEAD, PUT, POST, DELETE, CONNECT, OPTIONS, TRACE, PATCH
     글 등록
     POST Method

    @RequestMapping(method = RequestMethod.GET, path = "v1/pass") 로 사용했었으나

     SSR을 많이 사용하시고 jsp, thymeleaf, mustache
         html rendering
     SPA 방식도 많이
         javascript <> API(JSON)
         vue , nuxt(vue + SSR)
         react , next(react + SSR)
*/

    @PostMapping("/posts")
    public Map<String, String> post(@RequestBody @Valid PostCreate params, BindingResult result) {

        /** 이렇게 검증하면
         * 1. 매번 메서드마다 값을 검증 해야한다.
         *      > 개발자가 까먹을 수 있다. 버그 발생 여지 높다.
         *      > 지겹다. (간지가 안난다.
         * 2. 응답값에 HashMap -> 응답 클래스를 만들어 주는게 좋다.
         * 3. 여러개의 에러처리 힘듬
         * 4. 세 번 이상의 반복작업은 피해야한다.
         */

        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            FieldError firstFieldError = fieldErrors.get(0);
            String fieldName = firstFieldError.getField(); //title
            String errorMessage = firstFieldError.getDefaultMessage(); // 에러 메시지

            Map<String, String> error = new HashMap<>();
            error.put(fieldName, errorMessage);
            return error;
        }

      /** 데이터를 검증하는 이유
         1. client 개발자가 깜빡할 수 있다. 실수로 값을 안보낼 수 있다.
         2. client bug로 값이 누락될 수 있다.
         3. 외부에 나쁜 사람이 값을 임의로 조작해서 보낼 수 있다.
         4. DB에 값을 저장할 때, 의도치 않은 오류가 발생할 수 도 있다.
         5. 서버 개발자의 편의를 위해서
       */

      /**
        String title = params.getTitle();
        if (title == null || title.equals("")) {
             {"title": "  "}
             {"title": "...수십억글자..."}
            throw new Exception("타이틀 값이 없습니다");
             이렇게 검증을 하면
             1. 노가다
             2. 무언가 3번 이상 반복작업할 때 잘못한건 아닐지 의심한다.
             3. 누락될 염려가 있다.
             4. 다양한 측면의 검증을 필요로 한다.
             5. 개발자스럽지 않다.
        }
*/

        // {"title": "타이틀 값이 없습니다"}
        return Map.of();
    }
}
