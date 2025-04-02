package com.goormthon.knu.web1.notepad.service;

import com.goormthon.knu.web1.notepad.controller.dto.request.NoteCreateRequest;
import com.goormthon.knu.web1.notepad.controller.dto.response.NoteCreateResponse;
import com.goormthon.knu.web1.notepad.domain.Note;
import com.goormthon.knu.web1.notepad.repository.NoteRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("메모 서비스 테스트")
@SpringBootTest
@Transactional
public class NoteServiceTest {

    /**
     * 테스트 요구사항
     * - 메모 작성을 성공해야 한다.
     */

    @Autowired NoteService noteService;
    @Autowired NoteRepository noteRepository;

    @DisplayName("메모를 작성할 수 있다.")
    @Test
    public void createNote() throws Exception {
        // given
        NoteCreateRequest testNoteCreateRequest = new NoteCreateRequest("test title", "test content");

        // when
        NoteCreateResponse testNoteCreateResponse = noteService.createNote(testNoteCreateRequest);

        // then
        Note testNote = noteRepository.findById(testNoteCreateResponse.getNoteId())
                .orElseThrow(() -> new RuntimeException("메모 작성 실패"));

        assertThat(testNote.getTitle()).isEqualTo("test title");
        assertThat(testNote.getContent()).isEqualTo("test content");
    }
}
