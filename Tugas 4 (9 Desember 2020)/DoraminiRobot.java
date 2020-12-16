abstract class Robot
{
    String nama;
    String pemilik;
    int tahun;
    void setTahunpembuatan(int tahun)
    {
        System.out.println("Aku dibuat pada tahun " + tahun);
    }

    abstract void setNama(String nama);

    abstract void displayData();
}

class DoraMini extends Robot {
    void sayDora()
    {
        System.out.println("Hai, aku DoraMini");
    }

    @Override
    void setNama(String nama)
    {
        System.out.println("Nama panggilanku " + nama);
    }

    @Override
    void displayData()
    {
        sayDora();
        setNama("DoraMini");
        setTahunpembuatan(2020);
        System.out.print("\n");
    }

    public static void main(String[] args) {
        DoraMini DoraMini = new DoraMini();
        DoraMini.displayData();
    }
}