package com.cosmos.pojo;

import com.cosmos.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Questions {
    private List<Question> questionList;
}
