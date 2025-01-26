package Salonique.SaloonManagement.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    
    @GetMapping("/")
    public String index()
    {
        System.out.println("In Controller");
        return "index-3";
    }
}
