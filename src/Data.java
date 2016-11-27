import java.util.ArrayList;
import java.util.Comparator;

public class Data {

    private String name;
    private String type;
    private int typeSize;
    private ArrayList<Integer> dims;
    private int bytes;

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
        for (Integer dim : dims) result = 24 + result * dim;
        bytes = result;
    }

    static String toPrint(ArrayList<Data> list, String field) {
        String result = new String();
        switch (field) {
            case "bytes":
                for (Data arrayInfo : list) {
                    result += arrayInfo.bytes + "\r\n";
                }
                break;
            case "name":
                for (Data arrayInfo : list) {
                    result += arrayInfo.name + "\r\n";
                }
                break;
        }
        return result;
    }

    public static Comparator<Data> compByName = (o1, o2) -> o1.name.compareTo(o2.name);
    public static Comparator<Data> compByType = (o1, o2) -> o1.typeSize - o2.typeSize;
}