package w6d1;

public class SeparatedSum {
    public Sum sum(String s) {
        s = s.replace(",", ".");
        String[] temp = s.split(";");
        double psum = 0;
        double nsum = 0;
        for (String item : temp) {
            double n = Double.parseDouble(item);
            if (n > 0) {
                psum += n;
            } else {
                nsum += n;
            }
        }
        return new Sum(psum, nsum);
    }
}
