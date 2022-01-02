package dragons;

import java.util.ArrayList;

public class Dragon extends Wyrm {
    private Dragon mother;
    private Matriarch matriarch;
    private Drake mate;
    private ArrayList<Dragon> daughters;
    public ArrayList<Drake> sons;
    
    public Dragon(String name, String[] colors) {
        super(name, colors);
        daughters = new ArrayList<>();
        sons = new ArrayList<>();
    }

    public Dragon(String name, String[] colors, Dragon mother) {
        super(name, colors);
        setMother(mother);
        daughters = new ArrayList<>();
        sons = new ArrayList<>();
    }

    public void setMatriarch(Matriarch m) {
        matriarch = m;
    }

    public void setMother(Dragon d) {
        mother = d;
        if (mother.getMatriarch() == null) {
            setMatriarch((Matriarch) d);
        } else {
            setMatriarch(d.getMatriarch());
        }
    }

    public void setMate(Drake d) {
        mate = d;
        d.setMate(this);
    }

    public Drake getmate() {
        return mate;
    }

    public void addDaughter(Dragon d) {
        daughters.add(d);
        d.setMother(this);
    }

    public void addSon(Drake d) {
        sons.add(d);
    }

    public ArrayList<Dragon> getDaughters() {
        return daughters;
    }

    public ArrayList<Drake> getSons() {
        return sons;
    }

    public Matriarch getMatriarch() {
        return matriarch;
    }

    public Dragon getMother() {
        return mother;
    }

    @Override
    public String toString() {
        char q = '"';
        String result ="{ ";
        result += "\"name\": " + q + getName() + q;
        result += ", \"color\": " + q + getColors() + q;
        if (mate != null) {
            result += ", \"mate\": " + mate.toString();
        }
        if (daughters.size() > 0) {
            result += ", \"daughters\": [ ";
            for (int i = 0; i < daughters.size(); i ++) {
                if (i == daughters.size() - 1) {
                    result += daughters.get(i).toString() + "] ";
                } else {
                    result += daughters.get(i).toString() + ", ";
                }
            }
            result += "} ";
        } else {
            result += "} ";
        }
        return result;
    }

    
}
