package geekBrains.Lesson7;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Cat cat0 = new Cat("Барсик", 5, false);
        Cat cat1 = new Cat("Лакричка", 5, false);
        Cat cat2 = new Cat("Тимофей", 5, false);
        Cat cat3 = new Cat("Катя", 5, false);
        Cat cat4 = new Cat("Васька", 5, false);
        Cat[] arr = {cat0, cat1, cat2, cat3, cat4};

        Plate plate = new Plate(100, 0);
        plate.info();


        for (int  i = 0; i < arr.length; i++) {

            if (arr[i].satietyCat(arr[i].eat(plate))) //узнаем, остался ли кот сыт
            {
                plate.info();//если да, то просто узнаем количество еды на тарелке
            } else { //ессли кот не наелся
                plate.addAdditive(100); //добавляем еще еды
                plate.info();
                arr[i].satietyCat(arr[i].eat(plate)); //и кормим опять этого кота
                plate.info();
            }
        }
    }
}

class Cat {
    private String name;
    private int appetite;
    private boolean satiety; //сытость
    private Random random = new Random();//задаем разный аппетит котам

    public Cat(String name, int appetite, boolean satiety) {

        int randomAppetite = random.nextInt((30) + 1);

        this.name = name;
        this.appetite = appetite + randomAppetite;
        this.satiety = satiety;

    }

    public boolean eat(Plate plate) {
        //вызываем для тарелки метод уменьшения еды
        return plate.decreaseFood(appetite); //Если  true , то количесвто еды уменьшилось и значит кот покушал
    }
//метод говорит о сытости кота
    public boolean satietyCat(boolean satiety) {
        if (satiety) {
            System.out.println("Кот покушал, кот доволен.");
            return true;
        } else {
            System.out.println("Кот не наелся!");
        }
        return false;
    }
}

class Plate {
    private int food;
    private int additive;//Добавка

//у тарелки 2 переменные, количество еды и добавка
    public Plate(int food, int additive) {
        this.food = food; //количество еды
        this.additive = additive;//добавка
    }

    //Метод уменьшает количество еды на тарелке на n
    public boolean decreaseFood(int n) {
        if (n <= food) {
            food = food - n;
            return true;//если количество еды  больше или равно аппетитут кота
            // то  true
        }
        return false; //иначе false
    }

    //метод добавляет еду на тарелку, если кот не покушал
    public void addAdditive(int additive) {
        food = food + additive;
    }

    public void info() {
        System.out.println("Количесвто еды на тарелке " + food);
    }

}

