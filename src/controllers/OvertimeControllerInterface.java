/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Overtime;
import java.util.List;

/**
 *
 * @author Mukhlish
 */
public interface OvertimeControllerInterface {
    public List<Object> getAlls();
    public List<Object> search(String key);
    public Overtime getById(String id);
    public String insert(String NIK, String PresenceId, String OT_Duration, String Fee, String Status, String OvertimeId);
    public String update(String NIK, String PresenceId, String OT_Duration, String Fee, String Status, String OvertimeId);
    public String delete(String id);
    public List<Object> getOvertimeName(String keyword);
}
