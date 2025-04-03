package com.goormthon.knu.web1.notepad.controller.dto.response;

import lombok.Getter;

@Getter
public class NoteCreateResponse {

    private Long id;

    public NoteCreateResponse(Long id) {
        this.id = id;
    }
}
