import java.io.IOException;

import model.*;
import layanan.*;
import eksepsi.*;

public class Main {

    public static void main(String[] args) {

        KatalogPerpustakaan katalog =
                new KatalogPerpustakaan();

        // Data uji 1
        katalog.tambahKoleksi(new BukuCetak(
                "BK-001", "Java How to Program",
                2022, 620, "A-12", "Lantai 1", false));

        // Data uji 2
        katalog.tambahKoleksi(new BukuCetak(
                "BK-002", "Basis Data Relasional",
                2021, 410, "B-04", "Lantai 1", true));

        // Data uji 3
        katalog.tambahKoleksi(new Majalah(
                "MJ-001", "Info Teknologi Edisi 88",
                2026, "88", "Agustus", "C-01",
                "Lantai 2", true));

        // Data uji 4
        katalog.tambahKoleksi(new Majalah(
                "MJ-002", "Info Teknologi Edisi 87",
                2026, "87", "Juli", "C-02",
                "Lantai 2", false));

        // Data uji 5
        katalog.tambahKoleksi(new BerkasDigital(
                "BD-001", "Panduan Pemrograman Java",
                2024, 15,
                "unduh.polmed.ac.id/bd001"));

        // Data uji 6
        katalog.tambahKoleksi(new BerkasDigital(
                "BD-002", "Jurnal Rekayasa Perangkat",
                2025, 8,
                "unduh.polmed.ac.id/bd002"));

        System.out.println("=== KATALOG SIPUSTA ===");
        katalog.cetakStatus();

        System.out.println("\n=== URUTAN KOLEKSI ===");
        katalog.urut(new UrutLayakLaluJudul());
        katalog.cetakStatus();

        System.out.println("\n=== UJI PEMINJAMAN ===");

        cobaPinjam(katalog, "BK-001");
        cobaPinjam(katalog, "BK-001");
        cobaPinjam(katalog, "BK-002");
        cobaPinjam(katalog, "MJ-001");

        System.out.println("\n=== EKSPOR KATALOG ===");

        try {
            EksporKatalog ekspor = new EksporKatalog();

            ekspor.ekspor(
                    katalog.getDaftarKoleksi(),
                    "katalog.txt");

            System.out.println(
                    "Katalog berhasil disimpan ke katalog.txt");

        } catch (IOException e) {
            System.out.println(
                    "Gagal menyimpan katalog: "
                    + e.getMessage());
        }
    }

    public static void cobaPinjam(
            KatalogPerpustakaan katalog, String kode) {

        try {
            katalog.pinjam(kode);

        } catch (KoleksiSedangDipinjamException
                | KoleksiTidakLayakException e) {

            System.out.println(
                    "Peminjaman gagal: " + e.getMessage());

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
        }
    }
}