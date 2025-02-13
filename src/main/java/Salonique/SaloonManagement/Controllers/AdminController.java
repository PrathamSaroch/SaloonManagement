package Salonique.SaloonManagement.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    @GetMapping("/AdminLogin")
    public String adminlogin()
    {
        return "AdminLogin";
    }
    @GetMapping("/AdminHome")
    public String adminhomeget()
    {
        return "AdminHome";
    }
    
     @GetMapping("/admincities")
    public String addcitiespage()
    {
        return "AdminManageCities";
    }
    
    @GetMapping("/ManageOwners")
    public String manageownerpage()
    {
        return "AdminManageOwner";
    }
    
//    hello 
//    world
}
