import java.lang.Exception

fun main()
{
    try {
        {
        }
        var oper1 = OP();
        oper1.Input();
        var oper2 = Plata();
        oper2.name = oper1.name;
        oper2.cena = oper1.cena;
        oper2.S = oper1.S;
        oper2.Q = oper1.Q;
        oper2.Info();
    }catch(e:Exception)
    {
        println("Ошибка");

    }


}