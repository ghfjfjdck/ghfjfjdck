import kotlin.math.pow

fun main(){
    try{
        println("Введите первый член геометрической прогресии");
        var b1= readLine()!!.toDouble();
        if(b1==0.00)
        {
            println("Конец");
        }else{
        println("Введите знаменатель геометрической прогресии");
        var q= readLine()!!.toDouble();
        var sum=0!!.toDouble();
        println("K<P");
        println("Введите номер K от какого номера считать");
        var K = readLine()!!.toInt();
        println("Введите номер P до какого номера считать");
        var P = readLine()!!.toInt();
        while(K>P){
            println("K<P");
            println("Введите номер K от какого номера считать");
            K = readLine()!!.toInt();
            println("Введите номер P до какого номера считать");
            P = readLine()!!.toInt();
        }

        for(i in 0..P){
            sum+=b1*(q.pow(i-1))
        }

        println("Сумма геометрической прогрессии от $K до $P = $sum");
        }
    }catch(e:Exception){
println("Введен символ");
    }




}