package fourth.task.variant2;

import fourth.instruments.SortedMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Dartaan on 14.04.2015.
 */
    public class AvlMap extends SortedMap {

    CTree keyTree;

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
        return keyTree.find(key);
    }

    @Override
    /**
     * Удаляет значение по ключу
     * @param key ключ
     * @return удаленное значение, если связки нет, то возвращает null
     */
    public Object remove(Comparable key) {
        return keyTree.delete(key);
    }

    @Override
    /**
     * Возвращает все ключи отсортированные по возрастанию
     * @return множество ключей
     */
    public Set getKeys() {
        Set result = keyTree.returnAll();
        return null;
    }

    @Override
    /**
     * Возвращает все значения отсортированные по ключу
     * @return список значений
     */
    public List getValues() {
        ArrayList ValueList;

        return null;
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

    public void testFuntions(){

    }

    public static void main(){
        for (;;){
            System.out.println("Выберите действие/n 1. Добавить элемент/n 2. Удалить элемент/n 3. Вывести все элементы/n 0. Выход/n");
            break;
        }
    }
}
