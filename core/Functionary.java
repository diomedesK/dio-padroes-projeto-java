package core;

public class Functionary extends Partner {

  public class CPTS{ 
    private int number;
    private String series;

    public int getNumber(){
      return this.number;
    }

    public boolean setNumber(int newNumber){
      if ( newNumber >= 1 && newNumber <= 5000 ){
        this.number = (newNumber);
        return true;
      } else {
        return false;
      }

    }

    public String getSeries(){
      return this.series;
    }

    public boolean setSeries(String newSeries){
      this.series = newSeries;
      return false;
    }
  }

  public CPTS cpts = new CPTS();

  public Functionary(){

  }

  public Functionary( int code, String name, String telephoneNumber, String email, int CPTSNumber, String CPTSSeries ){
    super(code, name, telephoneNumber, email);

    this.cpts.setNumber(CPTSNumber);
    this.cpts.setSeries(CPTSSeries);
  }

  public String toString(){
    return String.format("%s" +
        "Número do CPTS: %04d\n" +
        "Série do CPTS: %s\n",
        super.toString(),
        this.cpts.getNumber(),
        this.cpts.getSeries()
        );

  }
  
}
