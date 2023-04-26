import core.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

class RegisterPartner{
  ArrayList<Partner> partners = new ArrayList<>();

  Scanner sc;
  InputReader reader;
  HashMap<String, Pattern> patternMap;

  private String DEFAULT_FALLBACK_MSG = "Ooops, não entendi...";

  private String MAIN_MENU = "" +
    "1. Consultar paceiros adicionados\n" +
    "2. Adicionar funcionário\n" +
    "3. Adicionar cliente\n" +
    "4. Adicionar fornecedor\n" +
    "5. Limpar o console\n" +
    "6. Sair\n" +
    "";

  RegisterPartner(){
    this.sc = new Scanner(System.in);
    this.reader = new InputReader(sc);
    this.patternMap = new HashMap<>();

    for ( HashMap.Entry<String, String> entry : GlobalData.REGEX_MAP.entrySet() ){
      String key = entry.getKey();
      String value = entry.getValue();
      Pattern p = Pattern.compile(value);
      this.patternMap.put(key, p);
    }

  }


  public boolean addPartner( Partner newPartner ){
    if (this.partners.size() <= 50){
      this.partners.add(newPartner);
      return true;
    } else {
      return false;
    }
  }

  public void readPartner( Partner targetPartner ){

    reader.readForIntSetterExpectBoolean( 
        true, (value) -> targetPartner.setCode(value), "Digite o código do parceiro?",
        this.DEFAULT_FALLBACK_MSG + "\nInsira um número inteiro entre 1 e 1000."
        );

    reader.readForStringSetterExpectBoolean( 
        true, value -> targetPartner.setName(value), "Qual o nome do parceiro (fantasia ou civil)?",
        this.DEFAULT_FALLBACK_MSG + "\nO nome deve ser formado por pelo menos duas palavras com duas letras cada uma."
        );

    reader.readForStringSetterExpectBoolean( 
        true, value -> targetPartner.setTelephoneNumber(value), "Qual o seu telefone fixo?",
        this.DEFAULT_FALLBACK_MSG + "\ne.g. (99)9999-9999"
        );

    reader.readForStringSetterExpectBoolean(
        true, value -> targetPartner.setEmail(value), "E qual o seu e-mail?",
        this.DEFAULT_FALLBACK_MSG + "\nInsira um email válido."
        );
  }

  public void readFunctionary( Functionary targetFunctionary ){
    readPartner(targetFunctionary);

    reader.readForIntSetterExpectBoolean( 
        true, (value) -> targetFunctionary.cpts.setNumber(value), "Qual o número do CPTS?",
        this.DEFAULT_FALLBACK_MSG + "\nO CPTS deve ser um número inteiro entre 1 e 5000."
        );

  }

  public void readClient( Client targetClient ){
    readPartner(targetClient);

    reader.readForStringSetterExpectBoolean(
        true, (cpfValue) -> targetClient.setCPF(cpfValue), "Qual o seu número do CPF?",
        this.DEFAULT_FALLBACK_MSG + "\nInsira um CPF válido (e.g. 000.111.222-33)." 
        );

    reader.readForStringSetterExpectBoolean(
        true, (rgValue) -> targetClient.setRG(rgValue), "Qual o seu número do RG?",
        this.DEFAULT_FALLBACK_MSG + "\nO número do RG deve ser um texto composto por no mínimo 8 caracteres e no máximo 11 caracteres" 
        );

    reader.readForStringSetterExpectBoolean(
        true, (celValue) -> targetClient.setCellphoneNumber(celValue), "Qual o número de seu telefone celular?",
        this.DEFAULT_FALLBACK_MSG + "\nInsira um celular válido (e.g. (11)91234-5678 )." 
        );

  }

  public void readSupplier(Supplier targetSupplier){
    readPartner( targetSupplier );

    reader.readForStringSetterExpectBoolean(
        true, (cnValue) -> targetSupplier.setCorporateName(cnValue), "Qual a razão social do fornecedor?",
        this.DEFAULT_FALLBACK_MSG + "\nA razão social deve ser composta por pelo menos duas palavras com duas letras cada uma."
        );

    reader.readForStringSetterExpectBoolean(
        true, (ieValue) -> targetSupplier.setIE(ieValue), "Qual o número de inscrição estadual (IE) do fornecedor?",
        this.DEFAULT_FALLBACK_MSG + "\nO IE deve ser um texto contendo de 1 a 15 caracteres."
        );

    reader.readForStringSetterExpectBoolean(
        true, (cnpjValue) -> targetSupplier.setCNPJ(cnpjValue), "Qual o CNPJ do fornecedor?",
        this.DEFAULT_FALLBACK_MSG + "\nO CNPJ deve seguir o modelo '00.000.000/0000-00'"
        );


  }


  public void start(String[] args){

    Functionary f = new Functionary(1000, "John Doe", "1123456789", "john.doe@email.com", 0001, "XXXX");
    Client c = new Client(1000, "Janny Doe", "1023232323", "janny.doe@email.com", "10945454545", "504985796", "54145986814");
    Supplier s = new Supplier(10, "SUPPLIER SU", "5412345678", "enterprise@supplier.com", "SUPPLIER SA" , "1123456789", "00.000.000/0000-00");

    addPartner(f);
    addPartner(c);
    addPartner(s);

mainMenuLoop:


    while(true){
      int selectedOption = reader.readForNumberedMenu(
          this.MAIN_MENU, this.DEFAULT_FALLBACK_MSG, 1, 6 
          );

      switch (selectedOption){
        case 1:
          for( Partner p : this.partners ){
            System.out.printf("%s\n", p);
          }
          break;

        case 2:
          Functionary newFunctionary = new Functionary();
          readFunctionary(newFunctionary);

          addPartner(newFunctionary);
          break;

        case 3:
          Client newClient = new Client();
          readClient(newClient);

          addPartner(newClient);
          break;

        case 4:
          Supplier newSupplier = new Supplier();
          readSupplier(newSupplier);

          addPartner(newSupplier);
          break;

        case 5:
          System.out.print("\033[H\033[2J"); // ANSI sequence for clearing the screen
          System.out.flush();
          break;

        case 6:
          break mainMenuLoop;

      }

    }

  }

}

public class runner {
  public static void main(String[] args) {
    new RegisterPartner().start(args);
  }

}

