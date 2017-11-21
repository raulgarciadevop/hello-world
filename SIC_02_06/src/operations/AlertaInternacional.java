package operations;


import static javax.swing.JOptionPane.showInputDialog;

public class AlertaInternacional {

    private int id;
    private String titulo;
    private int importancia;
    private String descripcion;
    private String ubicacion;//Socio

    public AlertaInternacional(int id, String titulo, int importancia, String descripcion, String ubicacion) {
        this.id = id;
        this.titulo = titulo;
        this.importancia = importancia;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
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

    @Override
    public String toString() {
        return "Titulo: "+titulo+"\nTipo: "+importancia+"\nDescripcion: "+descripcion+"\n\n";
    }
  
  

}