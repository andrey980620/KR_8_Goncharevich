import java.util.ArrayList;

public class Data {
    String name;
    String type;
    int typeSize;
    ArrayList<Integer> dims;
    int bytes;

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

    void print() {
        System.out.println(this.name + " -> " + this.dims);
    }

}