/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import UI.BaoCao;
import java.util.Date;

/**
 *
 * @author nguye
 */
public class BaoCaoTrongNgay {
     public double DoanhThuTrongNgay(){
  
         try{
            String sql="SELECT SUM(TongTien) AS TongTienHomNay FROM HoaDon WHERE CAST(NgayLap AS DATE) = CAST(GETDATE() AS DATE);";
            Connection con=KetNoiDB.openConnection();
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery(sql);
            if (rs.next()) {
                    // Lấy tổng tiền từ kết quả truy vấn
                    double total = rs.getDouble(1);
                    // Tạo giao diện Java Swing
                    return total;
                   
                }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
         return 0;
     }
     public double SoKhachHangTrongNgay(){
  
         try{
             String sql="SELECT Count(Distinct idKhachHang) AS SoKhachHang FROM HoaDon WHERE CAST(NgayLap AS DATE) = CAST(GETDATE() AS DATE);";
            Connection con=KetNoiDB.openConnection();
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery(sql);
            if (rs.next()) {
                    // Lấy tổng tiền từ kết quả truy vấn
                    double total = rs.getDouble(1);
                    // Tạo giao diện Java Swing
                    return total;
                   
                }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
         return 0;
     }
     public double DonHangTrongNgay(){
  
         try{
             String sql="SELECT COUNT(*) AS SoDonHang FROM HoaDon WHERE CAST(NgayLap AS DATE) = CAST(GETDATE() AS DATE);";
            Connection con=KetNoiDB.openConnection();
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery(sql);
            if (rs.next()) {
                    // Lấy tổng tiền từ kết quả truy vấn
                    double total = rs.getDouble(1);
                    // Tạo giao diện Java Swing
                    return total;
                   
                }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
         return 0;
     }
     public double TongDoanhThuUocTinh(Date ngaybd, Date ngaykt) {
    try {
        // Sử dụng PreparedStatement để tránh các vấn đề về an ninh và tránh lỗi SQL injection
        String sql = "SELECT SUM(TongTien) AS TongTienTuNgayNayDenNgayKhac FROM HoaDon WHERE NgayLap BETWEEN ? AND ?";
        Connection con = KetNoiDB.openConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        
        // Thiết lập các tham số ngày tháng cho PreparedStatement
        pstmt.setDate(1, new java.sql.Date(ngaybd.getTime())); // Chuyển đổi từ java.util.Date sang java.sql.Date
        pstmt.setDate(2, new java.sql.Date(ngaykt.getTime()));
        
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            // Lấy tổng tiền từ kết quả truy vấn
            double total = rs.getDouble("TongTienTuNgayNayDenNgayKhac");
            // Trả về tổng doanh thu
            return total;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0; // Trả về 0 nếu có lỗi xảy ra hoặc không có kết quả
}
      public double TongSoDonHangUocTinh(Date ngaybd, Date ngaykt) {
    try {
        // Sử dụng PreparedStatement để tránh các vấn đề về an ninh và tránh lỗi SQL injection
        String sql = "SELECT COUNT(*) AS SoDonHang FROM HoaDon WHERE NgayLap BETWEEN ? AND ?";
        Connection con = KetNoiDB.openConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        
        // Thiết lập các tham số ngày tháng cho PreparedStatement
        pstmt.setDate(1, new java.sql.Date(ngaybd.getTime())); // Chuyển đổi từ java.util.Date sang java.sql.Date
        pstmt.setDate(2, new java.sql.Date(ngaykt.getTime()));
        
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            // Lấy tổng tiền từ kết quả truy vấn
            double total = rs.getDouble("SoDonHang");
            // Trả về tổng doanh thu
            return total;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0; // Trả về 0 nếu có lỗi xảy ra hoặc không có kết quả
}
       public double TongLoiNhuanUocTinh(Date ngaybd, Date ngaykt) {
    try {
        // Sử dụng PreparedStatement để tránh các vấn đề về an ninh và tránh lỗi SQL injection
        String sql = "SELECT SUM(TongTien) AS TongTienTuNgayNayDenNgayKhac FROM HoaDon WHERE NgayLap BETWEEN ? AND ?";
        Connection con = KetNoiDB.openConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        
        // Thiết lập các tham số ngày tháng cho PreparedStatement
        pstmt.setDate(1, new java.sql.Date(ngaybd.getTime())); // Chuyển đổi từ java.util.Date sang java.sql.Date
        pstmt.setDate(2, new java.sql.Date(ngaykt.getTime()));
        
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            // Lấy tổng tiền từ kết quả truy vấn
            double total = rs.getDouble("TongTienTuNgayNayDenNgayKhac")*0.2;
            // Trả về tổng doanh thu
            return total;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0; // Trả về 0 nếu có lỗi xảy ra hoặc không có kết quả
}

     
}
