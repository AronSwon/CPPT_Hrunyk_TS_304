import math
import struct


def calculate_expression(x):
    """
    Обчислює вираз y = tg(x) / (3 * x) з точністю до 5 знаків після коми.

    Параметри:
        x (float): значення x для обчислення виразу.

    Повертає:
        float: результат обчислення виразу з округленням.
    """
    try:
        y = math.tan(x) / (3 * x)
        y = round(y, 5)  # Округлення до 5 знаків після коми
    except ZeroDivisionError:
        print("Помилка: ділення на нуль. Значення x не може бути нульовим.")
        y = None
    return y


def write_to_text_file(filename, data):
    """
    Записує результати обчислень у текстовий файл.

    Параметри:
        filename (str): ім'я файлу для запису.
        data (list): список даних для запису у файл.
    """
    with open(filename, 'w') as file:
        for x, y in data:
            file.write(f"x = {x:.5f}, y = {y:.5f}\n")  # Форматування з 5 знаками після коми


def read_from_text_file(filename):
    """
    Зчитує дані з текстового файлу.

    Параметри:
        filename (str): ім'я файлу для зчитування.

    Повертає:
        list: список кортежів зчитаних значень.
    """
    data = []
    with open(filename, 'r') as file:
        for line in file:
            parts = line.strip().split(',')
            x = float(parts[0].split('=')[1].strip())
            y = float(parts[1].split('=')[1].strip())
            data.append((x, y))
    return data


def write_to_binary_file(filename, data):
    """
    Записує результати обчислень у двійковий файл.

    Параметри:
        filename (str): ім'я файлу для запису.
        data (list): список даних для запису у файл.
    """
    with open(filename, 'wb') as file:
        for x, y in data:
            file.write(struct.pack('ff', x, y))


def read_from_binary_file(filename):
    """
    Зчитує дані з двійкового файлу.

    Параметри:
        filename (str): ім'я файлу для зчитування.

    Повертає:
        list: список кортежів зчитаних значень.
    """
    data = []
    with open(filename, 'rb') as file:
        while chunk := file.read(8):  # читаємо 8 байтів (2 float числа по 4 байти)
            x, y = struct.unpack('ff', chunk)
            data.append((x, y))
    return data
