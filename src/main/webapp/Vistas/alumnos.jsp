<%-- 
    Document   : alumnos
    Created on : 26-dic-2021, 14:37:44
    Author     : Carlos
--%>
<%@page import="config.Conexion"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="modelo.alumnosDAO"%>
<%@page import="java.util.List"%>
<%@page import="modelo.alumnos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alumnos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <a class="btn btn-secondary btn-sm col-4 m-4" href="AlumnosControler?accion=nuevo">Agregar Alumno</a>
                <table class="table table-striped">
                    <thead>
                        <tr class="text-center">
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Email</th>
                            <th>Modificar</th>
                            <th>Eliminar</th>
                        </tr>
                    </thead>
                                <tbody class="text-center">
                                <%
                                List<alumnos> res=null;
                                alumnosDAO alu = new alumnosDAO();
                                res = alu.listarAlumnos();
                                for(alumnos alum:res){
                                    String ruta ="AlumnosControler?accion=modificar&id=" + alum.getId();
                                    String rutaE ="AlumnosControler?accion=eliminar&id=" + alum.getId();
                                    %>
                                   <tr class="text-center">
                                    <td><%= alum.getId()%></td>
                                    <td><%=alum.getNombre()%></td>
                                    <td><%=alum.getApellido()%></td>
                                    <td><%=alum.getEmail()%></td>
                                    <td class="text-center"><a class="bi bi-pencil-square" href=<%=ruta%>></a></td>
                                    <td class="text-center"><a class="bi bi-x-octagon" href=<%=rutaE%>></a></td>
                                   </tr>
                                </tbody>
                            <%
                                }
                            %>
              
                         
                </table>
            </div>           
        </div>
    </body>
</html>