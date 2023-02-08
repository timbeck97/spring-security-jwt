/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.security.jwt.controller;

import com.security.jwt.model.User;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author tim
 */

@WebServlet("/api/download/*")
public class ServletTest extends HttpServlet  {
    
    @PersistenceContext
    private EntityManager em;
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("download");
        String sql="SELECT u FROM User u";
        
        Query query = em.createNativeQuery("SELECT u FROM User u");
        List<User> result=query.getResultList();
        
        result.forEach(x->System.out.println(x.getName()));
       
        
    }
    
    
    
}
