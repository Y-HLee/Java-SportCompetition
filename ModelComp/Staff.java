package ModelComp;

public class Staff{

    private String employeeID;
    private String employeeRole;
    private String staffName;
    private int accessLevel;

    public Staff(String employeeID, String employeeRole, String staffName, int accessLevel){

        this.employeeID = employeeID;
        this.employeeRole = employeeRole;
        this.staffName = staffName;
        this.accessLevel = accessLevel;

    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getEmployeeRole() {
        return employeeRole;
    }

    public String getStaffName() {
        return staffName;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    @Override
    public String toString() {
        return "ModelComp.Staff{" +
                "employeeID='" + employeeID + '\'' +
                ", employeeRole='" + employeeRole + '\'' +
                ", staffName='" + staffName + '\'' +
                ", accessLevel=" + accessLevel +
                '}';
    }
}


        