package personas;

public class CaracteristicasBiologicas {

  private String tipoSangre;

  private String enfermedades;
  
  public CaracteristicasBiologicas(){
      
  }

    public CaracteristicasBiologicas(String tipoSangre, String enfermedades) {
        this.tipoSangre = tipoSangre;
        this.enfermedades = enfermedades;
    }
  
  

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }
  
  

}