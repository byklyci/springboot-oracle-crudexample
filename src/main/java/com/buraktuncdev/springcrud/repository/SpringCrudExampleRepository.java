package com.buraktuncdev.springcrud.repository;

import com.buraktuncdev.springcrud.model.DataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringCrudExampleRepository extends JpaRepository<DataModel, String> {
    @Override
    void deleteById(String s);






}
