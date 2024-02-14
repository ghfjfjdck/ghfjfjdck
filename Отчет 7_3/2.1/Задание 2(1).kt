import kotlin.math.pow;
import kotlin.math.sqrt;
import kotlin.math.min;
import kotlin.math.max;
import kotlin.math.sin;
import kotlin.math.abs;
fun main(){

    try{

        println("Введите X");
        var x=readLine()!!.toDouble();
        println("Введите K")
         var k=readLine()!!.toInt();
        println("Введите N")
        var n=readLine()!!.toInt();
        println("Введите M")
        var m=readLine()!!.toInt();
var y=0.00;
         when{

             (m==max(k,n))->y=sin(abs(x))/x.pow(2)
             (m==min(k,n))->y=sin(abs(x))/(x.pow(2)+1)
             else->y=-1.00;
         }
      println("y(x) = ${String.format("%.2f",y)}");


    }catch(e:Exception){

        println("Введен символ");
    }
}