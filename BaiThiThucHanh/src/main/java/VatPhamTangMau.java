/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class VatPhamTangMau extends VatPham {

    private static int dem = 1;
    private double soMauTang;

    {
        this.maVatPham = String.format("A%02d", ++dem);
    }

    /**
     * @return the soLuotTang
     */
    public double getSoLuotTang() {
        return soMauTang;
    }

    /**
     * @param soLuotTang the soLuotTang to set
     */
    public void setSoLuotTang(double soMauTang) {
        this.soMauTang = soMauTang;
    }
}
