import org.w3c.dom.ls.LSOutput;

public class Loader
{
    public static void main(String[] args)
    {
        //Создаем объекты котов
        Cat murzik = new Cat(2000.0);
        Cat vaska = new Cat();
        Cat stepa = new Cat();
        Cat ryzhyk = new Cat();
        Cat masya = new Cat();
        Cat dusya = new Cat();

        //Коты
        System.out.println("Murzik :" + murzik.getWeight());
        System.out.println("Vaska :" + vaska.getWeight());
        System.out.println("Stepa :" + stepa.getWeight());
        System.out.println("Ryzhyk :" + ryzhyk.getWeight());
        System.out.println("Masya :" + masya.getWeight());
        System.out.println("Dusya :" + dusya.getWeight());

        //Котёнок с весом
        System.out.println();
        Cat poops = getKitten();
        System.out.println("Poops: " + poops.getWeight());
        System.out.println();

        //Создаем объект нового кота Вовка. Он близнец коту Степа
        Cat vovka = stepa.fullClone();
        System.out.println("Vovka weight : " + vovka.getWeight());
        System.out.println();

        //Количество созданных котов
        System.out.println("Cat count: " + Cat.getCount());
        System.out.println();

        //Разница в весе между Мурзиком и Васькой
        System.out.println("Murzik weight: " + murzik.getWeight());
        System.out.println("Vaska weight: " + vaska.getWeight());
        System.out.println("Difference weight: " + Cat.getWeightDifference(murzik, vaska));
        System.out.println();

        //Кормим Мурзика, узнаем его статус и массу еды
        System.out.println("Murzik weight: " + murzik.getWeight());
        murzik.feed(100.0);
        System.out.println("Murzik weight: " + murzik.getWeight());
        System.out.println("Status: " + murzik.getStatus());
        System.out.println("Weight Food: " + murzik.getWeightFood());
        System.out.println();

        //Кормим Ваську, узнаем его статус и массу еды
        System.out.println("Vaska weight: " + vaska.getWeight());
        vaska.feed(200.0);
        System.out.println("Vaska weight: " + vaska.getWeight());
        System.out.println("Status: " + vaska.getStatus());
        System.out.println("Weight Food: " + vaska.getWeightFood());
        System.out.println();

        //Кормим Стёпу, узнаем его статус и массу еды
        System.out.println("Stepa weight: " + stepa.getWeight());
        stepa.feed(300.0);
        System.out.println("Stepa weight: " + stepa.getWeight());
        System.out.println("Status: " + stepa.getStatus());
        System.out.println("Weight Food: " + stepa.getWeightFood());
        System.out.println();

        //Кормим Рыжика, узнаем его статус и массу еды
        System.out.println("Ryzhyk weight: " + ryzhyk.getWeight());
        ryzhyk.feed(400.0);
        System.out.println("Ryzhyk weight: " + ryzhyk.getWeight());
        System.out.println("Status: " + ryzhyk.getStatus());
        System.out.println("Weight Food: " + ryzhyk.getWeightFood());
        System.out.println();

        //Кормим Масю, узнаем её статус и массу еды
        System.out.println("Masya weight: " + masya.getWeight());
        masya.feed(500.0);
        System.out.println("Masya weight: " + masya.getWeight());
        System.out.println("Status: " + masya.getStatus());
        System.out.println("Weight Food: " + masya.getWeightFood());
        System.out.println();

        //Кормим Дусю, узнаем её статус и массу еды
        System.out.println("Dusya weight: " + dusya.getWeight());
        dusya.feed(600.0);
        System.out.println("Dusya weight: " + dusya.getWeight());
        System.out.println("Status: " + dusya.getStatus());
        System.out.println("Weight Food: " + dusya.getWeightFood());
        System.out.println();

        //Перекармливаем Масю, узнаем её статус и массу еды
        System.out.println("Masya weight: " + masya.getWeight());
        masya.feed(10000.0);
        System.out.println("Masya weight: " + masya.getWeight());
        System.out.println("Status: " + masya.getStatus());
        System.out.println("Weight Food: " + masya.getWeightFood());
        System.out.println();

        //Мурзик сходил в туалет, узнаем его статус
        System.out.println("Murzik weight: " + murzik.getWeight());
        murzik.toilet();
        System.out.println("Murzik weight: " + murzik.getWeight());
        System.out.println("Status: " + murzik.getStatus());
        System.out.println();

        //Подсчёт котов
        System.out.println("Cat count: " + Cat.getCount());
        System.out.println();

        //"Замяукиваем" Мурзика
        for (Integer i = 0; i < 10000; i++) {
            murzik.meow();
            System.out.println("Murzik weight: " + murzik.getWeight());
            String status = murzik.getStatus();
            if (status.equals("Dead")) {
                System.out.println("Murzik is " + murzik.getStatus());
                break;
            }
        }
    }

    //Создаем котёнка
    public static Cat getKitten() {
        Double randomWeight = 100.0 + 100.0 * Math.random();
        Cat kitty = new Cat(randomWeight);
        return kitty;
    }
}