/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

/**
 *
 * @author AD
 */
public class Datas {
    private static String nik;
    private static String status;
    private static  String name;
    private static  String email;
    private static  String notelp;
    private static  String Hire_date;
    private static  String job_title;
    private static  String manager_id;
    private static  String password;
    private static  String salary;

    public static String getStatus() {
        return status;
    }

    public static void setStatus(String status) {
        Datas.status = status;
    }
    

    public static String getNik() {
        return nik;
    }

    public static void setNik(String nik) {
        Datas.nik = nik;
    }

     public static String getName() {
       return name;
    }

    public static void setName(String name) {
       Datas.name = name;
    }

    public static String getemail() {
       return email;
    }
     
    public static void setEmail(String email) {
        Datas.email = email;
    }
    
    public static String getNotelp() {
       return notelp;
    }
    
    public static void setNotelp(String noTelp) {
        Datas.notelp = noTelp;
    }
    
   public static String getHire_date() {
       return Hire_date;
    }
   
    public static void setHire_date(String Hire_date) {
        Datas.Hire_date = Hire_date;
    }
    
    public static String geteJob_title() {
       return job_title;
    }
    
    public static void setJob_title(String Job) {
        Datas.job_title = Job;
    }

    public static String getManager_id() {
       return manager_id;
    }
    
    public static void setManager_id(String manager_id) {
        Datas.manager_id = manager_id;
    }
    
    public static String getPassword() {
       return password;
    }
    
    public static void setPassword(String password) {
        Datas.password = password;
    }

    public static String getSalary() {
       return salary;
    }
    
    public static void setSalary(String Salary) {
        Datas.salary = Salary;
    }
}
