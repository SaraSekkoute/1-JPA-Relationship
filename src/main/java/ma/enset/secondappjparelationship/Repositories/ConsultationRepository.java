package ma.enset.secondappjparelationship.Repositories;

import ma.enset.secondappjparelationship.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
