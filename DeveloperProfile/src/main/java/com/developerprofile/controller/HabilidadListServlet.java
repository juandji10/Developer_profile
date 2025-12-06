package com.developerprofile.controller;

import com.developerprofile.dao.HabilidadDAO;
import com.developerprofile.model.Habilidad;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class HabilidadListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HabilidadDAO dao = new HabilidadDAO();
        List<Habilidad> habilidades = dao.listarHabilidades();

        request.setAttribute("habilidades", habilidades);

        request.getRequestDispatcher("habilidades.jsp").forward(request, response);
        System.out.println("Total habilidades encontradas: " + habilidades.size());
    }
}
