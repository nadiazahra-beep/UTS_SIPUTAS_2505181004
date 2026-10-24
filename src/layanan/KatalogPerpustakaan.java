package layanan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import model.Koleksi;
import eksepsi.KoleksiSedangDipinjamException;
import eksepsi.KoleksiTidakLayakException;

public class KatalogPerpustakaan {

    private List<Koleksi> daftarKoleksi =
            new ArrayList<>();

    public void tambahKoleksi(Koleksi koleksi) {
        daftarKoleksi.add(koleksi);
    }

    public List<Koleksi> getDaftarKoleksi() {
        return new ArrayList<>(daftarKoleksi);
    }

    public void cetakStatus() {
        for (Koleksi koleksi : daftarKoleksi) {
            System.out.println(koleksi.deskripsi());
            System.out.println("Status: "
                    + koleksi.statusPinjam());
            System.out.println("Kelayakan: "
                    + (koleksi.layakDipinjam()
                    ? "Layak dipinjam"
                    : "Tidak layak dipinjam"));
            System.out.println("--------------------------------");
        }
    }

    public void urut(Comparator<Koleksi> aturan) {
        daftarKoleksi.sort(aturan);
    }

    public void pinjam(String kode)
            throws KoleksiSedangDipinjamException,
                   KoleksiTidakLayakException {

        Koleksi target = null;

        for (Koleksi koleksi : daftarKoleksi) {
            if (koleksi.getKodeKoleksi()
                    .equalsIgnoreCase(kode)) {
                target = koleksi;
                break;
            }
        }

        if (target == null) {
            throw new IllegalArgumentException(
                    "Kode koleksi tidak ditemukan.");
        }

        if (target.isSedangDipinjam()) {
            throw new KoleksiSedangDipinjamException(
                    "Koleksi sedang dipinjam orang lain.");
        }

        if (!target.layakDipinjam()) {
            throw new KoleksiTidakLayakException(
                    "Koleksi belum dapat dipinjam "
                    + "karena tidak memenuhi aturan.");
        }

        target.setSedangDipinjam(true);

        System.out.println("Berhasil meminjam: "
                + target.getJudul());
    }
}