package main;
import java.util.ArrayList;
import java.util.List;


/**
* This program counts the sum and the number of prime (int) numbers in interval 0-1000
*/
public class Prime {

    private List<Integer> primes;
    private int count = 0;
    private int sumOfPrimes = 0;

    public Prime(int firstNumber, int lastNumber) {
        primes = new ArrayList<>();
        calculatePrimes(firstNumber, lastNumber);
    }

    private boolean numIsPrime(int current, int depth) {
        if (depth == 0) {
            return true;
        }

        int divisibleBy = primes.get(depth);
        if (current % divisibleBy == 0) {
            return false;
        }

        return numIsPrime(current, ++depth);
    }

    private void calculatePrimes(int current, int stop) {
        if (current > stop) {
            primes.add(count);
            primes.add(sumOfPrimes);
        } else if (numIsPrime(current, 0)) {
            primes.add(current);
            ++count;
            sumOfPrimes += current;
            calculatePrimes(++current, stop);
        } else {
            calculatePrimes(++current, stop);
        }
    }

    public List<Integer> getPrimes() {
        return primes;
    }
