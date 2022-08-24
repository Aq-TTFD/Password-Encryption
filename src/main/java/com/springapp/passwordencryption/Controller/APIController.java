package com.springapp.passwordencryption.Controller;

import com.springapp.passwordencryption.Text;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class APIController {

    @GetMapping("/getRequest")
    public Map<String, String> getMethod(){
        var response = new HashMap<String, String>();

        response.put("status", "success");
        return response;
    }

    @GetMapping("/encrypt")
    public Map<String, String> submitTextEncrypt(@RequestBody Text text){
        var response = new HashMap<String, String>();
        String result = text.encrypt();
        if(result.equals("null")) {
            response.put("status", "Failed");
        } else {
            response.put("status", "success");
        }
        response.put("TextEncrypt", result);
        System.out.println("encrypt");
        return response;
    }

    @GetMapping("/decrypt")
    public HashMap<String, String> submitTextDecrypt(@RequestBody Text text){
        var response = new HashMap<String, String>();
        String result = text.decrypt();

        if(result.equals("null")) {
            response.put("status", "Failed");
        } else {
            response.put("status", "success");
        }
        response.put("TextEncrypt", result);
        return response;
    }
}
