package labs.second.task.additional;

import labs.second.task.variant2.*;
import labs.second.task.variant2.body.*;

import java.util.Random;

/**
 * Created by Dartaan on 02.06.2015.
 *
 * НАПОМИНАНИЕ!!!
 * суть алгоритма остается та же,
 * НО теперь от спаривания 3 яйца, т.о. дракоши дохнут, но оставляют после себя +1 потомков
 * можно прикрутить, что если дракош больше 10, то рандомно 1-3 яйца
 *
 */
public class Breeder {

    private  labs.second.task.variant2.Dragon[] dragons = new labs.second.task.variant2.Dragon[120];
    private  int dragonsAmount;
    private  int time;

    private labs.second.task.variant2.Dragon crossDragon(labs.second.task.variant2.Dragon dragon1, labs.second.task.variant2.Dragon dragon2){

        labs.second.task.variant2.Dragon dragonChild = new labs.second.task.variant2.Dragon();

        if (new Random().nextBoolean()) {dragonChild.color = dragon1.color;} else { dragonChild.color = dragon2.color;}
        if (new Random().nextBoolean()) {dragonChild.size  = dragon1.size;}  else { dragonChild.size  = dragon2.size;}
        if (new Random().nextBoolean()) {dragonChild.head  = dragon1.head;}  else { dragonChild.head  = dragon2.head;}
        if (new Random().nextBoolean()) {dragonChild.tail  = dragon1.tail;}  else { dragonChild.tail  = dragon2.tail;}
        if (new Random().nextBoolean()) {dragonChild.wings = dragon1.wings;} else { dragonChild.wings = dragon2.wings;}



        return dragonChild;
    }

    private int bringDragon(Color color, Size size, Head head, Tail tail, Wings wings){
        labs.second.task.variant2.Dragon target = new labs.second.task.variant2.Dragon(color, size, head, tail, wings);
        labs.second.task.variant2.Dragon tmp;
        int answer = 0;
        int[] parents = {0, 0};

        for (int i = 0; i <= dragonsAmount; i++)
            if(dragons[i] == null){
                parents = chooseParents(color, size, head, tail, wings);
                break;
            }
            else if(dragons[i].equals(target) && !dragons[i].isEgg){
                answer = i;
                return answer;
            }

        for(int i = 0; i < 10; i++){

            tmp = crossDragon(dragons[parents[0]],dragons[parents[1]]);

            for (int j = 0; j < dragonsAmount; j++){
                if (tmp.equals(dragons[j])){ // если у нас уже есть такой дракон, то мы его выкидываем
                    break;
                }
                else if(j+1 == dragonsAmount){ // иначе добавляем в массив драконов
                    dragons[dragonsAmount] = tmp;
                    if (tmp.equals(target)){
                        answer = dragonsAmount;
                    }
                    dragonsAmount++;
                }
            }
        }

        if (answer == 0)/*если нужный образец не был получен, отправляемся в рекурсию*/{
            bringDragon(color, size, head, tail, wings);
        }

        return answer;
    }

    private int[] chooseParents(Color color, Size size, Head head, Tail tail, Wings wings){
        int priority1 = 0;
        int[] priority2 = {0, 0};
        int[] parents = {0 , 0};


        for (int i = 0; i < dragonsAmount; i++, priority1 = 0)/*выбираем первого родителя*/{
            if (dragons[i].color == color) {priority1++;}
            if (dragons[i].size == size) {priority1++;}
            if (dragons[i].head == head) {priority1++;}
            if (dragons[i].tail == tail) {priority1++;}
            if (dragons[i].wings == wings) {priority1++;}

            if(priority1 >= priority2[0]){
                priority2[0] = priority1;
                priority2[1] = i;
            }
        }
        parents[0] = priority2[1];
        priority2[0]=0;
        for (int i = 0; i < dragonsAmount; i++, priority1 = 0)/*выбираем второго родителя*/{
            if (dragons[i].color == color && dragons[i].color != dragons[parents[0]].color) {priority1++;}
            if (dragons[i].size  == size  && dragons[i].size  != dragons[parents[0]].size) {priority1++;}
            if (dragons[i].head  == head  && dragons[i].head  != dragons[parents[0]].head) {priority1++;}
            if (dragons[i].tail  == tail  && dragons[i].tail  != dragons[parents[0]].tail) {priority1++;}
            if (dragons[i].wings == wings && dragons[i].wings != dragons[parents[0]].wings) {priority1++;}

            if(priority1 > priority2[0]){
                priority2[0] = priority1;
                priority2[1] = i;
            }
        }
        parents[1] = priority2[1];

        return parents;
    }


    public static void main(String[] args) {

        dragons[0] = labs.second.task.variant2.Dragon.RATHIAN;
        dragons[1] = labs.second.task.variant2.Dragon.RATHALOS;
        dragons[2] = labs.second.task.variant2.Dragon.DEATHWING;
        dragonsAmount = 3;

        System.out.println("Дракон: " + dragons[new Breeder().bringDragon(Color.GREEN, Size.BIG, Head.TWO, Tail.MACE, Wings.LEATHER)]);


    }

}
