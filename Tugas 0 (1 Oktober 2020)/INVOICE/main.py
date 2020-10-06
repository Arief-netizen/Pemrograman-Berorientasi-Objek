FROM INVOICE IMPORT INVOICE


def main():
	items = [Invoice("GTX 1650", "VGA", 5, 10000000), Invoice("Ryzen 7 3750h", "Processor", 10, 8000000)]
	for item in items:
		print(item.part_num)
		print(item.part_desc)
		print(item.quantity)
		print(item.price)
		print("Total tagihan anda :", item.get_invoice_amount(), end="\n\n")


if __name__ == "__main__":
	main()
