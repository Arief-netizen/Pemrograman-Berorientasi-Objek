from GameFighting import GameFighting as gf


def main():
	# Membuat Objek
	raiden = fg("Raiden", 10, 20)
	sub_zero = fg("Sub-Zero", 5, 25)

	# Pertarungan dimulai
	print("======== GAME FIGHT ========", end="\n\n")

	# Melakukan beberapa perintah
	raiden.kick(sub_zero)
	sub_zero.kick(raiden)
	for i in range(3):
		sub_zero.hit(raiden)
	for i in range(4):
		raiden.kick(sub_zero)

	# Pertarungan berakhir
	print("======== K.O ========", end="\n\n")

	# Mengeluarkan hasil akhir
	print("=============", end="")
	print("\nHasil Akhir\n{0} : {1}\n{2} : {3}".format(
		raiden.name, raiden.life_point, sub_zero.name, sub_zero.life_point
	))
	print("=============", end="")


if __name__ == "__main__":
	main()