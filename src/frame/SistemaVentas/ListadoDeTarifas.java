/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame.SistemaVentas;


import com.placeholder.PlaceHolder;

/**
 *
 * @author CARLOS
 */
public class ListadoDeTarifas extends javax.swing.JInternalFrame {

    /**
     * Creates new form ListadoDeTrabajadores
     */
    public ListadoDeTarifas() {
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
        tablaTarifa = new javax.swing.JTable();
        busquedaSemana = new javax.swing.JTextField();
        PlaceHolder texto = new PlaceHolder(busquedaSemana, "Nº Semana");
        busquedaPrecio = new javax.swing.JTextField();
        PlaceHolder texto2 = new PlaceHolder(busquedaPrecio, "Precio");
        busquedaFechas = new javax.swing.JTextField();
        PlaceHolder texto3 = new PlaceHolder(busquedaFechas, "Fechas");

        setMinimumSize(new java.awt.Dimension(623, 480));
        setPreferredSize(new java.awt.Dimension(623, 480));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaTarifa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nº Semana", "Precio", "Fechas"
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
        jScrollPane1.setViewportView(tablaTarifa);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 111, 510, 260));
        getContentPane().add(busquedaSemana, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 156, 25));
        getContentPane().add(busquedaPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 70, 150, 25));
        getContentPane().add(busquedaFechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 70, 150, 25));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField busquedaFechas;
    private javax.swing.JTextField busquedaPrecio;
    private javax.swing.JTextField busquedaSemana;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaTarifa;
    // End of variables declaration//GEN-END:variables
}
