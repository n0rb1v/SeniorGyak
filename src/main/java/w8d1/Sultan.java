package w8d1;

public class Sultan {
    public boolean[] openDoors() {
        boolean[] cells = new boolean[100];
        for (int day = 1; day < 101; day++) {
            for (int i = 1; i < 101; i += day) {
                cells[i - 1] = !cells[i - 1];
            }
        }
        return cells;
    }

    public String print(boolean[] b) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            if (b[i] == true) {
                result.append(i+"\n");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Sultan s = new Sultan();
        System.out.println(s.print(s.openDoors()));
    }
}
