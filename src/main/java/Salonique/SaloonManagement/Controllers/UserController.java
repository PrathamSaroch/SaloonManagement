package Salonique.SaloonManagement.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    
    @GetMapping("/")
    public String index()
    {
        return "index-3";
    }
    
    @GetMapping("/UserShowSaloons")
    public String UserShowSaloons()
    {
        return "UserShowSaloons";
    }
    
    @GetMapping("/UserShowSaloonDetail")
    public String UserShowSaloonDetail()
    {
        return "UserShowSaloonDetail";
    }
    
    @GetMapping("/checkout")
    public String Checkout()
    {
        return "checkout";
    }
}
