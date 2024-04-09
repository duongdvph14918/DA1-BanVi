/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package quanlycuahangpoly;

import Hepper.Auth;
import Hepper.MsgBox;
import Hepper.Xdate;
import Model.KhuyenMai;
import Repository.KhuyenMaiRepository;
import Service.KhuyenMaiService;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Windows
 */
public class KhuyenMaiJPanel extends javax.swing.JPanel {

    KhuyenMaiService kms = new KhuyenMaiService();
    KhuyenMaiRepository kmr = new KhuyenMaiRepository();
    DefaultTableModel dtm = new DefaultTableModel();

    /**
     * Creates new form KhuyenMaiJPanel
     */
    public KhuyenMaiJPanel() {
        initComponents();
        dtm = (DefaultTableModel) tableKM.getModel();
        ButtonGroup bG = new ButtonGroup();
        bG.add(hd);
        bG.add(nhd);
        fillTable();
        this.init();
    }
    private void init(){
                if (Auth.isManager() == false) {
            btDelete.setVisible(false);
            btSave.setVisible(false);
            btUpdate.setVisible(false);
           

        } else {
         btDelete.setVisible(true);
            btSave.setVisible(true);
            btUpdate.setVisible(true);
        }
    }
    private int currentPage = 1;
    private int recordsPerPage = 10;

    public void nextPage() {
        int totalRecords = kmr.getTotal();
        int totalPages = (int) Math.ceil((double) totalRecords / recordsPerPage);

        if (currentPage < totalPages) {
            currentPage++;
            fillTable();
        }
    }

    public void prevPage() {
        if (currentPage > 1) {
            currentPage--;
            fillTable();
        }
    }

    public void goToLastPage() {
        int totalRecords = kmr.getTotal();
        int totalPages = (int) Math.ceil((double) totalRecords / recordsPerPage);

        if (currentPage < totalPages) {
            currentPage = totalPages;
            fillTable();
        }
    }

    public void goToFirstPage() {
        if (currentPage > 1) {
            currentPage = 1;
            fillTable();
        }
    }

    private void fillTable() {
        List<Model.KhuyenMai> listKM;
        DefaultTableModel mol;
        listKM = kmr.getAll();
        mol = (DefaultTableModel) tableKM.getModel();
        mol.setRowCount(0);
        for (Model.KhuyenMai km : listKM) {
            mol.addRow(new Object[]{
                km.getMa(),
                km.getNgayBatDau(),
                km.getNgayKetThuc(),
                km.getGiaTri(),
                km.isTrangThai() ? "Còn hoạt động" : "Ngừng hoạt động"
            });
        }
        int totalPages = (int) Math.ceil((double) kmr.getTotal() / recordsPerPage);
        pageLabel.setText("Trang: " + currentPage + " / " + totalPages);
    }

    public void show(KhuyenMai km) {
        txtMa.setText(km.getMa());
        txtGiaTri.setText(km.getGiaTri() + "");
        dateBatDau.setDate(km.getNgayBatDau());
        dateKetThuc.setDate(km.getNgayKetThuc());
        if (km.isTrangThai() == true) {
            hd.setSelected(true);
        } else {
            nhd.setSelected(true);
        }
    }

    private KhuyenMai getInformation() {
        KhuyenMai km = new KhuyenMai();
        km.setMa(txtMa.getText());
        km.setGiaTri(Integer.parseInt(txtGiaTri.getText()));
        km.setNgayBatDau(Xdate.toDate(Xdate.toString(dateBatDau.getDate(), "yyyy-MM-dd"), "yyyy-MM-dd"));
        km.setNgayKetThuc(Xdate.toDate(Xdate.toString(dateKetThuc.getDate(), "yyyy-MM-dd"), "yyyy-MM-dd"));
        km.setTrangThai(hd.isSelected());
        return km;
    }

    private KhuyenMai setForm() {
        KhuyenMai km = new KhuyenMai();
        km.setMa(txtMa.getText());
        km.setGiaTri(Integer.parseInt(txtGiaTri.getText()));
        km.setNgayBatDau(Xdate.toDate(Xdate.toString(dateBatDau.getDate(), "yyyy-MM-dd"), "yyyy-MM-dd"));
        km.setNgayKetThuc(Xdate.toDate(Xdate.toString(dateKetThuc.getDate(), "yyyy-MM-dd"), "yyyy-MM-dd"));
        km.setTrangThai(hd.isSelected());
        return km;
    }

    void delete() {
        int chooser = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không ?");
        if (chooser == JOptionPane.YES_OPTION) {
            try {
                String ma = txtMa.getText();
                kmr.delete(ma);
                fillTable();
                JOptionPane.showMessageDialog(this, "Xóa thành công !");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Xóa thất bại !");
                e.printStackTrace();
            }
        }
    }

    void update() {
        if(number()){
            return;
        }
        else{
        try {

            kms.update(getInformation());
            fillTable();
            JOptionPane.showMessageDialog(this, "Update thành công!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Update thất bại!");
            e.printStackTrace();
        }
        }
    }

    void insert() {
        if (validateFormKM()) {
            return;
        } else if (number()) {
            return;
        } else {
            try {

                kms.insert(getInformation());
                fillTable();
                JOptionPane.showMessageDialog(this, "Thêm thành công!");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Thêm thất bại!");
                e.printStackTrace();
            }
        }
    }

