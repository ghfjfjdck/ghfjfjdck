fun main(){
    try {
        println("Введите x");
        var x=readLine()!!.toDouble();
        when{
            (x<=-3)->x=9.00;
            (x>-3)->x=(1)/(Math.pow(x,2.00)+1)
        }
        println("F(x) = $x");
    }catch(age:Exception) {
        println("Введен символ");
    }
}