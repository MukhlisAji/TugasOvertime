/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Timesheet;
import java.util.List;

/**
 *
 * @author Mukhlish
 */
public interface TimesheetControllerInterface {
    public List<Object> getAlls();
    public List<Object> search(String key);
    public Timesheet getById(String id);
    public String insert(String NIK, String TS_File, String Ts_Date, String TimesheetId);
    public String update(String NIK, String TS_File, String Ts_Date, String TimesheetId);;
    public String delete(String id);
    public List<Object> getTimesheetName(String keyword); 
}
