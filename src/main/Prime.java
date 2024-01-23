import java.util.ArrayList;
import java.util.List;


/**
 * This program counts the sum and the number of prime (int) numbers in interval 0-1000
 */
public class Prime {

    private List<Integer> generatedPrimes;
    private List<Integer> requestedPrimes;
    private int count = 0;
    private int sumOfPrimes = 0;
    private int firstNumber;
    private int lastNumber;

    /***
     * Generates a list of primes and gets the primes between the specified numbers.
     *
     * @param firstNumber has to be greater than zero and lower than lastNumber
     * @param lastNumber has to be lower than 1000 and higher than firstNumber
     */
    public Prime(int firstNumber, int lastNumber) {
        if (firstNumber < 0) {
            System.out.print("Hoppsan, fel intervall angivet!");
            return;
        }
        if (lastNumber > 1000) {
            System.out.print("Hoppsan, fel intervall angivet!");
            return;
        }
        if (firstNumber > lastNumber) {
            System.out.print("Hoppsan, fel intervall angivet!");
            return;
        }
        generatedPrimes = new ArrayList<>();
        this.firstNumber = firstNumber;
        this.lastNumber = lastNumber;
        generatePrimes(2, lastNumber);
        getRequestedPrimes();
    }

    /***
     * Checks if the number is divisible by our already found primes. No need to recalculate everything.
     * @param currentNumber - the number to check if prime
     * @return Returns true if the currentNumber is divisible
     */
    private boolean divisibleByFoundPrime(int currentNumber) {
        boolean divisible = false;
        for (Integer integer : generatedPrimes) {
            if (currentNumber % integer == 0) {
                divisible = true;
                break;
            }
        }
        return divisible;
    }


    /**
     * Inits the first prime if the primeList is empty and if first number is higher than 1,
     * that way we return 0 if the range is below 2
     * */
    private boolean numIsPrime(int current) {
        if (generatedPrimes.isEmpty() && current >1 ) {
            generatedPrimes.add(2);
        }
        return !divisibleByFoundPrime(current);
    }

    private void generatePrimes(int current, int stop) {
        if (current > stop) {
            return;
        } else if (numIsPrime(current)) {
            generatedPrimes.add(current);
            generatePrimes(++current, stop);
        } else {
            generatePrimes(++current, stop);
        }
    }

    public List<Integer> getPrimes(){
        if(requestedPrimes.isEmpty()){
            requestedPrimes = getRequestedPrimes();
        }
        return requestedPrimes;
    }

    private List<Integer> getRequestedPrimes() {
        requestedPrimes = new ArrayList<>();
        for (Integer integer : generatedPrimes) {
            if (integer > firstNumber) {
                count++;
                sumOfPrimes += integer;
                requestedPrimes.add(integer);
            }
        }
        return requestedPrimes;
    }

    public void printCount(){
        System.out.print("Hej, det finns " + count + " primtal mellan " + firstNumber + " och " + lastNumber );
    }
    public void printSum(){
        System.out.print("Och den totala summan av dessa primtal är " + sumOfPrimes);
    }
}
