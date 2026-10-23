package layanan;

import eksepsi.KoleksiSedangDiPinjamException;
import eksepsi.KoleksiSedangDiPinjamException;
import eksepsi.KoleksiTidakLayakException;
import eksepsi.PustakaException;
import model.Koleksi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KatalogPerpustakaan {
    private final List<Koleksi> daftarKoleksi = new ArrayList<>();

    public void tambah(Koleksi koleksi) {
        daftarKoleksi.add(koleksi);
    }

    public List<Koleksi> getDaftarKoleksi() {
        return Collections.unmodifiableList(daftarKoleksi);
    }

    // Polimorfik: tanpa percabangan tipe, cukup memanggil method milik kelas induk
    public void cetakStatus() {
        for (Koleksi k : daftarKoleksi) {
            String layak = k.layakDipinjam() ? "LAYAK DIPINJAM" : "TIDAK LAYAK DIPINJAM";
            String dipinjam = k.isSedangDipinjam() ? " (sedang dipinjam)" : "";
            System.out.println(k.deskripsi());
            System.out.println("   Status: " + layak + dipinjam);
        }
    }

    // Aturan pengurutan dapat diganti dari luar
    public void urut(Comparator<Koleksi> pembanding) {
        daftarKoleksi.sort(pembanding);
    }

    public void pinjam(String kodeKoleksi) throws PustakaException {
        Koleksi k = cari(kodeKoleksi);
        if (k.isSedangDipinjam()) {
            throw new KoleksiSedangDiPinjamException(k.getJudul());
        }
        if (!k.layakDipinjam()) {
            throw new KoleksiTidakLayakException(k.getJudul(), k.alasanTidakLayak());
        }
        k.setSedangDipinjam(true);
    }

    private Koleksi cari(String kodeKoleksi) throws PustakaException {
        for (Koleksi k : daftarKoleksi) {
            if (k.getKodeKoleksi().equalsIgnoreCase(kodeKoleksi)) {
                return k;
            }
        }
        throw new PustakaException("Koleksi dengan kode " + kodeKoleksi + " tidak ditemukan di katalog.");
    }
}