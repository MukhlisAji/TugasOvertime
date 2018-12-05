/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Presence;
import java.util.List;

/**
 *
 * @author Mukhlish
 */
public interface PresenceControllerInterface {
    public List<Object> getAlls();
    public List<Object> search(String key);
    public Presence getById(String id);
    public String insert(String NIK, String CheckIn, String CheckOut, String PresenceDate, String PresenceId);
    public String update(String NIK, String CheckIn, String CheckOut, String PresenceDate, String PresenceId);
    public String delete(String id);
    public List<Object> getPresenceName(String keyword); 
}
