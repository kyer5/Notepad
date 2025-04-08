package com.goormthon.knu.web1.notepad.controller.dto.response;

import com.goormthon.knu.web1.notepad.domain.Note;

import java.time.LocalDateTime;

public record NoteListResponse(
        Long id,
        String title,
        LocalDateTime updatedAt
) {
    public static NoteListResponse from(Note note) {
        return new NoteListResponse(
                note.getId(),
                note.getTitle(),
                note.getUpdatedAt()
        );
    }
}
