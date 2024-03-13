open class OP():Operator() {

    override var name:String="";
     override var cena:Int=0;
     override var S:Double=0.0;
     override var Q:Double=0.0;
     override fun Input()
     {
          println("Введите название оператора");
          name=readLine()!!.toString();
          println("Введите стоимость 1 минуты разговора");
          cena=readLine()!!.toInt();
          println("Введите площадь покрытия");
          S=readLine()!!.toDouble();
             Q=100*S/cena!!.toDouble();
     }
    override fun Qp()
    {

    }


}