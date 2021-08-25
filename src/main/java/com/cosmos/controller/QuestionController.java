package com.cosmos.controller;

import com.cosmos.entity.Question;
import com.cosmos.pojo.QuestionWithTopic;
import com.cosmos.pojo.Questions;
import com.cosmos.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
@Slf4j
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("/adddummy")
    public QuestionWithTopic addDummyQuestion(){
        log.info("addDummyQuestion got called");
        return questionService.addDummyQuestion();
    }
    @GetMapping()
    public Questions getAllQuestions(){
        log.info("getAllQuestions got called");
        return questionService.getAllQuestions();
    }
    @GetMapping("/{questionId}")
    public QuestionWithTopic getQuestionByQuestionId(@PathVariable Long questionId){
        log.info("getQuestionByQuestionId got called");
        return questionService.getQuestionByQuestionId(questionId);
    }
    @PostMapping
    public QuestionWithTopic addQuestionWithTopic(@RequestBody QuestionWithTopic questionWithTopic){
        log.info("addQuestion got called");
        return questionService.addQuestion(questionWithTopic);
    }
    @PutMapping("/{QuestionId}")
    public void updateQuestion(@PathVariable Long QuestionId){
        //To Do
    }
    @DeleteMapping("/{QuestionId}")
    public void deleteQuestion(@PathVariable Long QuestionId){

    }

}
