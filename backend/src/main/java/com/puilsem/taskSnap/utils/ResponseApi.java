package com.puilsem.taskSnap.utils;

import lombok.*;

import java.time.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ResponseApi<T> {

    private Integer statusCode;
    private String message;
    private LocalDateTime timestamp;
    private T data;

    public ResponseApi(Integer statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.timestamp = LocalDateTime.now();
        this.data = data;
    }
}
