package com.fuzail;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(
            SoftwareEngineerRepository softwareEngineerRepository
    ) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers(){
        return softwareEngineerRepository.findAll();
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.save(softwareEngineer);
    }


    public SoftwareEngineer getAllSoftwareEngineerById(
            Integer id) {
        return softwareEngineerRepository.findById(id).orElseThrow(()-> new IllegalStateException(
                id+" not found"));
    }

    public void deleteSoftwareEngineer(Integer id) {
        if(!softwareEngineerRepository.existsById(id)){
            throw new IllegalStateException(id+" not found");
        }

        softwareEngineerRepository.deleteById(id);
    }

    public void updateSoftwareEngineer(Integer id, SoftwareEngineer update) {
        SoftwareEngineer softwareEngineer = softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        id + " not found"));
        softwareEngineer.setName(update.getName());
        softwareEngineer.setTechStack(update.getTechStack());
        softwareEngineerRepository.save(softwareEngineer);

    }
}
