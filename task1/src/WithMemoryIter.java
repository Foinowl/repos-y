public class WithMemoryIter implements Fibonacci{

    public WithMemoryIter() {
    }

    @Override
    public int calculate(final int number) {
        int[] array = new int[number];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i < array.length; ++i) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[number - 1];
    }
}
