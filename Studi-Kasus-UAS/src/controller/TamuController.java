package controller;
import model.TamuModel;

public class TamuController {
    public void lokal(String nama, String noHp, String alamat, int lama,int ktp,String kamar){
        TamuModel.inputTamu(nama, noHp, alamat, lama, ktp, kamar);
    }
}
