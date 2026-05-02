package com.quiz.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.quiz.entity.Question;

@Component
public class QuestionClientFallback implements QuestionClient {

    @Override
    public List<Question> getQuestionsOfQuiz(Long quizId) {

        // 🔥 fallback logic
        System.out.println("Question Service is down! Returning empty list.");

        return Collections.emptyList();
    }
}