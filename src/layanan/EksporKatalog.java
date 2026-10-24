package layanan;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import model.Koleksi;

public class EksporKatalog {

    public void ekspor(List<Koleksi> daftar,
            String namaBerkas) throws IOException {

        try (BufferedWriter writer =
                Files.newBufferedWriter(
                Path.of(namaBerkas),
                StandardCharsets.UTF_8)) {

            writer.write(String.format(
                    "%-8s | %-34s | %-6s | %-18s | %s",
                    "KODE", "JUDUL", "TAHUN",
                    "STATUS PINJAM", "KELAYAKAN"));

            writer.newLine();
            writer.write("-".repeat(100));
            writer.newLine();

            for (Koleksi k : daftar) {
                writer.write(String.format(
                        "%-8s | %-34s | %-6d | %-18s | %s",
                        k.getKodeKoleksi(),
                        k.getJudul(),
                        k.getTahunTerbit(),
                        k.statusPinjam(),
                        k.layakDipinjam()
                        ? "Layak" : "Tidak layak"));

                writer.newLine();
            }
        }
    }
}