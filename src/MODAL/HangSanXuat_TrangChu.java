/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODAL;

/**
 *
 * @author nguye
 */
public class HangSanXuat_TrangChu {

    public int getIdHangSX() {
        return idHangSX;
    }

    public void setIdHangSX(int idHangSX) {
        this.idHangSX = idHangSX;
    }

    public String getTenHang() {
        return TenHang;
    }

    public void setTenHang(String TenHang) {
        this.TenHang = TenHang;
    }
    public int idHangSX;
    public String TenHang;
    public HangSanXuat_TrangChu(){}

    public HangSanXuat_TrangChu(int idHangSX, String TenHang) {
        this.idHangSX = idHangSX;
        this.TenHang = TenHang;
    }
}
