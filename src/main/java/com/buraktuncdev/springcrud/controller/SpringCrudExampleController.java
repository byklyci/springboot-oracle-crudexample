package com.buraktuncdev.springcrud.controller;

import com.buraktuncdev.springcrud.model.DataModel;
import com.buraktuncdev.springcrud.repository.SpringCrudExampleRepository;
import com.buraktuncdev.springcrud.service.SpringCrudExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SpringCrudExampleController {

    @Autowired
    SpringCrudExampleService SpringCrudExampleService;

    @Autowired
    SpringCrudExampleRepository SpringCrudExampleRepository;

    // GET
    @RequestMapping(value = "/get/trucks", method = RequestMethod.GET)
    public List<DataModel> getAllTrucks() {
        return SpringCrudExampleService.getAllTrucks();
    }

    // POST
    @RequestMapping(value = "/add/truck", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public DataModel addTruck(@RequestBody DataModel dataModel) {
        return this.SpringCrudExampleService.addTruck(dataModel);
    }

    // UPDATE

    @RequestMapping(value = "/update/truck/{id}", method = RequestMethod.PUT)
    public DataModel updateById(@RequestBody DataModel dataModel, @PathVariable String id) {
        return SpringCrudExampleRepository.findById(id)
                .map(truckModel1 -> {
                  truckModel1.setExample_name(dataModel.getExample_name());
                  return SpringCrudExampleRepository.save(truckModel1);
                }).orElseGet(() -> {
                   dataModel.setExample_id(id);
                   return SpringCrudExampleRepository.save(dataModel);
                });
    }

    // DELETE
    @RequestMapping(value = "/truck/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id){
        SpringCrudExampleRepository.deleteById(id);
    }
}
