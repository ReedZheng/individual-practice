package practicecourt.offer;

public class Off005 {

    public String replaceSpace(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        int length = str.length();

        for (int i = length - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (c == ' ') {
                sb.append("02%");
            } else {
                sb.append(c);
            }
        }
        return sb.reverse().toString();
    }

    // from github
    public String replaceSpace1(StringBuffer str) {
        int P1 = str.length() - 1;
        for (int i = 0; i <= P1; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }

        int P2 = str.length() - 1;
        while (P1 >= 0 && P2 > P1) {
            char c = str.charAt(P1--);
            if (c == ' ') {
                str.setCharAt(P2--, '0');
                str.setCharAt(P2--, '2');
                str.setCharAt(P2--, '%');
            } else {
                str.setCharAt(P2--, c);
            }
        }
        return str.toString();
    }
}
