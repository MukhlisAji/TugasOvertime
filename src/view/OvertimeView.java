/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controllers.OvertimeController;
import controllers.OvertimeControllerInterface;
import entities.Overtime;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author AD
 */
public class OvertimeView extends javax.swing.JInternalFrame {

    /**
     * Creates new form OvertimeView
     */
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    OvertimeControllerInterface oc = new OvertimeController(sessionFactory);

    public OvertimeView() {
        initComponents();
        Object overtime = oc.getAlls();
        bindingTable(oc.getAlls());
    }

//    public void feetot(int overtimes) {
//        Object overtime = overtimes;
//        Overtime o = (Overtime) overtime;
//
//        int hasil = 0;
//        Long esalary = Long.valueOf(o.getNik().getSalary());
//        hasil = esalary * 15 / 100;
//    }

    public void bindingTable(List<Object> overtimes) {
        Object[] header = {"No", "Overtime ID", "Date", "Duration", "Fee", "File", "Status"};
        DefaultTableModel data = new DefaultTableModel(null, header);
        tableOvertime.setModel(data);

        int no = 1;
        try {
            for (Object overtime : overtimes) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
                Overtime o = (Overtime) overtime;
                String isi1 = String.valueOf(no);
                String isi2 = String.valueOf(o.getOvertimeId());
                String isi3 = String.valueOf(sdf.format(o.getPresenceId().getPresenceDate()));
                String isi4 = String.valueOf(o.getOtDuration());
                String isi5 = String.valueOf(o.getFee());
                String isi6 = String.valueOf(o.getTsFile());
                String isi7 = String.valueOf(o.getStatus());

                String kolom[] = {isi1, isi2, isi3, isi4, isi5, isi6, isi7};
                data.addRow(kolom);
                no++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Oops! : " + e.getMessage());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tableOvertime = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jTextField1 = new javax.swing.JTextField();

        tableOvertime.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", "", ""
            }
        ));
        jScrollPane1.setViewportView(tableOvertime);
        if (tableOvertime.getColumnModel().getColumnCount() > 0) {
            tableOvertime.getColumnModel().getColumn(2).setResizable(false);
            tableOvertime.getColumnModel().getColumn(3).setResizable(false);
            tableOvertime.getColumnModel().getColumn(4).setResizable(false);
            tableOvertime.getColumnModel().getColumn(5).setResizable(false);
        }

        jButton1.setText("Upload");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JTable tableOvertime;
    // End of variables declaration//GEN-END:variables
}
