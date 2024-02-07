import kotlin.math.pow
import kotlin.math.round
import kotlin.math.roundToInt

fun main(){
    try{
        println("Введите a");
        var a=readLine()!!.toDouble();
        println("Введите b");
        var b=readLine()!!.toDouble();
        println("Введите c");
        var c=readLine()!!.toDouble();
        var h=0!!.toDouble();
        var P=0!!.toDouble();
        var m=0!!.toDouble();
        var bc=0!!.toDouble();
        if(a<=0||b<=0||c<=0)
            println("Конец");
          else{
              P=(a+b+c)/2;
              h=(2/a)*Math.sqrt(P*(P-a)*(P-b)*(P-c))
               m=0.5*Math.sqrt(2*b.pow(2)*2*c.pow(2)-a.pow(2))
              bc=(2*Math.sqrt(b*c*P*(P-a)))/(b+c)
            print("Высота = ${String.format("%.2f", h)} Медиана = ${String.format("%.2f", m)} биссектриса = ${String.format("%.2f", bc)}");
          }



    }catch(e:Exception){
        print("Введен символ");

    }



}