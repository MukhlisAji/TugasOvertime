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
}
