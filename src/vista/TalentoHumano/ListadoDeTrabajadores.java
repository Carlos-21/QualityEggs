/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.TalentoHumano;

import com.placeholder.PlaceHolder;

/**
 *
 * @author CARLOS
 */
public class ListadoDeTrabajadores extends javax.swing.JInternalFrame {

    /**
     * Creates new form ListadoDeTrabajadores
     */
    public ListadoDeTrabajadores() {
        initComponents();
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTrabajadores = new javax.swing.JTable();
        busquedaDNI = new javax.swing.JTextField();
        PlaceHolder texto = new PlaceHolder(busquedaDNI, "DNI");
        busquedaNombre = new javax.swing.JTextField();
        PlaceHolder texto2 = new PlaceHolder(busquedaNombre, "Nombre");
        busquedaCargo = new javax.swing.JTextField();
        PlaceHolder texto3 = new PlaceHolder(busquedaCargo, "Cargo");

        setPreferredSize(new java.awt.Dimension(500, 471));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaTrabajadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "DNI", "Nombre", "Cargo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaTrabajadores);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 111, 388, 231));
        getContentPane().add(busquedaDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 110, -1));
        getContentPane().add(busquedaNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 110, -1));
        getContentPane().add(busquedaCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 120, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField busquedaCargo;
    private javax.swing.JTextField busquedaDNI;
    private javax.swing.JTextField busquedaNombre;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaTrabajadores;
    // End of variables declaration//GEN-END:variables
}