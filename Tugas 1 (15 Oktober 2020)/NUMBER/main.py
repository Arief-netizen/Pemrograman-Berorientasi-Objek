from random import randint

from Number import Number


def main():
	numbers = [Number(randint(-10, 10)), Number(randint(-10, 10)),
	           Number(randint(-10, 10)), Number(randint(-10, 10)),
	           Number(randint(-10, 10)), Number(randint(-10, 10))]

	for number in numbers:
		print("Angka:", number.number)
		print("Positif Genap:", number.is_even_positive())
		print("Negatif Genap:", number.is_even_negative())
		print("Positif Ganjil:", number.is_odd_positive())
		print("Negatif Ganjil:", number.is_odd_negative(), end="\n\n")


if __name__ == "__main__":
	main()
