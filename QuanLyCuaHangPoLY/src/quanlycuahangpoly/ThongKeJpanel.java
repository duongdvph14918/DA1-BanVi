/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package quanlycuahangpoly;

import Hepper.Auth;
import Model.TKDoanhThu_View;
import Model.TKSanPham_View;
import Model.TKTongQuan_View;
import Service.ITKDoanhThu_service;
import Service.ITKSanPham_Service;
import Service.ITKTongQuan_Service;
import Service.TKDoanhThu_Service;
import Service.TKSanPham_Service;
import Service.TKTongQuan_service;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JPanel;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Windows
 */
public class ThongKeJpanel extends javax.swing.JPanel {

    SimpleDateFormat dateFM = new SimpleDateFormat("yyyy-MM-dd");
    private JPanel panel;
    DefaultTableModel mol;
    ITKSanPham_Service tkSP_sv = new TKSanPham_Service();
    ITKTongQuan_Service tkTQ_Service = new TKTongQuan_service();
    ITKDoanhThu_service tKDoanhThu_service = new TKDoanhThu_Service();
    List<TKDoanhThu_View> listDoanhThuThang;
    List<TKSanPham_View> listTkSP;
    NumberFormat numberFM = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
    public String ketthuc = "", batDau = "";

    /**
     * Creates new form ThongKeJpanel
     */
    public ThongKeJpanel() {
        initComponents();
        testbarchar(2024);
        filltblTKSP();
        txtBatDau.setEnabled(false);
        txtKetThuc.setEnabled(false);
        btnTK.setEnabled(false);
        TKTongQuan_View tk = tkTQ_Service.tkHomNay();
        fillTKTongQuan(tk.getDonHang(), tk.getSanPham(), tk.getDoanhthu());
        init();
    }

