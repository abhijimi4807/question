package com.cosmos.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topic {
    private Long topicId;
    //Ex:OOPs,Framework,DB etc..
    private String technologyStack;
    //Ex:CoreJava,Spring etc..
    private String subjectName;
    //Ex:basics,programs etc..
    private String topicName;
    //Ex:static,final etc..
    private String topicDescription;
}
