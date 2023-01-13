import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestPrimeAlgorithms {
    public static void main(String[] args) {
        int x = 14999981;
        long t;

        PrimesOne primesOne = new PrimesOne(x);
        PrimesTwo primesTwo = new PrimesTwo(x);

        t = System.currentTimeMillis();
        System.out.println(primesOne.isPrime());
        System.out.printf("PrimesOne.isPrime() executed in: %d ms\n\n", System.currentTimeMillis() - t);

        t = System.currentTimeMillis();
        System.out.println(primesTwo.isPrime());
        System.out.printf("PrimesTwo.isPrime() executed in: %d ms\n\n", System.currentTimeMillis() - t);
    }
}

class PrimesOne {
    private LinkedList<Integer> primes;
    private int n;

    public PrimesOne(int n) {
        this.n = n;
    }

    private void initPrimes() {
        primes = new LinkedList<>();

        for(int i = 2; i <= n; i++) {
            validate(i, (int)Math.sqrt(i));
        }
    }

    private void validate(int n, int sqrt) {
        for(Integer prime : primes) {
            if(prime > sqrt) {
                break;
            } else if(n % prime == 0) {
                return;
            }
        }

        primes.add(n);
    }

    public boolean isPrime() {
        initPrimes();
        return primes.getLast() == n;
    }
}

class PrimesTwo {
    private int n;
    public PrimesTwo(int n) {
        this.n = n;
    }

    public boolean isPrime() {
        int sqrt = (int)Math.sqrt(n);

        //for(int i = 2; i <= sqrt; i++) {
        for(int i = sqrt; i > 1; i--) {
            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
