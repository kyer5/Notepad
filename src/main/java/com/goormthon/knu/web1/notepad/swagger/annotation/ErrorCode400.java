package com.goormthon.knu.web1.notepad.swagger.annotation;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.core.annotation.AliasFor;
import org.springframework.http.ProblemDetail;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)  // Java Compiler가 annotation이 어디에 적용될지 결정
@Retention(RetentionPolicy.RUNTIME) // annotation이 실제 적용되고 유지되는 범위 (RetentionPolicy.RUNTIME: 컴파일 이후에도 JVM에 의해 계속 참조 가능)
@ApiResponse(
        responseCode = "400",
        description = "클라이언트 입력 오류",
        content = @Content(schema = @Schema(implementation = ProblemDetail.class))
)
public @interface ErrorCode400 {

    @AliasFor(annotation = ApiResponse.class, attribute = "description")
    String description() default "클라이언트 입력 오류";
}
