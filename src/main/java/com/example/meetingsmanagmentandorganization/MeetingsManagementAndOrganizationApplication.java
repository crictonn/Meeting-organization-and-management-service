package com.example.meetingsmanagmentandorganization;

import com.example.meetingsmanagmentandorganization.jwt.JwtCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MeetingsManagementAndOrganizationApplication {

    private JwtCore jwtCore;

    @Autowired
    public void setJwtCore(JwtCore jwtCore) {
        this.jwtCore = jwtCore;
    }

    public static void main(String[] args) {
        SpringApplication.run(MeetingsManagementAndOrganizationApplication.class, args);
    }

}
