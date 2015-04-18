package fourth.task.variant2;

import fourth.instruments.SortedMap;
import labs.fourth.instrument.Tree;

import java.util.List;
import java.util.Set;

/**
 * Created by Dartaan on 14.04.2015.
 */
public class AvlMap extends SortedMap {

    private MapEntry root = null;
    int NumberOfNodes = 0;

    @Override
    public void put(Comparable key, Object value) {
        MapEntry tmpNode = null;

        if (root == null) // если элементов в дереве нет
        {
           MapEntry newNode; // то инициализируем новый элемент
           root = newNode;                   // и делаем его корнем
           NumberOfNodes++;
           return;
        }
        else              // если в дереве уже есть элементы
        {
            tmpNode = root;// ставим указатель на начало
            while (true)   // и проверяем элементы, пока не найдем подходящее место
            {
                if (tmpNode->value < value)							// спускаемся в левое звено
                {
                    if (tmpNode == null)						// если дерево кончилось
                    {
                        MapEntry newNode = tmpNode;	// то создаем новый элемент
                        tmpNode->left = newNode;
                        NumberOfNodes++;
                        return true;						// и успешно выходим из функции
                    }
                    else											// иначе спускаемся дальше
                        tmpNode = tmpNode->left;
                }
                else if (tmpNode->value > value)					// спускаемся в правое звено
                {
                    if (tmpNode->right == NULL)						// если дерево кончилось
                    {
                        Node *newNode = new Node(value, tmpNode);   // то создаем новый элемент
                        tmpNode->right = newNode;
                        NumberOfNodes++;
                        return true;						// и успешно выходим из функции
                    }
                    else											// иначе спускаемся дальше
                        tmpNode = tmpNode->right;
                }
                else				// если элементы оказались равно
                    return false;	// с ошибкой выходим из функции
            }
        }
    }

    @Override
    public Object get(Comparable key) {
        return null;
    }

    @Override
    public Object remove(Comparable key) {
        return null;
    }

    @Override
    public Set getKeys() {
        return null;
    }

    @Override
    public List getValues() {
        List result = null;

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

    public static void main(){

    }

}
