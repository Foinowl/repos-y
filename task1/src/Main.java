public class Main {
    public static void main(String[] args) {
        Fibonacci fibonacciRec = new RecursiveImpl();
        System.out.println(fibonacciRec.calculate(6));

        Fibonacci fibonacciIterMemory = new WithMemoryIter();
        System.out.println(fibonacciIterMemory.calculate(6));

        Fibonacci fibonacciWithourMemory= new WithourMemory();
        System.out.println(fibonacciWithourMemory.calculate(6));

        Fibonacci memozationRec= new MemozationRec();
        System.out.println(memozationRec.calculate(6));
    }
}
