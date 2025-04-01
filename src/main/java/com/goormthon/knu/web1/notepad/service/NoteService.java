package com.goormthon.knu.web1.notepad.service;

import com.goormthon.knu.web1.notepad.controller.dto.request.NoteCreateRequest;
import com.goormthon.knu.web1.notepad.controller.dto.request.NoteUpdateRequest;
import com.goormthon.knu.web1.notepad.controller.dto.response.NoteCreateResponse;
import com.goormthon.knu.web1.notepad.controller.dto.response.NoteDeleteResponse;
import com.goormthon.knu.web1.notepad.controller.dto.response.NoteUpdateResponse;
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

    @Transactional
    public NoteUpdateResponse updateNote(Long id, NoteUpdateRequest noteUpdateRequest) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("해당 ID가 존재하지 않습니다."));

        if (noteUpdateRequest.getTitle() != null) {
            note.updateTitle(noteUpdateRequest.getTitle());
        }

        if (noteUpdateRequest.getContent() != null) {
            note.updateContent(noteUpdateRequest.getContent());
        }

        return new NoteUpdateResponse(note.getId());
    }

    public NoteDeleteResponse deleteNote(Long id) {
        noteRepository.deleteById(id);
        return new NoteDeleteResponse(id);
    }
}
