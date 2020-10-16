/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import Business.*;
import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class AccountDirectory {
    
    private ArrayList<Account> accountList;
    private ArrayList<Account> accountList2;
    
    
    
    public AccountDirectory(){
        
        this.accountList = new ArrayList<Account>();
        this.accountList2 = new ArrayList<Account>();
        
    }

    public ArrayList<Account> getAccountList2() {
        return accountList2;
    }

    public void setAccountList2(ArrayList<Account> accountList2) {
        this.accountList2 = accountList2;
    }
    
    public ArrayList<Account> getAccountList() {
        return accountList;
    }
    public void setAccountList(ArrayList<Account> accountList) {
        this.accountList = accountList;
    }
    
    public Account addAccount(){
        
        Account account = new Account();
        accountList.add(account);
        return account;
    }
    
    public Account addAccount2(){
        
        Account account = new Account();
        accountList2.add(account);
        return account;
    }
    
    public void deleteAccount(Account account){
        accountList.remove(account);
    }
    
    public Account SearchCarName(String CarName){
        for(Account account : accountList ){
            if(account.getCarName().equals(CarName)){
                return account;
                
            }
        }
     return null;
    }
    
     public Account SearchManufcturer(String Manufacturer){
        for(Account account : accountList ){
            if(account.getManufacturer().equals(Manufacturer)){
                return account;
                
            }
        }
     return null;
    }
     
     public Account SearchYom(String Yom){
        for(Account account : accountList ){
            if(account.getYom().equals(Yom)){
                return account;
                
            }
        }
     return null;
    }
     
     
     public Account SearchNumberOfSeats(String NumberOfSeats){
        for(Account account : accountList ){
            if(account.getNumberOfSeats().equals(NumberOfSeats)){
                return account;
                
            }
        }
     return null;
    }
     
     public Account SearchModelNumber(String ModelNumber){
        for(Account account : accountList ){
            if(account.getModelNumber().equals(ModelNumber)){
                return account;
                
            }
        }
     return null;
    }
     
     public Account SearchSerialNumber(String SerialNumber){
        for(Account account : accountList ){
            if(account.getSerialNumber().equals(SerialNumber)){
                return account;
                
            }
        }
     return null;
    }
     
     public Account SearchLocation(String Location){
        for(Account account : accountList ){
            if(account.getLocation().equals(Location)){
                return account;     
            }
        }
     return null;
    }
     
     public Account SearchAvailability(Boolean Availability){
        for(Account account : accountList ){
            if(account.getAvailability().equals(Availability)){
                return account;     
            }
        }
     return null;
    }   
}
