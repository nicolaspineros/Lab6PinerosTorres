/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.servlet;
import java.io.IOException;
import java.io.Writer;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.eci.cvds.servlet.model.*;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
    urlPatterns = "/clase"
)

public class Clase extends HttpServlet{
    
   protected List<Todo> todoList = new ArrayList<Todo>();
   
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Writer responseWriter = resp.getWriter();
       
       try {
           int id = Integer.parseInt(req.getParameter("id"));         
           Todo tid = Service.getTodo(id);
           todoList.add(tid);
           resp.setStatus(200);
           responseWriter.write(Service.todosToHTMLTable(todoList));
       } catch (IllegalArgumentException iae) {
           resp.setStatus(400);
           responseWriter.write("REQUERIMIENTO INVALIDO");
       } catch (MalformedURLException murle) {
           resp.setStatus(500);
           responseWriter.write("ERROR INTERNO EN EL SERVIDOR");
       } catch (NullPointerException npe) {
           resp.setStatus(404);
           responseWriter.write("NO EXISTE UN ITEM CON EL IDENTIFICADOR DADO");
       }
   }
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Writer responseWriter = resp.getWriter();
       
       try {
           int id = Integer.parseInt(req.getParameter("id"));         
           Todo tid = Service.getTodo(id);
           todoList.add(tid);
           resp.setStatus(200);
           responseWriter.write(Service.todosToHTMLTable(todoList));
       } catch (IllegalArgumentException iae) {
           resp.setStatus(400);
           responseWriter.write("REQUERIMIENTO INVALIDO");
       } catch (MalformedURLException murle) {
           resp.setStatus(500);
           responseWriter.write("ERROR INTERNO EN EL SERVIDOR");
       } catch (NullPointerException npe) {
           resp.setStatus(404);
           responseWriter.write("NO EXISTE UN ITEM CON EL IDENTIFICADOR DADO");
       }
   }
}
