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

        String file3 = Data.toPrint(vars,"bytes");

        vars.sort(Data.compByName);
        String file1 = Data.toPrint(vars,"name");

        vars.sort(Data.compByType);
        String file2 = Data.toPrint(vars,"name");

        Utils.createFile("src//bytes1.out", file1);
        Utils.createFile("src//bytes2.out", file2);
        Utils.createFile("src//bytes3.out", file3);
    }
}
