import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
   suspend fun main()= coroutineScope()
{

    try {
        var avto1 = Avto("", 0.0);
        delay(2000)
        var k: Int = avto1.Kolvo();
            launch()
            {
                for (i in 0..k-1) {
                    avto1.Input();
                }
                avto1.Info();
            }
            runBlocking {
                delay(3000);
            }

    }catch(e:Exception)
    {
        println("Ошибка неверный формат");
    }


}