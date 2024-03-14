package ma.enset.secondappjparelationship;

import ma.enset.secondappjparelationship.Repositories.ConsultationRepository;
import ma.enset.secondappjparelationship.Repositories.MedecinRepository;
import ma.enset.secondappjparelationship.Repositories.PatientRepository;
import ma.enset.secondappjparelationship.Repositories.RendezVousRepository;
import ma.enset.secondappjparelationship.Service.HospitalServiceImpl;
import ma.enset.secondappjparelationship.Service.IHospitalService;
import ma.enset.secondappjparelationship.entities.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class SecondAppJpaRelationshipApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondAppJpaRelationshipApplication.class, args);
    }
    @Bean
    //CommandLineRunner start(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository)
    CommandLineRunner start(IHospitalService hospitalService, PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository)
    {
        return arg->{
            Stream.of("sara","salma","hassan")
                    .forEach(name->{
                        Patient p=new Patient();
                        p.setNom(name);
                        p.setDateN(new Date());
                        p.setMalade(false);
                        patientRepository.save(p);
                    } );
            Stream.of("Ahmed","TAZI","Aya")
                    .forEach(name->{
                        Medecin m=new Medecin();
                        m.setNom(name);
                        m.setEmail(name+"@gmail.com");
                        m.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                       hospitalService.saveMedecin(m);
                    } );
            //Patient patient1=patientRepository.findById(1L).orElse(null);
         Patient patient=patientRepository.findByNom("sara");

            Medecin medecin=medecinRepository.findByNom("Aya");

            RendezVous rdv =new RendezVous();
            rdv.setDate(new Date());
            rdv.setStatusRDV(StatusRDV.PENDING);
            rdv.setPatient(patient);
            rdv.setMedecin(medecin);
            RendezVous rd=hospitalService.saveRDV(rdv);
System.out.println(rd.getId());

            RendezVous rdv1=rendezVousRepository.findAll().get(0);
            Consultation c= new Consultation();
            c.setDateconsultation(new Date());
            c.setRendezVous(rdv1);
            c.setRapport("Rapport de la consultation ....");
            consultationRepository.save(c);

        };


    }


}
