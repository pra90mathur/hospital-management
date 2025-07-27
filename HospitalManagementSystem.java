import java.util.*;

class Patient {
    private static int idCounter = 0;
    private int id;
    private String name;
    private String gender;
    private int age;

    public Patient(String name, String gender, int age){
        this.id = ++idCounter;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public int getId(){
        return id;
    }

    // Override
    public String toString(){
        return "Patient Id : " + id + ", Name : " + name + ", Gender : " + gender + ", Age : " + age;

    }
}

class Doctor {
    private static int idCounter = 0;
    private int id;
    private String name;
    private String speciality;

    public Doctor(String name, String speciality){
        this.id = ++idCounter;
        this.name = name;
        this.speciality = speciality;
    }

    public int getId(){
        return id;
    }

    // Override
    public String toString(){
        return "Doctor Id : " + id + ", Name : " + name + ", Speciality : " + speciality;

    }
}

class Appointment {
    private Patient p;
    private Doctor d;
    private String date;

    public Appointment(Patient p, Doctor d, String date){
        this.p = p;
        this.d = d;
        this.date = date;
    }

    // Override
    public String toString(){
        return "Appointment :- \nPatient : " + p + "\nDoctor : " + d + "\nDate : " + date;
    }
}

public class HospitalManagementSystem {
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Doctor> doctors = new ArrayList<>();
    private static ArrayList<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Hospital Management System\n");
            System.out.println("1 : Add Patient");
            System.out.println("2 : Add Doctor");
            System.out.println("3 : Schedule Appointment");
            System.out.println("4 : View Patients");
            System.out.println("5 : View Doctors");
            System.out.println("6 : View Appointment");
            System.out.println("0 : Exit");
            System.out.println();
            
            choice = sc.nextInt();

            switch (choice){
                case 1 :
                    addPatient(sc);
                    break;
                case 2 :
                    addDoctor(sc);
                    break;
                case 3 : 
                    scheduleAppointment(sc);
                    break;
                case 4 : 
                    viewPatient();
                    break;
                case 5 : 
                    viewDoctor();
                    break;
                case 6 : 
                    viewAppointment();
                    break;
                case 0 : 
                    System.out.println("Exiting...");
                    break;
                default :
                    System.out.println("Invalid choice, please try again");
            }
        } while (choice != 0);

        sc.close();
    }

    private static void addPatient(Scanner sc){
        sc.nextLine(); // consume leftover newline
        System.out.println("Enter Patient name : ");
        String name = sc.nextLine();

        System.out.println("Enter Patient age : ");
        int age = sc.nextInt();
        sc.nextLine(); // consume newline again

        System.out.println("Enter Patient Gender : ");
        String gender = sc.nextLine();

        Patient p = new Patient(name, gender, age);
        patients.add(p);

        System.out.println("Patient added successfully!");
}


    private static void addDoctor(Scanner sc){
        sc.nextLine();
        System.out.println("Enter doctor name : ");
        String name = sc.nextLine();

        System.out.println("Enter doctor speciality : ");
        String speciality = sc.nextLine();

        Doctor d = new Doctor(name, speciality);

        // For viewing doctors
        doctors.add(d);

        System.out.println("Doctor added successfully!");
    }

    private static void scheduleAppointment(Scanner sc) {
        System.out.println("Enter patient id : ");
        int patId = sc.nextInt();

        System.out.println("Enter doctor id : ");
        int docId = sc.nextInt();

        sc.nextLine();
        System.out.println("Enter Appointment date (YYYY-MM-DD): ");
        String date = sc.nextLine();

        Patient p = findPatientById(patId);
        Doctor d = findDoctorById(docId);

        if(p != null && d != null){
            Appointment appointment = new Appointment(p, d, date);

            // for viewing appointments
            appointments.add(appointment);
            System.out.println("Appointment scheduled successfully!");
        }
        else System.out.println("Invalid Doctor Id or Patient Id.");
    }

    private static Doctor findDoctorById(int docId) {
        for(Doctor doc : doctors){
            if(doc.getId() == docId) return doc;
        }

        return null;
    }

    private static Patient findPatientById(int patId) {
        for(Patient p : patients){
            if(p.getId() == patId) return p;
        }
        
        return null;
    }

    private static void viewDoctor() {
        System.out.println("List of Doctors : ");
        for(Doctor doc : doctors){
            System.out.println(doc);
        }
    }

    private static void viewPatient() {
        System.out.println("List of Patients : ");
        for(Patient p : patients){
            System.out.println(p);
        }
    }

    private static void viewAppointment() {
        System.out.println("List of Appointments : ");
        for(Appointment ap : appointments){
            System.out.println(ap);
        }
    }
    
}