package com.quiz.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

import com.quiz.entity.Question;

@FeignClient(name = "QUESTION-SERVICE", fallback = QuestionClientFallback.class)
public interface QuestionClient {

    @GetMapping("/questions/quiz/{quizid}")
    List<Question> getQuestionsOfQuiz(@PathVariable("quizid") Long quizId);
}
