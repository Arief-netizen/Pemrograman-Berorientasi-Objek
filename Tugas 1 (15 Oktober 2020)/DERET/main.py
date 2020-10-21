from Deret import Deret


def main():
	a = float(input("Masukkan nilai awal: "))
	b = float(input("Masukkan beda: "))
	c = int(input("Masukkan jumlah angka: "))

	x = Deret(a, b, c)
	x.buat_deret()
	print(x.deret)
	print(x.deret_mean())


if __name__ == "__main__":
	main()
