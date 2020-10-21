class Deret:
	def __init__(self, nilai_awal, beda, jumlah_angka):
		self._nilai_awal = nilai_awal
		self._beda = beda
		self._jumlah_angka = jumlah_angka
		self._deret = list()

	# Getter deret
	@property
	def deret(self):
		return self._deret

	# Buat deret
	def buat_deret(self):
		i = 0
		angka = 0
		while True:
			if i == self._jumlah_angka:
				break
			if i == 0:
				angka = self._nilai_awal
			else:
				angka += self._beda
			self._deret.append(angka)
			i += 1
		return True

	# Cari rata-rata deret
	def deret_mean(self):
		return sum(self._deret) / len(self._deret)
