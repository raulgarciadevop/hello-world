package personas;

public class Criminal extends Persona {

  private CaracteristicasFisicas caracteristicasFisicas;

  private CaracteristicasBiologicas caracteristicasBiologicas;

  private AnalisisPsicologico perfilPsicologico;

  private RedCriminal afiliacionCriminal;

  private String codigoCriminal;
  
  
  public Criminal(){
      
  }

    public Criminal(String nombre, int edad, String sexo, int estadoLegal,CaracteristicasFisicas caracteristicasFisicas, CaracteristicasBiologicas caracteristicasBiologicas, AnalisisPsicologico perfilPsicologico, RedCriminal afiliacionCriminal, String codigoCriminal) {
        super(nombre, edad, sexo, estadoLegal);
        
        this.caracteristicasFisicas = caracteristicasFisicas;
        this.caracteristicasBiologicas = caracteristicasBiologicas;
        this.perfilPsicologico = perfilPsicologico;
        this.afiliacionCriminal = afiliacionCriminal;
        this.codigoCriminal = codigoCriminal;
    }
  
  

    public CaracteristicasFisicas getCaracteristicasFisicas() {
        return caracteristicasFisicas;
    }

    public void setCaracteristicasFisicas(CaracteristicasFisicas caracteristicasFisicas) {
        this.caracteristicasFisicas = caracteristicasFisicas;
    }

    public CaracteristicasBiologicas getCaracteristicasBiologicas() {
        return caracteristicasBiologicas;
    }

    public void setCaracteristicasBiologicas(CaracteristicasBiologicas caracteristicasBiologicas) {
        this.caracteristicasBiologicas = caracteristicasBiologicas;
    }

    public AnalisisPsicologico getPerfilPsicologico() {
        return perfilPsicologico;
    }

    public void setPerfilPsicologico(AnalisisPsicologico perfilPsicologico) {
        this.perfilPsicologico = perfilPsicologico;
    }

    public RedCriminal getAfiliacionCriminal() {
        return afiliacionCriminal;
    }

    public void setAfiliacionCriminal(RedCriminal afiliacionCriminal) {
        this.afiliacionCriminal = afiliacionCriminal;
    }

    public String getCodigoCriminal() {
        return codigoCriminal;
    }

    public void setCodigoCriminal(String codigoCriminal) {
        this.codigoCriminal = codigoCriminal;
    }
  
  
  

}