/*
    Document   : ELMKAddBookServlet.java
    Assignment : A3
    Project    : ELMKClub
    Created on : 03/17/2016
    Date Due   : 03/23/2016
    Programmers: Eric Lachapelle, Mohammad Khomeiri
*/

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package club.admin;

import club.business.Book;
import club.data.BookIO;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author elachapelle-cc
 */
public class ELMKAddBookServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext context = request.getServletContext();
        String path = context.getRealPath("/WEB-INF/books.txt");
        
        String code = request.getParameter("code");
        String description = request.getParameter("description");
        String quantityString = request.getParameter("quantity");
           
        int quantity = 0;
        String message = (String) request.getAttribute("message");
        message = "";
        // validation
        if (code == null || code == "")
        {           
            message += "Must give a numeric code<br>"; 
        }
        if (description.length() < 2)
        {            
            message += "Description must have at least 2 characters<br>";
        }
        if (quantityString == null || quantityString == "")
        {
            message += "Quantity cannot be empty<br>";
        } 
        else
        {
            quantity = Integer.parseInt(quantityString);
            if (quantity < 1) 
            {
                message += "Quantity must be a positive value.<br>";
            }
        }        
        
        
        if (message == "") 
        {   
            // create new book
            Book newBook = new Book(code, description, quantity); 

            // if there are no errors add book and go to list of books
            BookIO.insert(newBook, path);           
            String url = "/ELMKDisplayBooks";        
            context.getRequestDispatcher(url).forward(request, response);
        }

        String url = "/ELMKAddBook.jsp";    
        request.setAttribute("message", message);//add
        context.getRequestDispatcher(url).forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
