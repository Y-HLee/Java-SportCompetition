package ModelComp;

import java.util.ArrayList;

public class Manager extends Staff{
    private ArrayList<Staff> staffList;

    public Manager(String employeeID, String employeeRole, String staffName, int accessLevel) {
        super(employeeID, employeeRole, staffName, accessLevel);
        staffList = new ArrayList<>();
    }

    public void addStaff(Staff staff){
        staffList.add(staff);
    }
    public String printInfo() {
        StringBuilder staffInfo = new StringBuilder();
        for (Staff staff : staffList) {
            staffInfo.append(staff.toString());
        }
        return staffInfo.toString();
    }
}

