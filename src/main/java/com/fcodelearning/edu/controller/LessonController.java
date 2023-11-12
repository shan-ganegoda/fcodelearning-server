package com.fcodelearning.edu.controller;

import com.fcodelearning.edu.dao.LessonDao;
import com.fcodelearning.edu.entity.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/lessons")
public class LessonController {

    @Autowired
    private LessonDao lessonDao;

    @GetMapping
    public List<Lesson> getAllCources(){
        return lessonDao.findAll();
    }

    @GetMapping("/{id}")
    public Lesson getById(@PathVariable Integer id){

        Optional<Lesson> result = lessonDao.findById(id);

        if(result.isEmpty()) new ResponseStatusException(HttpStatus.NOT_FOUND,"Cource Not Found!");
        return result.get();
//        return courceDao.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Lesson save(@RequestBody Lesson lesson){
        return lessonDao.save(lesson);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void delete(@PathVariable Integer id){
        lessonDao.deleteById(id);
    }

    @PutMapping("/{id}")
    public Lesson update(@PathVariable Integer id,@RequestBody Lesson lesson){

        if (!lessonDao.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Cource Not Found!");
        }else{
            lesson.setId(id);
            return lessonDao.save(lesson);
        }
    }
}
