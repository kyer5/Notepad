package com.goormthon.knu.web1.notepad.controller;

import com.goormthon.knu.web1.notepad.controller.dto.ResponseDto;
import com.goormthon.knu.web1.notepad.controller.dto.request.NoteCreateRequest;
import com.goormthon.knu.web1.notepad.controller.dto.request.NoteUpdateRequest;
import com.goormthon.knu.web1.notepad.controller.dto.response.NoteCreateResponse;
import com.goormthon.knu.web1.notepad.controller.dto.response.NoteDeleteResponse;
import com.goormthon.knu.web1.notepad.controller.dto.response.NoteUpdateResponse;
import com.goormthon.knu.web1.notepad.service.NoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping("/create")
    public ResponseDto<NoteCreateResponse> createNote(@Valid @RequestBody NoteCreateRequest noteCreateRequest) {
        NoteCreateResponse noteCreateResponse = noteService.createNote(noteCreateRequest);
        return ResponseDto.of(noteCreateResponse, "Successfully created a note.");
    }

    @PatchMapping("/update/{id}")
    public ResponseDto<NoteUpdateResponse> updateNote(@PathVariable final long id, @RequestBody NoteUpdateRequest noteUpdateRequest) {
        NoteUpdateResponse noteUpdateResponse = noteService.updateNote(id, noteUpdateRequest);
        return ResponseDto.of(noteUpdateResponse, "Successfully updated a note.");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto<NoteDeleteResponse> deleteNote(@PathVariable final long id) {
        NoteDeleteResponse noteDeleteResponse = noteService.deleteNote(id);
        return ResponseDto.of(noteDeleteResponse, "Successfully deleted a note.");
    }
}
