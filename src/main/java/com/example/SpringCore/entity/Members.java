package com.example.SpringCore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Members")
public class Members {
    @Id //индификатор
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id_user;

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
