package com.fcodelearning.edu.controller;

import com.fcodelearning.edu.dao.VideosDao;
import com.fcodelearning.edu.entity.Videos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/videos")
public class VideosController {

    @Autowired
    private VideosDao videosDao;

    @GetMapping
    public List<Videos> getAllCources(){
        return videosDao.findAll();
    }

    @GetMapping("/{id}")
    public Videos getById(@PathVariable Integer id){

        Optional<Videos> result = videosDao.findById(id);

        if(result.isEmpty()) new ResponseStatusException(HttpStatus.NOT_FOUND,"Cource Not Found!");
        return result.get();
//        return courceDao.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Videos save(@RequestBody Videos videos){
        return videosDao.save(videos);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void delete(@PathVariable Integer id){
        videosDao.deleteById(id);
    }

    @PutMapping("/{id}")
    public Videos update(@PathVariable Integer id,@RequestBody Videos videos){

        if (!videosDao.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Cource Not Found!");
        }else{
            videos.setId(id);
            return videosDao.save(videos);
        }
    }
}
