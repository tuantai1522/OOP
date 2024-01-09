
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author admin
 */
public class NhanVat {

    private static int dem = 1;
    private int maNhanVat;
    private String tenNhanVat;
    private List<VatPham> dsVatPham = new ArrayList<>();

    {
        this.maNhanVat = dem;
        ++dem;
    }

    public NhanVat(String tenNhanVat) {
        this.tenNhanVat = tenNhanVat;
    }

    /**
     * @return the maNhanVat
     */
    public int getMaNhanVat() {
        return maNhanVat;
    }

    /**
     * @param maNhanVat the maNhanVat to set
     */
    public void setMaNhanVat(int maNhanVat) {
        this.maNhanVat = maNhanVat;
    }

    /**
     * @return the dsVatPham
     */
    public List<VatPham> getDsVatPham() {
        return dsVatPham;
    }

    /**
     * @param dsVatPham the dsVatPham to set
     */
    public void setDsVatPham(List<VatPham> dsVatPham) {
        this.dsVatPham = dsVatPham;
    }

    /**
     * @return the tenNhanVat
     */
    public String getTenNhanVat() {
        return tenNhanVat;
    }

    /**
     * @param tenNhanVat the tenNhanVat to set
     */
    public void setTenNhanVat(String tenNhanVat) {
        this.tenNhanVat = tenNhanVat;
    }

}
