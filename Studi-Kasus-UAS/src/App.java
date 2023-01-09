import model.StaffModel;
import model.TamuModel;
import controller.StaffController;

public class App {
    public static void main(String[] args) {
        StaffController staff = new StaffController();
        StaffModel.initialStaff();
        TamuModel.initialKamar();
        staff.toMain();
    }
}
