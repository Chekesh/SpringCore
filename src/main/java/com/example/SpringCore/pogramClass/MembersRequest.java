package com.example.SpringCore.pogramClass;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MembersRequest {
    private String Name;
    private String Surname;
    private String Patronymic;
    private String Number_pas;
    private String Series_pas;

    private String Insurance_policy;
    private String Club;
    private String Date_Birth;

    private String Discharge;
}
