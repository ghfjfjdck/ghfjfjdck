#include <iostream>
#include <limits>
#include <locale>
using namespace std;

struct UnderflowException {};

int divide(int n, int m) {
    if (m == 0) {
        throw "Деление на ноль";
    }
    if (n == std::numeric_limits<int>::min() && m == -1) {
        throw UnderflowException(); // Это переполнение
    }
    int result = n / m;
    return result;
}

int main() {
    setlocale(LC_ALL, "ru");
    int n, m;
    cout << "Введите два целых числа (n и m): ";
    cin >> n >> m;
    try {
        int result = divide(n, m);
        cout << "Результат: " << result << endl;
    }
    catch (const char* msg) {
        cout << "Ошибка: " << msg << endl;
    }
    catch (UnderflowException&) {
        cout << "Ошибка: Произошло переполнение при делении." << endl;
    }
    cout << "Программа завершена." << endl;
    return 0;
}
