package com.cosmos.service;

import com.cosmos.entity.Question;
import com.cosmos.exception.QuestionNotAvailableException;
import com.cosmos.pojo.QuestionWithTopic;
import com.cosmos.pojo.Questions;
import com.cosmos.pojo.Topic;
import com.cosmos.repository.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private RestTemplate restTemplate;
    private String topicUrl ="http://localhost:9001/topic/";
    public QuestionWithTopic addDummyQuestion() {
        Question question = new Question();
        question.setQuestionDescription("Tell me about yourself");
        question.setProgram(false);
        QuestionWithTopic questionAndAnswer = new QuestionWithTopic();
        log.info("New Question to add: "+question);
        Topic topic = null;
        try{
            topic = restTemplate.getForObject(topicUrl+"adddummy", Topic.class);
            question.setTopicId(topic.getTopicId());
            question=questionRepository.save(question);
            questionAndAnswer.setQuestion(question);
            questionAndAnswer.setTopic(topic);
        }catch (Exception ex){
            topic =new Topic();
        }
        return questionAndAnswer;
    }

    public QuestionWithTopic addQuestion(QuestionWithTopic questionWithTopic) {
        log.info("New Question to add: "+questionWithTopic);
        Topic topic = restTemplate.postForObject(topicUrl, questionWithTopic.getTopic(), Topic.class);
        Question question = questionWithTopic.getQuestion();
        question.setTopicId(topic.getTopicId());
        question=questionRepository.save(question);
        return new QuestionWithTopic(question , topic);
    }

    public Questions getAllQuestions() {
        List questionList = questionRepository.findAll();
        Questions questions = new Questions();
        questions.setQuestionList(questionList);
        log.info("Entire Question list got called..");
        return questions;
    }

    public QuestionWithTopic getQuestionByQuestionId(Long QuestionId) {
        Optional<Question> optionalQuestion = questionRepository.findById(QuestionId);
        if(optionalQuestion.isPresent()){
            log.info("Question is available");
            Question question = optionalQuestion.get();
            Topic topic = restTemplate.getForObject(topicUrl+question.getTopicId(),Topic.class);
            return new QuestionWithTopic(question,topic);
        }else
            throw new QuestionNotAvailableException("This Question not available");
    }
}
