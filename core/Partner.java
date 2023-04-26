package core;

import java.util.regex.Pattern;
import java.util.HashMap;

public abstract class Partner {
  private int code;
  private String name;
  private String telephoneNumber;
  private String email;

  public HashMap<String, Pattern> patternMap;

  public Partner(){
    this.patternMap = GlobalData.getPatternMap();
  }

  public Partner( int code, String name, String telephoneNumber, String email ){
    this();

    this.setCode(code);
    this.setName(name);
    this.setTelephoneNumber(telephoneNumber);
    this.setEmail(email);

  }

  public int getCode(){
    return this.code;
  }

  public boolean setCode(int code){
    if ( code >= 1 && code <= 1000){
      this.code = code; 
      return true;
    } else{
      return false;
    }

  }
  
  public String getName(){
    return this.name;
  }
  
  public boolean setName(String newName){
    if (this.patternMap.get("name").matcher(newName).matches()){
      this.name = newName;
      return true;
    } else {
      return false;
    }
  }

  public String getTelephoneNumber(){
    return this.telephoneNumber;
  }
  
  public boolean setTelephoneNumber(String newTelephoneNumber){
    if (this.patternMap.get("telephone").matcher(newTelephoneNumber).matches()){
      this.telephoneNumber = newTelephoneNumber;
      return true;
    } else {
      return false;
    }

  }

  public String getEmail(){
    return this.email;
  }

  public boolean setEmail(String newEmail){
    if (this.patternMap.get("email").matcher(newEmail).matches()){
      this.email = newEmail;
      return true;
    } else {
      return false;
    }
  }

  public String toString(){
    return String.format("" +
        "Código: %04d\n" + 
        "Nome: %s\n" + 
        "Telefone: %s\n" +
        "E-mail: %s\n" +
        "",
        this.getCode(),
        this.getName(),
        this.getTelephoneNumber(),
        this.getEmail()
        );

  }
  
}
