<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
      
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

        <script type="text/javascript"  src="<%=request.getContextPath()%>/recursos/js/limpiar.js"></script>
        <title>Colegio Mantenedor</title>
    </head>
    <body>
           <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="index.html">INDEX</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
             <span class="navbar-toggler-icon"></span>
        </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                  <ul class="navbar-nav">

                    <li class="nav-item">
                      <a class="nav-link" href="home">Mantenedor Colegios</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="profesores2">Mantenedor Profesores</a>
                    </li>

                  </ul>
            </div>
        </nav>
        <h1>Mantenedor Colegios</h1>

        <form id="formulario"action="<%=request.getContextPath()%>/agregarcolegio" method="post">
  <div class="form-group row">
    <label for="colFormLabel" class="col-sm-2 col-form-label">Nombre</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="txtnombre" name="txtnombre"placeholder="nombe liceo"value="" required>
    </div>
 
  
    <label for="colFormLabel" class="col-sm-2 col-form-label">Direcccion</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="txtdireccion" name="txtdireccion" placeholder="direccion ciudad"value="" required>
    </div>
    <button type="submit"  class="btn btn-primary">agregar</button>
    <br>
     <button type="button" style="margin-left:  10px"onclick="limpiarFormulario()" class="btn btn-primary">limpiar</button>
    
  </div>
</form>
  
       

        <table class="table table-bordered">
            
            <thead>
                <th>ID</th>
                <th>Nombre</th>
                  <th>Direccion</th>
                <th>Opciones</th>
           
            </thead>
           
                <tbody>
                    <c:forEach items="${datos}" var="dato">
                        <tr>
                            <td><c:out value="${dato.getId()}" /> </td>
                            <td><c:out value="${dato.getNombre()}" /> </td>
                           <td><c:out value="${dato.getDireccion()}" /> </td>
                          <td>   
                             
                             <a href="<%=request.getContextPath()%>/eliminarcolegio?id=<c:out value="${dato.getId()}" />" class="btn btn-danger"><span class="glyphicon glyphicon-pencil"></span>eliminar</a>
                             <a href="#" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span>editar</a>
                        </tr>
                    </c:forEach>
                </tbody>
          
        </table>
    </body>
</html>
