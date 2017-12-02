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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;
import main.MainFrame;

/**
 *
 * @author Administrator
 */
public class downloadAlertas implements Runnable {
    
    private String DB_PATH;
    private String DB_USER;
    private String DB_PASS;
    //private String nombre_usuario;
    //private String clave_usuario;
    //private int id_usuario;
    //private int pin_usuario;
    private int connectionIntents;
    private Connection con;
    private Statement sentencia;
    private ResultSet resultado;
    private final MainFrame mf;
    private HashMap<Integer,AlertaInternacional> hmap;
    private boolean vis;
    
    public void setVis(boolean vis){
        this.vis=vis;
    }

    public downloadAlertas(MainFrame m) {
        this.DB_PATH = "jdbc:mysql://den1.mysql6.gear.host/sicpublic";
        this.DB_USER="sicpublic";
        this.DB_PASS="Zk4F!3OF4H9~";
        mf=m;
        hmap=new HashMap<>();
    }
    
    public void getData(){
        try {
            String query = "SELECT * FROM alertas_cmc";

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(DB_PATH, DB_USER, DB_PASS);
            sentencia = con.createStatement();
            resultado = sentencia.executeQuery(query);

            while (resultado.next()) {
                hmap.put(resultado.getInt("id_alerta"), new AlertaInternacional(resultado.getString("titulo_alerta"),resultado.getInt("importancia_alerta"),resultado.getString("descripcion_alerta"),resultado.getString("ubicacion_alerta")));
                //mf.alertas.add(new AlertaInternacional(resultado.getString("titulo_alerta"),resultado.getInt("importancia_alerta"),resultado.getString("descripcion_alerta"),resultado.getString("ubicacion_alerta")));

            }
            Set set=hmap.entrySet();
            Iterator iterator=set.iterator();
            
            //AlertaInternacional[] aii = new AlertaInternacional[hmap.size()] ;
            //int i=0;
            //String ss="";
            
            ArrayList<AlertaInternacional> lert=new ArrayList<>();
            
            while(iterator.hasNext()){
                Map.Entry mentry=(Map.Entry)iterator.next();
                //mf.addAlertaToArray((AlertaInternacional) mentry.getValue());
                //mf.addAlerta((AlertaInternacional) mentry.getValue());
                
                //aii[i]=(AlertaInternacional) mentry.getValue();
                lert.add((AlertaInternacional)mentry.getValue());
                
                //ss=ss+"\n"+mentry.getValue().toString();
                //i++;
            }
            
            mf.addAlerta(lert);
            
            
            
            /*
            for(AlertaInternacional str:mf.alertas){
                ss=ss+"\n"+str.toString();
            }*/
            //mf.setTxtArea(ss);
            /*
            while(resultado.next()){
            choice1.add(resultado.getString("nombre_usuario"));
            }
             */

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch(CommunicationsException e){
            //showMessageDialog(null, "No se ha podido localizar el servidor, desde ahora estara trabajando de forma local");
            this.DB_PATH = "jdbc:mysql://localhost/sic_final";
            this.DB_USER="root";
            this.DB_PASS="";
            connectionIntents++;
            if(connectionIntents>=1 && connectionIntents<=3)
                run();
            else{
                showMessageDialog(null, "Error: el sistema no esta disponible en este momento, por favor intente mas tarde.\n\n Error code: 02DBCOM ");
                System.exit(0);
            }
            
                
            
        }catch(SQLException e){
            e.printStackTrace();
            showMessageDialog(null, "Por favor visite la siguiente pagina:\n\nhttps://github.com/raulgarciadevop/sic-public/wiki/Codigos-de-error\n\nError code: 02-1DBF");
        }
    }
    
    

    @Override
    public void run() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        while(vis){
            getData();
        }
    }
    
}
