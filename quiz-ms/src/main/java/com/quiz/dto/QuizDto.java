package com.quiz.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuizDto {
	@NotBlank(message = "Quiz title cannot be empty")
    @Size(min = 3, message = "Quiz title must be at least 3 characters")
	
	private String title;

	    // getters & setters
	}
