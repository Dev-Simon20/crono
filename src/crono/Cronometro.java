/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crono;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author jean
 */
public class Cronometro extends javax.swing.JFrame {
    
    private Timer tiempo;
    private int centesimaseg=0,segundos=0,minuto=0,hora=0;
    private ActionListener acciones= new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            centesimaseg++;
            if (centesimaseg==100) {
                segundos++;
                centesimaseg=0;                
            }
            if (segundos==60) {
                minuto++;
                segundos=0;
            }
            if (minuto==60) {
                hora++;
                minuto=0;
            }
            
            actualizarEtiquetaTiempo();
        }
        
        
    };
    
    
    public Cronometro() {
        initComponents();
        setLocationRelativeTo(null);
        tiempo =new Timer(10,acciones);//cada 10 milisegundo ocurre el evento accion, osea centesima de segundo comienza a sumar comenzando a correr el cronometro
   
    }
    private void actualizarEtiquetaTiempo(){
        String texto= (hora<=9?"0":"")+hora+":"+(minuto<=9?"0":"")+minuto+":"+(segundos<=9?"0":"")+segundos+":"+(centesimaseg<=9?"0":"")+centesimaseg;
        etiquetaTextoTiempo.setText(texto);
    
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        etiquetaReloj = new javax.swing.JLabel();
        etiquetaCronometro = new javax.swing.JLabel();
        etiquetaTextoTiempo = new javax.swing.JLabel();
        botonIniciar = new javax.swing.JButton();
        botonPausar = new javax.swing.JButton();
        botonDetener = new javax.swing.JButton();
        etiquetaFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cronometro");
        setResizable(false);

        Panel.setBackground(new java.awt.Color(204, 204, 204));
        Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etiquetaReloj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/rel.png"))); // NOI18N
        Panel.add(etiquetaReloj, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 150, 150));

        etiquetaCronometro.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        etiquetaCronometro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaCronometro.setText("Cronometro");
        Panel.add(etiquetaCronometro, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 320, 60));

        etiquetaTextoTiempo.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        etiquetaTextoTiempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaTextoTiempo.setText("00:00:00:00");
        Panel.add(etiquetaTextoTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 270, 80));

        botonIniciar.setBackground(new java.awt.Color(204, 255, 204));
        botonIniciar.setText("Iniciar");
        botonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIniciarActionPerformed(evt);
            }
        });
        Panel.add(botonIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 100, 30));

        botonPausar.setBackground(new java.awt.Color(204, 255, 204));
        botonPausar.setText("Pausar");
        botonPausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPausarActionPerformed(evt);
            }
        });
        Panel.add(botonPausar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 100, 30));

        botonDetener.setBackground(new java.awt.Color(204, 255, 204));
        botonDetener.setText("Detener");
        botonDetener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDetenerActionPerformed(evt);
            }
        });
        Panel.add(botonDetener, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, 100, 30));

        etiquetaFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pstaaa (1).jpg"))); // NOI18N
        Panel.add(etiquetaFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIniciarActionPerformed
       tiempo.start();
       botonIniciar.setEnabled(false);
       botonIniciar.setText("Reanudar");
       botonPausar.setEnabled(true);
       botonDetener.setEnabled(true);
       
    }//GEN-LAST:event_botonIniciarActionPerformed

    private void botonPausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPausarActionPerformed
      tiempo.stop();
     
      botonIniciar.setEnabled(true);
      botonPausar.setEnabled(false);
      
    }//GEN-LAST:event_botonPausarActionPerformed

    private void botonDetenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDetenerActionPerformed
        if (tiempo.isRunning()) {
                tiempo.stop();
                botonIniciar.setEnabled(true);
        }
        botonIniciar.setText("Iniciar");
        botonPausar.setEnabled(false);
        botonDetener.setEnabled(false);
        
        hora=0;
        minuto=0;
        segundos=0;
        centesimaseg=0;
        
        actualizarEtiquetaTiempo();
        
    }//GEN-LAST:event_botonDetenerActionPerformed

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
            java.util.logging.Logger.getLogger(Cronometro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cronometro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cronometro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cronometro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cronometro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JButton botonDetener;
    private javax.swing.JButton botonIniciar;
    private javax.swing.JButton botonPausar;
    private javax.swing.JLabel etiquetaCronometro;
    private javax.swing.JLabel etiquetaFondo;
    private javax.swing.JLabel etiquetaReloj;
    private javax.swing.JLabel etiquetaTextoTiempo;
    // End of variables declaration//GEN-END:variables
}
