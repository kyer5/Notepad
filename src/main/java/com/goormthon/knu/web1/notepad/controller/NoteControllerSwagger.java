package com.goormthon.knu.web1.notepad.controller;

import com.goormthon.knu.web1.notepad.controller.dto.ResponseDto;
import com.goormthon.knu.web1.notepad.controller.dto.request.NoteCreateRequest;
import com.goormthon.knu.web1.notepad.controller.dto.request.NoteUpdateRequest;
import com.goormthon.knu.web1.notepad.controller.dto.response.*;
import com.goormthon.knu.web1.notepad.swagger.annotation.ErrorCode400;
import com.goormthon.knu.web1.notepad.swagger.annotation.ErrorCode404;
import com.goormthon.knu.web1.notepad.swagger.annotation.ErrorCode500;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Note API") // 관련 API 그룹화
public interface NoteControllerSwagger {

    @Operation( // API 엔드포인트의 작업에 대한 설명
            summary = "메모 리스트 조회",
            responses = {
                    @ApiResponse( // API 응답에 대한 설명과 상태 코드 정의
                            responseCode = "200",
                            description = "메모 리스트 조회 성공",
                            content = @Content(schema = @Schema(implementation = NoteListResponse.class)) // @Schema: API 모델 속성 정의
                    )
            }
    )
    @ErrorCode500
    ResponseEntity<ResponseDto<List<NoteListResponse>>> getNotes(
    );

    @Operation(
            summary = "메모 단건 조회",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "메모 단건 조회 성공",
                            content = @Content(schema = @Schema(implementation = NoteDetailsResponse.class))
                    )
            }
    )
//    @ErrorCode404(description = "존재하지 않는 메모")
    @ErrorCode500
    ResponseEntity<ResponseDto<NoteDetailsResponse>> getNoteDetails(
            @Parameter Long noteId
    );

    @Operation(
            summary = "메모 생성",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "메모 생성 성공",
                            content = @Content(schema = @Schema(implementation = NoteCreateResponse.class))
                    )
            }
    )
    @ErrorCode400
    @ErrorCode500
    ResponseEntity<ResponseDto<NoteCreateResponse>> createNote(
            @Parameter NoteCreateRequest noteCreateRequest
    );

    @Operation(
            summary = "메모 수정",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "메모 수정 성공",
                            content = @Content(schema = @Schema(implementation = NoteUpdateResponse.class))
                    )
            }
    )
    @ErrorCode400
    @ErrorCode500
    ResponseEntity<ResponseDto<NoteUpdateResponse>> updateNote(
            @Parameter Long id,
            NoteUpdateRequest noteUpdateRequest
    );

    @Operation(
            summary = "메모 삭제",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "메모 삭제 성공",
                            content = @Content(schema = @Schema(implementation = NoteDeleteResponse.class))
                    )
            }
    )
    @ErrorCode500
    ResponseEntity<ResponseDto<NoteDeleteResponse>> deleteNote(
            @Parameter Long id
    );
}
