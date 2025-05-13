package com.goormthon.knu.web1.notepad.controller;

import com.goormthon.knu.web1.notepad.controller.dto.ResponseDto;
import com.goormthon.knu.web1.notepad.controller.dto.request.NoteCreateRequest;
import com.goormthon.knu.web1.notepad.controller.dto.request.NoteUpdateRequest;
import com.goormthon.knu.web1.notepad.controller.dto.response.*;
import com.goormthon.knu.web1.notepad.service.NoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class NoteController implements NoteControllerSwagger {

    private final NoteService noteService;

    @GetMapping
    public ResponseEntity<ResponseDto<List<NoteListResponse>>> getNotes() {
        List<NoteListResponse> noteListResponses = noteService.getNoteList();
        return ResponseEntity.ok(ResponseDto.of(noteListResponses, "성공적으로 메모가 생성되었습니다."));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<NoteDetailsResponse>> getNoteDetails(@PathVariable final Long id) {
        NoteDetailsResponse noteDetailsResponse = noteService.getNoteDetails(id);
        return ResponseEntity.ok(ResponseDto.of(noteDetailsResponse, "Successfully retrieved the note details."));
    }

    @PostMapping
    public ResponseEntity<ResponseDto<NoteCreateResponse>> createNote(@Valid @RequestBody NoteCreateRequest noteCreateRequest) {
        NoteCreateResponse noteCreateResponse = noteService.createNote(noteCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ResponseDto.of(noteCreateResponse, "Successfully created a note."));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseDto<NoteUpdateResponse>> updateNote(@PathVariable final Long id, @RequestBody NoteUpdateRequest noteUpdateRequest) {
        NoteUpdateResponse noteUpdateResponse = noteService.updateNote(id, noteUpdateRequest);
        return ResponseEntity.ok(ResponseDto.of(noteUpdateResponse, "Successfully updated a note."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto<NoteDeleteResponse>> deleteNote(@PathVariable final Long id) {
        NoteDeleteResponse noteDeleteResponse = noteService.deleteNote(id);
        return ResponseEntity.ok(ResponseDto.of(noteDeleteResponse, "Successfully deleted a note."));
    }
}
