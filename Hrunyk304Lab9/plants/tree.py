# plants/tree.py
from .plant import Plant

class Tree(Plant):
    """Клас, що представляє дерево, яке є різновидом рослини"""

    def __init__(self, name, height, age):
        """
        Ініціалізація властивостей дерева

        :param name: Назва дерева
        :param height: Висота дерева (в см)
        :param age: Вік дерева (в роках)
        """
        super().__init__(name, height)
        self.age = age

    def grow(self, growth_amount):
        """
        Метод для зростання дерева та збільшення віку

        :param growth_amount: Кількість сантиметрів, на яку зростає дерево
        """
        super().grow(growth_amount)
        self.age += 1
        print(f"{self.name} також стало на рік старше. Його вік тепер {self.age} років.")

    def display(self):
        """Виведення інформації про дерево"""
        super().display()
        print(f"Вік: {self.age} років")
