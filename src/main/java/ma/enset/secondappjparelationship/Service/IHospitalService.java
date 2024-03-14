package ma.enset.secondappjparelationship.Service;

import ma.enset.secondappjparelationship.entities.Consultation;
import ma.enset.secondappjparelationship.entities.Medecin;
import ma.enset.secondappjparelationship.entities.Patient;
import ma.enset.secondappjparelationship.entities.RendezVous;

import javax.sound.midi.Patch;

public interface IHospitalService {
    Patient savePatient (Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);


}
