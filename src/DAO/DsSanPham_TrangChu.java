/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import MODAL.TonKho_TrangChu;
import MODAL.HangSanXuat_TrangChu;
import MODAL.SanPham_TrangChu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author nguye
 */
public class DsSanPham_TrangChu {
    
    public List<SanPham_TrangChu> read_SanPham(){
        List<SanPham_TrangChu> listSP = new ArrayList<>();
        try{
            String sql = "select HinhAnh,TenSP,KichThuoc,DonGia,TonCuoi from TonKho,SanPham where TonKho.idSanPham=SanPham.idSanPham";
            Connection con = KetNoiDB.openConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            listSP.clear();
            while(rs.next()){
               SanPham_TrangChu nv = new SanPham_TrangChu();
               nv.setHinhAnh(rs.getString(1));
               nv.setTenSanPham(rs.getString(2));
               nv.setKichThuoc(rs.getString(3));
               nv.setDonGia(rs.getInt(4));
               nv.setTonCuoi(rs.getInt(5));
                listSP.add(nv);
            }
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return listSP;
    }
    public List<SanPham_TrangChu> search_SanPham(String keyword){
        List<SanPham_TrangChu> resultList = new ArrayList<>();
        try{
            String sql = "SELECT * FROM SanPham WHERE TenSP LIKE '%" + keyword + "%'";
            Connection con = KetNoiDB.openConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            resultList.clear();
            while(rs.next()){
               SanPham_TrangChu sp = new SanPham_TrangChu();
               sp.setHinhAnh(rs.getString(6));
               sp.setTenSanPham(rs.getString(2));
               sp.setIdHangSX(rs.getInt(3));
               sp.setKichThuoc(rs.getString(4));
               sp.setDonGia(rs.getInt(5));
               resultList.add(sp);
            }
            con.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return resultList;
    }

    public int LAY_ID(String tensp) {
        int id = 0;
        try {
            Connection con = KetNoiDB.openConnection();
            Statement stm = con.createStatement();
            String query = "SELECT idSanPham FROM SanPham WHERE TenSP = '" + tensp + "'";
            ResultSet rs = stm.executeQuery(query);
            if (rs.next()) {
                id = rs.getInt("idSanPham");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
}
