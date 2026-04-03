package org.example.wardallocation.PService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.wardallocation.PRepo.hos_repo;
import org.example.wardallocation.PRepo.WardRepo;
import org.example.wardallocation.Patient.Patients;
import org.example.wardallocation.Patient.Ward;

import java.util.List;

@Service
@RequiredArgsConstructor
public class hos_service {

    private final hos_repo patientRepo;

    private final WardRepo wardRepo;

    public String assignPatient(Patients patient) {

        Ward ward;

        if (patient.getConditionType().equalsIgnoreCase("Emergency")) {
            ward = wardRepo.findByWardName("ICU");
        } else {
            ward = wardRepo.findByWardName("General");
        }

        if (ward != null && ward.getAvailableBeds() > 0) {

            ward.setAvailableBeds(ward.getAvailableBeds() - 1);
            patient.setWard(ward);

            wardRepo.save(ward);
            patientRepo.save(patient);

            return "Assigned to " + ward.getWardName();
        }

        return "No beds available";
    }

    public List<Patients> getAllPatients() {
        return patientRepo.findAll();
    }

    public Patients updatePatient(int id, Patients patient) {
        patient.setId(id);
        return patientRepo.save(patient);
    }

    public String deletePatient(int id) {

        Patients patient = patientRepo.findById(id).orElse(null);

        if (patient != null) {

            Ward ward = patient.getWard();

            if (ward != null) {
                ward.setAvailableBeds(ward.getAvailableBeds() + 1);
                wardRepo.save(ward);
            }

            patientRepo.deleteById(id);
            return "Patient deleted & bed updated";
        }

        return "Patient not found";
    }
}