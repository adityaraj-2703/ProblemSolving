package string;

public class ValidateIpAddress {
    public String validIPAddress(String queryIP) {

        String[] q = queryIP.split("\\.");
        if (queryIP.charAt(queryIP.length() - 1) == '.') {
            return "Neither";
        }
        if (q.length == 4) {
            for (int i = 0; i < q.length; i++) {
                if (q[i].length() > 1 && q[i].charAt(0) == '0' || q[i].length() > 3) {
                    return "Neither";
                }
                for (char c : q[i].toCharArray()) {
                    if (!Character.isDigit(c)) {
                        return "Neither";
                    }
                }
                if (Integer.parseInt(q[i]) > 255) {
                    return "Neither";
                }

            }
            return "IPv4";
        }
        q = queryIP.split(":");
        if (queryIP.charAt(queryIP.length() - 1) == ':') {
            return "Neither";
        }
        if (q.length == 8) {
            for (int i = 0; i < q.length; i++) {
                if (q[i].length() > 4) {
                    return "Neither";
                }
                for (int j = 0; j < q[i].length(); j++) {
                    if (q[i].charAt(j) >= '0' && q[i].charAt(j) <= '9') {
                        continue;
                    }
                    if ((q[i].charAt(j) < 'a'
                            || q[i].charAt(j) > 'f') && (q[i].charAt(j) < 'A' || q[i].charAt(j) > 'F')) {
                        return "Neither";
                    }
                }

            }
            return "IPv6";

        }

        return "Neither";

    }

    public static void main(String[] args) {
        ValidateIpAddress v = new ValidateIpAddress();
        System.out.println(v.validIPAddress("1.1.1.1."));
    }

}
