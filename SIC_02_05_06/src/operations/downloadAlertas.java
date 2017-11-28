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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
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
    private String nombre_usuario;
    private String clave_usuario;
    private int id_usuario;
    private int pin_usuario;
    private int connectionIntents;
    MainFrame mf;
    private HashMap<Integer,AlertaInternacional> hmap;

    public downloadAlertas(MainFrame m) {
        this.DB_PATH = "jdbc:mysql://mysql6.gear.host/sicfinal";
        this.DB_USER="sicfinal";
        this.DB_PASS="Gd5I-LJ-3Z2K";
        mf=m;
        hmap=new HashMap<>();
    }
    
    public void getData(){
        try {
            String query = "SELECT * FROM alertas_cmc";

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(DB_PATH, DB_USER, DB_PASS);
            Statement sentencia = con.createStatement();
            ResultSet resultado = sentencia.executeQuery(query);

            while (resultado.next()) {
                hmap.put(resultado.getInt("id_alerta"), new AlertaInternacional(resultado.getString("titulo_alerta"),resultado.getInt("importancia_alerta"),resultado.getString("descripcion_alerta"),resultado.getString("ubicacion_alerta")));
                //mf.alertas.add(new AlertaInternacional(resultado.getString("titulo_alerta"),resultado.getInt("importancia_alerta"),resultado.getString("descripcion_alerta"),resultado.getString("ubicacion_alerta")));

            }
            Set set=hmap.entrySet();
            Iterator iterator=set.iterator();
            
            String ss="";
            while(iterator.hasNext()){
                Map.Entry mentry=(Map.Entry)iterator.next();
                ss=ss+"\n"+mentry.getValue().toString();
            }
            /*
            for(AlertaInternacional str:mf.alertas){
                ss=ss+"\n"+str.toString();
            }*/
            mf.setTxtArea(ss);
            /*
            while(resultado.next()){
            choice1.add(resultado.getString("nombre_usuario"));
            }
             */

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch(CommunicationsException e){
            //showMessageDialog(null, "Error: COM ");
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
        getData();
    }
    
}
