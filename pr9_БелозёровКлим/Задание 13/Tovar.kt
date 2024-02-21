open class Tovar() {
    open var name="Мыло";
    open var price=125;
    open var ed="шт";
    open var kind="Хозяйственный";
    open var qua=3;

    open fun Item(){
        println("Мыло подорожало");
        price = price+5;
        println("Цена - $price");
    }
    open fun Info(){
        println("Товар - $name \nЦена - $price \nЕд.изм - $ed \nВид товара - $kind\nКол-во - $qua");
    }
    open fun Sell(){
    if(qua>2){
        println("От двух штук скидка 25");
        price=price-25;
        println("Цена - $price");
    }else
        println("Скидки нету");
    }
}