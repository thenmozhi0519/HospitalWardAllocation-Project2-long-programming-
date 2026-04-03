package org.example.wardallocation.PRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.wardallocation.Patient.Patients;

public interface hos_repo extends JpaRepository<Patients, Integer> {
}