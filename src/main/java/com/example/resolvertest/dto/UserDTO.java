package com.example.resolvertest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    String userId;
    String username;
    boolean admin;

    public boolean isAdmin(){
        if(this.userId == null || !this.userId.equals("admin")){
            return false;
        }
        return true;
    }
}
