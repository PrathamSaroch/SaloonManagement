package Salonique.SaloonManagement.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OwnerController {
   @GetMapping("/OwnerSignupPage")
    public String signuppage()
    {
        return "OwnerSignup";
    }  
    
    @GetMapping("/OwnerLogin")
    public String ownerlogin()        
    {
        return "OwnerLogin";
    }
    @GetMapping("/OwnerHome")
    public String openownerhome()
    {
        return "OwnerHome";
    }
    @GetMapping("/ManagePackage")
    public String addpackagepage()
    {
        return "OwnerManagePackage";
    }
}
