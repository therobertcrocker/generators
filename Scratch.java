

import tools.generator.*;
import dragons.*;

public class Scratch {
    public static void main(String[] args) {
        String[] color = new String[] {"Black", "Bronze"};
        Matriarch m = new Matriarch ("Iri", color, 3);
        Clan iri = new Clan(m);

        iri.addSister("Kiri");
        iri.addSister("Miri");
        iri.addSister("Hiri");

        Drake a = new Drake("Han", new String[] {"Black"});
        iri.addConsort(a);
        iri.addFirstDaughter("Iri-Ko");
        iri.mate("Kiri", new Drake("Kono", new String[] {"Bronze"}));
        iri.addDaughter("Kiri", new Dragon("Kiri-Ra", color));

        System.out.println(iri);

        
    }
}