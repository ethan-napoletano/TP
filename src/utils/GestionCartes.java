package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class GestionCartes {

    public static <T> T extraire(List<T> liste) {
        Random random = new Random();

        int index = random.nextInt(liste.size());

        return liste.remove(index);
    }

    public static <T> T extraireAvecIterator(List<T> liste) {
        Random random = new Random();

        int index = random.nextInt(liste.size());

        ListIterator<T> iterator = liste.listIterator();

        for (int i = 0; i <= index; i++) {
            iterator.next();
        }

        T element = iterator.previous();
        iterator.remove();

        return element;
    }

    public static <T> List<T> mélanger(List<T> liste) {
        List<T> resultat = new ArrayList<>();

        while (!liste.isEmpty()) {
            resultat.add(extraire(liste));
        }

        return resultat;
    }

    public static <T> boolean verifierMelange(
            List<T> liste1, List<T> liste2) {

        if (liste1.size() != liste2.size()) {
            return false;
        }

        for (T element : liste1) {
            if (Collections.frequency(liste1, element)
                    != Collections.frequency(liste2, element)) {
                return false;
            }
        }

        return true;
    }

    public static <T> List<T> rassembler(List<T> liste) {

        List<T> resultat = new ArrayList<>();
        List<T> reste = new ArrayList<>(liste);

        while (!reste.isEmpty()) {

            T element = reste.remove(0);
            resultat.add(element);

            Iterator<T> iterator = reste.iterator();

            while (iterator.hasNext()) {

                T courant = iterator.next();

                if (courant.equals(element)) {
                    resultat.add(courant);
                    iterator.remove();
                }
            }
        }

        return resultat;
    }

    public static <T> boolean verifierRassemblement(List<T> liste) {

        if (liste.isEmpty()) {
            return true;
        }

        ListIterator<T> premier = liste.listIterator();

        T ancienneValeur = premier.next();

        while (premier.hasNext()) {

            T nouvelleValeur = premier.next();

            if (!nouvelleValeur.equals(ancienneValeur)) {

                ListIterator<T> deuxieme =
                        liste.listIterator(premier.nextIndex());

                while (deuxieme.hasNext()) {

                    if (deuxieme.next().equals(ancienneValeur)) {
                        return false;
                    }
                }

                ancienneValeur = nouvelleValeur;
            }
        }

        return true;
    }
}