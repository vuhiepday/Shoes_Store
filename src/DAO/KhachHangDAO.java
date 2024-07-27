/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author nguye
 */
import MODAL.Khachhang1;/*của Hùng*/
import MODAL.KhachHang;/*Của Cường*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KhachHangDAO {
    public int kiemTraVaLayId(String tenKhachHang, String soDienThoai) {
        int idKhachHang = kiemTraTonTai(tenKhachHang, soDienThoai);
        if (idKhachHang == -1) {
            // Nếu không tồn tại, tạo mới
            idKhachHang = taoMoiKhachHang(tenKhachHang, soDienThoai);
        }
        return idKhachHang;
    }
    private int kiemTraTonTai(String tenKhachHang, String soDienThoai) {
        int idKhachHang = -1;
        try {
            Connection con = KetNoiDB.openConnection();
            Statement stm = con.createStatement();
            String query = "SELECT idKhachHang FROM KhachHang WHERE TenKhachHang = '" + tenKhachHang + "' AND SoDienThoai = '" + soDienThoai + "'";
            ResultSet rs = stm.executeQuery(query);
            if (rs.next()) {
                idKhachHang = rs.getInt("idKhachHang");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idKhachHang;
    }
    private int taoMoiKhachHang(String tenKhachHang, String soDienThoai) {
        int idKhachHang = -1;
        try {
            // Lấy ID lớn nhất hiện tại
            Connection con = KetNoiDB.openConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT MAX(idKhachHang) AS MaxId FROM KhachHang");
            if (rs.next()) {
                idKhachHang = rs.getInt("MaxId") + 1;
            } else {
                idKhachHang = 1; // Nếu bảng không có dữ liệu
            }
            // Thêm khách hàng mới
            String insertQuery = "INSERT INTO KhachHang (idKhachHang, TenKhachHang, SoDienThoai) VALUES (" + idKhachHang + ", '" + tenKhachHang + "', '" + soDienThoai + "')";
            stm.executeUpdate(insertQuery);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idKhachHang;
    }
    public void Cap_Nhat_TongTien_KH(int idkh, int tongtien){
            try {
            Connection con = KetNoiDB.openConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT SoTienMua FROM KhachHang where idKhachHang = " + idkh);
            if (rs.next()) {
                int tong = rs.getInt("SoTienMua") + tongtien;
                String updateQuery = "UPDATE KhachHang SET SoTienMua = " + tong + " WHERE idKhachHang = " + idkh + ";";
                stm.executeUpdate(updateQuery);
            }
            rs.close();
            stm.close();
            con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    
    public int Lay_Phan_Tram_TongTien_KH(int idkh, int tongtien){
        int sum =0 ;
            try {
            Connection con = KetNoiDB.openConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT SoTienMua FROM KhachHang where idKhachHang = " + idkh);
            if (rs.next()) {
                sum = rs.getInt("SoTienMua");
                if(sum >= 1000000){
                    tongtien -= tongtien * 5 / 100;
                }else if(sum >= 10000000){
                    tongtien -= tongtien * 10 / 100;
                }
            }
            rs.close();
            stm.close();
            con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return tongtien;
    }
     public List<Khachhang1> readKhachHang(){
        List<Khachhang1> listKH = new ArrayList<>();
        try
        {
            Connection con = KetNoiDB.openConnection();
            String sql ="select * from Khachhang";
            Statement stm = con.createStatement();
            ResultSet rs =stm.executeQuery(sql);
            listKH.clear();
            while(rs.next()){
                Khachhang1 kh = new Khachhang1();
                kh.setMakh(rs.getString(1));
                kh.setTenKH(rs.getString(2));
                kh.setSoDT(rs.getString(3));
                kh.setSoTM(rs.getInt(4));
                listKH.add(kh);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listKH;
    }
    
    public int UpdateKH(Khachhang1 kh)
    {
        int k= 0;
        try{
        Connection con = KetNoiDB.openConnection();
        
        String sql ="update KhachHang SET TenKhachHang=?, SoDienThoai=?, SoTienMua=? WHERE idKhachHang=? ";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, kh.getTenKH());
        pstmt.setString(2, kh.getSoDT());
        pstmt.setInt(3, kh.getSoTM());
        pstmt.setString(4, kh.getMakh());
        k= pstmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return k;
    }
    public int xoaKhachHang(String maKH) {
        int x = 0;
        try {
            Connection con = KetNoiDB.openConnection();
            String sql = "DELETE FROM KhachHang WHERE idKhachHang = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, maKH);
            x = pstmt.executeUpdate();
            pstmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x;
    }
    
}
