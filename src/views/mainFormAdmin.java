/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Email.sendEmail;
import controllers.EmployeeController;
import controllers.EmployeeControllerInterface;
import controllers.OvertimeController;
import controllers.OvertimeControllerInterface;
import entities.Employee;
import entities.Overtime;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;


/**
 *
 * @author Mukhlish
 */
public class mainFormAdmin extends javax.swing.JFrame {

    SessionFactory factory = HibernateUtil.getSessionFactory();
    EmployeeControllerInterface eci = new EmployeeController(factory);
    OvertimeControllerInterface oci = new OvertimeController(factory);

    /**
     * Creates new form mainFormAdmin
     */
    public mainFormAdmin() {
        initComponents();
        Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();

        int x = layar.width / 2 - this.getSize().width / 2;
        int y = layar.height / 2 - this.getSize().height / 2;

        this.setLocation(x, y);

        PanelProfilManage.setVisible(true);
        PanelOvertimeData.setVisible(false);

        bindingTable(eci.search(txtSearch.getText()));
        BindingOvertime(oci.search(txtSearch.getText()));

        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);

    }

    private void bindingTable(List<Object> emp) {
        Object[] header = {"No", "NIK", "Name", "Email", "No Telp", "Hire Date", "Job Title", "Salary", "Manager", "Status", "isDelete"};
        DefaultTableModel data = new DefaultTableModel(null, header);
        tblEmployee.setModel(data);
        try {
            int no = 1;
            for (Object obj : emp) {
                Employee employee = (Employee) obj;
                String isi = String.valueOf(no);
                String isi1 = employee.getNik();
//                System.out.println(isi1);
                String isi2 = employee.getName();
                String isi3 = employee.getEmail();
                String isi4 = employee.getPhoneNumber();
                String isi5 = String.valueOf(employee.getHireDate());
                String isi6 = employee.getJobTitle();
                String isi7 = String.valueOf(employee.getSalary());
                String isi8 = employee.getManagerId();
                String isi9 = String.valueOf(employee.getStatus());
                String delete = String.valueOf(employee.getIsDelete());
                String status = "";
                if (delete.matches("0")) {
                    status = "aktif";
                } else {
                    status = "nnon aktif";
                }
                String isi10 = String.valueOf(status);

                String kolom[] = {isi, isi1, isi2, isi3, isi4, isi5, isi6, isi7, isi8, isi9, isi10};
                data.addRow(kolom);
                no++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Oops! : " + e.getMessage());
        }
    }
    
     public void BindingOvertime(List<Object> overtimes) {
        Object[] header = {"No", "Overtime_Id", "Name", "NIK", "Duration", "Fee", "Status", "Timesheet"};
        DefaultTableModel data = new DefaultTableModel(null, header);
        tblOvertime.setModel(data);
        int number = 1;

        try {
            for (Object overtime : overtimes) {
                Overtime o = (Overtime) overtime;
                String Number = String.valueOf(number);
                String Isi1 = String.valueOf(o.getOvertimeId());
                String Isi2 = String.valueOf(o.getNik().getName());
                String Isi3 = String.valueOf(o.getNik().getNik());
                String Isi4 = String.valueOf(o.getOtDuration());
                String Isi5 = String.valueOf(o.getFee());
                String status = String.valueOf(o.getStatus());
                if (status.matches("0")) {
                    status = "request";
                } else if (status.matches("1")) {
                    status = "Approved";
                } else if (status.matches("2")) {
                    status = "rejected";
                }
                String Isi6 = status;
                String Isi7 = String.valueOf(o.getTsFile());

                String kolom[] = {Number, Isi1, Isi2, Isi3, Isi4, Isi5, Isi6, Isi7};
                number++;
                data.addRow(kolom);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ckck" + e.getMessage());
        }
    }


    public void reset() {
        txtNIK.setText("");
        txtName.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
        txtJob.setText("");
        txtmanager.setText("");
//        txthiredate.("");
        txtSalary.setText("");
        cmbStatus.setSelectedItem("Pilih Status");
        btnUpdate.setEnabled(false);
        btnSave.setEnabled(true);
//        getDatas(daoi.doDDL("Employee", ""));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        PanelProfilManage = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployee = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        txtmanager = new javax.swing.JTextField();
        txtJob = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtNIK = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtSalary = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        hireDate = new org.jdesktop.swingx.JXDatePicker();
        cmbStatus = new javax.swing.JComboBox<>();
        PanelOvertimeData = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOvertime = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        profilManage = new javax.swing.JMenu();
        OvertimeData = new javax.swing.JMenu();
        LogoutAdmin = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.CardLayout());

        tblEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmployeeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmployee);

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        txtNIK.setEditable(false);
        txtNIK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNIKActionPerformed(evt);
            }
        });

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("NIK                         :");

        jLabel18.setText("Name                      :");

        jLabel19.setText("Email                       :");

        jLabel20.setText("Phone Number      :");

        jLabel21.setText("Hire date                : ");

        jLabel22.setText("Job Title                 : ");

        jLabel23.setText("Manager                :");

        jLabel24.setText("Status                   :");

        jLabel1.setText("Salary                    :");

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manager", "Employee", "Admin" }));

        javax.swing.GroupLayout PanelProfilManageLayout = new javax.swing.GroupLayout(PanelProfilManage);
        PanelProfilManage.setLayout(PanelProfilManageLayout);
        PanelProfilManageLayout.setHorizontalGroup(
            PanelProfilManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelProfilManageLayout.createSequentialGroup()
                .addGroup(PanelProfilManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelProfilManageLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(PanelProfilManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(PanelProfilManageLayout.createSequentialGroup()
                                .addGroup(PanelProfilManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PanelProfilManageLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelProfilManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelProfilManageLayout.createSequentialGroup()
                                            .addGap(1, 1, 1)
                                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                                        .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                                    .addGroup(PanelProfilManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(PanelProfilManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelProfilManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelProfilManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNIK, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtmanager, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(hireDate, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtJob, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbStatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelProfilManageLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelProfilManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        PanelProfilManageLayout.setVerticalGroup(
            PanelProfilManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelProfilManageLayout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(PanelProfilManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelProfilManageLayout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelProfilManageLayout.createSequentialGroup()
                        .addGroup(PanelProfilManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(txtNIK, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelProfilManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelProfilManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelProfilManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelProfilManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(hireDate, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelProfilManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(txtJob, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelProfilManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtmanager, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelProfilManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelProfilManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PanelProfilManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSave)
                            .addComponent(btnUpdate)
                            .addComponent(btnDelete)
                            .addComponent(btnReset))))
                .addGap(35, 35, 35))
        );

        jPanel1.add(PanelProfilManage, "card2");

        tblOvertime.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblOvertime);

        jLabel2.setText("Search by Date");

        jLabel3.setText("Search by NIK");

        javax.swing.GroupLayout PanelOvertimeDataLayout = new javax.swing.GroupLayout(PanelOvertimeData);
        PanelOvertimeData.setLayout(PanelOvertimeDataLayout);
        PanelOvertimeDataLayout.setHorizontalGroup(
            PanelOvertimeDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelOvertimeDataLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(532, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        PanelOvertimeDataLayout.setVerticalGroup(
            PanelOvertimeDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelOvertimeDataLayout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(PanelOvertimeDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(PanelOvertimeData, "card3");

        profilManage.setText("Profil Manage");
        profilManage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profilManageMouseClicked(evt);
            }
        });
        jMenuBar1.add(profilManage);

        OvertimeData.setText("Overtime");
        OvertimeData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OvertimeDataMouseClicked(evt);
            }
        });
        jMenuBar1.add(OvertimeData);

        LogoutAdmin.setText("Log Out");
        LogoutAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutAdminMouseClicked(evt);
            }
        });
        jMenuBar1.add(LogoutAdmin);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1032, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1032, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void profilManageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilManageMouseClicked
        PanelProfilManage.setVisible(true);
        PanelOvertimeData.setVisible(false);
    }//GEN-LAST:event_profilManageMouseClicked

    private void OvertimeDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OvertimeDataMouseClicked
        PanelProfilManage.setVisible(false);
        PanelOvertimeData.setVisible(true);
    }//GEN-LAST:event_OvertimeDataMouseClicked

    private void txtNIKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNIKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNIKActionPerformed

    private void tblEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmployeeMouseClicked
        btnSave.setEnabled(false);
        btnDelete.setEnabled(true);
        btnUpdate.setEnabled(true);
        int i = tblEmployee.getSelectedRow();
        TableModel model = tblEmployee.getModel();
        txtNIK.setText(model.getValueAt(i, 1).toString());
        txtName.setText(model.getValueAt(i, 2).toString());
        txtEmail.setText(model.getValueAt(i, 3).toString());
        txtPhone.setText(model.getValueAt(i, 4).toString());
        //hireDate.setDate((Date) model.getValueAt(i, 5));
        txtJob.setText(model.getValueAt(i, 6).toString());
        txtSalary.setText(model.getValueAt(i, 7).toString());
        txtmanager.setText(model.getValueAt(i, 8).toString());
    }//GEN-LAST:event_tblEmployeeMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        bindingTable(eci.search(txtSearch.getText()));
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        String nik = txtNIK.getText();

        String name = txtName.getText();
        String email = txtEmail.getText();
