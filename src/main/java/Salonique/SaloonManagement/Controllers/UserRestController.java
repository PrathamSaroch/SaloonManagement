package Salonique.SaloonManagement.Controllers;

import Salonique.SaloonManagement.Connection.Database;
import Salonique.SaloonManagement.Connection.RDBMS_TO_JSON;
import java.sql.ResultSet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    @GetMapping("/userShowCities")
    public String userShowCities() {
        try {
            String ans = new RDBMS_TO_JSON().generateJSON("select * from cities");

            System.out.println(ans);

            return ans;
        } catch (Exception ex) {
            return ex.toString();
        }
    }

    @GetMapping("userShowAllSaloons")
    public String userShowSaloons(@RequestParam String cityid) {
        try {
            String ans = new RDBMS_TO_JSON().generateJSON("select * from owner where cityid= " + cityid + " ");

            System.out.println(ans);

            return ans;
        } catch (Exception ex) {
            return ex.toString();
        }
    }

    @GetMapping("userShowAllSaloonDetails")
    public String userShowAllSaloonDetails(@RequestParam String ownerid) {
        try {
            String ans = new RDBMS_TO_JSON().generateJSON("select * from owner where ownerid= " + ownerid + " ");

            System.out.println(ans);

            return ans;
        } catch (Exception ex) {
            return ex.toString();
        }
    }

    @GetMapping("userShowAllSaloonPackage")
    public String userShowAllSaloonPackage(@RequestParam String ownerid) {
        try {
            String ans = new RDBMS_TO_JSON().generateJSON("select * from packages where ownerid= " + ownerid + " ");

            System.out.println(ans);

            return ans;
        } catch (Exception ex) {
            return ex.toString();
        }
    }

    @GetMapping("userShowPackageDetails")
    public String userShowPackageDetails(@RequestParam String packageid) {
        try {
            String ans = new RDBMS_TO_JSON().generateJSON("select * from packages where packageid= " + packageid + " ");

            System.out.println(ans);

            return ans;
        } catch (Exception ex) {
            return ex.toString();
        }
    }
    
    
    @PostMapping("/booking")
public String addBookingDetails(@RequestParam String customername,
        @RequestParam String customeremail,
        @RequestParam String customeraddress,
        @RequestParam String bookingdate,
        @RequestParam String bookigntime,
        @RequestParam String modeofpayment,
@RequestParam String packageid) {
    try {
        // Check if the customer already exists based on email
        ResultSet rs = Database.executeQuery("SELECT * FROM booking");
        
            // Insert new booking record into the database
            rs.moveToInsertRow();
            rs.updateString("username", customername);
            rs.updateString("useremail", customeremail);
            rs.updateString("address", customeraddress);
            rs.updateString("bookingdate", bookingdate);
            rs.updateString("bookingtime", bookigntime);
            rs.updateString("modeofpayment", modeofpayment);
            rs.updateInt("packageid", Integer.parseInt(packageid));
            rs.insertRow();
            
            // Return success message after booking is created
            return "success";
       
    } catch (Exception ex) {
        ex.printStackTrace();
        return "exception"; // If any exception occurs
    }
}


}
