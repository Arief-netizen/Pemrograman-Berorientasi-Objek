FROM ACCOUNT IMPORT ACCOUNT


def main():
	humans = [Account(10000), Account(50000)]
	print(humans[0].initial_balance)


if __name__ == "__main__":
	main()
