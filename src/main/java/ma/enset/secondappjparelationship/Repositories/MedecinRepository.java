package ma.enset.secondappjparelationship.Repositories;

import ma.enset.secondappjparelationship.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String name);
}
