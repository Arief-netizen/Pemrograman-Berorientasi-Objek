import java.util.Scanner;
public class ConanNovel {
	String title, writer, desc;
	int year,buyPrice, sellPrice;
	Scanner scan = new Scanner(System.in);
	
	//constructor
	ConanNovel(String t, String w, String d, int y, int bp){
		this.title = t;
		this.writer = w;
		this.desc = d;
		this.buyPrice = bp;
	}
	    
	void showTitle() {
			System.out.println("Judul: " + this.title);
	}
	
	void showItemData() {
		System.out.println("Judul: " + this.title);
		System.out.println("Penulis: " + this.writer);
		System.out.println("Deskripsi: " + this.desc);
		System.out.println("Tahun Penerbit: " + this.year);
		System.out.println("Harga Novel: " + this.buyPrice);
	}
	
	
	public static void main(String[] args) {
		int n = 0, x, bp, y;
		String t, w, d;
		
		Scanner scan = new Scanner(System.in);
		ConanNovel[] obj = new ConanNovel[3];
		
		//input novel description
		System.out.print("------------------------------------\n");
		System.out.print("Nama        : Imam Arief Al Baihaqy\n");
		System.out.print("NIM         : 19051397006\n");
		System.out.print("Prodi/Kelas : D4 Manajemen Informatika/2019A\n");
		System.out.print("------------------------------------\n");
		System.out.println("Silahkan input data novel");
		while (n < 3){
			x = n+1;
			System.out.println("Data ke-" + x);
			
			System.out.print("Judul: ");
			t = scan.next();
			System.lineSeparator();
			
			System.out.print("Penulis: ");
			w = scan.next();
			System.lineSeparator();
			
			System.out.print("Deskripsi: ");
			d = scan.next();
			System.lineSeparator();
			
			System.out.print("Tahun Penerbit: ");
			y = scan.nextInt();
			System.lineSeparator();
			
			System.out.print("Harga Novel: ");
			bp = scan.nextInt();
			System.lineSeparator();	
			obj [n] = new ConanNovel(t, w, d, y, bp);
			n++;
		}
		
		System.lineSeparator();
		System.out.println("=================");
		System.out.println("Data List: ");
		System.out.println("=================");
		for(int z = 0; z < 3; z++) {
			obj[z].showItemData();
		}
	}
}
