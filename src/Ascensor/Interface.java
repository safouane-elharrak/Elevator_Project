package Ascensor;
/**
 *
 * @author Safouane 
 */
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import static java.awt.Font.BOLD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Interface extends javax.swing.JFrame {
   private JPanel Panel;
   private Thread Thread[]; 
   private Personne  Personnes;
   public static Semaphore Semaphore;
   public Ascenseur AscenseurLabel;
   public JButton startAnimation  ;
   public ActionListener Listener;

    public Interface() {
        initComponents();
        this.Semaphore = new Semaphore(1,false);
        this.setSize(1300,720);
        this.Panel  = new PanelAscenseur();
        this.setContentPane( this.Panel);
        this.Panel.setLayout(null);       
        this.AscenseurLabel   = new Ascenseur();
        this.Panel.add(AscenseurLabel);
        this.startAnimation= new JButton("Start Animation");
        this.startAnimation.setVisible(true);
        this.startAnimation.setBounds(1000, 370,250, 80);
        this.startAnimation.setBackground(Color.black);
        this.startAnimation.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.startAnimation.setForeground(Color.white);
        this.startAnimation.setFont(new Font("Serif",Font.ITALIC,30));
        this.Panel.add(startAnimation);       
        
        this.startAnimation.addActionListener(new ActionListener(){            
            public void actionPerformed(ActionEvent e){                
                for(int i=0;i<1;i++){                    
                   Thread[i].start();  
                }
            }       
        });
        Thread    = new Thread[1];
        for(int i=0;i<1;i++){
            
            Personnes     = new Personne("Personne "+i, (int) Math.floor(Math.random()*70) + 50,this.AscenseurLabel);
            Thread[i]     = new Thread(Personnes);
            this.Panel.add(Personnes);    
        }   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
