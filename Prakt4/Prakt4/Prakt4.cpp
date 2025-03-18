#include <iostream>
#include <cstdlib> // Для rand и srand
#include <ctime>   // Для time
#include <Windows.h> // Для VirtualAlloc и HeapAlloc
#include <locale>

void fillArrayWithRandomNumbers(int* arr, int size) {
    for (int i = 0; i < size; i++) {
        arr[i] = rand() % 100; // Заполнение случайными числами от 0 до 99
    }
}

int main() {
    setlocale(LC_ALL, "ru");
    // Установка генератора случайных чисел
    srand(static_cast<unsigned int>(time(0)));

    int size;
    std::cout << "Введите размер массива: ";
    std::cin >> size;

    // 1. Выделение памяти с использованием malloc
    int* arr_malloc = (int*)malloc(size * sizeof(int));
    if (arr_malloc == NULL) {
        std::cerr << "Не удалось выделить память с помощью malloc\n";
        return 1;
    }

    // Заполнение массива случайными числами
    fillArrayWithRandomNumbers(arr_malloc, size);

    // Вывод содержимого массива и суммы
    int sum = 0;
    std::cout << "Массив (malloc): ";
    for (int i = 0; i < size; i++) {
        std::cout << arr_malloc[i] << " ";
        sum += arr_malloc[i];
    }
    std::cout << "\nСумма: " << sum << std::endl;

    // Прибавление суммы к каждому элементу массива
    for (int i = 0; i < size; i++) {
        arr_malloc[i] += sum;
    }

    // Вывод измененного массива
    std::cout << "Измененный массив (malloc): ";
    for (int i = 0; i < size; i++) {
        std::cout << arr_malloc[i] << " ";
    }
    std::cout << std::endl;

    // Освобождение памяти
    free(arr_malloc);

    // 2. Выделение памяти с использованием new
    int* arr_new = new int[size];
    fillArrayWithRandomNumbers(arr_new, size);

    // Сброс суммы для нового массива
    sum = 0;
    std::cout << "Массив (new): ";
    for (int i = 0; i < size; i++) {
        std::cout << arr_new[i] << " ";
        sum += arr_new[i];
    }
    std::cout << "\nСумма: " << sum << std::endl;

    // Прибавление суммы к каждому элементу массива
    for (int i = 0; i < size; i++) {
        arr_new[i] += sum;
    }

    // Вывод измененного массива
    std::cout << "Измененный массив (new): ";
    for (int i = 0; i < size; i++) {
        std::cout << arr_new[i] << " ";
    }
    std::cout << std::endl;

    // Освобождение памяти
    delete[] arr_new;

    // 3. Выделение памяти с использованием VirtualAlloc
    int* arr_virtual = (int*)VirtualAlloc(NULL, size * sizeof(int), MEM_COMMIT, PAGE_READWRITE);
    if (arr_virtual == NULL) {
        std::cerr << "Не удалось выделить память с помощью VirtualAlloc\n";
        return 1;
    }

    fillArrayWithRandomNumbers(arr_virtual, size);

    // Сброс суммы для нового массива
    sum = 0;
    std::cout << "Массив (VirtualAlloc): ";
    for (int i = 0; i < size; i++) {
        std::cout << arr_virtual[i] << " ";
        sum += arr_virtual[i];
    }
    std::cout << "\nСумма: " << sum << std::endl;

    // Прибавление суммы к каждому элементу массива
    for (int i = 0; i < size; i++) {
        arr_virtual[i] += sum;
    }

    // Вывод измененного массива
    std::cout << "Измененный массив (VirtualAlloc): ";
    for (int i = 0; i < size; i++) {
        std::cout << arr_virtual[i] << " ";
    }
    std::cout << std::endl;

    // Освобождение виртуальной памяти
    VirtualFree(arr_virtual, 0, MEM_RELEASE);

    // 4. Выделение памяти с использованием HeapAlloc
    HANDLE hHeap = HeapCreate(0, 0, 0);
    if (hHeap == NULL) {
        std::cerr << "Не удалось создать кучу\n";
        return 1;
    }

    int* arr_heap = (int*)HeapAlloc(hHeap, 0, size * sizeof(int));
    if (arr_heap == NULL) {
        std::cerr << "Не удалось выделить память с помощью HeapAlloc\n";
        HeapDestroy(hHeap);
        return 1;
    }

    fillArrayWithRandomNumbers(arr_heap, size);

    // Сброс суммы для нового массива
    sum = 0;
    std::cout << "Массив (HeapAlloc): ";
    for (int i = 0; i < size; i++) {
        std::cout << arr_heap[i] << " ";
        sum += arr_heap[i];
    }
    std::cout << "\nСумма: " << sum << std::endl;

    // Прибавление суммы к каждому элементу массива
    for (int i = 0; i < size; i++) {
        arr_heap[i] += sum;
    }

    // Вывод измененного массива
    std::cout << "Измененный массив (HeapAlloc): ";
    for (int i = 0; i < size; i++) {
        std::cout << arr_heap[i] << " ";
    }
    std::cout << std::endl;

    // Освобождение памяти
    HeapFree(hHeap, 0, arr_heap);
    HeapDestroy(hHeap);

    return 0;
}
