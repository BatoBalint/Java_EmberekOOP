package hu.petrik.emberekoop;

<<<<<<< HEAD
public class Emberek {

=======
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Emberek {
    private List<Ember> emberLista;

    public Emberek(Ember[] emberTomb){
        this.emberLista = new ArrayList<>();
        // Tömböt átalakítottuk listává, és az összes elemet az addAll függvény segítségével felvettük.
        this.emberLista.addAll(Arrays.asList(emberTomb));
        /*
        for (Ember ember: emberTomb) {
            this.emberLista.add(ember);
        }
         */
    }

    @Override
    public String toString() {
        String s = "";
        for (Ember ember: this.emberLista) {
            s += ember + "\n";
        }
        return s;
    }
>>>>>>> origin/master
}
