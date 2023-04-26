package core;

import java.util.HashMap;
import java.util.regex.Pattern;

public class GlobalData{


  public static final HashMap<String, String> REGEX_MAP = new HashMap<String, String>(){{
    put("name", "^\\w{2,}\\s\\w{2,}.*"); // nome
    put("telephone", "^((\\(\\d{2}\\))|(\\d{2}))\\d{4}-?\\d{4}$"); // telefone fixo
    put("email", "^[\\w\\._-]{2,}@\\w+\\.\\w+$");

    put("cellphone", "^((\\(\\d{2}\\);)|(\\d{2}))\\d{5}-?\\d{4}$"); // telefone celular
    put("rg", "^\\w{8,11}$");
    put("cpf", "^\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2}$");

    put("corporateName", "^\\w{2,}\\s\\w{2,}.*"); // razão social
    put("ie", "^[\\w-\\.]{1,15}$");
    put("cnpj", "^\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}-\\d{2}$");
  }};

  public static HashMap<String, Pattern> getPatternMap(){
    HashMap<String, Pattern> patternMap = new HashMap<>();

    for ( HashMap.Entry<String, String> entry : GlobalData.REGEX_MAP.entrySet() ){
      String key = entry.getKey();
      String value = entry.getValue();
      Pattern p = Pattern.compile(value);
      patternMap.put(key, p);
    }

    return patternMap;
  }
  
}


