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
        if(d<=0.00||a<=0.00)
            println("Конец");
        else{
            S=a*sqrt(d.pow(2.00)-a.pow(2.00))
            b=sqrt(d.pow(2.00)-a.pow(2.00))
            println("S= $S");
            println("b= $b");
        }

    }catch(e:Exception){

        println("Введен символ");
    }
}