import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JUnitTest {
  @DisplayName("1+2는 3이다")
  @Test
  public void junitTest(){
    int a = 1;
    int b = 2;
    int sum = 3;

    Assertions.assertEquals(a+b,sum); // 1번째 인자는 비교하는 값, 2번째 인자는 원하는 값
  }

  @DisplayName("1+2는 4이다. fail test ")
  @Test
  public void junitFailTest(){
    int a = 1;
    int b = 2;
    int failSum = 4;

    Assertions.assertNotEquals(a + b, failSum); // 틀린 값

  }

}
