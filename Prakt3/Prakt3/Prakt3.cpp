#include <iostream>
#include <thread>
#include <vector>
#include <fstream>
#include <chrono>
#include <locale>

const int SIZE = 1000000; // Размер массивов
const int NUM_THREADS = 4; // Количество потоков

void multiply(int* a, int* b, int* result, int start, int end) {
    for (int i = start; i < end; ++i) {
        result[i] = a[i] * b[i];
    }
}

int main() {
    setlocale(LC_ALL,"ru");
    // Инициализация массивов
    int* a = new int[SIZE];
    int* b = new int[SIZE];
    int* result = new int[SIZE];

    // Заполнение массивов случайными числами
    for (int i = 0; i < SIZE; ++i) {
        a[i] = rand() % 100;
        b[i] = rand() % 100;
    }

    // Измерение времени работы без потоков
    auto start = std::chrono::high_resolution_clock::now();
    for (int i = 0; i < SIZE; ++i) {
        result[i] = a[i] * b[i];
    }
    auto end = std::chrono::high_resolution_clock::now();
    std::chrono::duration<double> duration = end - start;
    std::cout << "Время выполнения без потоков: " << duration.count() << " секунд" << std::endl;

    // Измерение времени работы с потоками
    std::vector<std::thread> threads;
    int chunk_size = SIZE / NUM_THREADS;

    start = std::chrono::high_resolution_clock::now();
    for (int i = 0; i < NUM_THREADS; ++i) {
        int start_index = i * chunk_size;
        int end_index = (i == NUM_THREADS - 1) ? SIZE : (i + 1) * chunk_size;
        threads.emplace_back(multiply, a, b, result, start_index, end_index);
    }

    // Ожидание завершения всех потоков
    for (auto& thread : threads) {
        thread.join();
    }
    end = std::chrono::high_resolution_clock::now();
    duration = end - start;
    std::cout << "Время выполнения с потоками: " << duration.count() << " секунд" << std::endl;

    // Сохранение результата в файл
    std::ofstream outFile("result.txt");
    for (int i = 0; i < SIZE; ++i) {
        outFile << result[i] << std::endl;
    }
    outFile.close();

    // Освобождение памяти
    delete[] a;
    delete[] b;
    delete[] result;

    return 0;
}
