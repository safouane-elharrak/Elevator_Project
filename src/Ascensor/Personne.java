package Ascensor;

import java.awt.Dimension;
import java.awt.Image;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Personne extends JLabel implements Runnable {
    
    private String IdPersonne;
    private int PoidePersonne;
    private ImageIcon  ImagePeronne;   
    private int posLabelX;
    private int posLabelY;
    public Ascenseur  Ascenseur;
    
    public  Personne(String identifie,int weight,Ascenseur asc){
        
        this.PoidePersonne  = weight;
        this.IdPersonne      = identifie;
        this.ImagePeronne     = new ImageIcon("images/1.png");
        this.setIcon(ImagePeronne);
        this.posLabelX = 150 ;
        this.posLabelY = 490;
        Dimension sizeOfImage  = this.getPreferredSize();
        this.setBounds(this.posLabelX,this.posLabelY,sizeOfImage.width,sizeOfImage.height);
        System.out.println("Personne Start = "+this.PoidePersonne);
        this.Ascenseur  = asc;
    }

    
        @Override
    public void run(){        
        while(true){            
            try {
            Interface.Semaphore.acquire();
            if(!(PanelAscenseur.MonteToSecondFloor(this,Ascenseur))){                
                System.out.println("Vous ne pouvez pas entrer dans l'ascenseur parce que vous êtes trop lourd");
            }
            Interface.Semaphore.release();
           Thread.sleep((long)  (5000* Math.random()));
           
            Interface.Semaphore.acquire();
            if(!(PanelAscenseur.DownToFirstFloor(this,Ascenseur))){                
                System.out.println("Vous ne pouvez pas entrer dans l'ascenseur parce que vous êtes trop lourd");
            }
            Interface.Semaphore.release();
           Thread.sleep((long)  (5000* Math.random()));
           
           Interface.Semaphore.acquire();
           if(!(PanelAscenseur.DownToGroundFloor(this,Ascenseur))){
                 System.out.println("Vous ne pouvez pas entrer dans l'ascenseur parce que vous êtes trop lourd");
           }
           Interface.Semaphore.release();
           Thread.sleep((long)  (5000* Math.random()));
           
            }catch (InterruptedException ex) {
                      Logger.getLogger(Personne.class.getName()).log(Level.SEVERE, null, ex);
                 }            
              }
}

    public void sleep(int i){
        try{            
            Thread.sleep(i); 

    }catch (InterruptedException ex) {
           
        Logger.getLogger(Personne.class.getName()).log(Level.SEVERE, null, ex);
      }
        
    }
    
    public String getIdetifieOfPerson() {
        return getPersonnIdentifie();
    }

    public int getWeightOfPerson() {
        return PoidePersonne;
    }

    public String getPersonnIdentifie() {
        return IdPersonne;
    }

    public ImageIcon getPersonImage() {
        return ImagePeronne;
    }
    public void setPersonImage(String nameOfImage){
        this.ImagePeronne  =  new ImageIcon(nameOfImage);
        this.setIcon(ImagePeronne);
    }
    public int getPosLabelX() {
        return posLabelX;
    }

    public void setPosLabelX(int posLabelX) {
        this.posLabelX = posLabelX;
    }

    public int getPosLabelY() {
        return posLabelY;
    }

    public void setPosLabelY(int posLabelY) {
        this.posLabelY = posLabelY;
    }
       
}
