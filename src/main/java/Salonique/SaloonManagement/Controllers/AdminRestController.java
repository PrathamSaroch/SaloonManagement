package Salonique.SaloonManagement.Controllers;

import java.sql.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import Salonique.SaloonManagement.Connection.*;
import jakarta.servlet.annotation.MultipartConfig;
import java.io.FileOutputStream;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class AdminRestController {

    @PostMapping("/AdminLogin1")
    public String adminlogindetails(@RequestParam String uname, @RequestParam String password) {
        try {
            ResultSet rs = Database.executeQuery("select * from admin where User='" + uname + "' and Password='" + password + "'");
            if (rs.next()) {
                return "success";
            } else {
                return "fail";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return "exception";
        }
    }

    @PostMapping("/AddCity")
    public String addcitytable(@RequestParam String name, @RequestParam String desc, MultipartFile file) {
        try {
            ResultSet rs = Database.executeQuery("select * from cities where cityname='" + name + "'");
            if (rs.next()) {
                return "fail";
            } else {
                rs.moveToInsertRow();
                rs.updateString("cityname", name);
                rs.updateString("citydesc", desc);
                String oname = file.getOriginalFilename();
                byte b[] = file.getBytes();
                String abspath = "src/main/resources/static/myuploads/";
                FileOutputStream fos = new FileOutputStream(abspath + oname);
                fos.write(b);
                rs.updateString("cityphotos", oname);
                rs.insertRow();
                return "success";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return "exception";
        }
    }
}
