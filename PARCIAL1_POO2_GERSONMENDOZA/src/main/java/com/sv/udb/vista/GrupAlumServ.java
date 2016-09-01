/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vista;

import com.sv.udb.controlador.AlumnosCtrl;
import com.sv.udb.controlador.GruposAlumnosCtrl;
import com.sv.udb.controlador.GruposCtrl;
import com.sv.udb.modelo.Alumnos;
import com.sv.udb.modelo.Grupos;
import com.sv.udb.modelo.GruposAlumnos;
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
@WebServlet(name = "GrupAlumServ", urlPatterns = {"/GrupAlumServ"})
public class GrupAlumServ extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        boolean esValido = request.getMethod().equals("POST");
        if(esValido)
        {
            String mens = "";
            String CRUD = request.getParameter("grupAlumBton");
            if(CRUD.equals("Guardar"))
            {
                Alumnos obje1 = new AlumnosCtrl().get(Integer.parseInt(request.getParameter("codiAlum")));
                Grupos obje2 = new GruposCtrl().get(Integer.parseInt(request.getParameter("codiGrup")));
                GruposAlumnos obje = new GruposAlumnos();
                obje.setEstaGrupAlum('1');
                obje.setCodiGrup(obje2);
                obje.setCodiAlum(obje1);
                mens = new GruposAlumnosCtrl().guar(obje) ? "Datos guardados exitosamente" : "Datos NO guardados";
            }
            else if(CRUD.equals("Consultar"))
            {
                int codiGrup = Integer.parseInt(request.getParameter("grup"));
                    request.setAttribute("Grupo", codiGrup);
            }
        request.setAttribute("mensAler", mens);
        request.getRequestDispatcher("/grupoalumno.jsp").forward(request, response);
        }
        else{
            response.sendRedirect(request.getContextPath() + "/grupoalumno.jsp");
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
