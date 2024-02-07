fun main(){
    try {
        println("Введите возраст человека");
        val age=readLine()!!.toInt();

            when{
                (age>0 && age<=2)->println("Младенец");
                (age>2 && age<12)->println("Детство");
                (age>=12 && age<18)->println("Подростковый возраст");
                (age>=18 && age<35)->println("Молодость");
                (age>=35 && age<60)->println("Зрелость");
                (age>=60 && age<110)->println("Пожилой возраст");
                else->println("Человека нет");
            }
    }catch(age:Exception) {
        println("Введен символ");
    }
}