package com.example.SpringCore.controller;

import com.example.SpringCore.entity.Judges;
import com.example.SpringCore.server.JudgesServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/judges")
public class JudgesController{
    private final JudgesServer judgesServer;

    @Autowired
    public JudgesController(JudgesServer judgesServer) {
        this.judgesServer = judgesServer;
    }

    @GetMapping("/")// получение данных
    public List<Judges> getAllStudents() {
        System.out.println(judgesServer.getAllJudges());
        return judgesServer.getAllJudges();
    }
}
