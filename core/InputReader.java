package core;

import java.util.Scanner;

import java.util.function.*;

public class InputReader {

  Scanner scanner;

  public InputReader( Scanner scanner ){
    this.scanner = scanner;
  }

  public int readForNumberedMenu( String menu, String onNumberFormatExceptionMessage, int floor, int ceil  ){
    System.out.printf("%s", menu);

    String userInput;
    int choosenOption;

    while(true){
      System.out.printf("-> ");
      userInput = scanner.nextLine();
      try {
        choosenOption = Integer.parseInt(userInput);
        if (choosenOption >= floor && choosenOption <= ceil){
          break;
        } else {
          throw new NumberFormatException();
        }
      } catch (NumberFormatException nfe){
        System.out.printf("%s\n", onNumberFormatExceptionMessage);
      } catch(Exception e){
        e.printStackTrace();
      }
    }

    return choosenOption;
  }


  public boolean readForStringSetterExpectBoolean( boolean expectedValue, Predicate<String> targetSetter, String message, String fallbackMessage){
    System.out.printf("%s\n", message);
    String userInput;

    while (true){
      System.out.printf("%s", "-> ");
      userInput = scanner.nextLine();
      boolean result = targetSetter.test(userInput);

      if(result == expectedValue){
        return true;
      } else {
        System.out.printf("%s\n", fallbackMessage);
      }
    }

  }


  public boolean readForIntSetterExpectBoolean( boolean expectedValue, Predicate<Integer> targetSetter, String message, String fallbackMessage){
    System.out.printf("%s\n", message);
    String userInput;


    while (true){
      int parsedInt = 0;

      System.out.printf("%s", "-> ");
      userInput = scanner.nextLine();

      try {
        parsedInt = Integer.parseInt(userInput);
        boolean result = targetSetter.test(parsedInt);

        if(result == expectedValue){
          return true;     
        } else {
          throw new NumberFormatException();
        }

      } catch( NumberFormatException nfe ){
        System.out.printf("%s\n", fallbackMessage);
      }
    }

  }

}

