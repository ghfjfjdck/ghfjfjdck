import kotlin.math.pow

fun main() {
    try {
        println("Введите число от 0 до 9");
        var x1= readLine()!!.toInt()
        while(x1<0 || x1>9) {
            println("число должно быть от 0 до 9");
        }
        when(x1)
        {
            1->println("Один");
            2->println("Два");
            3->println("Три");
            4->println("Четыре");
            5->println("Пять");
            6->println("Шесть");
            7->println("Семь");
            8->println("Восемь");
            9->println("Девять");
        }

    } catch () {
        print("Введен символ")
    }
}