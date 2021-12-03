package com.sergioarboleda.cacharrero.app.services;

import com.sergioarboleda.cacharrero.app.model.Clone;
import com.sergioarboleda.cacharrero.app.repositories.CloneRepository;
import com.sergioarboleda.cacharrero.app.repositories.crud.CloneCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CloneService {
    @Autowired
    private CloneCrudRepository repository;

    public List<Clone> getAll(){
        return repository.findAll();
    }
    public Clone saveClone(Clone clone){
        return repository.save(clone);

    }
    public Clone editClone(Clone clone){
        Optional<Clone> existClone = repository.findById(clone.getId());
        if (existClone.isPresent()){
            existClone.get().setBrand(clone.getBrand());
            existClone.get().setProcesor(clone.getProcesor());
            existClone.get().setOs(clone.getOs());
            existClone.get().setAvailability(clone.isAvailability());
            existClone.get().setHardDrive(clone.getHardDrive());
            existClone.get().setMemory(clone.getMemory());
            existClone.get().setPrice(clone.getPrice());
            existClone.get().setDescription(clone.getDescription());
            existClone.get().setQuantity(clone.getQuantity());
            existClone.get().setPhotography(clone.getPhotography());

            return repository.save(existClone.get());
        }
        return clone;
    }
    public void deleteClone(Integer idClone){
        repository.deleteById(idClone);
    }
}
