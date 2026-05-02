package com.quiz.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import com.quiz.dto.QuizDto;
import com.quiz.entity.Quiz;
import com.quiz.exception.QuizNotFoundException;
import com.quiz.repository.QuizRepository;



@Service
public class QuizService implements com.quiz.interfaceservice.QuizService {
	
	private static final Logger log = LoggerFactory.getLogger(QuizService.class);
	
	private QuizRepository quizRepository;
	
	private QuestionClient questionClient;
	
    public QuizService(QuizRepository quizRepository, QuestionClient questionClient) {
		super();
		this.quizRepository = quizRepository;
		this.questionClient = questionClient;
	}

    @Override
    public Quiz createQuiz(QuizDto quizDto) {
    	log.info("Creating quiz with title: {}", quizDto.getTitle());

        Quiz quiz = new Quiz();
        quiz.setTitle(quizDto.getTitle());

        return quizRepository.save(quiz);
    }
	@Override
	public List<Quiz> getAll() {
		log.info("Fetching all quizzes");
	    List<Quiz> quizzes = quizRepository.findAll();
	    
	    return quizzes.stream()
	            .map(q -> {
	                q.setQuestion(questionClient.getQuestionsOfQuiz(q.getId()));
	                return q;
	            })
	            .toList();
	}

//    @Override
//    public List<Quiz> getAll() {
//        return quizRepository.findAll();
//    }

	@Override
	public Quiz getQuizById(Long id) {
		log.info("Fetching quiz with id: {}", id);

	    Quiz quiz = quizRepository.findById(id)
	            .orElseThrow(() -> new QuizNotFoundException("Quiz not found with id: " + id));

	    quiz.setQuestion(questionClient.getQuestionsOfQuiz(id));

	    return quiz;
	}
    
	@Override
	public Quiz updateQuiz(Long id, Quiz quiz) {
		log.info("Updating quiz with id: {}", id);

	    Quiz existing = quizRepository.findById(id)
	            .orElseThrow(() -> new QuizNotFoundException("Quiz not found with id: " + id));

	    existing.setTitle(quiz.getTitle());

	    return quizRepository.save(existing);
	}

    // 🔥 DELETE
	@Override
	public void deleteQuiz(Long id) {
		log.info("Deleting quiz with id: {}", id);

	    Quiz quiz = quizRepository.findById(id)
	            .orElseThrow(() -> new QuizNotFoundException("Quiz not found with id: " + id));

	    quizRepository.delete(quiz);
	}
}
