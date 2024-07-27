/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import MODAL.SanPham;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Hooofaaa
 */
public class SPDAO {
    public List<SanPham> docTatCaSP(){
        List<SanPham> list = new ArrayList<>();
        try{
            String sql = "Select SanPham.idSanPham, SanPham.TenSP, HangSanXuat.TenHang,SanPham.KichThuoc,SanPham.DonGia,HinhAnh,TonKho.TonCuoi from SanPham,HangSanXuat,TonKho where SanPham.idHangSX = HangSanXuat.idHangSX and SanPham.idSanPham = TonKho.idSanPham;";
            Connection con = KetNoiDB.openConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            list.clear();
            while(rs.next()){
                SanPham sp = new SanPham();
                sp.setMaSP(Integer.parseInt(rs.getString(1)));
                sp.setTenSP(rs.getString(2));
                sp.setHangSX(rs.getString(3));
                sp.setSize(rs.getString(4));               
                sp.setDonGia(Integer.parseInt(rs.getString(5)));
                sp.setHinhAnh(rs.getString(6));
                sp.setSoLuong(Integer.parseInt(rs.getString(7)));
                list.add(sp);
            }
            rs.close();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    //Thêm sản phẩm
    public List<SanPham> taothemSP(SanPham sp) {
        List<SanPham> list = new ArrayList<>();
        String sql = "INSERT INTO SanPham (idSanPham, TenSP, idHangSX, KichThuoc, DonGia, HinhAnh) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = KetNoiDB.openConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            list.add(sp);
            pstmt.setInt(1, sp.getMaSP());
            pstmt.setString(2, sp.getTenSP());
            pstmt.setString(3, sp.getHangSX());
            pstmt.setString(4, sp.getSize());
            pstmt.setInt(5, sp.getDonGia());
            pstmt.setString(6, sp.getHinhAnh());
            pstmt.setInt(7, sp.getSoLuong());

            // Thực thi câu lệnh SQL để thêm sản phẩm vào cơ sở dữ liệu
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    //Xóa sản phẩm
    public boolean xoaSP(String maSP) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            String sql = "DELETE FROM SanPham WHERE idSanPham = ?";
            con = KetNoiDB.openConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, maSP);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0; // Trả về true nếu có dòng bị ảnh hưởng (xóa thành công)
        } catch (SQLException e) {
            e.printStackTrace();  // Nên sử dụng framework logging
        } catch (Exception e) {
            e.printStackTrace();  // Nên sử dụng framework logging
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    
    
    
    //Update sản phẩm
    public boolean suaSP(SanPham sp) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            String sql = "UPDATE ThongTinSanPham SET tenSP = ?, hangSX = ?, KichThuoc = ?, SLTonKho = ?, donGia = ? , hinhAnh = ? WHERE maSP = ?";
            con = KetNoiDB.openConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, sp.getTenSP());
            pstmt.setString(2, sp.getHangSX());
            pstmt.setString(3, sp.getSize());
            pstmt.setInt(4, sp.getDonGia());
            pstmt.setInt(5, sp.getMaSP());
            pstmt.setString(6, sp.getHinhAnh());
            pstmt.setInt(7, sp.getSoLuong());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0; // Trả về true nếu có dòng bị ảnh hưởng (cập nhật thành công)
        } catch (SQLException e) {
            e.printStackTrace();  
        } catch (Exception e) {
            e.printStackTrace();  
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    
    //Thêm số lượng 
    
    public int laySoLuongHienTai(String maSP) {
        int soLuongHienTai = 0; // Giả sử số lượng hiện tại ban đầu là 0

        try {
            String sql = "SELECT soLuongNhap  FROM TonKho WHERE idSanPham = ?";
            Connection con = KetNoiDB.openConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maSP);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                soLuongHienTai = rs.getInt("soLuongNhap");
            }

            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return soLuongHienTai;
    }
    
    public void capNhatSoLuongTonKho(String maSP, int SLMoi) {
        try {
            String sql = "UPDATE TonKho " +
                         "SET SoLuongNhap = ? " +
                         "WHERE idSanPham = ?";
            Connection con = KetNoiDB.openConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, SLMoi);
            ps.setString(2, maSP);
            ps.executeUpdate();

            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
