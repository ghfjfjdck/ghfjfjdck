class Plata():OP() {

 init {
  var name: String = name;
  var cena: Int = cena;
  var S: Double = S;
  var Q: Double = Q;
 }
override fun Qp()
{
 var sum:Double;
 println("Была произведена плата за каждое соединение");
 println("1-да");
 println("2-нет");
 var pp= readLine()!!.toInt();
 if(pp==1)
 {
     sum=0.7*Q;
 }else
         sum=1.5*Q;

 println("Qp = ${String.format("%.2f",sum)}");
}
override fun Info()
{
 println("Оператор - $name");
 println("Стоимость 1 минуты разговора - $cena");
 println("Площадь покрытия - $S");
 println("Q -  ${String.format("%.2f",Q)}");
Qp();

 }

}


