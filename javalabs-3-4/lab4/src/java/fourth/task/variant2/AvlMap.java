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
                    System.out.println("Введите ключ");
                    key = in.nextInt();
                    value = test.get(key);
                    if (value == null)
                        System.out.println("Элемента с таким ключем нет");
                    else
                        System.out.println("Ключ: " + key + " значение:" + value);
                    break;
                case 3:
                    System.out.println("Введите ключ");
                    key = in.nextInt();
                    value = test.remove(key);
                    if (value == null)
                        System.out.println("Элемента с таким ключем нет");
                    else
                        System.out.println("Ключ: " + key + " значение:" + value);
                    break;
                case 4:
                    System.out.println(test.getKeys());
                    break;
                case 5:
                    System.out.println(test.getValues());
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
    /**
     * Добавляет связку ключ-значение
     * @param key ключ по которому можно будет обратиться к значению
     * @param value значение
     */
    public void put(Comparable key, Object value) {
        MapEntry newNode = new MapEntry(key, value);
        keyTree.insert(newNode);
    }

    @Override
    /**
     * Выдает значение под ключу
     * @param key ключ
     * @return значение
     */
    public Object get(Comparable key) {
        MapEntry tmp = new MapEntry(key, null);
        return keyTree.find(tmp);
    }

    @Override
    /**
     * Удаляет значение по ключу
     * @param key ключ
     * @return удаленное значение, если связки нет, то возвращает null
     */
    public Object remove(Comparable key) {
        MapEntry tmp = new MapEntry(key, null);
        return keyTree.delete(tmp);
    }

    @Override
    /**
     * Возвращает все ключи отсортированные по возрастанию
     * @return множество ключей
     */
    public Set getKeys() {
        Set result = keyTree.returnKeys();
        return result;
    }

    @Override
    /**
     * Возвращает все значения отсортированные по ключу
     * @return список значений
     */
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
