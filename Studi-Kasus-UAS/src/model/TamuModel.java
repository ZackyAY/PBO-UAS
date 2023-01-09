package model;

import entity.TamuLokalEntity;
import entity.ReservasiEntity;
import entity.KamarEntity;
import utils.DateString;

import java.util.ArrayList;

public class TamuModel {
    static ArrayList<ReservasiEntity> arrayTamu = new ArrayList<>();
    static ArrayList<KamarEntity> arrayKamar = new ArrayList<>();
    
    public static void initialKamar(){
        arrayKamar.add(new KamarEntity("001", "Single Bed", true));
        arrayKamar.add(new KamarEntity("002", "Double Bed", true));
        arrayKamar.add(new KamarEntity("011", "Family Bed", true));
        arrayKamar.add(new KamarEntity("012", "Deluxe Bed", true));
        arrayKamar.add(new KamarEntity("101", "VVIP Bed", true));
    }

    public static KamarEntity cari(String noKamar){
        for(KamarEntity objek : arrayKamar){
            if(objek.getNo_kamar().equals(noKamar)){
                return objek;
            }
        }
        return null;
    }

    public static int indexData(String noKamar){
        KamarEntity kamar = cari(noKamar);
        return arrayKamar.indexOf(kamar);
    }

    public static void inputTamu(String nama, String noHp, String alamat, int lama,int ktp,String kamar){
        TamuLokalEntity tamu = new TamuLokalEntity(nama, noHp, alamat, lama, ktp);
        KamarEntity kamarCari = cari(kamar);
        arrayTamu.add(new ReservasiEntity(tamu, kamarCari));
    }

    public static int cariReservasibyKodeKamarLokal(String kodeKamar) {
        int i = -1;
        for (ReservasiEntity objek : arrayTamu) {
            i += 1;
            if (objek.getKamar().getNo_kamar().equals(kodeKamar)){
                if (!objek.getKamar().getStatus_kamar()) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void checkoutTamu(int index){
        ReservasiEntity reservasi = arrayTamu.get(index);
        reservasi.setCheckout(DateString.now());
        KamarEntity kamar = reservasi.getKamar();
        updateTamu(kamar, true);
        arrayTamu.set(index, reservasi);
    }


    private static void updateTamu(KamarEntity kamar, boolean status){
        for(KamarEntity objek : arrayKamar){
            if(kamar.getNo_kamar().equals(objek.getNo_kamar())){
                objek.setStatus_kamar(status);
                break;
            }
        }
    }

    public static ArrayList<ReservasiEntity> allTamu(){
        return arrayTamu;
    }
    public static ArrayList<KamarEntity> allKamar(){
        return arrayKamar;
    }
}