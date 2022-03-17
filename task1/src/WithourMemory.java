public class WithourMemory implements Fibonacci{
    public WithourMemory() {
    }

    @Override
    public int calculate(final int number) {
        int num0 = 0;
        int num1 = 1;
        int num2 = 0;
        
        for(int i = 2; i <= number; i++){
            num2 = num0 + num1;
            num0 = num1;
            num1 = num2;
        }
        return num2;
    }
}