    private void init() {

        if (Auth.isManager() == false) {
            jTabbedPane1.removeAll();
            pnlLoaiThoiGian.removeAll();
            cboLoaiTG.setEnabled(false);
        } else {
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbdonhang = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblsanpham = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbldoanhthu = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cboLoaiTG = new javax.swing.JComboBox<>();
        pnlLoaiThoiGian = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtBatDau = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        txtKetThuc = new com.toedter.calendar.JDateChooser();
        btnTK = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        tabDoanhThu = new javax.swing.JTabbedPane();
        pnlBieuDo = new javax.swing.JPanel();
        cboNam = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_TKSP = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.red));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setAlignmentX(1.0F);
        jPanel2.setAlignmentY(1.0F);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Đơn Hàng");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Đơn hàng :");

        lbdonhang.setForeground(new java.awt.Color(255, 255, 255));
        lbdonhang.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(lbdonhang))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel1)))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbdonhang))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.red));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setAlignmentX(1.0F);
        jPanel3.setAlignmentY(1.0F);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Sản Phẩm");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Sản Phẩm :");

        lblsanpham.setForeground(new java.awt.Color(255, 255, 255));
        lblsanpham.setText("10");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(lblsanpham))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblsanpham))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(51, 204, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.red));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Doanh Thu");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Doanh thu :");

        lbldoanhthu.setForeground(new java.awt.Color(255, 255, 255));
        lbldoanhthu.setText("0 VND");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(lbldoanhthu)
                .addContainerGap(135, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(90, 90, 90))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel7)
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lbldoanhthu))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Thời Gian :");

        cboLoaiTG.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hôm nay", "Theo Ngay" }));
        cboLoaiTG.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboLoaiTGItemStateChanged(evt);
            }
        });
        cboLoaiTG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLoaiTGActionPerformed(evt);
            }
        });

        pnlLoaiThoiGian.setBackground(new java.awt.Color(255, 255, 255));
        pnlLoaiThoiGian.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.red));

        jLabel3.setText("Ngày bắt đầu");

        jLabel6.setText("Ngày Kết Thúc");

        btnTK.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTK.setText("Tìm Kiếm");
        btnTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLoaiThoiGianLayout = new javax.swing.GroupLayout(pnlLoaiThoiGian);
        pnlLoaiThoiGian.setLayout(pnlLoaiThoiGianLayout);
        pnlLoaiThoiGianLayout.setHorizontalGroup(
            pnlLoaiThoiGianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoaiThoiGianLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel6)
                .addGap(26, 26, 26)
                .addComponent(txtKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(btnTK)
                .addGap(18, 18, 18))
        );
        pnlLoaiThoiGianLayout.setVerticalGroup(
            pnlLoaiThoiGianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLoaiThoiGianLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(pnlLoaiThoiGianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTK)
                    .addGroup(pnlLoaiThoiGianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(txtBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(11, 11, 11))
        );

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabDoanhThu.setBackground(new java.awt.Color(255, 255, 255));
        tabDoanhThu.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tabDoanhThu.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tabDoanhThu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabDoanhThuMouseClicked(evt);
            }
        });

        pnlBieuDo.setBackground(new java.awt.Color(255, 255, 255));
        pnlBieuDo.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.red));
        pnlBieuDo.setLayout(new java.awt.BorderLayout());
        tabDoanhThu.addTab("Biểu Đồ", pnlBieuDo);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabDoanhThu)
        );

        cboNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2024", "2025" }));
        cboNam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboNamMouseClicked(evt);
            }
        });
        cboNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNamActionPerformed(evt);
            }
        });

        jLabel9.setText("Năm");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Doanh Thu", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        tbl_TKSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "Hoá Đơn Chi Tiết", "Tên Sản Phẩm", "Thương Hiệu", "Nhà Sản Xuất", "Chất Liệu", "Loại Ví", "Số Lượng Bán"
            }
        ));
        jScrollPane1.setViewportView(tbl_TKSP);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1097, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sản Phẩm", jPanel6);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboLoaiTG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                        .addComponent(pnlLoaiThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(191, 191, 191))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1097, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(pnlLoaiThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboLoaiTG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboLoaiTGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLoaiTGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboLoaiTGActionPerformed

    private void cboLoaiTGItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboLoaiTGItemStateChanged
        // TODO add your handling code here:
        if (cboLoaiTG.getItemCount() > 0) {
            if (cboLoaiTG.getItemCount() == 0) {
                TKTongQuan_View tk = tkTQ_Service.tkHomNay();
                txtBatDau.setEnabled(false);
                txtKetThuc.setEnabled(false);
                btnTK.setEnabled(false);
                fillTKTongQuan(tk.getDonHang(), tk.getSanPham(), tk.getDoanhthu());
            } else {
                pnlLoaiThoiGian.setEnabled(true);
                txtBatDau.setEnabled(true);
                txtKetThuc.setEnabled(true);
                btnTK.setEnabled(true);
            }
        }
    }//GEN-LAST:event_cboLoaiTGItemStateChanged

    private void btnTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTKActionPerformed
        // TODO add your handling code here:
        // tim kiem
        TKTongQuan_View tkTQ = tkTQ_Service.tkTheoNgay(dateFM.format(txtBatDau.getDate()), dateFM.format(txtKetThuc.getDate()));
        ketthuc = dateFM.format(txtBatDau.getDate());
        batDau = dateFM.format(txtKetThuc.getDate());
        fillTKTongQuan(tkTQ.getDonHang(), tkTQ.getSanPham(), tkTQ.getDoanhthu());
    }//GEN-LAST:event_btnTKActionPerformed

    private void cboNamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboNamMouseClicked
        // TODO add your handling code here:
        filltblTKSP();
        testbarchar(Integer.parseInt(cboNam.getSelectedItem().toString()));
    }//GEN-LAST:event_cboNamMouseClicked

    private void cboNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNamActionPerformed
        // TODO add your handling code here:
        filltblTKSP();
        testbarchar(Integer.parseInt(cboNam.getSelectedItem().toString()));
    }//GEN-LAST:event_cboNamActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
        filltblTKSP();
        testbarchar(Integer.parseInt(cboNam.getSelectedItem().toString()));
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        if (jTabbedPane1.getSelectedIndex() == 0) {
            filltblTKSP();
        }
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void tabDoanhThuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabDoanhThuMouseClicked
        // TODO add your handling code here:
        if (tabDoanhThu.getSelectedIndex() == 1) {
            testbarchar(Integer.parseInt(cboNam.getSelectedItem().toString()));
        }
    }//GEN-LAST:event_tabDoanhThuMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTK;
    private javax.swing.JComboBox<String> cboLoaiTG;
    private javax.swing.JComboBox<String> cboNam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbdonhang;
    private javax.swing.JLabel lbldoanhthu;
    private javax.swing.JLabel lblsanpham;
    private javax.swing.JPanel pnlBieuDo;
    private javax.swing.JPanel pnlLoaiThoiGian;
    private javax.swing.JTabbedPane tabDoanhThu;
    private javax.swing.JTable tbl_TKSP;
    private com.toedter.calendar.JDateChooser txtBatDau;
    private com.toedter.calendar.JDateChooser txtKetThuc;
    // End of variables declaration//GEN-END:variables

    public void testbarchar(int nam) {
        listDoanhThuThang = tKDoanhThu_service.getTKDoanhThu(nam);
        DefaultCategoryDataset dbSet = new DefaultCategoryDataset();
        for (TKDoanhThu_View t : listDoanhThuThang) {
            dbSet.setValue(t.getTongDoanhThu(), "Doanh Thu", t.getThang() + "");
        }
        JFreeChart Barchar = ChartFactory.createBarChart("Doanh Thu Theo Năm", "Thang", "Doanh Thu", dbSet, PlotOrientation.VERTICAL, false, false, false);
        ChartPanel chartPanel = new ChartPanel(Barchar);
        chartPanel.setPreferredSize(new java.awt.Dimension(150, 150));
        pnlBieuDo.removeAll();
        pnlBieuDo.add(chartPanel);

    }

    private void fillTKTongQuan(int donHang, int sanPham, float doanhthu) {
        lbldoanhthu.setText(numberFM.format(doanhthu));
        lbdonhang.setText(donHang + "");
        lblsanpham.setText(sanPham + "");
    }

    public void filltblTKSP() {
        listTkSP = tkSP_sv.getTKSanPham();
        mol = (DefaultTableModel) tbl_TKSP.getModel();
        mol.setRowCount(0);
        for (TKSanPham_View t : listTkSP) {
            mol.addRow(new Object[]{t.getMaSP(), t.getMachitiet(), t.getTen(), t.getThuonghieu(), t.getNhasanxuat(), t.getChatlieu(), t.getLoaivi(), t.getSlBan()});
        }
    }
}
