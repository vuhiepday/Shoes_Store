/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODAL.TonKho_TrangChu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nguye
 */
public class TonKho_TrangChu_Dao {
    public List<TonKho_TrangChu> readAlltonkho(){
        List<TonKho_TrangChu> listSP = new ArrayList<>();
        try{
            String sql = "select * from TonKho";
            Connection con = KetNoiDB.openConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            listSP.clear();
            while(rs.next()){
                TonKho_TrangChu nv = new TonKho_TrangChu();
                nv.setIdSanPham(rs.getInt(2));
                nv.setTonDau(rs.getInt(3));
                nv.setSoLuongNhap(rs.getInt(4));
                nv.setSoLuongXuat(rs.getInt(5));
                nv.setTonCuoi(rs.getInt(6));
                listSP.add(nv);
            }
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return listSP;
    }
    
    public void updateSoLuongXuat(DefaultTableModel model) {
        DsSanPham_TrangChu ds = new DsSanPham_TrangChu();
            try {
                List<TonKho_TrangChu> idSanPhamList = new ArrayList<>();
                // Lấy danh sách idSanPham và SoLuongXuat từ model
                for (int i = 0; i < model.getRowCount(); i++) {
                    TonKho_TrangChu nv = new TonKho_TrangChu();
                    int idSanPham = ds.LAY_ID(String.valueOf(model.getValueAt(i, 0)));
                    int sl = Integer.parseInt(String.valueOf(model.getValueAt(i, 1)));
                    nv.setIdSanPham(idSanPham);
                    nv.setSoLuongXuat(sl);
                    idSanPhamList.add(nv);
                }
                Connection con = KetNoiDB.openConnection();
                Statement stm = con.createStatement();
                // Duyệt qua danh sách idSanPham và cập nhật trong cơ sở dữ liệu
                for (TonKho_TrangChu tonKho : idSanPhamList) {
                    int idSanPham = tonKho.getIdSanPham();
                    int soLuongXuat = tonKho.getSoLuongXuat();
                    // Lấy số lượng xuất hiện tại và tồn đầu
                    ResultSet rs = stm.executeQuery("SELECT SoLuongNhap, SoLuongXuat, TonDau FROM TonKho WHERE idSanPham = '"+ idSanPham +"'" );
                    int soLuongXuatHienTai = 0;
                    int tonDau = 0;
                    int soluongnhap = 0;
                    if (rs.next()) {
                        soluongnhap = rs.getInt("SoLuongNhap");
                        soLuongXuatHienTai = rs.getInt("SoLuongXuat");
                        tonDau = rs.getInt("TonDau");
                    }
                    rs.close();
                    // Cập nhật số lượng xuất mới và tính tồn cuối
                    int soLuongXuatMoi = soLuongXuatHienTai + soLuongXuat;
                    int tonCuoi = tonDau + soluongnhap - soLuongXuatMoi;
                    // Thực hiện câu truy vấn cập nhật SoLuongXuat và TonCuoi cho idSanPham tương ứng
                    //String updateQuery = "UPDATE TonKho SET SoLuongXuat = " + soLuongXuatMoi + ", TonCuoi = " + tonCuoi + " WHERE idSanPham = " + idSanPham;
                    String updateQuery="UPDATE TonKho SET SoLuongXuat ='"+ soLuongXuatMoi +"' , TonCuoi ='"+ tonCuoi +"'WHERE idSanPham ='"+ idSanPham+"'";
                    stm.executeUpdate(updateQuery);
                }
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
