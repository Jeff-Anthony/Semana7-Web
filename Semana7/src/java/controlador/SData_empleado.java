
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.swing.JOptionPane;
import modelo.B_empleado;

public class SData_empleado extends HttpServlet {
    private Connection conn;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       B_empleado bempleado= new B_empleado();
       String codigo=request.getParameter("codigo");
       Statement sen;
       ResultSet res;
       this.conexion_bd();
       try{
           sen = conn.createStatement();
           res=sen.executeQuery("select codigo,apellidos,nombres,sueldo from empleados where codigo="+codigo);
           while(res.next()){
               bempleado.setCodigo(res.getString(1));              
               bempleado.setApellidos(res.getString(2));               
               bempleado.setNombres(res.getString(3));              
               bempleado.setSueldo(res.getDouble(4));               
               
           }
           res.close();
           sen.close();
           conn.close();
       
       }catch(SQLException e4){
           JOptionPane.showMessageDialog(null, "Error en el proceso");
       }
       request.setAttribute("b_empleado", bempleado);
       RequestDispatcher rd = request.getRequestDispatcher("data_empleado.jsp");
       rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    public void conexion_bd(){
    
        String driver="com.mysql.jdbc.Driver";
        String cadena="jdbc:mysql://localhost/semana07";
        String usuario="root";
        String clave="";
        try{
        
          Class.forName(driver);
          conn=DriverManager.getConnection(cadena, usuario, clave);
            
        }catch(ClassNotFoundException e1){
            JOptionPane.showMessageDialog(null, "Error de Driver");
        }catch(SQLException e2){            
            JOptionPane.showMessageDialog(null, "Error en la Conexión");
        }
    
    }
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
