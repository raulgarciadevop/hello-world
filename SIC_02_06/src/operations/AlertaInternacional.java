package operations;


import static javax.swing.JOptionPane.showInputDialog;

public class AlertaInternacional {

  private String titulo;

  private Integer tipo;

  private String descripcion;
  
  public void createNew(){
      try{
          titulo=showInputDialog("Ingrese el titulo:");
          tipo=Integer.parseInt(showInputDialog("Ingrese el tipo:"));
          descripcion=showInputDialog("Ingrese la descripcion:");
          
      }catch(NumberFormatException e){
          tipo=Integer.parseInt(showInputDialog("Error: ingrese solo valores enteros aqui.\n\nIngrese el tipo:"));
          descripcion=showInputDialog("Ingrese la descripcion:");
      }
      
      
  }

    @Override
    public String toString() {
        return "Titulo: "+titulo+"\nTipo: "+tipo+"\nDescripcion: "+descripcion+"\n\n";
    }
  
  

}