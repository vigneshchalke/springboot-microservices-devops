package com.question.controller;

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

import com.question.dto.QuestionDto;
import com.question.entity.Question;
import com.question.service.QuestionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/questions")
public class QuestionController {

	    @Autowired
	    private QuestionService questionService;

	    @PostMapping("/add")
	    public Question addQuestion(@Valid @RequestBody QuestionDto dto) {
	        return questionService.addQuestion(dto);
	    }

	    @GetMapping("/readall")
	    public List<Question> getAll() {
	        return questionService.getAll();
	    }

	    @GetMapping("/readone/{id}")
	    public Question getById(@PathVariable Long id) {
	        return questionService.getById(id);
	    }
	    
	    @GetMapping("/quiz/{quizId}")
	    public List<Question> getAllQuestions(@PathVariable Long quizId){
	    	return questionService.findByQuizId(quizId);
	    }
	    
	    @PutMapping("update/{id}")
	    public Question update(@PathVariable Long id, @RequestBody Question question) {
	        return questionService.updateQuestion(id, question);
	    }

	    // 🔥 DELETE
	    @DeleteMapping("delete/{id}")
	    public String delete(@PathVariable Long id) {
	    	questionService.deleteQuestion(id);
	        return "Question deleted successfully";
	    }
	}
