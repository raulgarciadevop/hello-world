package operations;


import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class AlertaInternacional {
    
    private Connection con;
    private Statement sentencia;
    private String query;
    private String DB_PATH,DB_USER,DB_PASS;
    private int connectionIntents;

    private int id;
    private String titulo;
    private int importancia;
    private String descripcion;
    private String ubicacion;//Socio

    public AlertaInternacional(String titulo, int importancia, String descripcion, String ubicacion) {
        
        this.titulo = titulo;
        this.importancia = importancia;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        
        this.connectionIntents = 0;
        this.DB_PATH = "jdbc:mysql://mysql6.gear.host/sicfinal";
        this.DB_USER="sicfinal";
        this.DB_PASS="Gd5I-LJ-3Z2K";
    }
    
    public AlertaInternacional(){
        
    }
  
  public void createNew(){
      try{
          titulo=showInputDialog("Ingrese el titulo:");
          importancia=Integer.parseInt(showInputDialog("Ingrese el tipo:"));
          descripcion=showInputDialog("Ingrese la descripcion:");
          
      }catch(NumberFormatException e){
          importancia=Integer.parseInt(showInputDialog("Error: ingrese solo valores enteros aqui.\n\nIngrese el tipo:"));
          descripcion=showInputDialog("Ingrese la descripcion:");
      }
      
      
  }
  
  public void insertarEnDB(){
      try {
            query = "INSERT INTO alertas_cmc VALUES (0, '"+titulo+"', "+importancia+", '"+descripcion+"', '"+ubicacion+"')";

            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(DB_PATH, DB_USER,DB_PASS);
            sentencia = con.createStatement();
            
            sentencia.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "La siguiente alerta ha sido creada y enviada satisfactoriamente:\n\nTitulo: "+titulo+"\nPrioridad: "+importancia+"\nDescripcion: "+descripcion+"\nUbicacion: "+ubicacion);
            

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch(CommunicationsException e){
            this.DB_PATH = "jdbc:mysql://localhost/sic_final";
            this.DB_USER="root";
            this.DB_PASS="";
            connectionIntents++;
            if(connectionIntents>=1 && connectionIntents<=3)
                //getDataFromDB(nombre_usuario,clave_usuario);
                insertarEnDB();
            else{
                showMessageDialog(null, "Error: el sistema no esta disponible en este momento, por favor intente mas tarde.\n\n Error code: 01SQLCOM ");
                System.exit(0);
            }
            
                
            
        }catch(SQLException e){
            e.printStackTrace();
            showMessageDialog(null, "Error SQL.");
        }
  }

    @Override
    public String toString() {
        return "Titulo: "+titulo+"\nTipo: "+importancia+"\nDescripcion: "+descripcion+"\n\n";
    }
    
    public void downloadData(){
        
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getDB_PATH() {
        return DB_PATH;
    }

    public void setDB_PATH(String DB_PATH) {
        this.DB_PATH = DB_PATH;
    }

    public String getDB_USER() {
        return DB_USER;
    }

    public void setDB_USER(String DB_USER) {
        this.DB_USER = DB_USER;
    }

    public String getDB_PASS() {
        return DB_PASS;
    }

    public void setDB_PASS(String DB_PASS) {
        this.DB_PASS = DB_PASS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getImportancia() {
        return importancia;
    }

    public void setImportancia(int importancia) {
        this.importancia = importancia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    
    
    
  
  

}