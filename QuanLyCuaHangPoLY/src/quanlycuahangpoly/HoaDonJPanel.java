/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package quanlycuahangpoly;

//import Model.HoaDonCT;
//import Model.HoaDonCT1;
//import Service.HoaDonDAO;
import Model.HoaDonCT;
import Model.HoaDonCT1;
import Service.HoaDonDAO;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KIPOSTEST
 */
public class HoaDonJPanel extends javax.swing.JPanel {

    DefaultTableModel mol = new DefaultTableModel();
    HoaDonDAO service = new HoaDonDAO();
    int index = -1;
    int row;
    String maHD;
    public HoaDonJPanel() {
        initComponents();
        fillTable(service.timKiem(txt_timKiem.getText()));

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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_timKiem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_HoaDon = new javax.swing.JTable();
        btnTimKiem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_hoaDonCT = new javax.swing.JTable();
        pageLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnExport = new javax.swing.JButton();
        btnFirstPage = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLastPage = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("HOÁ ĐƠN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setText("Tìm kiếm hóa đơn");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 91, 151, -1));

        txt_timKiem.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timKiemActionPerformed(evt);
            }
        });
        txt_timKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_timKiemKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_timKiemKeyReleased(evt);
            }
        });
        jPanel1.add(txt_timKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 83, 275, 29));

        tbl_HoaDon.setAutoCreateRowSorter(true);
        tbl_HoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Hóa Đơn", "Tên Khách Hàng", "Tên Nhân Viên", "Tổng Tiền", "Phương Thức Thanh Toán", "Ngày Thanh Toán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_HoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_HoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_HoaDon);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 1070, 170));

        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        jPanel1.add(btnTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 83, -1, -1));

        tbl_hoaDonCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã HĐCT", "Mã Ví", "Tên Ví", "Số Lượng", "Tổng Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_hoaDonCT);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 1070, 170));
        jPanel1.add(pageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 260, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("Hóa Đơn");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel5.setText("Hóa Đơn Chi Tiết");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnExport.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExport.setText("Export PDF");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });
        jPanel2.add(btnExport);

        btnFirstPage.setText("|<");
        btnFirstPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstPageActionPerformed(evt);
            }
        });
        jPanel2.add(btnFirstPage);

        btnPrev.setText("<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });
        jPanel2.add(btnPrev);

        btnNext.setText(">");
        jPanel2.add(btnNext);

        btnLastPage.setText(">|");
        jPanel2.add(btnLastPage);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 590, 60));

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
//                filterHoaDon();
        this.fillTable(service.timKiem(txt_timKiem.getText()));
                String keySearch = txt_timKiem.getText();

    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tbl_HoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_HoaDonMouseClicked
        // Hiện hóa đơn chi tiết
                this.showHDCT();
    }//GEN-LAST:event_tbl_HoaDonMouseClicked

    private void txt_timKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timKiemKeyReleased
        // Tìm kiếm
