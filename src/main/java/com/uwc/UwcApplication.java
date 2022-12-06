package com.uwc;

import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uwc.entity.Role;
import com.uwc.entity.User;

@SpringBootApplication
public class UwcApplication {

	public static void main(String[] args) {
		SpringApplication.run(UwcApplication.class, args);
	}

	private static User createUserObject1() {
        User user = new User();
        user.setUsername("user1");
        user.setPassword("testPassword");
        
       
        return user;
    }
	
	private void createSampleRoles() {
	}

}
