/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import classes.*;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Miguel Matul <https://github.com/MigueMat4>
 */
public class frmMain extends javax.swing.JFrame {
    Pokemon IsThisPokemon;
    Pokemon whoIsThatPokemon1; // objeto de la clase que hace match con los datos de la API
    Pokemon whoIsThatPokemon2; 
    Pokemon whoIsThatPokemon3; 
    Pokemon whoIsThatPokemon4; 
    GameOn demosle = new GameOn();
    Pokedex dexter = new Pokedex();
    PokeViewer visor = new PokeViewer();
    Reloj horaActual = new Reloj();
    ReViewer reV = new ReViewer(); // se supone que era para que se mantuviera girando, lastimsoamente no salió
    /**
     * Creates new form frmMain
     */
    public frmMain() {
        initComponents();
        horaActual.start();
        reV.start();
        demosle.bloqueado=1;
        demosle.start();
    }
    public class ReViewer extends Thread{
        public boolean run=false;
        public boolean isRun() {
            return run;
        }
        public void startRunning(){
            run=true;
        }
        public void stopRunning(){
            run=false;
        }
        @Override
        public void run() {
            while(run){
                    if (IsThisPokemon != null){
                    try {
                        lblSprite.setText("");
                        // obtengo la url del listado de cada uno de los sprites que me dio la API
                        URL url = new URL(IsThisPokemon.getSprites().get("front_default").toString());
                        Image img = ImageIO.read(url);
                        lblSprite.setIcon(new ImageIcon(img));
                        // 1 segundo para cada cambio de sprite
                        Thread.sleep(1000);

                        url = new URL(IsThisPokemon.getSprites().get("back_default").toString());
                        img = ImageIO.read(url);
                        lblSprite.setIcon(new ImageIcon(img));
                        Thread.sleep(1000);
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException | IOException ex) {
                        Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
                    else{
                        lblSprite.setText("?");
                        btnPokemon1.setText("???");
                        btnPokemon2.setText("???");
                        btnPokemon3.setText("???");
                        btnPokemon4.setText("???");
                    }
                }
                try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
    }
    public class PokeViewer {
        public void mostrarSprites(Pokemon poke) {
            if (poke != null){
                try {
                    lblSprite.setText("");
                    // obtengo la url del listado de cada uno de los sprites que me dio la API
                    URL url = new URL(poke.getSprites().get("front_default").toString());
                    Image img = ImageIO.read(url);
                    lblSprite.setIcon(new ImageIcon(img));
                    // 1 segundo para cada cambio de sprite
                    Thread.sleep(1000);
                        
                    url = new URL(poke.getSprites().get("back_default").toString());
                    img = ImageIO.read(url);
                    lblSprite.setIcon(new ImageIcon(img));
                    Thread.sleep(1000);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException | IOException ex) {
                    Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                lblSprite.setText("?");
                btnPokemon1.setText("???");
                btnPokemon2.setText("???");
                btnPokemon3.setText("???");
                btnPokemon4.setText("???");
            }
            reV.startRunning();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSprite = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnPokemon1 = new javax.swing.JButton();
        btnPokemon2 = new javax.swing.JButton();
        btnPokemon3 = new javax.swing.JButton();
        btnPokemon4 = new javax.swing.JButton();
        btnJugar = new javax.swing.JButton();
        lblHoraSistema = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblSprite.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblSprite.setText("?");

        btnPokemon1.setText("???");
        btnPokemon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPokemon1ActionPerformed(evt);
            }
        });

        btnPokemon2.setText("???");
        btnPokemon2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPokemon2ActionPerformed(evt);
            }
        });

