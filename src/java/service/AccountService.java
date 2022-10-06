
package service;

import java.beans.*;
import java.io.Serializable;



public class AccountService implements Serializable {
    

   
    
    public AccountService(){
    
}
    
    public User login(String users, String pass){
     String abe = "abe";
     String barb = "barb";
     String password = "password";
     
     if(users.equals(abe)|| users.equals(barb) && pass.equals(password)){
           User user = new User(users, pass);
         return user;
     }
     else{
         return null;
     }
       
    }
    
    
    
}

