package model;

// Tidak mengimplementasikan Terarsip karena tidak memiliki lokasi fisik di rak
public class BerkasDigital extends Koleksi {
    private final int ukuranMB;
    private final String tautanUnduh;

    public BerkasDigital(String kodeKoleksi, String judul, int tahunTerbit, int ukuranMB, String tautanUnduh) {
        super(kodeKoleksi, judul, tahunTerbit);
        this.ukuranMB = ukuranMB;
        this.tautanUnduh = tautanUnduh;
    }

    public int getUkuranMB() { return ukuranMB; }
    public String getTautanUnduh() { return tautanUnduh; }

    @Override
    public boolean layakDipinjam() {
        return true;
    }

    @Override
    public String alasanTidakLayak() {
        return "berkas digital selalu dapat dipinjam";
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " | Berkas Digital, " + ukuranMB + " MB | " + tautanUnduh;
    }
}