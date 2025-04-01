package com.goormthon.knu.web1.notepad.controller.dto.response;

import lombok.Getter;

@Getter
public class NoteUpdateResponse {

    private Long id;

    public NoteUpdateResponse(Long id) {
        this.id = id;
    }
}
