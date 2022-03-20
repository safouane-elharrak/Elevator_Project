package Ascensor;

import java.awt.Graphics;
import static java.awt.image.ImageObserver.WIDTH;
import static java.lang.Thread.sleep;
import java.util.HashSet;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class PanelAscenseur  extends JPanel{
        public ImageIcon imagePanel;
        public static int PoideMax ;
        public int nbrPersonnes ;
     
        public  PanelAscenseur(){            
         this.nbrPersonnes  = 1;
         this.PoideMax = 250;
         }
        
         protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            imagePanel = new ImageIcon("images/frame 7.jpg");       
            imagePanel.paintIcon(this, g, WIDTH,WIDTH);
         }

    public static boolean MonteToSecondFloor(Personne p,Ascenseur a ) throws InterruptedException{               
                int x = p.getPosLabelX();
                int y = p.getPosLabelY();       
       if(p.getWeightOfPerson() > PoideMax){           
           return false;           
       }else{
                 while(x < 700){
                     x +=50;
                     p.setLocation(x, y);
                     if(x == 650){
                         a.CaseSecondFloor();
                         a.SwitchIconAscensor("images/a1.png");
                         Thread.sleep(1000);
                     }
                      p.sleep(200);
                 }
                  p.setPersonImage("images/4.png");
                  p.hide();
                  a.ToSecondFloor();
                  y  -= 450;   
                  p.setLocation(x,y);
                  p.show();
                  while(x > 50){
                     x -=50;
                     p.setLocation(x, y);
                     p.sleep(200);
                 }
                 a.SwitchIconAscensor("images/a1.png");
                 p.setPersonImage("images/1.png");
                 p.setPosLabelX(x);
                 p.setPosLabelY(y);                 
                 return true;        
       }  
    }
     
    public static boolean DownToFirstFloor(Personne p,Ascenseur a ) throws InterruptedException{                
                int x = p.getPosLabelX();
                int y = p.getPosLabelY();  
                
       if(p.getWeightOfPerson() > PoideMax){          
           return false;           
       }else{
                 while(x < 700){
                     x +=50;
                     p.setLocation(x, y);
                     if(x == 650){
                         a.CaseFirstFloor();
                         a.SwitchIconAscensor("images/a1.png");
                         Thread.sleep(1000);
                     }
                      p.sleep(200);
                 }
                  p.setPersonImage("images/4.png");
                  p.hide();
                  a.ToFirstFloor();
                  y  += 230;    
                  p.setLocation(x,y);
                  p.show();
                  while(x > 50){
                     x -=50;
                     p.setLocation(x, y);
                     p.sleep(200);
                 }
                 a.SwitchIconAscensor("images/a1.png");
                 p.setPersonImage("images/1.png");
                 p.setPosLabelX(x);
                 p.setPosLabelY(y);                 
                 return true;        
       }  
    }
   
    public static boolean DownToGroundFloor(Personne p,Ascenseur a) throws InterruptedException{        
                int x = p.getPosLabelX();
                int y = p.getPosLabelY();
                
        if(p.getWeightOfPerson() > PoideMax){
                   return false;
                 }else{
                         while(x < 700){
                             x +=50;
                             p.setLocation(x, y);
                             if(x == 650){
                                 a.CaseGroundFloor();
                                 a.SwitchIconAscensor("images/a1.png");
                                 Thread.sleep(1000);
                             }
                              p.sleep(200);
                         }
                         p.setPersonImage("images/4.png");
                          p.hide();
                          a.ToGroundFloor();
                          y  += 220;
                          p.setLocation(x,y);
                          p.show();
                          while(x > 50){
                             x -=50;
                             p.setLocation(x, y);
                             p.sleep(200);
                         }
                         a.SwitchIconAscensor("images/a1.png");
                         p.setPersonImage("images/1.png");
                         p.setPosLabelX(x);
                         p.setPosLabelY(y);
                  return true;
                 }
            }
}
