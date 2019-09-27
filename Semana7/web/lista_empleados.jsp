<jsp:useBean id="a_empleado" class="java.util.ArrayList" scope="request" />
<%@page import="modelo.B_empleado" %>
<%@page import="java.util.AbstractList" %>
<html>
    <head><title>Empresa ABC - Lista de empleados </title></head>
    <body>
        <h1> Lista de empleados</h1>
        
        <table>
            
            <tr>
                <td>Codigo</td>       
                <td>Apellidos</td>     
                <td>Nombres</td>               
                <td>Sueldo</td>
            </tr>
            
            <% 

                B_empleado bempleado=new B_empleado();
                for(int i=0; i<a_empleado.size();i++){
                
                    bempleado=(B_empleado)a_empleado.get(i);
                     
            %>
            
             <tr>
                 <td><a href='SData_empleado?codigo=<%=bempleado.getCodigo()%>'><%=bempleado.getCodigo()%></td>       
                <td><%=bempleado.getApellidos()%></td>     
                <td><%=bempleado.getNombres()%></td>               
                <td><%=bempleado.getSueldo()%></td>
                <td><a href='SDelete_empleado?codigo='>Eliminar</a></td>
            </tr>
            
            <%}%>
        </table>
        
    </body>
</html>
