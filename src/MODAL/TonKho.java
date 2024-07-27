/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODAL;

/**
 *
 * @author Hooofaaa
 */
public class TonKho {
    public int maTonKho;
    public int maSP;
    public int tonDau;
    public int soLuongNhap;
    public int soLuongXuat;
    public int tonCuoi;
    
    public TonKho(){
    
    }  

    public TonKho(int maTonKho, int maSP, int tonDau, int soLuongNhap, int soLuongXuat, int tonCuoi) {
        this.maTonKho = maTonKho;
        this.maSP = maSP;
        this.tonDau = tonDau;
        this.soLuongNhap = soLuongNhap;
        this.soLuongXuat = soLuongXuat;
        this.tonCuoi = tonCuoi;
    }

    public int getMaTonKho() {
        return maTonKho;
    }

    public void setMaTonKho(int maTonKho) {
        this.maTonKho = maTonKho;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public int getTonDau() {
        return tonDau;
    }

    public void setTonDau(int tonDau) {
        this.tonDau = tonDau;
    }

    public int getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(int soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }

    public int getSoLuongXuat() {
        return soLuongXuat;
    }

    public void setSoLuongXuat(int soLuongXuat) {
        this.soLuongXuat = soLuongXuat;
    }

    public int getTonCuoi() {
        return tonCuoi;
    }

    public void setTonCuoi(int tonCuoi) {
        this.tonCuoi = tonCuoi;
    }

    
    
    
    
}
