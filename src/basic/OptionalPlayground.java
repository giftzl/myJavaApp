package basic;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalPlayground{

    public static void main(String[] args){

        testOptional();
        testOptionalMap();
    }

    public static void testOptional(){

        // creating a string array
        String[] str = new String[5];

        // Setting value for 2nd index
        str[2] = "Optional are coming soon";

        // It returns a non-empty Optional
        Optional<String> value = Optional.of(str[2]);

        // It returns value of an Optional.
        // If value is not present, it throws
        // an NoSuchElementException
        System.out.println(value.get());

        // It returns hashCode of the value
        System.out.println(value.hashCode());

        // It returns true if value is present,
        // otherwise false
        System.out.println(value.isPresent());

    }

    public static void testOptionalMap(){
        List<String> companyNames = Arrays.asList(
                "paypal", "oracle", "", "microsoft", "", "apple");
        Optional<List<String>> listOptional = Optional.of(companyNames);

        int size = listOptional
                .map(List::size)
                .orElse(0);



    }
}
