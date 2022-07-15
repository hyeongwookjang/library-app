package com.dolog.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    // Http Method (https://developer.mozilla.org/ko/docs/Web/HTTP/Methods)
    // GET, HEAD, PUT, POST, DELETE, CONNECT, OPTIONS, TRACE, PATCH

//    @RequestMapping(method = RequestMethod.GET, path = "v1/pass") 로 사용했었으나
    @RequestMapping( "/posts")
    // SSR을 많이 사용하시고 -> jsp, thymeleaf, mustache
        // html rendering
    // SPA 방식도 많이 -> vue
        // javascript <> API(JSON)
        // vue , nuxt(vue + SSR)
        // react , next(react + SSR)
    public String get() {
        return "Hello World";
    }
}
