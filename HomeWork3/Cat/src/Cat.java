import java.sql.SQLOutput;

public class Cat
{
    private Double originWeight;
    private Double weight;

    private Double minWeight;
    private Double maxWeight;

    private static Integer catCount = 0;

    //Конструктор котов
    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        catCount++;
    }

    //Конструктор с явным вводом
    public Cat(Double weight)
    {
        this.weight = weight;
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        catCount++;
    }

    //Конструктор для клонирования
    public Cat fullClone() {
        Cat clone = new Cat();
        clone.weight = this.weight;
        clone.originWeight = this.originWeight;
        clone.minWeight = this.minWeight;
        clone.maxWeight = this.maxWeight;
        return clone;
    }

    //Мяуканье
    public void meow()
    {
        weight = weight - 1;
        System.out.println("Meow");
    }

    //Кормежка котов
    public void feed(Double amount)
    {
        weight = weight + amount;
    }

    //Вода для котов
    public void drink(Double amount)
    {
        weight = weight + amount;
    }

    //Полчения веса кота
    public Double getWeight()
    {
        return weight;
    }

    //Получение состояния кота
    public String getStatus()
    {
        if(weight < minWeight) {
            catCount--;
            return "Dead";
        }
        else if(weight > maxWeight) {
            catCount--;
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }

    //Высисление веса еды
    public Double getWeightFood(){
        Double weightFood =  weight - originWeight;
        return weightFood;
    }

    //Поход кота в туалет
    public void toilet(){
        weight = weight - 250;
        System.out.println("Oups, meow");
    }

    //Метод вычисления разницы масс кошек
    public static Double getWeightDifference(Cat cat1, Cat cat2) {
        Double difference = Math.abs(cat1.getWeight() - cat2.getWeight());
        return difference;
    }

    //Мяуканье
    public void meow(Double weight) {
        this.weight = this.weight - weight;
        System.out.println("Meow");
    }

    //Счетчик котов
    public static Integer getCount() {
        return catCount;
    }
}