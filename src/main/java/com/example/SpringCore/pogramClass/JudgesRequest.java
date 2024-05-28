package com.example.SpringCore.pogramClass;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class JudgesRequest {

    private String Name;
    private String Surname;
    private String Patronymic;
    private String Сategory;
}
