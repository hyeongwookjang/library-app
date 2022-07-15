package com.dolog.response;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * {
 *     "code": "400",
 *     "message": "잘못된 요청입니다."; -> 이것만 봤을때는 어떤 값이 잘못된 건지 알 수 없다. (유저에게 피드백 줄 수 없다.)
 *     "validation: {
 *         "title" : "값을 입력해주세요"
 *     }
 * }*/

@Getter
@RequiredArgsConstructor
public class ErrorResponse {

    private final String code;
    private final String message;

    private final Map<String, String> validation = new HashMap<>();

    public void addValidation(String fieldName, String errorMessage) {
        this.validation.put(fieldName, errorMessage);
    }
}
