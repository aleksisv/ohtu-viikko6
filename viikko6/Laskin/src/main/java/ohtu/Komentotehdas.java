/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import java.util.HashMap;
import javax.swing.JTextField;

/**
 *
 * @author aleksisvuoksenmaa
 */
public class Komentotehdas {
    private HashMap<String, Komento> komennot;

    public Komentotehdas(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        komennot = new HashMap<String, Komento>();
        komennot.put("+", new Summa(sovellus, tuloskentta, syotekentta));
        komennot.put("-", new Erotus(sovellus, tuloskentta, syotekentta));
        komennot.put("Z", new Nollaa(sovellus, tuloskentta, syotekentta));
        komennot.put("undo", new Undo(sovellus, tuloskentta, syotekentta));
    }

    public Komento hae(String operaatio) {
        Komento komento = komennot.get(operaatio);
        if (komento == null) {
        }
        return komento;
    }
}
