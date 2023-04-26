package core;

public class Supplier extends Partner{
  private String corporateName;
  private String IE; // inscrição estadual
  private String CNPJ;

  public Supplier(){

  }

  public Supplier( int code, String name, String telephoneNumber, String email, String corporateName, String IE, String CNPJ ){
    super(code, name, telephoneNumber, email);
    this.setCNPJ(CNPJ);
    this.setIE(IE);
    this.setCorporateName(corporateName);
  }

  public String getCorporateName(){
    return this.corporateName;
  }

  public boolean setCorporateName(String newCorporateName){
    if (this.patternMap.get("corporateName").matcher( newCorporateName ).matches()){
      this.corporateName = newCorporateName;
      return true;
    } else {
      return false;
    }

  }

  public String getIE(){
    return this.IE;
  }

  public boolean setIE( String newIE ){
    if (this.patternMap.get("ie").matcher( newIE ).matches()){
      this.IE = newIE;
      return true;
    } else {
      return false;
    }

  } 

  public String getCNPJ(){
    return this.CNPJ;
  }

  public boolean setCNPJ(String newCNPJ){
    if (this.patternMap.get("cnpj").matcher( newCNPJ ).matches()){
      this.CNPJ = newCNPJ;
      return true;
    } else {
      return false;
    }

  }

  public String toString(){
    return String.format("%s" +
        "Razão social: %s\n" +
        "Inscrição Estadual: %s\n" +
        "CNPJ: %s\n",
        super.toString(),
        this.getCorporateName(),
        this.getIE(),
        this.getCNPJ()
        );
  }


}
