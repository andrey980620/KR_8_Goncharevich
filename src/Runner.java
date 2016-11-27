import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Runner {
    public static void main(String[] args) throws IOException {
        File file = new File("src//bytes.in");
        Scanner in = new Scanner(file);

        ArrayList<Data> vars = new ArrayList<>();
        while (in.hasNextLine()) {
            String tmp = in.nextLine();
            vars.add(Utils.getInfo(tmp));
            vars.get(vars.size() - 1).calculateMemory();
        }

        String file3 = new String();
        for (Data var : vars) {
            file3 += var.bytes + "\r\n";
        }

        String file1 = new String();
        vars.sort(Utils.compByName);
        for (Data var : vars) {
            file1 += var.name + "\r\n";
        }

        String file2 = new String();
        vars.sort(Utils.compByType);
        for (Data var : vars) {
            file2 += var.name + "\r\n";
        }

        Utils.createFile("src//bytes1.out", file1);
        Utils.createFile("src//bytes2.out", file2);
        Utils.createFile("src//bytes3.out", file3);
    }
}
