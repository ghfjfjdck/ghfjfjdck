fun main(){

    try{

        println("Введите высоту");
        var h=readLine()!!.toDouble();
        var t=0!!.toDouble();
        var g=9.8;
        while(h<0){
            println("введите не отрицательное значение");
            h=readLine()!!.toDouble();
        }
            when {
                (h == 0.00) -> println("Конец Время падения камня 0 секунд");


                else ->{
                    t = Math.sqrt(2 * h / g);
                    println("Время падения камня = ${String.format("%.2f", t)}");
                }
            }

    }catch(e:Exception){

        println("Введен символ");
    }



}