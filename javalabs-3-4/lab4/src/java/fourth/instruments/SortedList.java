package fourth.instruments;


import labs.Unit;
import labs.fourth.instrument.Tree;

/**
 * Класс хранящий упорядоченный по возрастанию список
 */
public abstract class SortedList<T extends Comparable<T>> implements Unit {

    Tree tree;

    /**
     * Добавляет значение в список
     * @param value значение
     */
    public abstract void add(T value);

    /**
     * Получает значение по номеру элемента (в уже отсортированном списке, т.е. не по порядку добавления)
     * @param index номер элемента в списке
     * @return значение
     */
    public abstract T get(int index);

    /**
     * Удаляет переданное значение
     * @param value удаляемое значение
     * @return флаг успешности операции
     */
    public abstract boolean delete(T value);

    /**
     * Класс итератор позволяющий двигаться по списку
     * изначально инициализируется пустым,
     * после первого вызова функции next содержит минимальное значение из списка
     * и далее вызов функции next выдает элементы по возрастанию по возрастанию
     */
    public abstract class Iterator {
        protected T value;
        protected Tree.Node<T> current;// or may be next

        protected Iterator(Tree.Node<T> node){
            value = node.getKey();
        }

        /**
         * выдает следующее значение, если возвращает null значит список закончился
         * @return значение
         */
        public abstract T next();

        /**
         * Удаляет текущий элемент из списка
         * @return успешность операции
         */
        public abstract boolean remove();

    }
}
