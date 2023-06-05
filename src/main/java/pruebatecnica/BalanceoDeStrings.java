package pruebatecnica;

import java.util.ArrayList;
import java.util.List;

public class BalanceoDeStrings {

  public static List<Integer> balancedOrNot(List<String> expressions, List<Integer> maxReplacements) {
    List<Integer> retorno = new ArrayList<>();
    for (int i = 0; i < expressions.size(); i++) {
      String exp = expressions.get(i);
      int maxRep = maxReplacements.get(i);

      int cantBal = balanceo(exp);
      if (cantBal == -1 || cantBal > maxRep)
        retorno.add(0);
      else
        retorno.add(1);
    }
    return retorno;
  }

  public static long cantidadCaracteresCierre(String exp){
    int position = 0;
    long cant = 0;
    while (position < exp.length()){
      if(exp.charAt(position) == '>' && exp.indexOf('<') < position)
        cant++;
      position++;
    }
    return cant;
  }

  public static List<Character> caracteresSinBalancear(String exp) {
    List<Character> newExp = new ArrayList<>();
    int position = 0;
    int par = 0;
    long cantClose = cantidadCaracteresCierre(exp);

    while (position < exp.length()) {
      if (exp.charAt(position) == '<' && cantClose != 0) {
        par++;
        cantClose--;
      } else if (exp.charAt(position) == '>' && par > 0)
        par--;
      else
        newExp.add(exp.charAt(position));
      position++;
    }

    return newExp;
  }

  public static int balanceo(String exp) {
    List<Character> caracteres = caracteresSinBalancear(exp);
    int cantBal = 0;
    int position = 0;

    while(position < caracteres.size()){
      if(caracteres.get(position) == '>')
        cantBal++;
      else {
        cantBal = -1;
        break;
      }
      position++;
    }

    return cantBal;
  }

}
