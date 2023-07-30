package com.example.office.service;

import com.example.office.domain.Office;
import com.example.office.domain.OfficeDTO;
import com.example.office.exception.NotFoundException;
import com.example.office.repo.OfficeRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OfficeService {
    final OfficeRepo officeRepo;

    public List<Office> retrieveAllOffices(){
        return officeRepo.findAll();
    }

    public Office retrieveOfficeById(Long id){
        return officeRepo.findById(id).orElseThrow(
                ()
                        -> new NotFoundException(
                        "NO USER PRESENT WITH ID = " + id));
    }

    public Office createOffice (OfficeDTO officeDTO){
        Office office = new Office();
        office.setName(officeDTO.getName());
        return officeRepo.save(office);
    }

    public Office updateOffice (Long id, OfficeDTO updatedName){
        Office office = officeRepo.findById(id).orElseThrow( ()
                -> new NotFoundException(
                "NO USER PRESENT WITH ID = " + id));
        office.setName(updatedName.getName());
        return officeRepo.save(office);
    }

    public void deleteOffice (Long id){
        officeRepo.deleteById(id);
    }
}
