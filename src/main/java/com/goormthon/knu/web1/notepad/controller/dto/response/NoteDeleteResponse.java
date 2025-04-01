package com.goormthon.knu.web1.notepad.controller.dto.response;

import lombok.Getter;

@Getter
public class NoteDeleteResponse {

    private Long id;

    public NoteDeleteResponse(Long id) {
        this.id = id;
    }
}
