/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import javax.swing.JTextField;

/**
 *
 * @author aleksisvuoksenmaa
 */
public class Erotus implements Komento {
    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;

    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }
    
    @Override
    public void suorita() {
        int alkuarvo = Integer.parseInt(tuloskentta.getText());
        int lisattava = Integer.parseInt(syotekentta.getText());
        int uusiarvo = alkuarvo - lisattava;
        tuloskentta.setText(Integer.toString(uusiarvo));
        sovellus.miinus(lisattava);
    }

    @Override
    public void peru() {
        
    }
    
}
