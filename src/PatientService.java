import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PatientService {
    AtomicInteger uuid;
    HashMap<Integer, Patient> patientIdVSPatient;

    public PatientService(){
        patientIdVSPatient = new HashMap<>();
        uuid = new AtomicInteger(0);
    }
    public Patient createAccount(String firstName, String lastName, String phoneNumber, String email, String address, String history){
        return new Patient(this.generateUUId(),firstName,lastName,phoneNumber,email,address,history);
    }

    public void deleteAccount(int patientId){
        patientIdVSPatient.remove(patientId);
    }



    private int generateUUId(){
        return this.uuid.incrementAndGet();
    }
}
