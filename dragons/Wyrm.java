package dragons;

public class Wyrm {
    private String name;
    private String[] colors;

    public Wyrm(String n, String[] c) {
        name = n;
        colors = c;
    }

    public String getName() {
        return name;
    }

    public String getColors() {
        String color = "";
        if (colors.length == 1) {
            color = colors[0];
        } else {
            color += colors[0] + "/" + colors[1];
        }
        return color;
    }

    public String[] colors() {
        return colors;
    }

    @Override
    public String toString() {
        char q = '"';
        String result = "{ ";
        result += "\"name\": " + q + name + q;
        result += ", \"color\": " + q + getColors() + q;
        result += "} ";
        return result;
    }
}
