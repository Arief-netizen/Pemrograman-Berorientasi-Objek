from Pecahan import Pecahan as pc


def main():
	# Buat Objek
	angka_1 = pc(3, 2)
	angka_2 = pc(5, 6)

	# Hitung Hasil
	hasil = angka_1.tambah(angka_2)

	# Tampilkan kesimpulan
	print("Pecahan {0}/{1} + Pecahan {2}/{3} = {4}/{5}".format(
		angka_1.pembilang, angka_1.penyebut, angka_2.pembilang,
		angka_2.penyebut, hasil.pembilang, hasil.penyebut
	))


if __name__ == "__main__":
	main()
