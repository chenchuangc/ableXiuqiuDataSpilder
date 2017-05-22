package chen;

import java.util.function.Function;

/**
 * Created by chen on 2017/5/22.
 */
public class Ftest {
    public static void main(String[] args) {
        Function<String, Integer> toInteger = Integer::valueOf;
        System.out.println(toInteger.apply("456")+1);

        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        System.out.println(backToString.apply("123"));
    }
}
