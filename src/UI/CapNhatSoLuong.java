/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DAO.SPDAO;
import DAO.TonKhoDAO;
import MODAL.SanPham;
import MODAL.TonKho;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hooofaaa
 */
public class CapNhatSoLuong extends javax.swing.JFrame {
    List<TonKho> listTK = new ArrayList<>();
    DefaultTableModel tblModel = new DefaultTableModel();
    private QuanLySanPham qlsp;
    int index = 0;
    /**
     * Creates new form CapNhatSoLuong
     */
    public CapNhatSoLuong() {
        this.qlsp = qlsp;
        initComponents();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTonKho = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtSLThem = new javax.swing.JTextField();
        btnLuu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 51, 255));
        jLabel1.setText("CẬP NHẬT SỐ LƯỢNG");

        jLabel2.setText("Mã sản phẩm:");

        btnTimKiem.setText("Tìm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        tblTonKho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Mã tồn kho", "Tồn đầu", "Số lượng nhập", "Số lượng xuất", "Tồn cuối"
            }
        ));
        tblTonKho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTonKhoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTonKho);

        jLabel8.setText("Nhập số lượng muốn thêm:");

        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btnTimKiem)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(215, 215, 215))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(26, 26, 26)
                        .addComponent(txtSLThem, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnLuu)
                        .addGap(94, 94, 94))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSLThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(btnLuu))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        try {
            String maSP = txtMaSP.getText();
            if (maSP.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sản phẩm", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            int SLThem;
            try {
                SLThem = Integer.parseInt(txtSLThem.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Số lượng thêm phải là số nguyên", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            SPDAO spdao = new SPDAO();
            
            // Lấy số lượng hiện tại từ cơ sở dữ liệu
            int SLHienTai = spdao.laySoLuongHienTai(maSP);

            // Tính toán số lượng mới
            int SLMoi = SLHienTai + SLThem;

            // Cập nhật số lượng mới vào cơ sở dữ liệu
            spdao.capNhatSoLuongTonKho(maSP, SLMoi);

            // Cập nhật lại dữ liệu trong bảng hiển thị sản phẩm
            if (qlsp != null) {
                qlsp.fillToTable();
            }

            // Hiển thị thông báo nhập thành công
            JOptionPane.showMessageDialog(this, "Nhập thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

            // Đóng form sau khi lưu
            this.dispose();
        } catch (Exception e) { 
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        
        qlsp.setVisible(true);
        qlsp.fillToTable();
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        String maSP = txtMaSP.getText();
        if (maSP.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã sản phẩm", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        TonKhoDAO tkdao = new TonKhoDAO();
        List<TonKho> list = tkdao.timTonKhoTheoMa(maSP);
        fillToTableTonKho(list);

    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tblTonKhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTonKhoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblTonKhoMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
           int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            
            this.dispose();
            QuanLySanPham ad=new QuanLySanPham();
            ad.setVisible(true);
        } 
    }//GEN-LAST:event_formWindowClosing
    
    public void fillToTableTonKho(List<TonKho> listTK) {
        tblModel = (DefaultTableModel) tblTonKho.getModel();
        tblModel.setRowCount(0);
        
        String maSP = txtMaSP.getText();
        TonKhoDAO tkdao = new TonKhoDAO();
        listTK = tkdao.timTonKhoTheoMa(maSP);  // Lấy dữ liệu sản phẩm từ cơ sở dữ liệu
        
        for (TonKho tk : listTK) {
            Object[] row = new Object[]{ tk.getMaSP(), tk.getMaTonKho(), tk.getTonDau(), tk.getSoLuongNhap(), tk.getSoLuongXuat(), tk.getTonCuoi()};
            tblModel.addRow(row);
            tblTonKho.setModel(tblModel);
        }
    }
    
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
            java.util.logging.Logger.getLogger(CapNhatSoLuong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CapNhatSoLuong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CapNhatSoLuong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CapNhatSoLuong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CapNhatSoLuong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTonKho;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtSLThem;
    // End of variables declaration//GEN-END:variables
}
