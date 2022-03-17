public class RecursiveImpl implements Fibonacci {

    public RecursiveImpl() {

    }


    @Override
    public int calculate(final int number) {
        if(number == 0)
            return 0;
        else if(number == 1)
            return 1;
        else
            return calculate(number - 1) + calculate(number - 2);
    }
}
