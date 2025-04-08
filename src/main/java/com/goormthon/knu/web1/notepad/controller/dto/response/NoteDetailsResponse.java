package com.goormthon.knu.web1.notepad.controller.dto.response;

import java.time.LocalDateTime;

public record NoteDetailsResponse(
        Long id,
        String title,
        String content,
        LocalDateTime updatedAt
) {
}
