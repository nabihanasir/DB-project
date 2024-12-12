/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.freshfoods;

import static com.mycompany.freshfoods.accounts.userRecords;
import java.util.ArrayList;

public abstract class accounts {

    public accounts(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public  String username;
    public  String password;
    public static final ArrayList<user> userRecords =new ArrayList<>();
    public static final ArrayList<admin> adminRecords =new ArrayList<>();
    public abstract boolean login(String username,String password);
    public void signup(String username,String password){
        this.username=username;
        this.password=password;
    } 
    public static void createAccounts()
    {
        user user1= new user("sara","1234","House 34 street 45","033474783");
        user user2= new user("fatima","1234","House 34 street 45","033474783");
        user user3= new user("nabiha","1234","House 34 street 45","033474783");
        user user4= new user("alia","1234","House 34 street 45","033474783");
        
        userRecords.add(user1);
        userRecords.add(user2);
        userRecords.add(user3);
        userRecords.add(user4);
        
        admin Admin= new admin("nabiha","1234");
        adminRecords.add(Admin);
    }

}
class user extends accounts{

    @Override
    public String toString() {
        return "user{"+"username="+username+"password=" +password +"contactNumber=" + contactNumber + ", Addresss=" + Addresss + '}';
    }
   
    public String contactNumber;
    public String Addresss;
    public user( String username, String password, String contactNumber, String Addresss) {
        super(username, password);
        this.contactNumber = contactNumber;
        this.Addresss = Addresss;
    }
    public user(String username, String password) {
        super(username, password);
    }
    public void signup(user u)
        {
        userRecords.add(u);
        System.out.println("Account added successfully: "+u.toString());
        }
    @Override
    public boolean login(String username, String password) {
        boolean check=false;
        for(user u : userRecords)
        {
        if(username.equals(u.username)&&password.equals(u.password)){
        check=true;
        break;
        }
        }
        return check;
        }  
}
class admin extends accounts{

    public admin(String username, String password) {
        super(username, password);
    }

    @Override
    public String toString() {
        return "admin{"+"username="+username+"password=" +password +'}';
    }
  
   
    @Override
    public boolean login(String username, String password) {
        boolean check=false;
        for(admin a : adminRecords)
        {
        if(username.equals(a.username)&&password.equals(a.password)){
        check=true;
        break;
        }
        }
        return check;
        }
 

   
}