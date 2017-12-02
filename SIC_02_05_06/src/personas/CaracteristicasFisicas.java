package personas;

public class CaracteristicasFisicas {

  private String rostro;

  private String piel;

  private String altura;

  private String peso;
  
  public CaracteristicasFisicas(){
      
  }

    public CaracteristicasFisicas(String rostro, String piel, String altura, String peso) {
        this.rostro = rostro;
        this.piel = piel;
        this.altura = altura;
        this.peso = peso;
    }
  
  

    public String getRostro() {
        return rostro;
    }

    public void setRostro(String rostro) {
        this.rostro = rostro;
    }

    public String getPiel() {
        return piel;
    }

    public void setPiel(String piel) {
        this.piel = piel;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }
  
  

}