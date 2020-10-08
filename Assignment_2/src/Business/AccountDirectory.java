/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class AccountDirectory {
    
    private ArrayList<Account> accountList;
    
    public AccountDirectory(){
        
        this.accountList = new ArrayList<Account>();   
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
    
    public void deleteAccount(Account account){
        accountList.remove(account);
    }
    
    public Account searchAccount(String CarName){
        for(Account account : accountList ){
            if(account.getCarName().equals(CarName)){
                return account;
            }
        }
     return null;
    }
    
    public Account searchByManufacturer(String Manufacturer){
        
        for(Account account: accountList){
            if(account.getManufacturer().equals(Manufacturer)){
                return account;
            }   
        }
        return null;   
    }
    
    public Account searchByYom(String Yom){
        
        for(Account account: accountList){
            if(account.getYom().equals(Yom)){
                return account;
            }   
        }
        return null;   
    }
    
    public Account searchByNumberOfSeats(String NumberOfSeats){
        
        for(Account account: accountList){
            if(account.getNumberOfSeats().equals(NumberOfSeats)){
                return account;
            }   
        }
        return null;   
    }
    
    public Account searchBySerialNumber(String SerialNumber){
        
        for(Account account: accountList){
            if(account.getSerialNumber().equals(SerialNumber)){
                return account;
            }   
        }
        return null;   
    }
    
    public Account searchByModelNumber(String ModelNumber){
        
        for(Account account: accountList){
            if(account.getModelNumber().equals(ModelNumber)){
                return account;
            }   
        }
        return null;   
    }
    
    public Account searchByLocation(String Location){
        
        for(Account account: accountList){
            if(account.getLocation().equals(Location)){
                return account;
            }   
        }
        return null;   
    }
    
}