//                this.fillTable(service.timKiem(txt_timKiem.getText()));
    }//GEN-LAST:event_txt_timKiemKeyReleased

    private void txt_timKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timKiemKeyPressed

    }//GEN-LAST:event_txt_timKiemKeyPressed

    private void txt_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_timKiemActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        // TODO add your handling code here:
        printToPDF();
    }//GEN-LAST:event_btnExportActionPerformed

    private void btnFirstPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstPageActionPerformed
        // TODO add your handling code here:
        row = 0;
        tbl_HoaDon.setRowSelectionInterval(row, row);
        fillTable(service.timKiem(txt_timKiem.getText()));
    }//GEN-LAST:event_btnFirstPageActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
         if (row > 0) {
                row--;
                tbl_HoaDon.setRowSelectionInterval(row, row);
                fillTable(service.timKiem(txt_timKiem.getText()));
            }
    }//GEN-LAST:event_btnPrevActionPerformed

    private void printToPDF() {
        int selectedRow = tbl_HoaDon.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một hóa đơn để in!");
            return;
        }

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn nơi lưu file PDF");

        FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF Files", "pdf");
        fileChooser.setFileFilter(filter);

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            try {
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                if (!filePath.toLowerCase().endsWith(".pdf")) {
                    filePath += ".pdf";
                }

                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream(filePath));
                document.open();

                // Thêm thông tin hóa đơn vào PDF
                for (int j = 0; j < tbl_HoaDon.getColumnCount(); j++) {
                    String label = tbl_HoaDon.getColumnName(j) + ": ";
                    String value = tbl_HoaDon.getValueAt(selectedRow, j).toString();

                    Font font = FontFactory.getFont(FontFactory.TIMES, 12); // Set font chữ là "Times New Roman" với kích thước 12
                    Paragraph paragraph = new Paragraph(label + value, font);

                    document.add(paragraph);
                }

                // Kiểm tra xem tbl_HoaDonCT có được chọn hay không
                // Thêm bảng hóa đơn chi tiết vào PDF
                PdfPTable detailTable = new PdfPTable(tbl_hoaDonCT.getColumnCount());
                for (int i = 0; i < tbl_hoaDonCT.getColumnCount(); i++) {
                    detailTable.addCell(new PdfPCell(new Phrase(tbl_hoaDonCT.getColumnName(i))));
                }
                for (int i = 0; i < tbl_hoaDonCT.getRowCount(); i++) {
                    for (int j = 0; j < tbl_hoaDonCT.getColumnCount(); j++) {
                        detailTable.addCell(tbl_hoaDonCT.getValueAt(i, j).toString());
                    }
                }
                document.add(detailTable);

                document.close();

                JOptionPane.showMessageDialog(this, "Thông tin đã được in vào file PDF!");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnFirstPage;
    private javax.swing.JButton btnLastPage;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel pageLabel;
    private javax.swing.JTable tbl_HoaDon;
    private javax.swing.JTable tbl_hoaDonCT;
    private javax.swing.JTextField txt_timKiem;
    // End of variables declaration//GEN-END:variables

    private void fillTablett(List<HoaDonCT> list) {
        mol = (DefaultTableModel) tbl_HoaDon.getModel();
        mol.setRowCount(0);
        for (HoaDonCT x : list) {
            if (x.getThanhTien() != 0) {
                mol.addRow(new Object[]{
                    x.getMaHD(),
                    x.getTenKH(),
                    x.getTenNV(),
                    x.getThanhTien(),
                    x.getPTTT(),
                    x.getNgayTT(),});
            }
        }
    }
    
    
