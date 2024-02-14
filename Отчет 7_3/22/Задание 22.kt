import kotlin.math.pow;
import kotlin.math.sqrt;
fun main(){

    try{

        println("Введите a");
        var a=readLine()!!.toDouble();
        println("Введите b");
        var b=readLine()!!.toDouble();
        println("Введите c");
        var c=readLine()!!.toDouble();
        var D=0!!.toDouble();
        var x1=0!!.toDouble();
        var x2=0!!.toDouble();
        D=b.pow(2)-4*(a*c);
        when{
            (a==0.0||b==0.0||c==0.0)->println("Конец");
            (D<0)->println("Решений нет");
            (D==0.00)->{
                x2=-b-sqrt(D)/2*a
                println("x2 = $x2");
            }
           else->{
                x1 = -b + sqrt(D) / 2 * a
                x2 = -b - sqrt(D) / 2 * a
                println("D = $D");
                println("x1 = ${String.format("%.2f",x1)}");
                println("x2 = ${String.format("%.2f",x2)}");
            }
        }

    }catch(e:Exception){

        println("Введен символ");
    }
}