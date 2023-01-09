package entity;
import utils.DateString;
public class ReservasiEntity {
    private TamuLokalEntity tamuLokal;
    private KamarEntity kamar;
    private String checkin;
    private String checkout;

    public ReservasiEntity(TamuLokalEntity tamuLokal, KamarEntity kamar) {
        this.tamuLokal = tamuLokal;
        this.kamar = kamar;
        this.checkin = DateString.now();
    }

    public ReservasiEntity() {
    }

    public TamuLokalEntity getTamuLokal() {
        return this.tamuLokal;
    }

    public void setTamuLokal(TamuLokalEntity tamuLokal) {
        this.tamuLokal = tamuLokal;
    }

    public KamarEntity getKamar() {
        return this.kamar;
    }

    public void setKamar(KamarEntity kamar) {
        this.kamar = kamar;
    }

    public String getCheckin() {
        return this.checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return this.checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
}