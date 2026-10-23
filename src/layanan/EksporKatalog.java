package layanan;

import model.Koleksi;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EksporKatalog {
    private static final String FORMAT = "%-8s %-14s %-32s %-6s %-12s%n";

    public void ekspor(KatalogPerpustakaan katalog, String namaBerkas) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(namaBerkas))) {
            out.printf(FORMAT, "KODE", "JENIS", "JUDUL", "TAHUN", "KELAYAKAN");
            out.println("-".repeat(76));
            for (Koleksi k : katalog.getDaftarKoleksi()) {
                out.printf(FORMAT,
                        k.getKodeKoleksi(),
                        k.getClass().getSimpleName(),
                        k.getJudul(),
                        k.getTahunTerbit(),
                        k.layakDipinjam() ? "Layak" : "Tidak layak");
            }
        }
    }
}