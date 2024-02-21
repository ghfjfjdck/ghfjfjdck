import java.lang.Exception

fun main(){
    try {
        var book1 = Book();
        book1.bk()
        var book2 = BookH();
        book2.Getinfo();
        book2.bk();
        var book3 = Info();
        book3.bk();
    }catch(e:Exception)
    {
        println("Введен символ");
    }

}