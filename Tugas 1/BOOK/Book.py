class Book:
	def __init__(self, judul, pengarang, tahun_terbit, harga_beli, deskripsi):
		self._judul = judul
		self._pengarang = pengarang
		self._tahun_terbit = tahun_terbit
		self._harga_beli = harga_beli
		self._deskripsi = deskripsi
		self._harga_jual = int(self._harga_beli - (0.2 * self._harga_beli))

	# Getter Judul
	@property
	def judul(self):
		return self._judul

	# Getter Pengarang
	@property
	def pengarang(self):
		return self._pengarang

	# Getter Tahun Terbit
	@property
	def tahun_terbit(self):
		return self._tahun_terbit

	# Getter Harga Beli
	@property
	def harga_beli(self):
		return self._harga_beli

	# Getter Harga Jual
	@property
	def harga_jual(self):
		return self._harga_jual

	# Getter Deskripsi
	@property
	def deskripsi(self):
		return self._deskripsi
