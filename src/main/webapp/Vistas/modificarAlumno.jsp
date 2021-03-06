<%-- 
    Document   : modificarAlumno
    Created on : 26-dic-2021, 14:38:37
    Author     : Carlos
--%>

<%@page import="modelo.alumnosDAO"%>
<%@page import="modelo.alumnos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Alumno</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    </head>
    <body>
        
        <%
            String id = request.getParameter ("id"); // Use request para obtener 
            int mid;
            mid =Integer.parseInt(id);
            alumnos resultado=null;
            alumnosDAO alumnosDao = new alumnosDAO(); 
            resultado =  alumnosDao.mostrarAlumno(mid);
            
            
        %>
        <div class="container">
            <h1 class="text-center">Modificar Alumno</h1>
            <div class="row">
                <form class="p-5" action="AlumnosControler?accion=actualizar" method="POST">
                        <div class="mb-3">
                          <label for="id" class="form-label"></label>
                          <input type="hidden" class="form-control" id="id" name="id"  value=<%=resultado.getId()%>>
                        </div>
                        <div class="mb-3">
                          <label for="nombre1" class="form-label">Nombre</label>
                          <input type="text" class="form-control" id="nombre1" name="nombre"  value=<%=resultado.getNombre()%>>
                        </div>
                        <div class="mb-3">
                          <label for="apellido" class="form-label">Apellido</label>
                          <input type="text" class="form-control" id="apellido" name="apellido" value=<%=resultado.getApellido()%>>
                        </div>
                        <div class="mb-3">
                          <label for="email" class="form-label">Email</label>
                          <input type="email" class="form-control" id="email" name="email" value=<%=resultado.getEmail()%>>
                        </div>
                        <button type="submit" class="btn btn-secondary btn-sm">Modificar</button>
                      </form>
            </div>
        </div>
    </body>
</html>

