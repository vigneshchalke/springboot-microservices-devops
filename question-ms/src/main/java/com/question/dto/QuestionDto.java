package com.question.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionDto {

    @NotBlank(message = "Question cannot be empty")
    @Size(min = 5, message = "Question must be at least 5 characters")
    private String question;

    @NotNull(message = "Quiz ID is required")
    private Long quizId;
}