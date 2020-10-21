from textwrap import fill

from Book import Book


def main():
	books = [Book("Dunia Sophie", "Jostein Gaarder", "1996", 108000,
	              "Dunia sophie adalah sebuah novel filsafat. berkisah tentang seorang gadis berusia 14 tahun yang "
	              "sebelumnya hidup dengan wajar seperti anak-anak seusianya, hingga suatu ketika ia dikirimi surat "
	              "misterius berisi pertanyaan-pertanyaan filsafat. Selanjutnya buku ini akan membawa kita ke dalam "
	              "dunia filsafat, menembus sejarah mulai dari masa jahiliyah dimana orang-orang hanya percaya pada "
	              "dewa hingga masa dimana kita berdiri saat ini."),
	         Book("Sapiens: A Brief History of Humankind", "Yuval Noah Harari", "2011", 219000,
	              "Sekitar 13,5 miliar tahun lalu, materi, energi, waktu dan ruang hadir melalui Dentuman Besar "
	              "(Big Bang). Sekitar 300.000 tahun setelahnya, materi dan energi mulai menyatu membentuk struktur "
	              "yang kompleks, yang dinamai atom, yang lalu berkombinasi membentuk molekul. Sekitar 3,8 miliar "
	              "tahun lalu, di planet bernama Bumi, molekul-molekul tertentu membentuk struktur besar dan rumit "
	              "yang dinamai organisme. Sekitar 70.000 tahun lalu, organisme menjadi bagian dari spesies Homo "
	              "sapiens, membentuk struktur yang dinamai kebudayaan. Perkembangan selanjutnya dari kebudayaan "
	              "manusia itu dinamai sejarah."),
	         Book("A Brief History of Time", "Stephen Hawking", "1988", 70000,
	              "Inilah salah satu buku sains terpenting yang ditulis oleh satu di antara para ilmuwan besar zaman "
	              "kita, Stephen Hawking. Dalam buku ini Hawking membahas pertanyaan-pertanyaan besar seperti: "
	              "Bagaimana alam semesta bermula—dan apa yang memulainya? Apakah waktu itu, dan apakah ia selalu "
	              "bergerak maju? Adakah ujung alam semesta, dalam ruang maupun waktu? Adakah dimensi lain dalam alam "
	              "semesta? Apa yang terjadi ketika alam semesta berakhir? Lewat penulisan yang bisa dimengerti semua "
	              "orang, A Brief History of Time mengajak kita menjelajahi dunia ajaib lubang hitam dan kuark, antizat "
	              "dan “panah waktu”, ledakan besar dan peran Tuhan di alam semesta beserta segala kemungkinan yang "
	              "luar biasa dan tak terduga. Dengan penggambaran yang menarik dan menggugah imajinasi, Stephen "
	              "Hawking membawa kita makin dekat ke rahasia pamungkas penciptaan alam semesta.")]

	total_hb = list()
	total_hj = list()
	for book in books:
		print("Judul:", book.judul)
		print("Pengarang:", book.pengarang)
		print("Tahun Terbit:", book.tahun_terbit)
		print("Harga Beli: Rp." + str(book.harga_beli))
		total_hb.append(book.harga_beli)
		print("Harga Jual: Rp." + str(book.harga_jual))
		total_hj.append(book.harga_jual)
		print("Deskripsi:\n", fill(book.deskripsi), end="\n\n")

	print("Total Harga Beli Buku: Rp." + str(sum(total_hb)))
	print("Total Harga Jual Buku: Rp." + str(sum(total_hj)))


if __name__ == "__main__":
	main()
