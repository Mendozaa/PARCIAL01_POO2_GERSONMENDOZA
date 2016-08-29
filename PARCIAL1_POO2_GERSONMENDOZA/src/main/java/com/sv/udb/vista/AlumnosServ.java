/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vista;

import com.sv.udb.controlador.AlumnosCtrl;
import com.sv.udb.modelo.Alumnos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gersonfrancisco
 */
@WebServlet(name = "AlumnosServ", urlPatterns = {"/AlumnosServ"})
public class AlumnosServ extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean esValido = request.getMethod().equals("POST");
        if(esValido)
        {
            String mens = "";
            String CRUD = request.getParameter("alumBton");
            if(CRUD.equals("Guardar"))
            {
                Alumnos obje = new Alumnos();
                obje.setNombAlum(request.getParameter("nombAlum"));
                obje.setApelAlum(request.getParameter("apelAlum"));
                obje.setFechNaciAlum(Date.valueOf(request.getParameter("fechAlum")));
                obje.setMailAlum(request.getParameter("mailAlum"));
                obje.setTeleAlum(request.getParameter("teleAlum"));
                obje.setDireAlum(request.getParameter("direAlum"));
                obje.setGeneAlum(request.getParameter("geneAlum").charAt(0));
                mens = new AlumnosCtrl().guar(obje) ? "Datos guardados exitosamente" : "Datos NO guardados";
            }
            /*else if(CRUD.equals("Consultar"))
            {
                Long CodiLuga = Long.parseLong(request.getParameter("codiPersRadio") == null ? 
                        "0" : request.getParameter("codiPersRadio"));
                LugaAcce objeLuga = new LugaAcceCtrl().get(CodiLuga);
                if(objeLuga != null)
                {
                    request.setAttribute("CodiLuga", objeLuga.getCodiLugaAcce());
                    request.setAttribute("nombLuga", objeLuga.getNombLugaAcce());
                }
            }*/
        request.setAttribute("mensAler", mens);
        request.getRequestDispatcher("/Alumno.jsp").forward(request, response);
        }
        else{
            response.sendRedirect(request.getContextPath() + "/Alumno.jsp");
        }
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
