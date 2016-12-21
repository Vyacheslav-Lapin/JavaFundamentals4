package generics;

import java.util.ArrayList;
import java.util.List;

public class Generics {

    public static void main(String[] args) {
//        List<? extends Doctor> list1 = new ArrayList<MedicalStaff>(); // error
        List<? extends Doctor> list2 = new ArrayList<>();
        List<? extends Doctor> list3 = new ArrayList<HeadDoctor>();

    }
}

class MedicalStaff {}
class Doctor extends MedicalStaff {}
class HeadDoctor extends Doctor {}
class Nurse extends MedicalStaff {}
