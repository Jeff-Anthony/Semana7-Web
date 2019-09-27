
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.swing.JOptionPane;

public class SUpdate_empleado extends HttpServlet {

    private Connection conn;
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String codigo=request.getParameter("codigo");
        double sueldo=Double.parseDouble(request.getParameter("Sueldo"));
        Statement sen;
        String consulta;
        this.conexion_bd();
        try{
            sen=conn.createStatement();
            consulta="update empleados set sueldo ="+sueldo+" where codigo ="+codigo+"";
            sen.executeUpdate(consulta);
        
        }catch(SQLException e5){
            JOptionPane.showMessageDialog(null, "Error en el proceso");
        }
        response.sendRedirect("SLista_empleados");
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
