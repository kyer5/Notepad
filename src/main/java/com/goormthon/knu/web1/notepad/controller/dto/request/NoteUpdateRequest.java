package com.goormthon.knu.web1.notepad.controller.dto.request;

public record NoteUpdateRequest(
        String title,
        String content
) {
}
