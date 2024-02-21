
open class Book()
 {
     open var name="Sword"!!.toString();
     open var avtor="George"!!.toString();
     open var date=1989!!.toInt();
     open var Vlist=236!!.toInt();

         open fun Getinfo(){
             println("Название - $name");
             println("Автор - $avtor");
             println("год выпуска - $date");
             println("кол-во листов - $Vlist");

         }
  open fun bk()
 {
    print("Книга $name Открыта");
 }

 }
