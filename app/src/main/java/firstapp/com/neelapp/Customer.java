package firstapp.com.neelapp;

public class Customer {
     String id ;
     String name;
     String loanno;
     String vehno ;
     String vehname;
     String vehicleChasis;
     String engineNumber;
     String loanAmount;
     String monthlyEmi;
     String dueDate;
     String status;

    public Customer(){

    }
    /*
    public Customer(String id, String name,String loanno,String vehno,String vehname,String vehicleChasis,String engineNumber,String loanAmount,String monthlyEmi,String dueDate, String status){
        this.id = id;
        this.name = name;
        this.loanno = loanno;
        this.vehno = vehno;
        this.vehname = vehname;
        this.vehicleChasis = vehicleChasis;
        this.engineNumber = engineNumber;
        this.loanAmount = loanAmount;
        this.monthlyEmi = monthlyEmi;
        this.dueDate = dueDate;
        this.status = status;
    }
    */
    public Customer(String name, String id, String loanno, String vehno, String vehname,String vehicleChasis, String engineNumber, String loanAmount, String monthlyEmi, String dueDate, String status){
        this.id = id;
        this.name= name;
        this.vehno = vehno;
        this.vehname = vehname;
        this.loanno = loanno;
        this.vehicleChasis = vehicleChasis;
        this.engineNumber = engineNumber;
        this.loanAmount = loanAmount;
        this.monthlyEmi = monthlyEmi;
        this.dueDate = dueDate;
        this.status = status;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLoanno() {
        return loanno;
    }

    public String getVehno() {
        return vehno;
    }

    public String getVehname() {
        return vehname;
    }

    public String getVehicleChasis() {
        return vehicleChasis;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public String getMonthlyEmi() {
        return monthlyEmi;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getStatus() {
        return status;
    }
}
