class Number:
	def __init__(self, number):
		self._number = number

	# Getter number
	@property
	def number(self):
		return self._number

	# Cek Positif Genap
	def is_even_positive(self):
		if self._number % 2 == 0 and self._number > 0:
			return True
		return False

	# Cek Negatif Genap
	def is_even_negative(self):
		if self._number % 2 == 0 and self._number < 0:
			return True
		return False

	# Cek Positif Ganjil
	def is_odd_positive(self):
		if self._number % 2 == 1 and self._number > 0:
			return True
		return False

	# Cek Negatif Ganjil
	def is_odd_negative(self):
		if self._number % 2 == 1 and self._number < 0:
			return True
		return False
