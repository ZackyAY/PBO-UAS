package model;

import entity.StaffEntity;
import java.util.ArrayList;

public class StaffModel {
    static ArrayList<StaffEntity> arrayStaff = new ArrayList<>();

    public static ArrayList<StaffEntity> all(){
        return arrayStaff;
    }

    public static void initialStaff(){
        arrayStaff.add(new StaffEntity("admin", "admin"));
        arrayStaff.add(new StaffEntity("zacky", "indomie"));
        arrayStaff.add(new StaffEntity("andre", "bolot"));
        arrayStaff.add(new StaffEntity("zidan", "gakboleh"));
        arrayStaff.add(new StaffEntity("okto ", "kopling"));
    }
}