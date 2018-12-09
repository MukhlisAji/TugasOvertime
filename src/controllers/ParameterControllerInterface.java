/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Parameter;
import java.util.List;

/**
 *
 * @author AD
 */
public interface ParameterControllerInterface {
    public List<Object> getAlls();
    public List<Object> search(String key);
    public Parameter getById(String id);
    public boolean insert(String paramaterId, String paramaterName, String value);
    public boolean update(String paramaterId, String paramaterName, String value);
    public boolean delete(String id);
}
