package com.goormthon.knu.web1.notepad.controller;

import com.goormthon.knu.web1.notepad.controller.dto.ResponseDto;
import com.goormthon.knu.web1.notepad.controller.dto.request.NoteCreateRequest;
import com.goormthon.knu.web1.notepad.controller.dto.response.NoteCreateResponse;
import com.goormthon.knu.web1.notepad.service.NoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notepad")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping("/create")
    public ResponseDto<NoteCreateResponse> createNote(@Valid @RequestBody NoteCreateRequest noteCreateRequest) {
        NoteCreateResponse noteCreateResponse = noteService.createNote(noteCreateRequest);
        return ResponseDto.of(noteCreateResponse, "Successfully created a note.");
    }
}
