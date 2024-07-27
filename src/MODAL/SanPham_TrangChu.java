/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODAL;

/**
 *
 * @author nguye
 */
public class SanPham_TrangChu {

    private int idSanPham, idHangSX,DonGia,TonCuoi;

    public int getTonCuoi() {
        return TonCuoi;
    }

    public void setTonCuoi(int TonCuoi) {
        this.TonCuoi = TonCuoi;
    }
    private String TenSanPham,HinhAnh,KichThuoc;
    public int getIdSanPham() {
        return idSanPham;
    }

    public int getIdHangSX() {
        return idHangSX;
    }

    public int getDonGia() {
        return DonGia;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public String getKichThuoc() {
        return KichThuoc;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public void setIdHangSX(int idHangSX) {
        this.idHangSX = idHangSX;
    }

    public void setDonGia(int DonGia) {
        this.DonGia = DonGia;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public void setKichThuoc(String KichThuoc) {
        this.KichThuoc = KichThuoc;
    }
    
    public SanPham_TrangChu(){}
    public SanPham_TrangChu(int idSanPham, int idHangSX, int DonGia, String TenSanPham, String HinhAnh, String KichThuoc,int TonCuoi) {
        this.idSanPham = idSanPham;
        this.idHangSX = idHangSX;
        this.DonGia = DonGia;
        this.TenSanPham = TenSanPham;
        this.HinhAnh = HinhAnh;
        this.KichThuoc = KichThuoc;
        this.TonCuoi=TonCuoi;
    }  
}
