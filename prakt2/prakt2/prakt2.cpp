#include <windows.h>
#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <mutex>
#include <thread>
#include <locale>

std::mutex mtx; // Мьютекс для синхронизации доступа к файлу результатов
void calculateAverage(const std::string& filename, const std::string& resultFilename) {
    std::ifstream inputFile(filename);
    if (!inputFile.is_open()) {
        std::cerr << "Не удалось открыть файл: " << filename << std::endl;
        return;
    }
    double sum = 0;
    int count = 0;
    double number;
    // Чтение чисел из файла
    while (inputFile >> number) {
        sum += number;
        count++;
    }
    // Проверка на ошибки чтения
    if (inputFile.fail() && !inputFile.eof()) {
        std::cerr << "Ошибка при чтении данных из файла: " << filename << std::endl;
    }
    inputFile.close();

    // Вычисление среднего значения
    double average = (count > 0) ? (sum / count) : 0;
    // Запись результата в файл
    {
        std::lock_guard<std::mutex> lock(mtx); // Автоматическая блокировка мьютекса
        std::ofstream resultFile(resultFilename, std::ios::app);
        if (resultFile.is_open()) {
            resultFile << "Среднее значение из " << filename << ": " << average << std::endl;
            resultFile.close();
        }
        else {
            std::cerr << "Не удалось открыть файл для записи: " << resultFilename << std::endl;
        }
    }
    // Вывод отладочной информации
    std::cout << "Обработан файл: " << filename << ", Среднее: " << average << ", Чисел: " << count << std::endl;
}
int main() {
    setlocale(LC_ALL, "ru");
    const std::string resultFilename = "results.txt";
    // Удаляем файл результатов, если он существует
    std::remove(resultFilename.c_str());
    // Создаем массив файлов для чтения
    std::vector<std::string> files = { "data1.txt", "data2.txt", "data3.txt" };
    std::vector<std::thread> threads;
    // Создаем потоки для вычисления среднего значения
    for (const auto& file : files) {
        threads.emplace_back(calculateAverage, file, resultFilename);
    }
    // Ожидаем завершения всех потоков
    for (auto& thread : threads) {
        thread.join();
    }
    std::cout << "Вычисления завершены. Результаты записаны в " << resultFilename << std::endl;
    return 0;
}
