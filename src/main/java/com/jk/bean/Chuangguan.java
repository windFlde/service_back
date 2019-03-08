package com.jk.bean;

import lombok.Data;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "t_CG")
public class Chuangguan {

    private String id;
    private String question;

    private String answer;
    @Transient
    private String answer1;
    @Transient
    private String answer2;
    @Transient
    private String answer3;
    @Transient
    private String answer4;
    private String questionKey;
    private String keyWhy;



    public Chuangguan(String question, String answer, String questionKey, String keyWhy) {
        this.question = question;
        this.answer = answer;
        this.questionKey = questionKey;
        this.keyWhy = keyWhy;
    }
}
