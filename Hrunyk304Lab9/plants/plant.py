# plants/plant.py

class Plant:
    """Клас, що представляє рослину"""

    def __init__(self, name, height):
        """
        Ініціалізація базових властивостей рослини

        :param name: Назва рослини
        :param height: Висота рослини (в см)
        """
        self.name = name
        self.height = height

    def grow(self, growth_amount):
        """
        Метод для зростання рослини на задану кількість сантиметрів

        :param growth_amount: Кількість сантиметрів, на яку зростає рослина
        """
        self.height += growth_amount
        print(f"Рослина ({self.name}) виросла на {growth_amount} см і тепер має висоту {self.height} см.")

    def display(self):
        """Виведення інформації про рослину"""
        print(f"Рослина: {self.name}, Висота: {self.height} см")
