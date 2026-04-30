package cesde.domain;

import java.util.List;

public class Student {

    // POJO - Plain Old Java Object

    // Atributes

    private int id;
    private int number;
    private String name;
    private String lastName;
    private String email;
    private boolean status;

    //Constructores

    public Student(){

    }

    public Student(String email){
        this.email = email;
    }

    public Student(int id, String name,String lastName, String email, boolean status) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.status = status;
    }

    // Getters And Setters

    public int getId(){
        return this.id;
    }


    public void setId(int id){
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    //methods

    





}
