package view;
import java.util.Scanner;
import entity.KamarEntity;
import entity.ReservasiEntity;
import model.TamuModel;
import controller.TamuController;

public class TamuView {
    Scanner input = new Scanner(System.in);
    TamuController tamu = new TamuController();

    public void inputKamar(){
        System.out.print("Masukkan Nama     = ");
        String nama = input.nextLine();
        System.out.print("Masukkan No Hp    = ");
        String noHp = input.nextLine();
        System.out.print("Masukkan Alamat   = ");
        String alamat = input.nextLine();
        System.out.print("Masukkan Lama     = "); 
        int lama = input.nextInt();
        input.nextLine();
        System.out.println("""
                1. Tamu Lokal
                """);
        System.out.print("Masukkan Pilihan = ");
        String pilih = input.nextLine();
        switch(pilih){
            case "1" -> inputTamu(nama, noHp, alamat, lama);
            default -> System.out.println("Inputan Tidak Ada");
        }   
    }

    private void inputTamu(String nama, String noHp, String alamat, int lama){
        try{
            System.out.print("Masukkan KTP          = ");
            int ktp = input.nextInt();
            CariKamarTamu(nama,noHp,alamat,lama,ktp);
        }catch (Exception e) {
            System.out.println("Terjadi Kesalahan input KTP");
        }

    }

    private KamarEntity CariKamarTamu(String nama, String noHp, String alamat, int lama,int ktp){
        boolean pilihKamarStatus = false;
        KamarEntity kamar;
        do {
            input.nextLine();
            System.out.print("Masukan Kode Kamar    = ");
            String noKamar = input.nextLine();
            kamar = TamuModel.cari(noKamar);
            if (kamar != null) {
                if (kamar.getStatus_kamar()) {
                    char pilihKamarIni = 'n';

                    System.out.println("No Kamar      : " + kamar.getNo_kamar());
                    System.out.println("Tipe kamar    : " + kamar.getTipe_kamar());

                    System.out.print("Pilih Kamar ini (y/n) : ");
                    pilihKamarIni = input.nextLine().charAt(0);

                    if (pilihKamarIni == 'y') {
                        kamar.setStatus_kamar(false);
                        tamu.lokal(nama, noHp, alamat, lama, ktp, noKamar);
                        pilihKamarStatus = true;
                        break;
                    }
                } else {
                    System.out.println("------------- KAMAR TELAH DIPESAN ------------");
                }
            } else {
                System.out.println("------------ KAMAR TIDAK DITEMUKAN -----------");
            }
        } while (pilihKamarStatus == false);

        return kamar;
    }

    public void checkoutTamu(){
        System.out.print("Masukan Kode Kamar    = ");
        String noKamar = input.nextLine();
        int index = TamuModel.cariReservasibyKodeKamarLokal(noKamar);
        if(index >-1){
            TamuModel.checkoutTamu(index);
            System.out.println("Berhasil Checkout");
        }else{
            System.out.println("Data Tidak Ditemukan");
        }
    }

    public void daftarReservasi(){
        displayTamu();
    }

    public void displayTamu(){
        if(TamuModel.allTamu().isEmpty()){
            System.out.println();
            System.out.println("===========================");
            System.out.println("        Tamu Hotel");
            System.out.println("==========================");
            System.out.println("        Data Tidak Ada");
        }else{
            for(ReservasiEntity objek : TamuModel.allTamu()){
                System.out.println();
                System.out.println("====================================");
                System.out.println("        Tamu Hotel");
                System.out.println("==================================");
                System.out.println("Nama                = " + objek.getTamuLokal().getNama());
                System.out.println("No HP               = " + objek.getTamuLokal().getNoHp());
                System.out.println("Alamat              = " + objek.getTamuLokal().getAlamat());
                System.out.println("lama                = " + objek.getTamuLokal().getLama());
                System.out.println("KTP                 = " + objek.getTamuLokal().getKtp());
                System.out.println("No Kamar            = " + objek.getKamar().getNo_kamar());
                System.out.println("Tipe Kamar          = " + objek.getKamar().getTipe_kamar());
                System.out.println("Tanggal Check in    = " + objek.getCheckin());
                if(objek.getCheckout()==null){
                    System.out.println("==================================");
                    System.out.println("Checkout            = Belum Checkout");
                    System.out.println("==================================");
                }else{
                    System.out.println("==================================");
                    System.out.println("Checkout            = " + objek.getCheckout());
                    System.out.println("==================================");
                }
            }
        } 
    }

    public void displayKamar(){
        for(KamarEntity objek : TamuModel.allKamar()){
            System.out.println();
            System.out.println("============================");
            System.out.println("No Kamar        = " + objek.getNo_kamar());
            System.out.println("Type kamar      = " + objek.getTipe_kamar());
            if(objek.getStatus_kamar()==true){
                System.out.println("Status Kamar    = Tersedia");
                System.out.println("============================");
            }
            else{
                System.out.println("Status Kamar    = Terboking");
                System.out.println("============================");
            }
        }
    }
}