package org.example.wardallocation.PRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.wardallocation.Patient.Ward;

public interface WardRepo extends JpaRepository<Ward, Integer> {

    Ward findByWardName(String wardName);
}
