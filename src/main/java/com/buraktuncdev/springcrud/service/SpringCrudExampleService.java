package com.buraktuncdev.springcrud.service;

import com.buraktuncdev.springcrud.model.DataModel;
import com.buraktuncdev.springcrud.repository.SpringCrudExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpringCrudExampleService {

    @Autowired
    SpringCrudExampleRepository SpringCrudExampleRepository;

    public List<DataModel> getAllTrucks() {
        return this.SpringCrudExampleRepository.findAll();
    }

    public DataModel addTruck(DataModel dataModel) {
        return this.SpringCrudExampleRepository.save(dataModel);
    }



}
