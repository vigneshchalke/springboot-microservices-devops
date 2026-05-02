package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.dto.QuizDto;
import com.quiz.entity.Quiz;
import com.quiz.interfaceservice.QuizService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
    private QuizService quizService;

    // 🔹 Create Quiz
	@PostMapping("/add")
	public Quiz create(@Valid @RequestBody QuizDto quizDto) {
	    return quizService.createQuiz(quizDto);
	}

    // 🔹 Get All Quizzes
    @GetMapping("/readall")
    public List<Quiz> getAll() {
        return quizService.getAll();
    }

    // 🔹 Get Quiz by ID
    @GetMapping("readone/{quizid}")
    public Quiz getQuizById(@PathVariable("quizid") Long id) {
        return quizService.getQuizById(id);
    }
    
    @PutMapping("update/{id}")
    public Quiz updateQuiz(@PathVariable Long id, @RequestBody Quiz quiz) {
        return quizService.updateQuiz(id, quiz);
    }

    // 🔥 DELETE
    @DeleteMapping("delete/{id}")
    public String deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuiz(id);
        return "Quiz deleted successfully!";
    }
}
