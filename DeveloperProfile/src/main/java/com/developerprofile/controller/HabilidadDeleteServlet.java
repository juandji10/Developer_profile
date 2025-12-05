package com.developerprofile.controller;

import com.developerprofile.dao.HabilidadDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HabilidadDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");

        new HabilidadDAO().eliminarHabilidad(id);

        response.sendRedirect("habilidades");
    }
}
