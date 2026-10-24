package model;

public class Majalah extends Koleksi
        implements Terarsip {

    private String edisi;
    private String bulanTerbit;
    private String rak;
    private String lantai;
    private boolean edisiTerbaru;

    public Majalah(String kode, String judul, int tahun,
            String edisi, String bulanTerbit, String rak,
            String lantai, boolean edisiTerbaru) {

        super(kode, judul, tahun);
        this.edisi = edisi;
        this.bulanTerbit = bulanTerbit;
        this.rak = rak;
        this.lantai = lantai;
        this.edisiTerbaru = edisiTerbaru;
    }

    @Override
    public boolean layakDipinjam() {
        return !edisiTerbaru;
    }

    @Override
    public String deskripsi() {
        return super.deskripsi()
                + " | Majalah | Edisi " + edisi
                + " | " + bulanTerbit
                + " | " + ringkasanArsip()
                + " | " + (edisiTerbaru
                ? "Edisi terbaru" : "Bukan edisi terbaru");
    }

    @Override
    public String nomorRak() {
        return rak;
    }

    @Override
    public String lokasiLantai() {
        return lantai;
    }
}