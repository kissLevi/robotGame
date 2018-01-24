/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Jana
 */
public class Szedo implements Alma{
    int szam = 100;
    private String munkama = "Hihihihi";
    @Override
    public int szedjAlmat(int i) {
        return i + csalas();
    }
    
    public int csalas(){
        System.out.println(this.munkama);
        return this.szam * 2000;
    }
    
}
