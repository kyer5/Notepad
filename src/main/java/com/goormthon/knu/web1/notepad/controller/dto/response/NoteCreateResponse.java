package com.goormthon.knu.web1.notepad.controller.dto.response;

public record NoteCreateResponse(
        Long id
){
    public NoteCreateResponse(Long id) {
        this.id = id;
    }
}
