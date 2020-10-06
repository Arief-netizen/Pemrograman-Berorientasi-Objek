FROM EMPLOYEE IMPORT EMPLOYEE


def main():
	humans = [Employee("Arief", "Baihaqy", 5000000), Employee("Imam", "Abil", 10000000)]
	for human in humans:
		print("Gaji anda perbulan sekarang adalah", human.monthly_salary)

	for human in humans:
		human.monthly_salary += human.monthly_salary * 10 / 100

	print()

	for human in humans:
		print("Gaji anda perbulan sekarang adalah", human.monthly_salary)


if __name__ == "__main__":
	main()
