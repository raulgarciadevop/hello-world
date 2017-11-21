/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Administrator
 */
public class DownloadFromDB implements Runnable {

    private String DB_PATH;
    private String DB_USER;
    private String DB_PASS;
    private final String nombre_usuario;
    private String clave_usuario;
    private int id_usuario;
    private int pin_usuario;
    private int connectionIntents;

    public DownloadFromDB(String nombre_usuario) {
        this.DB_PATH = "jdbc:mysql://mysql6.gear.host/sicfinal";
        this.DB_USER="sicfinal";
        this.DB_PASS="Gd5I-LJ-3Z2K";
        this.nombre_usuario = nombre_usuario;
        this.clave_usuario = null;
    }
    
    

    @Override
    public void run() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            String query = "SELECT * FROM usuario WHERE nombre_usuario='" + nombre_usuario + "'";

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(DB_PATH, DB_USER, DB_PASS);
            Statement sentencia = con.createStatement();
            ResultSet resultado = sentencia.executeQuery(query);

            while (resultado.next()) {
                this.id_usuario=resultado.getInt("id_usuario");
                this.clave_usuario = resultado.getString("clave_usuario");
                this.pin_usuario = resultado.getInt("pin_usuario");

            }
            /*
            while(resultado.next()){
            choice1.add(resultado.getString("nombre_usuario"));
            }
             */

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch(CommunicationsException e){
            showMessageDialog(null, "Error: COM ");
            this.DB_PATH = "jdbc:mysql://localhost/sic_final";
            this.DB_USER="root";
            this.DB_PASS="";
            connectionIntents++;
            if(connectionIntents<=3)
                run();
            else{
                showMessageDialog(null, "Error: el sistema no esta disponible en este momento, por favor intente mas tarde.\n\n Error code: 01SQLCOM ");
                System.exit(0);
            }
            
                
            
        }catch(SQLException e){
            e.printStackTrace();
            showMessageDialog(null, "Error SQL.");
        }
    }
    
    
    
}
