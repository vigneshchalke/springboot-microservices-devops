package com.question.serviceimplments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question.dto.QuestionDto;
import com.question.entity.Question;
import com.question.exception.QuestionNotFoundException;
import com.question.repository.QuestionRepository;
import com.question.service.QuestionService;

@Service
public class QuestionServiceImple implements QuestionService {
	
	private static final Logger log = LoggerFactory.getLogger(QuestionServiceImple.class);
	@Autowired
    private QuestionRepository repo;
	
	//we can go for field dependency and also constructor dependency
	
	@Override
	public Question addQuestion(QuestionDto dto) {
		log.info("Adding question: {}", dto.getQuestion());

	    Question q = new Question();
	    q.setQuestion(dto.getQuestion());
	    q.setQuizId(dto.getQuizId());

	    return repo.save(q);
	}

    @Override
    public List<Question> getAll() {
    	log.info("Fetching all questions");
        return repo.findAll();
    }

    @Override
    public Question getById(Long id) {
    	log.info("Fetching questions for quizId: {}", id);
        return repo.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException("Question not found with id: " + id));
    }
    
    @Override
    public List<Question> findByQuizId(Long quizId){
    	
    	return repo.findByQuizId(quizId);
    }
    

    @Override
    public Question updateQuestion(Long id, Question question) {
    	log.info("Updating question with id: {}", id);

        Question existing = repo.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException("Question not found with id: " + id));

        existing.setQuestion(question.getQuestion());
        existing.setQuizId(question.getQuizId());

        return repo.save(existing);
    }

    @Override
    public void deleteQuestion(Long id) {
    	log.info("Deleting question with id: {}", id);

        Question q = repo.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException("Question not found with id: " + id));

        repo.delete(q);
    }

}
