/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Administrator
 */
public class Usuario {
    private int id_usuario;
    private String nombre_usuario;
    private String clave_usuario;
    private int pin_usuario;
    
    private Connection con;
    private Statement sentencia;
    private String query;
    private final String DB_PATH,usr,pass;
    
    public Usuario(){
        this.DB_PATH = "jdbc:mysql://localhost/sicfinal";
        this.usr="root";
        this.pass="";
        
    }
    
    public Usuario(String username, String password) {
        this.DB_PATH = "jdbc:mysql://localhost/sicfinal";
        this.usr="root";
        this.pass="";
        try {
            query = "SELECT * FROM usuario WHERE nombre_usuario='" + username + "'";
            this.nombre_usuario = username;

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(DB_PATH, usr, pass);
            sentencia = con.createStatement();
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean authActualUP(String user, String pass){
        return user.equals(this.nombre_usuario) && pass.equals(this.clave_usuario);
    }
    
    public boolean authActualPin(String pin){
        return Integer.parseInt(pin)==this.pin_usuario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getClave_usuario() {
        return clave_usuario;
    }

    public void setClave_usuario(String clave_usuario) {
        this.clave_usuario = clave_usuario;
    }

    public int getPin_usuario() {
        return pin_usuario;
    }

    public void setPin_usuario(int pin_usuario) {
        this.pin_usuario = pin_usuario;
    }
    
    
    
}
