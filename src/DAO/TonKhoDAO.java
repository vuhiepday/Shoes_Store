/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODAL.SanPham;
import MODAL.TonKho;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hooofaaa
 */
public class TonKhoDAO {
    public List<TonKho> docTatCaTonKho() {
        List<TonKho> list = new ArrayList<>();
        try {
            String sql = "Select * from TonKho";
            Connection con = KetNoiDB.openConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            list.clear();
            while (rs.next()) {
                TonKho tk = new TonKho();
                tk.setMaTonKho(rs.getInt(1));
                tk.setMaSP(rs.getInt(2));
                tk.setTonDau(rs.getInt(3));
                tk.setSoLuongNhap(rs.getInt(4));
                tk.setSoLuongXuat(rs.getInt(5));
                tk.setTonCuoi(rs.getInt(6));
                list.add(tk);
            }
            rs.close();
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<TonKho> timTonKhoTheoMa(String maSP) {
        List<TonKho> listTK = new ArrayList<>();
        try {
            String sql = "SELECT * FROM TonKho WHERE idSanPham = ?";
            Connection con = KetNoiDB.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, maSP);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) { 
                TonKho tk = new TonKho();
                tk.setMaSP(rs.getInt(1));
                tk.setMaTonKho(rs.getInt(2));
                tk.setTonDau(rs.getInt(3));
                tk.setSoLuongNhap(rs.getInt(4));
                tk.setSoLuongXuat(rs.getInt(5));
                tk.setTonCuoi(rs.getInt(6));
                listTK.add(tk);
            }
            rs.close();
            pstmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTK;
    }
}
