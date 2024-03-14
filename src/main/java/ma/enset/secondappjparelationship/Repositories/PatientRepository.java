package ma.enset.secondappjparelationship.Repositories;

import ma.enset.secondappjparelationship.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByNom(String name);
}
