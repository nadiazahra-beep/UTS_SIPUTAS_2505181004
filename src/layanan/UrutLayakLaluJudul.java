package layanan;

import java.util.Comparator;
import model.Koleksi;

public class UrutLayakLaluJudul
        implements Comparator<Koleksi> {

    @Override
    public int compare(Koleksi a, Koleksi b) {

        int hasil = Boolean.compare(
                b.layakDipinjam(),
                a.layakDipinjam());

        if (hasil != 0) {
            return hasil;
        }

        return String.CASE_INSENSITIVE_ORDER.compare(
                a.getJudul(), b.getJudul());
    }
}