package com.question.service;

import java.util.List;

import com.question.dto.QuestionDto;
import com.question.entity.Question;

public interface QuestionService {
    
	Question addQuestion(QuestionDto dto);

    List<Question> getAll();

    Question getById(Long id);
    
    List<Question> findByQuizId(Long quizId);

    Question updateQuestion(Long id, Question question);

    void deleteQuestion(Long id);
}

