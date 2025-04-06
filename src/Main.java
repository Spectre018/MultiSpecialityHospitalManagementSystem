import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Hospital Management Portal!");

        EmployeeManagementService employeeManagementService = new EmployeeManagementService();
        //add 5 doctors
        // Head of the hospital with id 1
        for(int id = 1;id<=5;id++){
            Doctor doc = employeeManagementService.addDoctor("Dr."," name_"+id,1,"General Surgeon_"+id,0);
//            System.out.println("Dr. name_"+id+" is added");
        }
        // add five nurses
        for(int id = 1;id<=5;id++){
            Nurse doc = employeeManagementService.addNurse("Nurse"," name_"+id,1,"General Surgeon",0);
//            System.out.println("Nurse name_"+id+" is added");
        }

        // add five staffs
        for(int id = 1;id<=5;id++){
            Staff doc = employeeManagementService.addStaff("Staff"," name_"+id,1,"General Surgeon",0);
//            System.out.println("Staff name_"+id+" is added");
        }

        DepartmentService departmentService = new DepartmentService();
        for(int i=1;i<=5;i++){
            departmentService.addDepartment(i, "department_"+i);
        }

        System.out.println(departmentService.deptIdVsName.values());

        PatientService patientService = new PatientService();
        Patient rahul = patientService.createAccount("Rahul", "Kumar", "9709548032", "rahul@gmail.com", "Yogipur", "Fracture");


        HashMap<Integer,String> departmentList = departmentService.getAllDepartments();
        System.out.println(departmentList);
        int reqDeptId = 1;

        List<Doctor> listOfDocByDeptId = employeeManagementService.doctorService.getDoctorsByDepartment(reqDeptId);


        for(Doctor doc : listOfDocByDeptId){
            System.out.println("Name = "+doc.lastName+" specialization = "+doc.specialization);
        }

        Doctor selectedDoc = listOfDocByDeptId.get(0);

        // check available slots by day from 0 to 29
        List<Appointment> availableAppointments = employeeManagementService.doctorService.getAvailableSlotsByDay(selectedDoc, 0);

        for(Appointment slot : availableAppointments){
            System.out.println("day = "+slot.day+"  slot = "+slot.slot);
        }

        AppointmentService appointmentService = new AppointmentService();
        appointmentService.bookAppointment(rahul.uuid, selectedDoc, 0, 18);

//        List<Appointment> availableAppointments1 = employeeManagementService.doctorService.getAvailableSlotsByDay(selectedDoc, 0);
//        for(Appointment slot : availableAppointments1){
//            System.out.println("day = "+slot.day+"  slot = "+slot.slot);
//        }
        System.out.println(appointmentService.doctorsAppointment);
        System.out.println(appointmentService.patientsAppointment);
    }
}

/*
Object list
------------
Employees- tick
Doctor
Nurse
Staff
Patient
Appointment
LabReports
Department - tick
Prescription
Billings
Payments
Invoice
 */

