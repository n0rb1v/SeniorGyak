package inf1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sorozatok {
    private List<Sorozat> sorozatList = new ArrayList<>();

    public void loadFile(Path file) {
        try (BufferedReader bf = Files.newBufferedReader(file)) {
            String line;
            while ((line = bf.readLine()) != null) {
                Sorozat s = new Sorozat(
                        line,
                        bf.readLine(),
                        bf.readLine(),
                        Integer.parseInt(bf.readLine()),
                        Integer.parseInt(bf.readLine())
                );
                sorozatList.add(s);
            }

        } catch (IOException e) {
            throw new IllegalStateException("file error", e);
        }
    }

    public int ismertDatum() {
        int sum = 0;
        for (Sorozat item : sorozatList) {
            if (item.getDate() != null) {
                sum++;
            }
        }
        return sum;
    }

    public double szazalek() {
        return Math.round((double) latta().size() / sorozatList.size() * 10000.0) / 100.0;
    }

    private List<Sorozat> latta() {
        List<Sorozat> sum = new ArrayList<>();
        for (Sorozat item : sorozatList) {
            if (item.getReady() == 1) {
                sum.add(item);
            }
        }
        return sum;
    }
    private List<Sorozat> nincsIdo() {
        List<Sorozat> result = new ArrayList<>();
        for (Sorozat item : sorozatList) {
            if (item.getDate() == null) {
                result.add(item);
            }
        }
        return result;
    }

    public Duration nezesIdo() {
        Duration ido = Duration.ofMinutes(0);
        for (Sorozat item : latta()) {
            ido = ido.plusMinutes(item.getMinutes());
        }
        return ido;
    }

    public List<String> otodik(LocalDate ld) {
        List<Sorozat> nemlatta = new ArrayList<>(sorozatList);
        nemlatta.removeAll(latta());
        nemlatta.removeAll(nincsIdo());
        List<String> result = new ArrayList<>();

        for (Sorozat item: nemlatta) {
            if (item.getDate().isBefore(ld)){
                result.add(item.getSeason()+"x"+item.getEpisode()+"--"+item.getName());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Sorozatok s = new Sorozatok();
        Scanner scanner = new Scanner(System.in);
        s.loadFile(Path.of("src/main/resources/inf1/lista.txt"));

        System.out.println("2.f: " + s.ismertDatum());
        System.out.println("3.f: látta a " + s.szazalek() + "%-át");
        System.out.println("4.f: " + s.nezesIdo().toDaysPart()+"nap "+s.nezesIdo().toHoursPart()+"ora "+s.nezesIdo().toMinutesPart()+"percet toltott vele");
        System.out.println("Datum?:");
        LocalDate dinp = LocalDate.parse(scanner.nextLine());
        System.out.println("5.f:\n"+s.otodik(dinp));
    }
}
