import kotlin.math.pow

fun main() {
    try {
        println("Введите 1 число");
        var x1= readLine()!!.toDouble()
        println("Введите 2 число");
        var x2= readLine()!!.toDouble()
        when
        {
            (x1>x2)->x1++;
            (x2>x1)->x2++;
            (x1==x2)->x1=x1.pow(3)
            else-> print("Сообщение");
        }
             println("1 число = $x1");
             println("2 число = $x2");



    } catch (e: Exception) {
        print("Введен символ")
    }
}