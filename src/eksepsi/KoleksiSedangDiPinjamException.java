package eksepsi;

public class KoleksiSedangDiPinjamException extends PustakaException {
    public KoleksiSedangDiPinjamException(String judul) {
        super("Maaf, \"" + judul + "\" sedang dipinjam oleh pengguna lain. "
                + "Silakan coba lagi setelah koleksi dikembalikan.");
    }
}