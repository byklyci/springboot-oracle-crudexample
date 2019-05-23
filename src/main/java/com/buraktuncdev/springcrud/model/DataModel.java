package com.buraktuncdev.springcrud.model;

import javax.persistence.*;

@Entity
@Table(name = "***")
public class DataModel {

    @Column(name = "example_id")
    @Id
    private String example_id;

    @Column(name = "example_name")
    private String example_name;

    public String getExample_id() {
        return example_id;
    }

    public void setExample_id(String example_id) {
        this.example_id = example_id;
    }

    public String getExample_name() {
        return example_name;
    }

    public void setExample_name(String example_name) {
        this.example_name = example_name;
    }
}