        btnPokemon3.setText("???");
        btnPokemon3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPokemon3ActionPerformed(evt);
            }
        });

        btnPokemon4.setText("???");
        btnPokemon4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPokemon4ActionPerformed(evt);
            }
        });

        btnJugar.setText("Jugar");
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });

        lblHoraSistema.setText("Hora sistema");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnPokemon4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPokemon3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPokemon2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPokemon1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 124, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblHoraSistema)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblSprite)
                                .addGap(148, 148, 148)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblHoraSistema)
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblSprite)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnPokemon1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPokemon2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPokemon3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPokemon4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(btnJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed
        demosle.startRunning();
    }//GEN-LAST:event_btnJugarActionPerformed

    private void btnPokemon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPokemon1ActionPerformed
        if(IsThisPokemon==whoIsThatPokemon1){
            JOptionPane.showMessageDialog(null, "Acertó");
        }
        else{
             JOptionPane.showMessageDialog(null, "Falló");
        }
    }//GEN-LAST:event_btnPokemon1ActionPerformed

    private void btnPokemon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPokemon2ActionPerformed
        if(IsThisPokemon==whoIsThatPokemon2){
            JOptionPane.showMessageDialog(null, "Acertó");
        }
        else{
             JOptionPane.showMessageDialog(null, "Falló");
        }
    }//GEN-LAST:event_btnPokemon2ActionPerformed

    private void btnPokemon3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPokemon3ActionPerformed
        if(IsThisPokemon==whoIsThatPokemon3){
            JOptionPane.showMessageDialog(null, "Acertó");
        }
        else{
             JOptionPane.showMessageDialog(null, "Falló");
        }
    }//GEN-LAST:event_btnPokemon3ActionPerformed

    private void btnPokemon4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPokemon4ActionPerformed
        if(IsThisPokemon==whoIsThatPokemon4){
            JOptionPane.showMessageDialog(null, "Acertó");
        }
        else{
             JOptionPane.showMessageDialog(null, "Falló");
        }
    }//GEN-LAST:event_btnPokemon4ActionPerformed

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
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMain().setVisible(true);
            }
        });
    }
    // clase para obtener los pokemones
    public class GameOn extends Thread {
        public boolean run=false;
        public int bloqueado=0;
        public boolean isRun() {
            return run;
        }
        public void startRunning(){
            run=true;
        }
        public void stopRunning(){
            run=false;
        }
        @Override
        public void run() {
            Image img;
            while(bloqueado==1){
                while(run){
                    System.out.println("si entró");
                    try {
                        demosle.startRunning();
                        whoIsThatPokemon1 = dexter.buscarPokemon();
                        whoIsThatPokemon2 = dexter.buscarPokemon();
                        whoIsThatPokemon3 = dexter.buscarPokemon();
                        whoIsThatPokemon4 = dexter.buscarPokemon();
                        btnPokemon1.setText(whoIsThatPokemon1.getName());
                        btnPokemon2.setText(whoIsThatPokemon2.getName());
                        btnPokemon3.setText(whoIsThatPokemon3.getName());
                        btnPokemon4.setText(whoIsThatPokemon4.getName());
                        int cualquiera = (int) Math.floor(Math.random() * 4 + 1);
                        if(cualquiera ==1){
                            visor.mostrarSprites(whoIsThatPokemon1);
                            IsThisPokemon=whoIsThatPokemon1;
                        }
                        else if(cualquiera ==2){
                            visor.mostrarSprites(whoIsThatPokemon2);
                            IsThisPokemon=whoIsThatPokemon2;
                        }
                        else if(cualquiera ==3){
                            visor.mostrarSprites(whoIsThatPokemon3);
                            IsThisPokemon=whoIsThatPokemon3;
                        }
                        else{
                            visor.mostrarSprites(whoIsThatPokemon4);
                            IsThisPokemon=whoIsThatPokemon4;
                        }
                        btnJugar.setText("Jugar de nuevo");
                        
                       run=false;
                    } catch (IOException ex) {
                        Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    // clase para la hora del sistema. ¡No modificar!
    public class Reloj extends Thread {
        Calendar calendario;
        
        @Override
        public void run() {
            while (true) {
                String horaSistema = "";
                calendario = Calendar.getInstance();
                if (calendario.get(Calendar.HOUR_OF_DAY)<10)
                    horaSistema += String.valueOf("0"+calendario.get(Calendar.HOUR_OF_DAY)) + ":";
                else
                    horaSistema += String.valueOf(calendario.get(Calendar.HOUR_OF_DAY)) + ":";
                if (calendario.get(Calendar.MINUTE)<10)
                    horaSistema += String.valueOf("0"+calendario.get(Calendar.MINUTE)) + ":";
                else
                    horaSistema += String.valueOf(calendario.get(Calendar.MINUTE)) + ":";
                if (calendario.get(Calendar.SECOND)<10)
                    horaSistema += String.valueOf("0"+calendario.get(Calendar.SECOND)) + ":";
                else
                    horaSistema += String.valueOf(calendario.get(Calendar.SECOND)) + ":";
                horaSistema += String.valueOf(calendario.get(Calendar.MILLISECOND)) + " hrs";
                lblHoraSistema.setText(horaSistema);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJugar;
    private javax.swing.JButton btnPokemon1;
    private javax.swing.JButton btnPokemon2;
    private javax.swing.JButton btnPokemon3;
    private javax.swing.JButton btnPokemon4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblHoraSistema;
    private javax.swing.JLabel lblSprite;
    // End of variables declaration//GEN-END:variables
}
