class Pecahan:
	def __init__(self, pembilang, penyebut):
		if (not type(pembilang) is int) or (not type(penyebut) is int):
			raise TypeError("Masukkan dengan benar!!!")
		self.__pembilang = pembilang
		self.__penyebut = penyebut

	# Getter pembilang
	@property
	def pembilang(self):
		return self.__pembilang

	# Getter penyebut
	@property
	def penyebut(self):
		return self.__penyebut

	# METHOD UTAMA

	def tambah(self, angka_2):
		if (not type(angka_2) is Pecahan):
			raise TypeError("Masukkan objek pecahan!!!")
		new_penyebut = angka_2.penyebut * self.__penyebut
		pembilang_1 = (new_penyebut / self.__penyebut) * self.__pembilang
		pembilang_2 = (new_penyebut / angka_2.penyebut) * angka_2.pembilang
		new_pembilang = pembilang_1 + pembilang_2
		return Pecahan(int(new_pembilang), int(new_penyebut))