//bỏ qua
//    private void filterHoaDon() {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//        // Lấy giá trị từ JDateChooser
//        Date startDate = cbNgayBatDau.getDate();
//        Date endDate = cbNgayKetThuc.getDate();
//
//        // Kiểm tra xem cả cbNgayBatDau và cbNgayKetThuc có giá trị null không
//        if (startDate != null || endDate != null) {
//            String startDateStr = (startDate != null) ? simpleDateFormat.format(startDate) : null;
//            String endDateStr = (endDate != null) ? simpleDateFormat.format(endDate) : null;
//            String keySearch = txt_timKiem.getText();
//            Integer payMethod = cbo_HinhThucThanhToan.getSelectedIndex();
//
//            // Xử lý khi giá trị payMethod là 0, tức là tìm kiếm theo tất cả
//            if (payMethod == 0) {
//                // Gọi phương thức filterHoaDon từ service với thêm các thông tin tìm kiếm và phân trang
//                List<HoaDonCT> hoaDons = service.filterHoaDon(startDateStr, endDateStr, keySearch, null, currentPage, recordsPerPage);
//
//                fillTable(hoaDons);
//
//            } else if (payMethod == 1 || payMethod == 2) {
//                // Gọi phương thức filterHoaDon từ service với thêm các thông tin tìm kiếm, phân trang, và hình thức thanh toán
//                List<HoaDonCT> hoaDons = service.filterHoaDon(startDateStr, endDateStr, keySearch, payMethod - 1, currentPage, recordsPerPage);
//
//                fillTable(hoaDons);
//
//            } else {
//                // Thực hiện xử lý khi giá trị payMethod không hợp lệ
//                JOptionPane.showMessageDialog(this, "Lựa chọn hình thức thanh toán không hợp lệ");
//            }
//        } else {
//            // Xử lý khi cả hai ngày đều là null
//            String keySearch = txt_timKiem.getText();
//            Integer payMethod = cbo_HinhThucThanhToan.getSelectedIndex();
//
//            // Xử lý khi giá trị payMethod là 0, tức là tìm kiếm theo tất cả
//            if (payMethod == 0) {
//                // Gọi phương thức filterHoaDon từ service với thêm các thông tin tìm kiếm
//                List<HoaDonCT> hoaDons = service.filterHoaDon(null, null, keySearch, null, currentPage, recordsPerPage);
//                fillTable(hoaDons);
//
//            } else if (payMethod == 1 || payMethod == 2) {
//                // Gọi phương thức filterHoaDon từ service với thêm các thông tin tìm kiếm theo hình thức thanh toán
//                List<HoaDonCT> hoaDons = service.filterHoaDon(null, null, keySearch, payMethod - 1, currentPage, recordsPerPage);
//
//                fillTable(hoaDons);
//
//            } else {
//                // Thực hiện xử lý khi giá trị payMethod không hợp lệ
//                JOptionPane.showMessageDialog(this, "Lựa chọn hình thức thanh toán không hợp lệ");
//            }
//        }
//    }
    //bot qua
    

    private void fillTable(List<HoaDonCT> list) {
        mol = (DefaultTableModel) tbl_HoaDon.getModel();
        mol.setRowCount(0);
        for (HoaDonCT x : list) {
            mol.addRow(new Object[]{
                x.getMaHD(),
                x.getTenKH(),
                x.getTenNV(),
                x.getThanhTien(),
                x.getPTTT(),
                x.getNgayTT(),});
        }
//        int totalPages = (int) Math.ceil((double) service.getTotalHoaDon() / recordsPerPage);
//        pageLabel.setText("Trang: " + currentPage + " / " + totalPages);
    }

    private void fillTableWithPagination() {
        mol = (DefaultTableModel) tbl_HoaDon.getModel();
        mol.setRowCount(0);
        List<HoaDonCT> list = service.getAllByPage(currentPage, recordsPerPage);
        fillTable(list);
        int totalRecords = service.getTotalHoaDon(); // Update total records
        int totalPages = (int) Math.ceil((double) totalRecords / recordsPerPage); // Recalculate total pages
        pageLabel.setText("Trang: " + currentPage + " / " + totalPages);
    }

    private int currentPage = 1;
    private int recordsPerPage = 5;

    private void fillTableByPage() {
        List<HoaDonCT> list = service.getAllByPage(currentPage, recordsPerPage);
        mol = (DefaultTableModel) tbl_HoaDon.getModel();
        mol.setRowCount(0);
        for (HoaDonCT x : list) {
            mol.addRow(new Object[]{
                x.getMaHD(),
                x.getTenKH(),
                x.getTenNV(),
                x.getThanhTien(),
                x.getPTTT(),
                x.getNgayTT(),});
        }
    }

    private void showHDCT() {
        fillHDCTTable();
    }

    private void fillHDCTTable() {
        index = tbl_HoaDon.getSelectedRow();
        if (index != -1) {
            HoaDonCT hd = service.timKiem(txt_timKiem.getText()).get(index);
            maHD = hd.getMaHD();
            DefaultTableModel molHDCT = (DefaultTableModel) tbl_hoaDonCT.getModel();
            molHDCT.setRowCount(0);
            for (HoaDonCT1 hoaDonCT1 : service.getAllCTHD(maHD)) {
                molHDCT.addRow(new Object[]{
                    hoaDonCT1.getMaHDCT(),
                    hoaDonCT1.getMaVi(),
                    hoaDonCT1.getTenVi(),
                    hoaDonCT1.getSoLuong(),
                    hoaDonCT1.getTongTien()
                });
            }
        }
    }

}
