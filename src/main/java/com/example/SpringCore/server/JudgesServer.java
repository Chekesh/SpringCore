package com.example.SpringCore.server;

import com.example.SpringCore.entity.Judges;
import com.example.SpringCore.pogramClass.JudgesRequest;
import com.example.SpringCore.repository.JudgesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;


@Service
public class JudgesServer {
    private final JudgesRepository judgesRepository;

    @Autowired
    public JudgesServer(JudgesRepository judgesRepository) {
        this.judgesRepository = judgesRepository;
    }

    public List<Judges> getAllJudges() {
        List<Judges> students = new ArrayList<>();
        judgesRepository.findAll().forEach(students::add);
        return students;
    }

    public ResponseEntity<List<Judges>> ReturnData(@RequestBody JudgesRequest student){
        List<Judges> all = judgesRepository.findAll();
        return ResponseEntity.ok(all);

    }

    public ResponseEntity<String> addJudgesToDatabase(@RequestBody JudgesRequest judgesDTO) {
        try {
            Judges judges = new Judges();
            judges.setName(judgesDTO.getName());
            judges.setSurname(judgesDTO.getSurname());
            judges.setPatronymic(judgesDTO.getPatronymic());
            judges.setСategory(judgesDTO.getСategory());

            judgesRepository.save(judges);

            return new ResponseEntity<>("Студент успешно добавлен в базу данных", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Произошла ошибка при добавлении студента: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> deleteJudgesById(@PathVariable Long id) {
        try {
            if (judgesRepository.existsById(id)) {
                judgesRepository.deleteById(id); // удаляем студента из базы данных по Id
                return new ResponseEntity<>("Студент с Id " + id + " успешно удален из базы данных", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Студент с Id " + id + " не найден", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Произошла ошибка при удалении студента: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Judges updateJudges(Long id, Judges updatedJudges) {
        Judges existingJudges = judgesRepository.findById(id).orElse(null);

        if(existingJudges != null) {
            existingJudges.setName(updatedJudges.getName());
            existingJudges.setSurname(updatedJudges.getSurname());
            existingJudges.setPatronymic(updatedJudges.getPatronymic());
            existingJudges.setСategory(updatedJudges.getСategory());

            return judgesRepository.save(existingJudges);
        } else {
            // Обработка случая, когда студент с указанным ID не найден
            return null;
        }
    }

    /*public Judges getJudgesByLogin(String login) {
        List<Judges> students = judgesRepository.findAllByLogin(login);
        if (!students.isEmpty()) {
            return students.get(0);
        } else {
            return null;
        }
    }*/

}
