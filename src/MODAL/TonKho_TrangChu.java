/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODAL;

/**
 *
 * @author nguye
 */
public class TonKho_TrangChu {
    private int TonCuoi,SoLuongXuat,SoLuongNhap,TonDau, idSanPham;

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }
    public TonKho_TrangChu(){}

    public int getTonCuoi() {
        return TonCuoi;
    }

    public void setTonCuoi(int TonCuoi) {
        this.TonCuoi = TonCuoi;
    }

    public int getSoLuongXuat() {
        return SoLuongXuat;
    }

    public void setSoLuongXuat(int SoLuongXuat) {
        this.SoLuongXuat = SoLuongXuat;
    }

    public int getSoLuongNhap() {
        return SoLuongNhap;
    }

    public void setSoLuongNhap(int SoLuongNhap) {
        this.SoLuongNhap = SoLuongNhap;
    }

    public int getTonDau() {
        return TonDau;
    }

    public void setTonDau(int TonDau) {
        this.TonDau = TonDau;
    }

    public TonKho_TrangChu(int idsp,int TonCuoi, int SoLuongXuat, int SoLuongNhap, int TonDau) {
        this.idSanPham = idsp;
        this.TonCuoi = TonCuoi;
        this.SoLuongXuat = SoLuongXuat;
        this.SoLuongNhap = SoLuongNhap;
        this.TonDau = TonDau;
    }
}
