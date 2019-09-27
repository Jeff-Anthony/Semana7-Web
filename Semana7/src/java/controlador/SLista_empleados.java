
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import modelo.B_empleado;

public class SLista_empleados extends HttpServlet {
    private Connection conn;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
        ArrayList lista = new ArrayList();
        
        B_empleado bempleado;
        Statement sen;
        ResultSet res;
        this.conexion_bd();
        try{
        
            sen=conn.createStatement();
            res = sen.executeQuery("select * from empleados");
            while(res.next()){
                bempleado = new B_empleado();
               
                bempleado.setCodigo(res.getString(1));
                bempleado.setApellidos(res.getString(2));
                bempleado.setNombres(res.getString(3));
                bempleado.setSueldo(res.getDouble(4));
                lista.add(bempleado);
            }
            res.close();
            sen.close();
            conn.close();
            
        }catch(SQLException e3){
             JOptionPane.showMessageDialog(null, "Error en la Consulta");
        }
     
        request.setAttribute("a_empleado", lista);
        RequestDispatcher rd=request.getRequestDispatcher("lista_empleados.jsp");
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
