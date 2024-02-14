import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow
fun main() {
    try {
        println("Введите x");
        var x = readLine()!!.toDouble();
        println("Введите y");
        var y = readLine()!!.toDouble();

            if(x<=1.00&&x>=-1.00&&y<=1.00&&y>=-1) println("точка принадлежит варианту a");
            if(x<=0.5&&x>=-0.5&&y<=2&&y>=-2) println("точка принадлежит варианту б");
            if(x<=1&&x>=-2&&y<=1&&y>=-1) println("точка принадлежит варианту в");
            else println("точка не принадлежит не одному из вариантов");

    } catch (e: Exception) {
        println("Введен символ");
    }
}