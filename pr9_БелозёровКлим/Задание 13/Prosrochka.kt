class Prosrochka :Price(){
    override var name="Picnic";
    override var kind="Сладкое";
    override var price=100;
    var date =1989;
    open fun Pros(){
        if(date<2024)
        println("Просрочка")

    }
    override fun Item(){
        println("Цена не изменилась");
    }
    override fun Info() {
        println("Товар - $name \nЦена - $price \nЕд.изм - $ed \nВид товара - $kind\nКол-во - $qua\n Год производства - $date");
    }
}