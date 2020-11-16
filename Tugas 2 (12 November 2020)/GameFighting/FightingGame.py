class GameFighting:
	def __init__(self, name, attack_hit_point, attack_kick_point):
		if (not type(name) is str) or \
				(not type(attack_hit_point) is int) or \
				(not type(attack_kick_point) is int):
			raise TypeError("Masukkan dengan benar!!!")
		self.__name = name
		self.__attack_hit_point = attack_hit_point
		self.__attack_kick_point = attack_kick_point
		self.__life_point = 100

	# Getter name
	@property
	def name(self):
		return self.__name

	# Getter life_point
	@property
	def life_point(self):
		return self.__life_point

	# Setter life_point
	@life_point.setter
	def life_point(self, new_life_point):
		self.__life_point = new_life_point

	# Getter attack_hit_point
	@property
	def attack_hit_point(self):
		return self.__attack_hit_point

	# Getter attack_kick_point
	@property
	def attack_kick_point(self):
		return self.__attack_kick_point

	# METHOD UTAMA

	# Info life_point Lawan
	def info_life_point_lawan(self, GameCharacter):
		print("Nyawa {0} sekarang {1}".format(GameCharacter.name, GameCharacter.life_point), end="\n\n")

	# Cek nyawa musuh
	def lawan_ko(self, GameCharacter):
		if GameCharacter.life_point <= 0:
			GameCharacter.life_point = 0
			return True
		return False

	# Cek nyawa saya
	def saya_ko(self):
		if self.__life_point <= 0:
			self.__life_point = 0
			return True
		return False

	# Memukul Musuh
	def hit(self, GameCharacter):
		if (not type(GameCharacter) is FightingGame):
			raise TypeError("Masukkan objek FightingGame")
		if self.lawan_ko(GameCharacter) or self.saya_ko():
			print("Nyawa {0} sudah mencapai 0".format(GameCharacter.name))
		else:
			GameCharacter.life_point -= self.__attack_hit_point
			print("{0} memukul {1}".format(self.__name, GameCharacter.name))
			print("Nyawa {0} berkurang sebesar {1}".format(GameCharacter.name, self.__attack_hit_point))
			self.info_life_point_lawan(GameCharacter)

	# Menendang Musuh
	def kick(self, GameCharacter):
		if (not type(GameCharacter) is FightingGame):
			raise TypeError("Masukkan objek FightingGame")
		if self.lawan_ko(GameCharacter) or self.saya_ko():
			print("Nyawa {0} sudah mencapai 0".format(GameCharacter.name))
		else:
			GameCharacter.life_point -= self.__attack_kick_point
			print("{0} menendang {1}".format(self.__name, GameCharacter.name))
			print("Nyawa {0} berkurang sebesar {1}".format(GameCharacter.name, self.__attack_kick_point))
			self.info_life_point_lawan(GameCharacter)