package Salonique.SaloonManagement.Controllers;

import Salonique.SaloonManagement.Connection.Database;
import Salonique.SaloonManagement.Connection.RDBMS_TO_JSON;
import org.springframework.web.bind.annotation.GetMapping;
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
            String ans = new RDBMS_TO_JSON().generateJSON("select * from owner where cityid= "+cityid+" ");

            System.out.println(ans);

            return ans;
        } catch (Exception ex) {
            return ex.toString();
        }
    }
}
