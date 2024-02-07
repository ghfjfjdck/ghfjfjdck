fun main(){
    try {
        println("Введите  кол-во жёлудей у Ниф Нифа");
        var x1=readLine()!!.toInt();
        println("Введите  кол-во жёлудей у Нуф Нуфа");
        var x2=readLine()!!.toInt();
        println("Введите  кол-во жёлудей у Наф Нафа");
        var x3=readLine()!!.toInt();
        when{
            (x1>x2&&x2>x3)->println("Наф-Наф набрал меньше всех");
            (x3>x2&&x2>x1)->println("Ниф-Ниф набрал меньше всех");
            (x1>x3&&x3>x2)->println("Нуф-Нуф набрал меньше всех");
            else -> println("Ошибка");
        }
    }catch(x:Exception) {
        println("Введен символ");
    }
}