open class Price:Tovar() {
    override var name="Сникерс";
    override var kind="Сладкое";
    override var price=65;

    override fun Info(){
        println("Товар - $name \nЦена - $price \nЕд.изм - $ed \nВид товара - $kind\nКол-во - $qua");
    }
    override fun Item(){
        println("Цена упала");
        price=price-5;
        println("Цена - $price");
    }
}