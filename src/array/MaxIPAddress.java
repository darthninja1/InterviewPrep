package array;

/*
Given list of IP addresses, find out max occured IP. I.e given ["255.255.11.135", "255.255.111.35", "255.255.110.135",
"255.255.11.135", "255.255.98.135"], maximum occured IP address is "255.255.110.135" with 2 occurances where as rest
of them have only one
 */
public class MaxIPAddress {
    public static void main(String[] args) {
        String[] ips = new String[]{"1.1.1.1", "255.255.11.135", "255.255.111.35", "255.255.110.135",
                "255.255.11.135", "255.255.98.135"};
        System.out.println(maxIP(ips));
        ips = new String[]{"1.1.1.1", "2.2.2.2", "1.1.100.1", "1.255.255.255"};
        System.out.println(maxIP(ips));
    }

    private static String maxIP(String[] ips) {
        long max = 0;
        String maxString = "";
        for (int i = 0; i < ips.length; i++) {
            String[] ip = ips[i].split("\\.");
            long numericIP=0;
            for (int j = 0; j < 4; j++) {
                numericIP += (Long.valueOf(ip[j]) << ((3 - j) * 8));
            }
            if (numericIP> max) {
                max = numericIP;
                maxString = ips[i];
            }
        }
        return maxString;
    }
}
