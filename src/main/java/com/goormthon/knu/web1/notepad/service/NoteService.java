package com.goormthon.knu.web1.notepad.service;

import com.goormthon.knu.web1.notepad.controller.dto.request.NoteCreateRequest;
import com.goormthon.knu.web1.notepad.controller.dto.response.NoteCreateResponse;
import com.goormthon.knu.web1.notepad.domain.Note;
import com.goormthon.knu.web1.notepad.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    @Transactional
    public NoteCreateResponse createNote(NoteCreateRequest noteCreateRequest) {
        Note note = Note.builder()
                .title(noteCreateRequest.getTitle())
                .content(noteCreateRequest.getContent())
                .build();
        noteRepository.save(note);
        return new NoteCreateResponse(note.getId());
    }
}
