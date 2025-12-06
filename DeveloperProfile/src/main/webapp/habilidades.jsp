<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@ page import="java.util.List" %> 
<%@ page import="com.developerprofile.model.Habilidad" %> 
<% 
    List<Habilidad> lista = (List<Habilidad>) request.getAttribute("habilidades"); 
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Habilidades</title>
        <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
        />
    </head>

    <body class="bg-light">
        <div class="container mt-5">
          <h1 class="mb-4 text-center">Gestión de Habilidades</h1>

          <div class="text-end mb-3">
            <a href="HabilidadController?action=nuevo" class="btn btn-primary">
              ➕ Agregar habilidad
            </a>
          </div>

          <table class="table table-striped table-bordered">
            <thead class="table-dark">
              <tr>
                <th>Nombre</th>
                <th>Nivel</th>
                <th style="width: 180px">Acciones</th>
              </tr>
            </thead>

            <tbody>
              <% if (lista != null) { for (Habilidad h : lista) { %>
                <tr>
                    <td><%= h.getId() %></td>
                    <td><%= h.getNombre() %></td>
                    <td><%= h.getNivel() %></td>
                    <td>
                        <a href="HabilidadController?action=editar&id=<%= h.getId() %>" class="btn btn-warning btn-sm">Editar</a>

                        <a href="HabilidadController?action=eliminar&id=<%= h.getId() %>" class="btn btn-danger btn-sm" onclick="return confirm('¿Seguro que deseas eliminar esta habilidad?');">Eliminar</a>
                    </td>
                </tr>
              <% } } %>
            </tbody>
          </table>
        </div>
    </body>
</html>

