package com.fcodelearning.edu.controller;

import com.fcodelearning.edu.dao.CourceDao;
import com.fcodelearning.edu.entity.Cources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/cources")
public class CourceController {

    @Autowired
    private CourceDao courceDao;

    @GetMapping
    public List<Cources> getAllCources(){
        return courceDao.findAll();
    }

    @GetMapping("/{id}")
    public Cources getById(@PathVariable Integer id){

        Optional<Cources> result = courceDao.findById(id);

        if(result.isEmpty()) new ResponseStatusException(HttpStatus.NOT_FOUND,"Cource Not Found!");
        return result.get();
//        return courceDao.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cources save(@RequestBody Cources cource){
        return courceDao.save(cource);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void delete(@PathVariable Integer id){
        courceDao.deleteById(id);
    }

    @PutMapping("/{id}")
    public Cources update(@PathVariable Integer id,@RequestBody Cources cource){

        if (!courceDao.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Cource Not Found!");
        }else{
            cource.setId(id);
            return courceDao.save(cource);
        }
    }
}
