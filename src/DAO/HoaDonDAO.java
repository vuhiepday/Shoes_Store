/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODAL.ChiTietHoaDon;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import MODAL.HoaDon;

public class HoaDonDAO {
    public List<HoaDon> readAllHoaDon(){
        List<HoaDon> listSP = new ArrayList<>();
        try{
            String sql = "select idHoaDon,Ten,TenKhachHang,NgayLap,TongTien from HoaDon,NhanVien, KhachHang where HoaDon.idNhanVien = NhanVien.idNhanVien and HoaDon.idKhachHang = KhachHang.idKhachHang;";
            Connection con = KetNoiDB.openConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            listSP.clear();
            while(rs.next()){
                HoaDon nv = new HoaDon();
                nv.setIdHoaDon(rs.getInt(1));
                nv.setNhanVien(rs.getString(2));
                nv.setKhachHang(rs.getString(3));
                nv.setNgayLap(rs.getString(4));
                nv.setTongTien(rs.getInt(5));
                listSP.add(nv);
            }
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return listSP;
    }
    
    public boolean deleteHoaDon(int idHoaDon) {
        try {
            String sql = "DELETE FROM HoaDon WHERE idHoaDon = " + idHoaDon;
            Connection con = KetNoiDB.openConnection();
            Statement stm = con.createStatement();
            int affectedRows = stm.executeUpdate(sql);
            con.close();
            return affectedRows > 0; // Trả về true nếu có bản ghi bị xóa
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; // Trả về false nếu không có bản ghi bị xóa hoặc xảy ra lỗi
    }
    
    public void LuuDuLieu(DefaultTableModel model, int idKhachHang, int idNhanVien,int TongTien) {
        try {
            // Lấy ID lớn nhất hiện tại của hóa đơn
            int idHoaDon = layMaxIdHoaDon() + 1;
            // Thêm hóa đơn mới
            String insertHoaDonQuery = "INSERT INTO HoaDon (idHoaDon, idKhachHang, idNhanVien,NgayLap,TongTien) VALUES (" + idHoaDon + ", " + idKhachHang + ", " + idNhanVien + ",GETDATE(),"+ TongTien +" )";
            Connection con = KetNoiDB.openConnection();
            Statement stm = con.createStatement();
            stm.executeUpdate(insertHoaDonQuery);
            DsSanPham_TrangChu sp = new DsSanPham_TrangChu();

            // Thêm chi tiết hóa đơn
            for (int i = 0; i < model.getRowCount(); i++) {
                String tenSP = model.getValueAt(i, 0).toString();
                int idSP = sp.LAY_ID(tenSP);
                int soLuong = Integer.parseInt(model.getValueAt(i, 1).toString());
                double thanhtien = Double.parseDouble(model.getValueAt(i, 2).toString());
                String insertChiTietHoaDonQuery = "INSERT INTO ChiTietHoaDon (idHoaDon, idSanPham, SoLuong, ThanhTien) VALUES (" + idHoaDon + ", '" + idSP + "', " + soLuong + ", " + thanhtien + ")";
                stm.executeUpdate(insertChiTietHoaDonQuery);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private int layMaxIdHoaDon() {
        int maxId = -1;
        try {
            Connection con = KetNoiDB.openConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT MAX(idHoaDon) AS MaxId FROM HoaDon");
            if (rs.next()) {
                maxId = rs.getInt("MaxId");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maxId;
    }
    
    public List<ChiTietHoaDon> getChiTietHoaDon(int idHoaDon) {
        List<ChiTietHoaDon> chiTietList = new ArrayList<>();
        try {
            String sql = "select idHoaDon,TenSP,SoLuong,ThanhTien from ChiTietHoaDon,SanPham where ChiTietHoaDon.idSanPham = SanPham.idSanPham AND idHoaDon = " + idHoaDon;
            Connection con = KetNoiDB.openConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                ChiTietHoaDon chiTiet = new ChiTietHoaDon();
                chiTiet.setTenSanPham(rs.getString("TenSP"));
                chiTiet.setSoLuong(rs.getInt("SoLuong"));
                chiTiet.setThanhTien(rs.getInt("ThanhTien"));
                chiTietList.add(chiTiet);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chiTietList;
    }
    
}

