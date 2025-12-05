package com.developerprofile.controller;


import com.developerprofile.dao.HabilidadDAO;
import com.developerprofile.model.Habilidad;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HabilidadAddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        int nivel = Integer.parseInt(request.getParameter("nivel"));

        Habilidad hab = new Habilidad(nivel, null, nombre);

        new HabilidadDAO().agregarHabilidad(hab);

        response.sendRedirect("habilidades");
    }
}