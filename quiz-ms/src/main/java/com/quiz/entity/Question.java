package com.quiz.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Data
public class Question {

 
    private Long id;

    private String question;
    private Long quizId;
}
