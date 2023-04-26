package core;

public class Client extends Partner {
  private String cellphoneNumber; //telefone celular
  private String RG;
  private String CPF;

  public Client(){

  }

  public Client( int code, String name, String telephoneNumber, String email, String cellphoneNumber, String RG, String CPF ){
    super(code, name, telephoneNumber, email);
    this.setCellphoneNumber(cellphoneNumber);
    this.setRG(RG);
    this.setCPF(CPF);
  }

  public String getCellphoneNumber(){
    return this.cellphoneNumber;
  }

  public boolean setCellphoneNumber( String newCellphoneNumber ){
    if (this.patternMap.get("ie").matcher( newCellphoneNumber ).matches()){
      this.cellphoneNumber = newCellphoneNumber;
      return true;
    } else {
      return false;
    }
  }

  public boolean setRG( String newRG ){
    if (this.patternMap.get("rg").matcher( newRG ).matches()){
      this.RG = newRG;
      return true;
    } else {
      return false;
    }
  }

  public String getRG(){
    return this.RG;
  }

  public boolean setCPF( String newCPF ){
    if (this.patternMap.get("cpf").matcher( newCPF ).matches()){
      this.CPF = newCPF;
      return true;
    } else {
      return false;
    }

  }

  public String getCPF(){
    return this.CPF;
  }

  public String toString(){
    return String.format("%s" +
        "Celular: %s\n" +
        "RG: %s\n" +
        "CPF: %s\n",
        super.toString(),
        this.getCellphoneNumber(),
        this.getRG(),
        this.getCPF()
        );
  }


}
