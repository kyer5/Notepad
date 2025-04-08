package com.goormthon.knu.web1.notepad.controller;

import com.goormthon.knu.web1.notepad.controller.dto.ResponseDto;
import com.goormthon.knu.web1.notepad.controller.dto.request.NoteCreateRequest;
import com.goormthon.knu.web1.notepad.controller.dto.request.NoteUpdateRequest;
import com.goormthon.knu.web1.notepad.controller.dto.response.*;
import com.goormthon.knu.web1.notepad.service.NoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @GetMapping
    public ResponseDto<List<NoteListResponse>> getNotes() {
        List<NoteListResponse> noteListResponses = noteService.getNoteList();
        return ResponseDto.of(noteListResponses, "Successfully loaded the list of notes.");
    }

    @GetMapping("/{id}")
    public ResponseDto<NoteDetailsResponse> getNoteDetails(@PathVariable final Long id) {
        NoteDetailsResponse noteDetailsResponse = noteService.getNoteDetails(id);
        return ResponseDto.of(noteDetailsResponse, "Successfully retrieved the note details.");
    }

    @PostMapping
    public ResponseDto<NoteCreateResponse> createNote(@Valid @RequestBody NoteCreateRequest noteCreateRequest) {
        NoteCreateResponse noteCreateResponse = noteService.createNote(noteCreateRequest);
        return ResponseDto.of(noteCreateResponse, "Successfully created a note.");
    }

    @PatchMapping("/{id}")
    public ResponseDto<NoteUpdateResponse> updateNote(@PathVariable final long id, @RequestBody NoteUpdateRequest noteUpdateRequest) {
        NoteUpdateResponse noteUpdateResponse = noteService.updateNote(id, noteUpdateRequest);
        return ResponseDto.of(noteUpdateResponse, "Successfully updated a note.");
    }

    @DeleteMapping("/{id}")
    public ResponseDto<NoteDeleteResponse> deleteNote(@PathVariable final long id) {
        NoteDeleteResponse noteDeleteResponse = noteService.deleteNote(id);
        return ResponseDto.of(noteDeleteResponse, "Successfully deleted a note.");
    }
}
