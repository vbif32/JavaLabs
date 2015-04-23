package fourth.task.variant2;

import fourth.instruments.CTree;
import fourth.instruments.SortedMap;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Dartaan on 14.04.2015.
 */
    public class AvlMap extends SortedMap {

    CTree keyTree;

    AvlMap() {
        keyTree = new CTree();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        AvlMap test = new AvlMap();
        int command, key;
        Object value;

        test.printUnit();
        for (; ; ) {
            System.out.println("Значения: " + test.getValues());
            System.out.println("Выберите действие\n" +
                    "1. Добавить элемент\n" +
                    "2. Получить значение по указанному ключу\n" +
                    "3. Удалить элемент с указанным ключом\n" +
                    "4. Вывести все ключи\n" +
                    "5. Вывести все значения\n" +
                    "0. Выход");
            command = in.nextInt();
            switch (command) {
                case 1:
                    System.out.println("Введите ключ и значение");
                    key = in.nextInt();
                    value = in.nextInt();
                    test.put(key, value);
                    break;
                case 2:
                    key = in.nextInt();
                    value = test.get(key);
                    if (value == null)
                        System.out.println("Элемента с таким ключем нет");
                    else
                        System.out.println("Найден ключ: " + key + "  со значением:" + value);
                    break;
                case 3:
                    System.out.println("Введите ключ");
                    key = in.nextInt();
                    value = test.remove(key);
                    if (value == null)
                        System.out.println("Элемента с таким ключем нет");
                    else
                        System.out.println("Удален ключ: " + key + " со значением:" + value);
                    break;
                case 4:
                    System.out.println("Ключи: " + test.getKeys());
                    break;
                case 5:
                    System.out.println("Значения: " + test.getValues());
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Ошибка ввода");
                    break;
            }
        }
    }

    @Override
    public void put(Comparable key, Object value) {
        if (get(key) == null) {
            MapEntry newNode = new MapEntry(key, value);
            keyTree.insert(newNode);
            System.out.println("Добавлен ключ: " + key + " со значением:" + value);
        } else
            System.out.println("Такой ключ уже есть");
    }

    @Override
    public Object get(Comparable key) {
        MapEntry tmp = new MapEntry(key, null);
        return keyTree.find(tmp);
    }

    @Override
    public Object remove(Comparable key) {
        if (get(key) == null)
            return null;
        MapEntry tmp = new MapEntry(key, null);
        return keyTree.delete(tmp);
    }

    @Override
    public Set getKeys() {
        Set result = keyTree.returnKeys();
        return result;
    }

    @Override
    public List getValues() {
        List result = keyTree.returnValues();
        return result;
    }

    @Override
    public int UnitNumber() {
        return 4;
    }

    @Override
    public String FIO() {
        return "Федин Михаил Андреевич";
    }

    @Override
    public String GroupNumber() {
        return "ИИБ-2-14";
    }

    public void printUnit() {
        System.out.println(UnitNumber());
        System.out.println(FIO());
        System.out.println(GroupNumber());
    }
}
