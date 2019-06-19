package commute;

import java.io.*;
import java.net.*;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Properties;


import javax.net.ssl.*;

public class ProxyClientDemo {

    public static void main(String[] args) throws Exception {

        ProxyClientDemo p = new ProxyClientDemo();
        p.getAmapLocation();

        final initializer initializer = new initializer() {
            @Override
            public void init() {
                System.out.println("test");
            }
        };

        final ProxyClientDemo.initializer[] initializers = new initializer[3];
        for (ProxyClientDemo.initializer i:initializers) {
                if(i == null)
                    System.out.println("Element is null");
        }
    }

    public void proxyClient() throws IOException {
        ProxyClient proxyclient = new ProxyClient();

        // set the host the proxy should create a connection to
        //
        // Note:  By default port 80 will be used. Some proxies
        // only allow conections to ports 443 and 8443.
        // This is because the HTTP CONNECT method was intented
        // to be used for tunneling HTTPS.
        proxyclient.getHostConfiguration().setHost("www.google.com");

        // set the proxy host and port
        proxyclient.getHostConfiguration().setProxy("10.195.32.165", 443);

        // set the proxy credentials, only necessary
        // for authenticating proxies
        proxyclient.getState().setProxyCredentials(
                new AuthScope("userproxy.visa.com", 443, null),
                new UsernamePasswordCredentials("vizhu@visa.com", "!@"));

        // create the socket
        ProxyClient.ConnectResponse response = proxyclient.connect();

        if (response.getSocket() != null) {

            Socket socket = response.getSocket();

            try {

                // go ahead and do an HTTP GET using the socket
                Writer out = new OutputStreamWriter(
                        socket.getOutputStream(), "ISO-8859-1");

                out.write("GET http://www.google.com/ HTTP/1.1\r\n");
                out.write("Host: www.yahoo.com\r\n");
                out.write("Agent: whatever\r\n");
                out.write("\r\n");
                out.flush();

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream(),
                                "ISO-8859-1"));

                String line = null;

                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }

            } finally {
                // be sure to close the socket when we're done
                socket.close();
            }
        } else {
            // the proxy connect was not successful, check
            // connect method for reasons why
            System.out.println("Connect failed: " +
                    response.getConnectMethod().getStatusLine());

            System.out.println(
                    response.getConnectMethod().getResponseBodyAsString());
        }
    }

    private final String USER_AGENT = "Mozilla/5.0";

    public void getAmapLocation() throws Exception{

        // configure the SSLContext with a TrustManager
        SSLContext ctx = SSLContext.getInstance("TLS");
        ctx.init(new KeyManager[0], new TrustManager[] {new DefaultTrustManager()}, new SecureRandom());
        SSLContext.setDefault(ctx);

        String url = "https://restapi.amap.com/v3/geocode/geo?address=建设路火车站广场罗湖商业城3220号&output=xml&key=921377ff333b86ac0d49297f55e3f7ff";
//        String url = "http://www.google.com/search?q=mkyong";

        URL obj = new URL(url);
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("userproxy.visa.com", 8080));
        HttpURLConnection con = (HttpURLConnection) obj.openConnection(proxy);
//        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());
    }

    private static class DefaultTrustManager implements X509TrustManager {

        @Override
        public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {}

        @Override
        public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {}

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

    interface initializer{

        void init();
    }


}

