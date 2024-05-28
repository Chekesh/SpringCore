package com.example.SpringCore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Judges")
public class Judges {
    @Id //индификатор
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id_user;

    private String Name;
    private String Surname;
    private String Patronymic;
    private String Сategory;
}
