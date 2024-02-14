import kotlin.math.pow;
import kotlin.math.sqrt;
fun main(){

    try{

        println("Введите x");
        var x=readLine()!!.toDouble();
        println("Введите y");
        var y=readLine()!!.toDouble();
           when{
               (x>=-3&&x<=1 && y>=-1&&y<=1)->println("точка принадлежит варианту a");

               (x>=-1&&x<=1 && y>=-2&&y<=2)->println("точка принадлежит варианту б");

               (x>=-1&&x<=1 && y>=-1&&y<=2)->println("точка принадлежит варианту в");

               (x>=-2&&x<=1 && y>=-2&&y<=1)->println("точка принадлежит варианту г");
               else->println("точка не принадлежит ни одной закрашеной область");
           }

    }catch(e:Exception){

        println("Введен символ");
    }
}