    private boolean number() {
        if (Integer.parseInt(txtGiaTri.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Giá không được nhập âm ");
            txtGiaTri.requestFocus();
            return true;
        }
        if (Integer.parseInt(txtGiaTri.getText()) >= 100) {
            JOptionPane.showMessageDialog(this, "Giá không được nhập quá 100%");
            txtGiaTri.requestFocus();
            return true;
        }        

        return false;
    }

    private boolean validateFormKM() {
        if (txtMa.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui long nhap ma khuyen mai");
            return true;
        }

        if (dateBatDau.getDate().equals("")) {
            dateBatDau.requestFocus();
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Ngày bat dau");
            return true;
        }

        if (dateKetThuc.getDate().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Ngày ket thuc");
            return true;
        }
        List<KhuyenMai> list = kmr.getAll();
        String id = txtMa.getText();

        for (int i = 0; i < list.size(); i++) {
            if (id.equalsIgnoreCase(list.get(i).getMa())) {
                JOptionPane.showMessageDialog(this, "Mã khuyến mãi đã tồn tại");
                txtMa.requestFocus();
                return true;
            }
        }

        if (txtGiaTri.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mức giảm giá");
            txtGiaTri.requestFocus();
            return true;
        }
        return false;
    }

    private boolean check() {
        Date a = dateBatDau.getDate();
        Date b = dateKetThuc.getDate();
        if (a.getTime() > b.getTime()) {
            MsgBox.alert(this, "Ngày kết thúc phải nhỏ hơn ngày bắt đầu");
            return false;
        }
        return true;
    }
    public static boolean isInt(JTextField txt,String mess){
        try {
            int testInt = Integer.parseInt(txt.getText());
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, mess,"Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    public  void searchKM(){
        String search = txtSearch.getText();
        TableRowSorter<DefaultTableModel> km = new TableRowSorter<>(dtm);
        tableKM.setRowSorter(km);
        km.setRowFilter(javax.swing.RowFilter.regexFilter(search));
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableKM = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLastPage = new javax.swing.JButton();
        pageLabel = new javax.swing.JLabel();
        btnFirstPage = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtGiaTri = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dateBatDau = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        dateKetThuc = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        hd = new javax.swing.JRadioButton();
        nhd = new javax.swing.JRadioButton();
        btSave = new javax.swing.JButton();
        btUpdate = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách khuyến mại", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        tableKM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã KM", "Ngày bắt đầu", "Ngày kết thúc", "Giá trị", "Trạng thái"
            }
        ));
        tableKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableKMMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableKM);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Tìm Kiếm :");

        txtSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        btnPrev.setText("<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setText(">");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLastPage.setText(">|");
        btnLastPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastPageActionPerformed(evt);
            }
        });

        pageLabel.setText("jLabel7");

        btnFirstPage.setText("|<");
        btnFirstPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstPageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFirstPage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(pageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLastPage)
                .addGap(33, 33, 33))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPrev)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNext)
                        .addComponent(btnLastPage)
                        .addComponent(pageLabel)
                        .addComponent(btnFirstPage)))
                .addGap(15, 15, 15))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Mã KM :");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Mức giảm giá :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Thời gian bắt đầu :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Thời gian kết thúc :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Trạng thái :");

        hd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        hd.setText("Hoạt động");

        nhd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nhd.setText("Ngừng hoạt động");

        btSave.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btSave.setText("Lưu");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });

        btUpdate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btUpdate.setText("Cập nhật");
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateActionPerformed(evt);
            }
        });

        btDelete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btDelete.setText("Xóa");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(346, 346, 346)
                                        .addComponent(btSave))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(168, 168, 168)
                                        .addComponent(dateBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btUpdate)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btDelete))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(hd)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(nhd))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtGiaTri, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addComponent(jLabel4)))
                                .addGap(18, 18, 18)
                                .addComponent(dateKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dateBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txtGiaTri, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addComponent(dateKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(hd)
                            .addComponent(nhd))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btSave)
                            .addComponent(btUpdate)
                            .addComponent(btDelete))
                        .addGap(9, 9, 9)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void tableKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKMMouseClicked
        // TODO add your handling code here:
int index = tableKM.getSelectedRow();
KhuyenMai km = kmr.getById(tableKM.getValueAt(index, 0).toString());
        show(km);
    }//GEN-LAST:event_tableKMMouseClicked

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        this.searchKM();
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        this.prevPage();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        this.nextPage();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastPageActionPerformed
        // TODO add your handling code here:
        this.goToLastPage();
    }//GEN-LAST:event_btnLastPageActionPerformed

    private void btnFirstPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstPageActionPerformed
        // TODO add your handling code here:
        this.goToFirstPage();
    }//GEN-LAST:event_btnFirstPageActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        // TODO add your handling code here:
        // them
        if (check()) {
            this.insert();
        }
    }//GEN-LAST:event_btSaveActionPerformed

    private void btUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateActionPerformed
        // TODO add your handling code here:
        //xua
        if (check()) {
            this.update();
        }
    }//GEN-LAST:event_btUpdateActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        // TODO add your handling code here:
        //xoa
        this.delete();
    }//GEN-LAST:event_btDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btSave;
    private javax.swing.JButton btUpdate;
    private javax.swing.JButton btnFirstPage;
    private javax.swing.JButton btnLastPage;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private com.toedter.calendar.JDateChooser dateBatDau;
    private com.toedter.calendar.JDateChooser dateKetThuc;
    private javax.swing.JRadioButton hd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton nhd;
    private javax.swing.JLabel pageLabel;
    private javax.swing.JTable tableKM;
    private javax.swing.JTextField txtGiaTri;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
