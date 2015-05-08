package com.example.missioncontrol;

public class RAContact {
	int _id;
    String _name;
    String _phone_number;
    String _email;
    String _password;
    
    public RAContact(){}
    
    public RAContact(int id, String name, String phone_number, String email, 
    		String password){
        this._id = id;
        this._name = name;
        this._phone_number = phone_number;
        this._email = email;
        this._password = password;
    }
    
    public RAContact(String name, String phone_number, String email, 
    		String password){
        this._name = name;
        this._phone_number = phone_number;
        this._email = email;
        this._password = password;
    }
    
    public int getID() {
        return this._id;
    }
    public void setID(int id) {
        this._id = id;
    }
    public String getName() {
        return this._name;
    }
    public void setName(String name) {
    	this._name = name;
    }
    public String getPhoneNumber(){
        return this._phone_number;
    }
    public void setPhoneNumber(String phone_number){
        this._phone_number = phone_number;
    }
    public String getEmail() {
        return this._email;
    }
    public void setEmail(String email) {
    	this._email = email;
    }
    public String getPassword() {
        return this._password;
    }
    public void setPassword(String password) {
    	this._password = password;
    }
}
