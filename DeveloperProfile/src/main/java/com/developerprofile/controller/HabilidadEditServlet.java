package com.developerprofile.controller;

import com.developerprofile.dao.HabilidadDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HabilidadEditServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");

        new HabilidadDAO().editarHabilidad(id, nombre);

        response.sendRedirect("habilidades");
    }
}
