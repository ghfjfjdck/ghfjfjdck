import kotlin.math.max
import kotlin.math.min
import kotlin.math.sin
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.math.ln
fun main() {
    try {
        println("Введите k");
        var k = readLine()!!.toInt();
        println("Введите l");
        var l = readLine()!!.toInt();
        println("Введите m");
        var m = readLine()!!.toInt();
          println("Введите x")
        var x=readLine()!!.toDouble();
        var y=0!!.toDouble();
          var z=0!!.toDouble();
        if(m==min(k,l))
            y=sin(Math.abs(x))/sqrt(x.pow(2)+1)

        if(m==max(k,l))
            y=Math.abs(x)*ln(1+x)

        if(m==min(k,l)||m==max(k,l))
            y=x.pow(3)+x+10.00.pow(-2);
else
    y=-1.00;

           z=y.pow(4)-y.pow(2)+5;
        println("y(x) = $y");
        println("x(y) = $z");
    } catch (e: Exception) {
        println("Введен символ");
    }
}