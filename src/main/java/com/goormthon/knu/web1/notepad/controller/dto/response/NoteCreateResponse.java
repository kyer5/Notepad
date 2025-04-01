package com.goormthon.knu.web1.notepad.controller.dto.response;

import lombok.Getter;

@Getter
public class NoteCreateResponse {

    private Long noteId;

    public NoteCreateResponse(Long noteId) {
        this.noteId = noteId;
    }
}
