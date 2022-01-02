package dragons;

import java.util.ArrayList;

public class Clan {
    private String name;
    private String[] colors;
    private Matriarch matriarch;
    private ArrayList<Dragon> dragons;
    private ArrayList<Drake> drakes;

    public Clan(Matriarch m) {
        matriarch = m;
        name = matriarch.getName();
        colors = m.colors();
        dragons = new ArrayList<>();
        drakes = new ArrayList<>();
    }

    public void addFirstDaughter(Dragon d) {
        matriarch.addDaughter(d);
        dragons.add(d);
    }

    public void addFirstDaughter(String name) {
        addFirstDaughter(new Dragon(name, colors, matriarch));
    }


    public void addSister(Dragon d) {
        matriarch.addSister(d);
        dragons.add(d);
    }

    public void addSister(String name) {
        Dragon sister = new Dragon(name, colors);
        sister.setMatriarch(matriarch);
        addSister(sister);
    }

    public void addConsort(Drake c) {
        matriarch.addconsort(c);
        drakes.add(c);
    }

    public void addFirstSon(Drake s) {
        matriarch.addSon(s);
        drakes.add(s);
    }

    public void addFirstSon(String name) {
        addFirstSon(new Drake(name, colors, matriarch));
    }

    public void addDaughter(String mother, Dragon d) {
        for (Dragon dragon : dragons) {
            if (dragon.getName().equals(mother)) {
                dragon.addDaughter(d);
                dragons.add(d);
                break;
            }
        }
    }

    public void addSon(String mother, Drake s) {
        for (Dragon dragon : dragons) {
            if (dragon.getName().equals(mother)) {
                dragon.addSon(s);
                drakes.add(s);
                break;
            }
        }
    }

    public void mate(String wife, Drake m) {
        for (Dragon dragon : dragons) {
            if (dragon.getName().equals(wife)) {
                dragon.setMate(m);
                if (!drakes.contains(m)) {
                    drakes.add(m);
                }
                break;
            }
        }
    }

    public void mate(String mate, Dragon d) {
        for (Drake drake :drakes) {
            if (drake.getName().equals(mate)) {
                drake.setMate(d);
                if (!dragons.contains(d)) {
                    dragons.add(d);
                }
                break;
            }
        }
    }

    @Override
    public String toString() {
        char q = '"';
        String result = "{ \"clan\": {";
        result += "\"name\": " + q + name + "\", ";
        result += "\"matriarch\": " + matriarch.toString();
        result += "}";
        return result;
    }
}
