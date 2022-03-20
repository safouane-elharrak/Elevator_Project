package Ascensor;

import java.awt.Dimension;
import static java.lang.Thread.sleep;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Ascenseur extends JLabel {        
    private ImageIcon acensorImage;
    private int posLabelX;
    private int posLabelY;
    public int status;   
     
   public Ascenseur(){
            
        this.acensorImage  = new ImageIcon("images/a1.png");
        this.setIcon(acensorImage);
        this.posLabelX = 700 ;
        this.posLabelY = 490 ;
        Dimension sizeOfImage  = this.getPreferredSize();
        this.setBounds(this.posLabelX,this.posLabelY,sizeOfImage.width,sizeOfImage.height);
        this.status = 0; // l'Ascensuer au rez de chaussée
        }
      public void SwitchIconAscensor(String nameOfImageAscensor){
          
          this.setIcon(new ImageIcon(nameOfImageAscensor));
      }
      public void ToSecondFloor() throws InterruptedException{
               
                    int m = this.posLabelX;
                    int n = this.posLabelY;

               System.out.println("L'ascenseur commence à monter à la 2éme Etage"); 
               this.SwitchIconAscensor("images/a1.png");
               while(n > 50){
                     n -=50;
                     this.setLocation(m,n);
                     Thread.sleep(200);
                 }
                this.SwitchIconAscensor("images/a1.png");              
                 this.posLabelX = m;
                 this.posLabelY = n;
                 this.status    = 1;
             
        }
      public void ToFirstFloor() throws InterruptedException{
               
                    int m = this.posLabelX;
                    int n = this.posLabelY;

               System.out.println("L'ascenseur commence à décend à la 1ér Etage"); 
                 this.SwitchIconAscensor("images/a1.png");
               while(n < 260){
                     n +=50;
                     this.setLocation(m,n);
                     Thread.sleep(200);
                 }
                this.SwitchIconAscensor("images/a1.png");               
                 this.posLabelX = m;
                 this.posLabelY = n;
                 this.status    = 2;
             
        }      
    public void ToGroundFloor() throws InterruptedException{
                    int m = this.posLabelX;
                    int n = this.posLabelY;
               System.out.println("L'ascenseur commence à décend à rez de chaussée"); 
                 this.SwitchIconAscensor("images/a1.png");
                 while(n < 450){
                      n  +=50;
                     this.setLocation(m, n);
                     Thread.sleep(200);
                 }
                this.SwitchIconAscensor("images/a1.png");
                 this.posLabelX = m;
                 this.posLabelY = n;
                 this.status    = 0;           
        }   
    public void CaseSecondFloor() throws InterruptedException{
                    int m = this.posLabelX;
                    int n = this.posLabelY;
                if(this.status == 1){
                  while(n > 50){  
                     n  +=50;
                     this.setLocation(m, n);
                     Thread.sleep(200);
                  }               
                 this.posLabelY = n;
                 this.status  = 0;                 
                }                                                               
    }

    public void CaseFirstFloor() throws InterruptedException{        
                    int m = this.posLabelX;
                    int n = this.posLabelY;
                if(this.status == 2){
                  while(n < 260){ 
                     n  +=50;
                     this.setLocation(m, n);
                     Thread.sleep(200);
                  }               
                 this.posLabelY = n;
                 this.status  = 0;                 
                }                                                               
    }
    
    public void CaseGroundFloor() throws InterruptedException{
                       int m = this.posLabelX;
                       int n = this.posLabelY;
                   if(this.status == 0){
                     while(n < 450){
                        n  -=50;
                        this.setLocation(m, n);
                        Thread.sleep(200);
                     }               
                    this.posLabelY = n;
                    this.status  = 1;                 
                   }                                                               
       }


}
