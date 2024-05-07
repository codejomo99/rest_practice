import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JUnitCircleTest {

  @BeforeAll
  static void beforeAll(){
    System.out.println("beforeAll 실행");
  }

  @BeforeEach
  public void beforeEach(){
    System.out.println("beforeEach 실행");
  }

  @Test
  public void test1(){
    System.out.println("test1 시작");
  }

  @Test
  public void test2(){
    System.out.println("test2 시작");
  }

  @AfterAll
  static void afterAll(){
    System.out.println("afterAll 실행");
  }

  @AfterEach
  public void afterEach(){
    System.out.println("afterEach 실행");
  }

}
