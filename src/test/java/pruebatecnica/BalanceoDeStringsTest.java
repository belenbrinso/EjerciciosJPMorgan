package pruebatecnica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BalanceoDeStringsTest {
  private List<String> expresiones;
  private List<Integer> reemplazosMaximos;

  @Test
  void test1() {
    List<Character> listaEsperada = Arrays.asList('>', '>');
    Assertions.assertEquals(listaEsperada, BalanceoDeStrings.caracteresSinBalancear("<>>>"));
  }

  @Test
  void test2() {
    Assertions.assertEquals(new ArrayList<>(), BalanceoDeStrings.caracteresSinBalancear("<<<>>>"));
  }

  @Test
  void test3() {
    expresiones = Arrays.asList("<>>>", "<>>>>");
    reemplazosMaximos = Arrays.asList(2, 2);
    List<Integer> listaEsperada = Arrays.asList(1, 0);
    Assertions.assertEquals(listaEsperada, BalanceoDeStrings.balancedOrNot(expresiones, reemplazosMaximos));
  }

  @Test
  void test4() {
    expresiones = Arrays.asList("><><", "<<<<", "<><><>");
    reemplazosMaximos = Arrays.asList(10, 10, 10);
    List<Integer> listaEsperada = Arrays.asList(0, 0, 1);
    Assertions.assertEquals(listaEsperada, BalanceoDeStrings.balancedOrNot(expresiones, reemplazosMaximos));
  }

  @Test
  void test5A() {
    Assertions.assertEquals(6, BalanceoDeStrings.cantidadCaracteresCierre(">><<><<<<>>>>>"));
  }

  @Test
  void test5B() {
    List<Character> listaEsperada = Arrays.asList('<', '<');
    Assertions.assertEquals(listaEsperada, BalanceoDeStrings.caracteresSinBalancear("<<<<><<<<>>>>>"));
  }

  @Test
  void test5C() {
    expresiones = Arrays.asList("<<<><<<<", ">>><>>>>", ">><<><<<<>>>>>", "<<<<><<<<>>>>>", ">>><<<<>>>>>><<<<");
    reemplazosMaximos = Arrays.asList(10, 5, 2, 10, 4);
    List<Integer> listaEsperada = Arrays.asList(0, 0, 1, 0, 0);
    Assertions.assertEquals(listaEsperada, BalanceoDeStrings.balancedOrNot(expresiones, reemplazosMaximos));
  }

  @Test
  void test6() {
    expresiones = Arrays.asList("<<<<><>><<<<>>>>>", ">>><<><<<>>>>>", "<<<<<<<><><>><<<<<<>>>>>>>",
        ">>><><<<<<<<>>>>>><<<<><<<<<>>>>>>>>>", "><<<><>><<<<>>>>>");
    reemplazosMaximos = Arrays.asList(10, 5, 2, 3, 1);
    List<Integer> listaEsperada = Arrays.asList(0, 1, 0, 1, 1);
    Assertions.assertEquals(listaEsperada, BalanceoDeStrings.balancedOrNot(expresiones, reemplazosMaximos));
  }
}
