package com.example.SpringCore.controller;

import com.example.SpringCore.entity.Members;
import com.example.SpringCore.repository.MembersRepository;
import com.example.SpringCore.server.MembersServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MembersController {

    /*@Autowired
    private MembersRepository membersRepository;*/

    private final MembersServer membersServer;
    @Autowired
    public MembersController(MembersServer membersServer) {
        this.membersServer = membersServer;
    }

    /*@GetMapping // получение данных
    public String getAllStudents(@RequestParam("name") String name) {
        return "Hello " + name;
    }*/

    //@GetMapping("/") // получение данных
    //public List<Members> getAllStudents() {return membersServer.getAllMembers();}
}
