package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpress {

    private final static Pattern pattern_baseDomain = Pattern.compile("(http://|https://)*([^/]+).*");

    public static void main(String[] args){

        String[] urls= {"https://wps-service.visa.com/v1/payments",
                        "http://wps-service/v1/refunds.com",
                        "http://wps-service&com"};

        for (String url: urls) {
            System.out.println("output:"+getBaseDomainName(url));
        }

    }

    public static String getBaseDomainName(String url) {
        Matcher m = pattern_baseDomain.matcher(url);
        if(m.find()) {
            return m.group(2);
        }
        return "";
    }


}
