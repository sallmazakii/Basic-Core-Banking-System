package com.example.office.controller;

import com.example.office.domain.Office;
import com.example.office.domain.OfficeDTO;
import com.example.office.service.OfficeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@AllArgsConstructor
public class OfficeController{
    OfficeService officeService;
    @GetMapping("/retrieveAllOffices")
    public List<Office> retrieveAllOffices(){
        return officeService.retrieveAllOffices();
    }
    @GetMapping("/retrieveOfficeById/{id}")
    public Office retrieveOfficeById(@PathVariable("id") Long id){
        return officeService.retrieveOfficeById(id);
    }

    @PutMapping("/updateOffice")
    public Office updateOffice(@RequestBody OfficeDTO updatedName, @RequestParam Long id){
        return officeService.updateOffice(id,updatedName);
    }

    @DeleteMapping("/deleteOffice/{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {
        officeService.deleteOffice(id);
    }

    @PostMapping("/createOffice")
    public Office createOffice(@RequestBody OfficeDTO officeDTO){
        return officeService.createOffice(officeDTO);
    }
}

