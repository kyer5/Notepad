package com.goormthon.knu.web1.notepad.controller.dto;

import lombok.Getter;

@Getter
public class DefaultResponseData<T> implements ResponseData<T> {

    private final T body;

    protected DefaultResponseData(T body) {
        this.body = body;
    }
}
