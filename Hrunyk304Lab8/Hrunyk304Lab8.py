import calculations

def main():
    # Список значень x для обчислення y
    x_values = [0.1, 0.5, 1.0, 2.0, 5.0, 3.0, 6.0]
    results = []

    # Обчислення значень виразу для кожного x
    for x in x_values:
        y = calculations.calculate_expression(x)
        if y is not None:
            results.append((x, y))

    # Запис у текстовий файл
    text_filename = "results.txt"
    calculations.write_to_text_file(text_filename, results)
    print(f"Результати записані у текстовий файл: {text_filename}")

    # Запис у двійковий файл
    binary_filename = "results.bin"
    calculations.write_to_binary_file(binary_filename, results)
    print(f"Результати записані у двійковий файл: {binary_filename}")

    # Зчитування з текстового файлу
    text_data = calculations.read_from_text_file(text_filename)
    print("Дані з текстового файлу:")
    for x, y in text_data:
        print(f"x = {x:.5f}, y = {y:.5f}")

    # Зчитування з двійкового файлу
    binary_data = calculations.read_from_binary_file(binary_filename)
    print("Дані з двійкового файлу:")
    for x, y in binary_data:
        print(f"x = {x:.5f}, y = {y:.5f}")  # Форматування для виводу з 5 знаками після коми

if __name__ == "__main__":
    main()
