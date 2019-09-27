<jsp:useBean class="modelo.B_empleado" id="b_empleado" scope="request"/>
<html>
    <head><title>Empresa ABC -Mantenimiento de Empleado</title></head>
    <body>
        <h1>Empresa ABC -Mantenimiento de Empleado</h1>
        
        <form action="SUpdate_empleado">
            
            <table>
                
                 <tr>                   
                    <td>Apellidos</td>
                    <td><input type="text" readonly name="Apellidos" value="<%=b_empleado.getApellidos()%>"  ></td>
                 </tr>   
                 
                   
                <tr>
                    <td>Nombres</td>   
                    <td><input type="text" readonly name="Nombres" value="<%=b_empleado.getNombres()%>"></td>
                    
                 </tr>    
                 
                  
                 <tr>    
                     <td>Sueldos</td>
                     <td><input type="text" name="Sueldo" value="<%=b_empleado.getSueldo()%>"></td>
                    
                    
                </tr>
                         
                 <tr>    
                     <td><input type="submit" value="Actualizar"></td>    
                </tr>
                
            </table>
                     <input type="hidden" name="codigo" value="<%=b_empleado.getCodigo()%>">
        </form>      
        
    </body>
</html>
