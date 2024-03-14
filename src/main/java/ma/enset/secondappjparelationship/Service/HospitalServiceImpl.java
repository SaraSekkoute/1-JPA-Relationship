package ma.enset.secondappjparelationship.Service;

import jakarta.transaction.Transactional;
import ma.enset.secondappjparelationship.Repositories.ConsultationRepository;
import ma.enset.secondappjparelationship.Repositories.MedecinRepository;
import ma.enset.secondappjparelationship.Repositories.PatientRepository;
import ma.enset.secondappjparelationship.Repositories.RendezVousRepository;
import ma.enset.secondappjparelationship.entities.Consultation;
import ma.enset.secondappjparelationship.entities.Medecin;
import ma.enset.secondappjparelationship.entities.Patient;
import ma.enset.secondappjparelationship.entities.RendezVous;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService{

    //@Autowired
    private PatientRepository patientRepository;

    //@Autowired
    private MedecinRepository medecinRepository;
    //@Autowired
   private RendezVousRepository rendezVousRepository;
    //@Autowired
    private ConsultationRepository consultationRepository;


    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return  consultationRepository.save(consultation);
    }
}
