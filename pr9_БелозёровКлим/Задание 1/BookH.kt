
open class BookH:Book()
{
    var color="dark-blue"!!.toString();
    var tolsh=12!!.toInt();


   override fun Getinfo()
    {
        println("\nНазвание - $name");
        println("\nАвтор - $avtor");
        println("\nгод выпуска - $date");
        println("\nкол-во листов - $Vlist");
        println("\nцвет обложки -$color");
        println("\nТолщина листа -$tolsh");

    }
    override fun bk(){
        println("Книга $name закрыта");
    }

}