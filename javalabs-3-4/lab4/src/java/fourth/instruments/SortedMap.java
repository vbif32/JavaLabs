package fourth.instruments;

import labs.Unit;
import labs.fourth.instrument.Tree;

import java.util.List;
import java.util.Set;

/**
 * Класс для хранения связок ключ-значение, основанный на дереве
 * поддерживает только одну пару ключ-значение,
 * при дублировании ключа значение заменяется
 */
public abstract class SortedMap<K extends Comparable<K>,V> implements Unit{

    private Tree keyTree;

    /**
     * Добавляет связку ключ-значение
     * @param key ключ по которому можно будет обратиться к значению
     * @param value значение
     */
    public abstract void put(K key, V value);

    /**
     * Выдает значение под ключу
     * @param key ключ
     * @return значение
     */
    public abstract V get(K key);

    /**
     * Удаляет значение по ключу
     * @param key ключ
     * @return удаленное значение, если связки нет, то возвращает null
     */
    public abstract V remove(K key);

    /**
     * Возвращает все ключи отсортированные по возрастанию
     * @return множество ключей
     */
    public abstract Set<K> getKeys();

    /**
     * Возвращает все значения отсортированные по ключу
     * @return список значений
     */
    public abstract List<V> getValues();

    /**
     * Класс-структура предназначенная для хранения связок ключ-значение
     */
    public class MapEntry implements Comparable<MapEntry>{
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public int compareTo(MapEntry o) {
            return this.getKey().compareTo(o.getKey());
        }
    }
}
