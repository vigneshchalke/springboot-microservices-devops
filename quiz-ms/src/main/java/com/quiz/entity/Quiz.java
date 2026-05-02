package com.quiz.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Data
@JsonPropertyOrder({"id", "title"})
public class Quiz {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title;
	

	transient private List<Question> question;
	
}
