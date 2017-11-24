package personas;

public class Persona {

  private String nombre;

  private Integer edad;

  private String sexo;

  private Integer estadoLegal;
  
  public Persona(){
      
  }

    public Persona(String nombre, Integer edad, String sexo, Integer estadoLegal) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.estadoLegal = estadoLegal;
    }
  
  

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getEstadoLegal() {
        return estadoLegal;
    }

    public void setEstadoLegal(Integer estadoLegal) {
        this.estadoLegal = estadoLegal;
    }
  
  

}