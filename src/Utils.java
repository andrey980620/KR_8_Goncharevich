import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class Utils {

    public static class Data {
        public String name;
        public String type;
        public int typeSize;
        public ArrayList<Integer> dims;
        public int bytes;

        Data(String mName, String mType, ArrayList<Integer> mSize) {
            name = mName;
            type = mType;
            dims = mSize;
            switch (this.type) {
                case "boolean":
                case "byte":
                    typeSize = 1;
                    break;
                case "char":
                case "short":
                    typeSize = 2;
                    break;
                case "float":
                case "int":
                    typeSize = 4;
                    break;
                case "long":
                case "double":
                    typeSize = 8;
                    break;
            }

        }

        void calculateMemory() {
            int result = typeSize;
            for (int i = 0; i < dims.size(); i++)
                result = 24 + result * dims.get(i);
            bytes = result;
        }

        void print() {
            System.out.println(this.name + " -> " + this.dims);
        }

    }


    public static Data getInfo(String input) {
        String[] words = input.split(" ", 2);
        String type = words[0];
        String name = nameOfVar(words[1]);
        String[] dimString = words[1].split("[\\[\\]a-zA-z;]");
        ArrayList<Integer> dims = new ArrayList<>();
        for (int i = 0; i < dimString.length; i++) {
            if (!Objects.equals(dimString[i], ""))
                dims.add(Integer.parseInt(dimString[i]));
        }
        System.out.println(dims);

        return new Data(name, type, dims);

    }

    public static String nameOfVar(String str) {
        int index = str.indexOf("[");
        if (index == -1)
            return str.substring(0, str.length() - 1);
        else return str.substring(0, index);
    }


    public static void createFile(String path, String content) throws IOException {
        try {
            File newFile = new File(path);
            newFile.getParentFile().mkdirs();
            newFile.createNewFile();
            FileWriter out = new FileWriter(newFile);
            out.write(content);
            out.close();
        } catch (IOException e) {
            System.out.println("\n!!! Unable to  create a file with path:  " + path);
        }
    }

    public static Comparator<Data> compByName = (o1, o2) -> o1.name.compareTo(o2.name);
    public static Comparator<Data> compByType = (o1, o2) -> o1.typeSize-o2.typeSize;
}

