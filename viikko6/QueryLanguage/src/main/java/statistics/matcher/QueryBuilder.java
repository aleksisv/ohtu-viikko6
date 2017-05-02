/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import java.util.ArrayList;

/**
 *
 * @author aleksisvuoksenmaa
 */
public class QueryBuilder {
    
    private ArrayList<Matcher> matchers;


    public QueryBuilder() {
        this.matchers = new ArrayList();
    }
    
    public QueryBuilder playsIn(String team) {
        this.matchers.add(new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int amount, String type) {
        this.matchers.add(new HasAtLeast(amount, type));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int amount, String type) {
        this.matchers.add(new HasFewerThan(amount, type));
        return this;
    }
    
    public QueryBuilder oneOf(Matcher... matchers) {
        this.matchers.add(new Or(matchers));
        return this;
    }
    
    public QueryBuilder allOf(Matcher... matchers) {
        this.matchers.add(new And(matchers));
        return this;
    }
    
    public Matcher[] matchersToArray() {
        Matcher[] matchers = new Matcher[this.matchers.size()];
        return this.matchers.toArray(matchers);
        
    }
    
    public void initialize() {
        this.matchers = new ArrayList();
    }
    
    public Matcher build() {
        Matcher[] matchers = matchersToArray();
        this.initialize();
        
        return new And(matchers);
    }
    
    
}
