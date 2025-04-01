package com.goormthon.knu.web1.notepad.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class NoteCreateRequest {

    @NotBlank(message = "제목은 비어있을 수 없습니다.")
    private String title;

    @NotBlank(message = "내용은 비어있을 수 없습니다.")
    private String content;
}
