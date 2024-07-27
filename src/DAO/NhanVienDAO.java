/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODAL.NhanVien;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class NhanVienDAO {
    public List<NhanVien> readAllNhanVien(){
        List<NhanVien> listSP = new ArrayList<>();
        try{
            String sql = "select * from NhanVien";
            Connection con = KetNoiDB.openConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            listSP.clear();
            while(rs.next()){
                NhanVien nv = new NhanVien();
                nv.setId_NV(rs.getInt(1));
                nv.setTenNV(rs.getString(2));
                nv.setTuoiNV(rs.getInt(3));
                nv.setChucvuNV(rs.getString(4));
                nv.setTaiKhoan(rs.getString(5));
                nv.setMatKhau(rs.getString(6));
                listSP.add(nv);
            }
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return listSP;
    }
    
    public String kiemTraDangNhap(String tenDN, String matKhau){
        try{
            String sql = "SELECT ChucVu FROM NhanVien WHERE taikhoan = '" + tenDN + "' AND matkhau = '" + matKhau + "'";
            Connection con = KetNoiDB.openConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()){
                String chucvu = rs.getString("ChucVu");
                con.close();
                return chucvu; // Trả về chức vụ của người dùng
            }
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null; // Trả về null nếu không có bản ghi phù hợp hoặc xảy ra lỗi
    }

    public int layIDNhanVien(String tenDN, String matKhau){
        try{
            String sql = "SELECT idNhanVien FROM NhanVien WHERE taikhoan = '" + tenDN + "' AND matkhau = '" + matKhau + "'";
            Connection con = KetNoiDB.openConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()){
                int id = rs.getInt("idNhanVien");
                con.close();
                return id; // Trả về ID của nhân viên
            }
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1; // Trả về -1 nếu không có bản ghi phù hợp hoặc xảy ra lỗi
    }
    
    public boolean deleteNhanVien(int idNhanVien) {
        try {
            String sql = "DELETE FROM NhanVien WHERE idNhanVien = " + idNhanVien;
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
    public boolean addNhanVien(NhanVien nv) {
        try {
            int newId = getMaxIdNhanVien() + 1;
                String sql = "INSERT INTO NhanVien (idNhanVien, Ten, Tuoi, ChucVu, taikhoan, matkhau) VALUES ("
                     + newId + ", '"
                     + nv.getTenNV() + "', "
                     + nv.getTuoiNV() + ", '"
                     + nv.getChucvuNV() + "','"
                     + nv.getTaiKhoan()+ "','"
                     + nv.getMatKhau()+ "')";
            Connection con = KetNoiDB.openConnection();
            Statement stm = con.createStatement();
            int affectedRows = stm.executeUpdate(sql);
            con.close();
            return affectedRows > 0; // Trả về true nếu thêm thành công
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; // Trả về false nếu thêm thất bại hoặc xảy ra lỗi
    }
    public int getMaxIdNhanVien() {
        int maxId = 0;
        try {
            String sql = "SELECT MAX(idNhanVien) AS maxId FROM NhanVien";
            Connection con = KetNoiDB.openConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                maxId = rs.getInt("maxId");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
             return maxId;
      }       
    public boolean updateNhanVien(NhanVien nv) {
        try {
            String sql = "UPDATE NhanVien SET Ten = '"
                         + nv.getTenNV() + "', Tuoi = "
                         + nv.getTuoiNV() + ", ChucVu = '"
                         + nv.getChucvuNV() + "', taikhoan = '"
                         + nv.getTaiKhoan() + "', matkhau = '"
                         + nv.getMatKhau() + "' WHERE idNhanVien = "
                         + nv.getId_NV();
            Connection con = KetNoiDB.openConnection();
            Statement stm = con.createStatement();
            int affectedRows = stm.executeUpdate(sql);
            con.close();
            return affectedRows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<String> getAllChucVu() {
        List<String> listChucVu = new ArrayList<>();
        try {
            String sql = "SELECT DISTINCT ChucVu FROM NhanVien";
            Connection con = KetNoiDB.openConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String chucVu = rs.getString("ChucVu");
                listChucVu.add(chucVu);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listChucVu;
    }
}