//        String password = txtpassword.getText();
        String password = "buat password baru";

        String phonenumber = txtPhone.getText();
        Date hiredate = hireDate.getDate();
        String dates = format.format(hiredate);
        String jobtitle = txtJob.getText();
        String salary = txtSalary.getText();
        String manager = txtmanager.getText();
        String status = (String) cmbStatus.getSelectedItem();
        String is_delete = "0";
        if (!nik.equals("") && !name.equals("")
                && !email.equals("")
                && !phonenumber.equals("")
                && !hiredate.equals("") && !jobtitle.equals("")
                && !salary.equals("") && !manager.equals("")
                && !status.equals("")) {
            if (eci.insert(name, email, password, phonenumber, dates, jobtitle, salary, manager, status, is_delete, nik)) {
                JOptionPane.showMessageDialog(null, "insert berhasil");
                //kosongData();
                bindingTable(eci.search(""));
//                txtnik.setEnabled(false);
                btnSave.setEnabled(false);
                reset();
                sendEmail e = new sendEmail();
                e.sent(true);
                //employeeid_field.setText(employeeController.lastId());
            } else {
                JOptionPane.showMessageDialog(null, "insert gagal");
            }

        } else {
            JOptionPane.showMessageDialog(null, "form input tidak boleh kosong");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        String nik = txtNIK.getText();
        String name = txtName.getText();
        String email = txtEmail.getText();
//        String password = txtpassword.getText();
        Employee employee = eci.getByNIK(nik);
        String password = employee.getPassword();
        System.out.println(password);

        String phonenumber = txtPhone.getText();
        Date hiredate = hireDate.getDate();
        String dates = format.format(hiredate);
        String jobtitle = txtJob.getText();
        String salary = txtSalary.getText();
        String manager = txtmanager.getText();
        String status = (String) cmbStatus.getSelectedItem();
        String is_delete = "0";
        if (!nik.equals("") && !name.equals("")
                && !email.equals("")
                && !phonenumber.equals("")
                && !hiredate.equals("") && !jobtitle.equals("")
                && !salary.equals("") && !manager.equals("")
                && !status.equals("")) {
            if (eci.update(name, email, password, phonenumber, dates, jobtitle, salary, manager, status, is_delete, nik)) {
                JOptionPane.showMessageDialog(null, "Update berhasil");
                //kosongData();
                String autiID = String.valueOf(eci.getAlls().size() + 14407);
                bindingTable(eci.search(""));
//                txtnik.setEnabled(false);
                btnSave.setEnabled(false);
                reset();
                //employeeid_field.setText(employeeController.lastId());
            } else {
                JOptionPane.showMessageDialog(null, "Update gagal");
            }

        } else {
            JOptionPane.showMessageDialog(null, "form input tidak boleh kosong");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        String nik = txtNIK.getText();

//        String password = txtpassword.getText();
        Employee employee = eci.getByNIK(nik);
        String password = employee.getPassword();
//        System.out.println(password);
        String name = employee.getName();
        String email = employee.getEmail();
        String phonenumber = employee.getPhoneNumber();
//        System.out.println(phonenumber);

        String dates = format.format(employee.getHireDate());
        System.out.println(dates);
        String jobtitle = employee.getJobTitle();
        String salary = String.valueOf(employee.getSalary());
        String manager = employee.getManagerId();
        String status = employee.getStatus();
        String is_delete = "1";

        int option;
        JDialog.setDefaultLookAndFeelDecorated(true);
        option = JOptionPane.showConfirmDialog(null, "Confirm delete !",
                "Warning", JOptionPane.YES_NO_OPTION);
        
        
        
        if (option == JOptionPane.YES_OPTION) {
            if (eci.update(name, email, password, phonenumber, dates, jobtitle, salary, manager, status, is_delete, nik)) {
            JOptionPane.showMessageDialog(null, "Delete berhasil");
            String autiID = String.valueOf(eci.getAlls().size() + 14407);
            //kosongData();
            bindingTable(eci.search(""));
//                txtnik.setEnabled(false);
            btnSave.setEnabled(false);
            reset();
            //employeeid_field.setText(employeeController.lastId());
        } else {
            JOptionPane.showMessageDialog(null, "Delete gagal");
        }

        } else if (option == JOptionPane.NO_OPTION) {


        }


    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        String autiID = String.valueOf(eci.getAlls().size() + 14407);
        reset();
        txtNIK.setText(autiID);
        txtNIK.setEnabled(false);
        btnDelete.setEnabled(false);
    }//GEN-LAST:event_btnResetActionPerformed

    private void LogoutAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutAdminMouseClicked
        int dialogButton = 0;
        int dialog = JOptionPane.showConfirmDialog(null, "Apakah anda ingin Logout ?", "Warning", dialogButton);
        if (dialog == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            LoginForm loginForm = new LoginForm();
            loginForm.show();
        } else {
        }
    }//GEN-LAST:event_LogoutAdminMouseClicked

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
            java.util.logging.Logger.getLogger(mainFormAdmin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainFormAdmin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainFormAdmin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFormAdmin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainFormAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu LogoutAdmin;
    private javax.swing.JMenu OvertimeData;
    private javax.swing.JPanel PanelOvertimeData;
    private javax.swing.JPanel PanelProfilManage;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbStatus;
    private org.jdesktop.swingx.JXDatePicker hireDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JMenu profilManage;
    private javax.swing.JTable tblEmployee;
    private javax.swing.JTable tblOvertime;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtJob;
    private javax.swing.JTextField txtNIK;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSalary;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtmanager;
    // End of variables declaration//GEN-END:variables
}
