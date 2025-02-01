package Salonique.SaloonManagement.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.sql.*;
import Salonique.SaloonManagement.Connection.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class OwnerRestController {

    @PostMapping("/OwnerDetails")
    public String addownerdetails(@RequestParam String city,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String shopname,
            @RequestParam String desc,
            @RequestParam String stime,
            @RequestParam String etime,
            @RequestParam String experience,
            @RequestParam String longitude,
            @RequestParam String latitude,
            @RequestParam MultipartFile profile,
            @RequestParam MultipartFile shopphoto) {
        try {
            ResultSet rs = Database.executeQuery("select * from owner where owneremail='" + email + "'");
            if(rs.next())
            {
                return "fail";
            }
            else
            {
                int cid=Integer.parseInt(city);
                String oname = profile.getOriginalFilename();
                byte b[] = profile.getBytes();
                String abspath = "src/main/resources/static/myuploads/";
                FileOutputStream fos = new FileOutputStream(abspath + oname);
                fos.write(b);
                String oname1 = shopphoto.getOriginalFilename();
                byte b1[] = shopphoto.getBytes();
                String abspath1 = "src/main/resources/static/myuploads/";
                FileOutputStream fos1 = new FileOutputStream(abspath1 + oname1);
                fos1.write(b1);
                rs.moveToInsertRow();
                rs.updateString("ownername", name);
                rs.updateString("owneremail", email);
                rs.updateString("ownerpass", password);
                rs.updateString("ownerphoto", oname);
                rs.updateString("shopphoto", oname1);
                rs.updateString("shopname", shopname);
                rs.updateString("shopdesc", desc);
                rs.updateInt("cityid", cid);
                rs.updateString("latitude", latitude);
                rs.updateString("longitude", longitude);
                rs.updateString("status", "pending");
                rs.updateString("starttime", stime);
                rs.updateString("endtime", etime);
                rs.updateString("experience", experience);
                rs.insertRow();
                return "success";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return "exception";
        }

    }
    @PostMapping("/OwnerLogin1")
    public String ownerlogin(@RequestParam String uname,@RequestParam String password)
    {
        try{
            
        ResultSet rs=Database.executeQuery("select * from owner where owneremail='"+uname+"' and ownerpass='"+password+"'");
        if(rs.next())
        {
            return "success";
        }
        else
        {
            return "fail";
        }
        }
        catch(Exception ex){
            ex.printStackTrace();
            return "exception";
        }
    }
    @PostMapping("/AddPackage")
    public String addnewpackage(@RequestParam String packagename
            ,@RequestParam String packagedesc
            ,@RequestParam MultipartFile packagephoto
            ,@RequestParam String price
            ,@RequestParam String offerprice
            ,@RequestParam String type)
    {
     try{
            ResultSet rs=Database.executeQuery("select * from packages where packagename='"+packagename+"'");
            if(rs.next())
            {
                return "fail";
            }
            else
            {
                 String oname = packagephoto.getOriginalFilename();
                byte b[] = packagephoto.getBytes();
                String abspath = "src/main/resources/static/myuploads/";
                FileOutputStream fos = new FileOutputStream(abspath + oname);
                fos.write(b);
                rs.moveToInsertRow();
                rs.updateString("packagename", packagename);
                rs.updateString("packagedesc", packagedesc);
                rs.updateString("packagephoto","myuploads/"+oname);
                rs.updateString("price", price);
                rs.updateString("offerprice", offerprice);
                rs.updateString("type", type);
                rs.updateInt("ownerid", 2);
                rs.insertRow();
                return "success";
                
            }
     }   
     catch(Exception ex)
     {
         ex.printStackTrace();
         return "exception";
     }
    
        
    }
    
     @GetMapping("/GetServices")
     public String getservice()
     {
         int a=2;
         String ans=new RDBMS_TO_JSON().generateJSON("select * from packages where ownerid='"+a+"'");
         return ans;
     }
}
