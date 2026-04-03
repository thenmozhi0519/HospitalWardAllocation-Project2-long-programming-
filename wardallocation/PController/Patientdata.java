package org.example.wardallocation.PController;

import lombok.RequiredArgsConstructor;
import org.example.wardallocation.PService.hos_service;
import org.springframework.web.bind.annotation.*;
import org.example.wardallocation.Patient.Patients;

import java.util.List;

@RestController
@RequestMapping("api/patients")
@RequiredArgsConstructor
public class Patientdata {

    private final hos_service service;

    @PostMapping("/assign")
    public String assign(@RequestBody Patients patient) {
        return service.assignPatient(patient);
    }

    @GetMapping("/all")
    public List<Patients> getAll() {
        return service.getAllPatients();
    }

    @PutMapping("/update/{id}")
    public Patients update(@PathVariable int id, @RequestBody Patients patient) {
        
        return service.updatePatient(id, patient);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        return service.deletePatient(id);
    }
}