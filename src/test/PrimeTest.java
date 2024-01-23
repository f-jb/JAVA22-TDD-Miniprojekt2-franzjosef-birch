import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PrimeTest {
    @SuppressWarnings("unused")
    @Nested
    class InputAndOutputTest {
        private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        private final PrintStream originalOut = System.out;
        private final String errorMessage = "Hoppsan, fel intervall angivet!";

        @BeforeEach
        void setupStreams() {
            System.setOut(new PrintStream(outContent));
        }

        @AfterEach
        void restoreStreams() {
            System.setOut(originalOut);
        }


        @DisplayName("Får ett felmeddelande om det första numret är negativt")
        @Test
        void primesNegativeNumber() {
            Prime prime = new Prime(-1, 100);
            assertEquals(errorMessage, outContent.toString());
        }

        @DisplayName("Får ett felmeddelande om det andra numret är högre än 1000")
        @Test
        void primesAbove1000SecondNumber() {
            Prime prime = new Prime(1, 10000);
            assertEquals(errorMessage, outContent.toString());
        }

        @DisplayName("Får ett felmeddelande om det första numret är högre än det andra")
        @Test
        void primesFirstNumberHigherThanSecond() {
            Prime prime = new Prime(1000, 1);
            assertEquals(errorMessage, outContent.toString());
        }
        @Test
        @DisplayName("Skriver ut 0 i count om det inte finns något primtal")
        void getCountPrints0IfNoPrimes(){
            int firstNumber = 20;
            int lastNumber = 21;
            int count = 0;
            String countMessage = "Hej, det finns " + count + " primtal mellan " + firstNumber + " och " + lastNumber;
            Prime prime = new Prime(firstNumber,lastNumber);
            prime.printCount();
            assertEquals(countMessage, outContent.toString());
        }
        @Test
        @DisplayName("Skriver ut 15 i count i intervallet 0-50")
        void getCountPrintsAnAmountOfPrimes(){
            int firstNumber = 0;
            int lastNumber = 50;
            int count = 15;
            String countMessage = "Hej, det finns " + count + " primtal mellan " + firstNumber + " och " + lastNumber;
            Prime prime = new Prime(firstNumber,lastNumber);
            prime.printCount();
            assertEquals(countMessage, outContent.toString());
        }

        @Test
        @DisplayName("Skriver ut 0 i sum i intervallet 0-1")
        void getSumPrints0IfNoPrimes(){
            int firstNumber = 0;
            int lastNumber = 1;
            int sumOfPrimes = 0;
            String sumMessage = "Och den totala summan av dessa primtal är " + sumOfPrimes;
            Prime prime = new Prime(firstNumber,lastNumber);
            prime.printSum();

            assertEquals(sumMessage, outContent.toString());
        }
        @Test
        @DisplayName("Skriver ut 328 i sum i intervallet 0-50")
        void getSumPrintsQUESTIONinInterval(){
            int firstNumber = 0;
            int lastNumber = 50;
            int sumOfPrimes = 328;
            String sumMessage = "Och den totala summan av dessa primtal är " + sumOfPrimes;
            Prime prime = new Prime(firstNumber,lastNumber);
            prime.printSum();

            assertEquals(sumMessage, outContent.toString());
        }

    }
    @Nested
    class DataTypeTest{
        @Test
        @DisplayName("Return an empty list if there are no primes")
        void getPrimesReturnsAnEmptyArrayIfNoPrimes(){
            Prime prime = new Prime(0,1);
            List<Integer> emptyList = new ArrayList<>();
            assertEquals(emptyList,prime.getPrimes());
        }
        @Test
        @DisplayName("Return a list with primes")
        void getPrimesReturnsAndListWithPrimes(){
            Prime prime = new Prime(0,50);
            List<Integer> emptyList = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47);
            assertEquals(emptyList,prime.getPrimes());
        }
    }

}