import core.*;
import core.Camera;

public class RoadController
{
    //Создается переменная passengerCarMaxWeight с типом Double
    public static Double passengerCarMaxWeight = 3500.0; // kg
    //Создается переменная passengerCarMaxHeight с типом Integer
    public static Integer passengerCarMaxHeight = 2000; // mm
    //Создается переменная controllerMaxHeight с типом Integer
    public static Integer controllerMaxHeight = 3500; // mm

    //Создается переменная passengerCarPrice с типом Integer
    public static Integer passengerCarPrice = 100; // RUB
    //Создается переменная cargoCarPrice с типом Integer
    public static Integer cargoCarPrice = 250; // RUB
    //Создается переменная vehicleAdditionalPrice с типом Integer
    public static Integer vehicleAdditionalPrice = 200; // RUB

    //Создается переменная maxOncomingSpeed с типом Integer
    public static Integer maxOncomingSpeed = 60; // km/h
    //Создается переменная speedFineGrade с типом Integer
    public static Integer speedFineGrade = 20; // km/h
    //Создается переменная finePerGrade с типом Integer
    public static Integer finePerGrade = 500; // RUB
    //Создается переменная criminalSpeed с типом Integer
    public static Integer criminalSpeed = 160; // km/h

    public static void main(String[] args)
    {
        //Создание переменной i с типом Integer
        for(Integer i = 0; i < 10; i++)
        {
            //Создание переменной car
            Car car = Camera.getNextCar();
            System.out.println(car);
            System.out.println("Скорость: " + Camera.getCarSpeed(car) + " км/ч");

            /**
             * Проверка на наличие номера в списке номеров нарушителей
             */
            //Создание переменной policeCalled с типом Boolean
            Boolean policeCalled = false;
            for(String criminalNumber : Police.getCriminalNumbers())
            {
                //Создание переменной carNumber с типом String
                String carNumber = car.getNumber();
                if(carNumber.equals(criminalNumber)) {
                    Police.call("автомобиль нарушителя с номером " + carNumber);
                    blockWay("не двигайтесь с места! За вами уже выехали!");
                    break;
                }
            }
            if(Police.wasCalled()) {
                continue;
            }

            /**
             * Пропускаем автомобили спецтранспорта
             */
            if(car.isSpecial()) {
                openWay();
                continue;
            }

            /**
             * Проверяем высоту и массу автомобиля, вычисляем стоимость проезда
             */
            //Создание переменной carHeight с типом Integer
            Integer carHeight = car.getHeight();
            //Создание переменной price с типом Integer
            Integer price = 0;
            if(carHeight > controllerMaxHeight)
            {
                blockWay("высота вашего ТС превышает высоту пропускного пункта!");
                continue;
            }
            else if(carHeight > passengerCarMaxHeight)
            {
                //Создание переменной weight с типом Double
                Double weight = WeightMeter.getWeight(car);
                //Грузовой автомобиль
                if(weight > passengerCarMaxWeight)
                {
                    price = cargoCarPrice;
                    if(car.hasVehicle()) {
                        price = price + vehicleAdditionalPrice;
                    }
                }
                //Легковой автомобиль
                else {
                    price = passengerCarPrice;
                }
            }
            else {
                price = passengerCarPrice;
            }

            /**
             * Проверка скорости подъезда и выставление штрафа
             */
            //Создание переменной carSpeed с типом Integer
            Integer carSpeed = Camera.getCarSpeed(car);
            if(carSpeed > criminalSpeed)
            {
                Police.call("cкорость автомобиля - " + carSpeed + " км/ч, номер - " + car.getNumber());
                blockWay("вы значительно превысили скорость. Ожидайте полицию!");
                continue;
            }
            else if(carSpeed > maxOncomingSpeed)
            {
                //Создание переменной overSpeed с типом Integer
                Integer overSpeed = carSpeed - maxOncomingSpeed;
                //Создание переменной totalFine с типом Integer
                Integer totalFine = finePerGrade * (1 + overSpeed / speedFineGrade);
                System.out.println("Вы превысили скорость! Штраф: " + totalFine + " руб.");
                price = price + totalFine;
            }

            /**
             * Отображение суммы к оплате
             */
            System.out.println("Общая сумма к оплате: " + price + " руб.");
        }

    }

    /**
     * Открытие шлагбаума
     */
    public static void openWay()
    {
        System.out.println("Шлагбаум открывается... Счастливого пути!");
    }

    public static void blockWay(String reason)
    {
        System.out.println("Проезд невозможен: " + reason);
    }
}