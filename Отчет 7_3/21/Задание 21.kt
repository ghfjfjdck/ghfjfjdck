import kotlin.math.pow;
import kotlin.math.sqrt;
fun main(){

    try{

        println("Введите Диагональ");
        var d=readLine()!!.toDouble();
        println("Введите Сторону");
        var a=readLine()!!.toDouble();
        var S=0.00;
        var b=0.00;
        while(d<0){
            println("введите не отрицательное значение");
            d=readLine()!!.toDouble();
        }
        when{
            (d<=0.00||a<=0.00)->println("Конец");


            else-> {
            S = a * sqrt(d.pow(2.00) - a.pow(2.00))
            b = sqrt(d.pow(2.00) - a.pow(2.00))
            println("S= ${String.format("%.2f", S)}");
            println("b= ${String.format("%.2f", b)}");
                }
        }

    }catch(e:Exception){

        println("Введен символ");
    }
}