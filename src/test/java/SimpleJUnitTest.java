import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleJUnitTest {

    int result;

    @BeforeAll
    static void BeforeAll() {
        System.out.println("### BeforeAll()\n");

    }

    @BeforeEach
    void BeforeEach() {
       result = getResult();
        System.out.println("###     BeforeEach()");
    }

    @AfterEach
    void AfterEach() {
        result = 0;
        System.out.println("###     AfterEach()");
    }

    @AfterAll
    static void AfterAll() {
        System.out.println("### AfterAll()\n");


    @Test
    void firstTest() {
        System.out.println("###     firstTest()");
    Assertions.assertTrue(result>2);
    }

    @Test
    void secondTest() {
        System.out.println("###     secondTest()");
        Assertions.assertTrue(result>2);
    }

    @Test
    void thirdTest() {
        System.out.println("###     thirdTest");
        Assertions.assertTrue(result>2);
    }


    private int getResult() {

        return 3;
    }

}
