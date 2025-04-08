package com.goormthon.knu.web1.notepad.controller.dto.response;

public record NoteUpdateResponse(
        Long id
) {
    public NoteUpdateResponse(Long id) {
        this.id = id;
    }
}
