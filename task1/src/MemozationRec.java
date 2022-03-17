import java.util.HashMap;
import java.util.Map;

public class MemozationRec implements Fibonacci{

    private final Map<Integer, Integer> map = new HashMap<>();

    {
        map.put(0, 0);
        map.put(1, 1);
    }

    public MemozationRec() {
    }

    @Override
    public int calculate(final int n) {

        if(map.containsKey(n)){
            return map.get(n);
        }

        var fibForN = calculate(n-1) + calculate(n-2);
        map.put(n, fibForN);

        return fibForN;
    }
}
