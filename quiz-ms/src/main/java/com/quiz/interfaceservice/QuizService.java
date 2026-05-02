package com.quiz.interfaceservice;

import java.util.List;

import com.quiz.dto.QuizDto;
import com.quiz.entity.Quiz;

public interface QuizService {
	 Quiz createQuiz(QuizDto quizDto);

    List<Quiz> getAll();

    Quiz getQuizById(Long id);
    
    Quiz updateQuiz(Long id, Quiz quiz);

    void deleteQuiz(Long id);

	

}
