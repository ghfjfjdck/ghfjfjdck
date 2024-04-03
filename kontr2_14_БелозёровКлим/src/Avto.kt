class Avto( marka:String,power:Double):abstracteclassavto(marka,power) {
    var k=0;
    var x=0;
    var c=0;
    var proverka=0;
    var mas=Array(k){""};
    override fun Input() {
        proverka=0;
        while(proverka!=1){
            try{
                marka="";
                while(marka==""||marka==" ") {
                    println("Введите марку машины ${c + 1}");
                    marka = readLine()!!.toString();
                }
                power=0.0;
          while(power<=0.0)
          {
            println("Введите мощность машины");
            power = readLine()!!.toDouble();
                if(power!=0.0&&power>0.0) {
                    mas[x] = "Марка - $marka Мощность - $power";
                    x++;
                    c++;
                    proverka=1;
                }
            }
            }catch(e:Exception)
            {
                println("Ошибка неверный формат");
            }
    }
        }


    override fun Info() {
       for(i in 0..mas.size-1)
       {
           println("Авто ${i+1}");
           println(mas[i]);
       }
    }
    override fun Kolvo():Int {
        println("Введите сколько раз повторить");
         k=readLine()!!.toInt();
         mas=Array(k){""};
        return k;
    }
}