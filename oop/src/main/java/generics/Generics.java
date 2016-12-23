package generics;

import java.util.ArrayList;
import java.util.List;

public class Generics {

    public static void main(String[] args) {
//        List<? extends Doctor> list1 = new ArrayList<MedicalStaff>(); // error
        List<? extends Doctor> list2 = new ArrayList<>();
        List<? extends Doctor> list3 = new ArrayList<HeadDoctor>();
//        List<? super Doctor> list7 = new ArrayList<HeadDoctor>(); // error
        List<? super Doctor> list6 = new ArrayList<>();
        List<? super Doctor> list5 = new ArrayList<MedicalStaff>();
        List<? super Doctor> list4 = new ArrayList<Object>();

//        list5.add(new Object()); // error
//        list5.add(new MedicalStaff()); // error
        list5.add(new Doctor());
        list5.add(new HeadDoctor());

        Object object = list5.get(0);
//        MedicalStaff medicalStaff = list5.get(0); //error
//        Doctor doctor = list5.get(0); //error
//        HeadDoctor headDoctor = list5.get(0); //error

    }
}

class MedicalStaff {}
class Doctor extends MedicalStaff {}
class HeadDoctor extends Doctor {}
class Nurse extends MedicalStaff {}
