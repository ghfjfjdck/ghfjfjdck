import kotlin.math.pow;
import kotlin.math.min;
import kotlin.math.max;
fun main() {
    try{
    var z1=0!!.toDouble();
    var z2=0!!.toDouble();
    var z3=0!!.toDouble();
    println("Введите x");
    var x=readLine()!!.toDouble();
    println("Введите y");
    var y=readLine()!!.toDouble();
    z1=(min(x,y)+0.5)/(1+max(x,y)*max(x,y))

       if(y>=0)  z3=min(x,y);
       if(y<0) z3=max(x.pow(2),y.pow(2))
       if(x<0) z2=max(x,y);
       if(x>=0) z2=min(x,y);

          println(" Первое = ${String.format("%.2f",z1)}");
        println(" Второе = $z2");
        println(" Третье = $z3");
    }catch(e:Exception){
        println("Введен символ");
    }

}