# main.py
from plants.plant import Plant
from plants.tree import Tree

def main():
    # Створення об'єкта типу Рослина
    plant = Plant("Квітка", 30)
    plant.display()
    plant.grow(5)

    print("\n")  # Додатковий відступ між виведеннями

    # Створення об'єкта типу Дерево
    tree = Tree("Дуб", 150, 5)
    tree.display()
    tree.grow(20)

if __name__ == "__main__":
    main()
