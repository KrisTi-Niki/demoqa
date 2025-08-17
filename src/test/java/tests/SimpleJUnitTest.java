package tests;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleJUnitTest {

    static int result;

    @BeforeAll
    static void BeforeAll() {
        System.out.println("### BeforeAll()\n");

    }

    @BeforeEach
    void BeforeEach() {
       result = getResult();
        System.out.println("###     BeforeEach()");
    }

    private int getResult() {
        return 0;
    }

    @AfterEach
    void AfterEach() {
        result = 0;
        System.out.println("###     AfterEach()");
    }

    @AfterAll
    static void AfterAll() {

    }
}
