package com.goormthon.knu.web1.notepad.controller.dto.response;

public record NoteDeleteResponse(
        Long id
) {
    public NoteDeleteResponse(Long id) {
        this.id = id;
    }
}
