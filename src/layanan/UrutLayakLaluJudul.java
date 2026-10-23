package layanan;

import model.Koleksi;

import java.util.Comparator;

// Koleksi layak pinjam tampil lebih dulu, lalu diurutkan berdasarkan judul
public class UrutLayakLaluJudul implements Comparator<Koleksi> {
    private final Comparator<Koleksi> pembanding =
            Comparator.comparing(Koleksi::layakDipinjam, Comparator.reverseOrder())
                    .thenComparing(Koleksi::getJudul, String.CASE_INSENSITIVE_ORDER);

    @Override
    public int compare(Koleksi a, Koleksi b) {
        return pembanding.compare(a, b);
    }
}