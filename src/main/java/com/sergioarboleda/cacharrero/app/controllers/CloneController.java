package com.sergioarboleda.cacharrero.app.controllers;

import com.sergioarboleda.cacharrero.app.model.Clone;
import com.sergioarboleda.cacharrero.app.services.CloneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/clone/")

public class CloneController {
    @Autowired
    private CloneService service;

    @GetMapping("all")
    public List<Clone> getAll(){
        return service.getAll();
    }

    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone save(@RequestBody Clone clone){
        return service.saveClone(clone);
    }

    @PutMapping("update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone edit(@RequestBody Clone clone){
        return service.editClone(clone);
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id")Integer idClone){
        service.deleteClone(idClone);
    }
}
