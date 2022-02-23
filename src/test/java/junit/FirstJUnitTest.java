package junit;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

public class FirstJUnitTest {

    @BeforeAll

    static void beforeAll() {
        System.out.println("Этот метод выполняется перед всеми тестами!");

    }
    @BeforeEach
    void before() {
        System.out.println("    Этот метод выполняется перед каждым тестом!");

    }

    @AfterEach
    void after() {
        System.out.println("    Этот метод выполняется после каждого теста!");

    }

    @AfterAll
    static void afterAll() {
        System.out.println("Этот метод выполняется после всех тестов!");

    }

    @Test
    void textTest() {
        // поиск по тексту
        System.out.println("        Это первый тест");

    }

    @Test
    void videoTest() {
        // поиск по видео
        System.out.println("        Это второй тест");
    }
}
