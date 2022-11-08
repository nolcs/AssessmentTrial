package com.esteban.assestmentprojectquestionary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esteban.assestmentprojectquestionary.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
