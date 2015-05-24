package five.task;

import sdc.jloader.JLoader;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.List;

/**
 * Created by Dartaan on 16.05.2015.
 */
public class lab5Common {

    private static String filePath = "javalabs-5-6/lab5/src/java/five/libs/lab51lib.jar";

    public static void main(String[] arg) throws IOException {
        lab5Common test = new lab5Common();
        JLoader testJLoader = new JLoader();
        List<Class> jarContent = testJLoader.loadJar(new File(filePath), true);
        System.out.println("==========================\n\n");
        for (int i = 0; i < jarContent.size(); i++)
            test.printClass(jarContent.get(i));
    }

    public void printClass(Class curClass){
        StringBuilder var1 = new StringBuilder();

        // получение аннотаций
        var1.append(getAnnotationsAsString(curClass.getAnnotations()));

        // получение имени класса с модификаторами
        var1.append( Modifier.toString(curClass.getModifiers()) + " ");
        if (!Modifier.isInterface(curClass.getModifiers()))
            var1.append("class ");
        else if (curClass.isAnnotation()){
            var1.delete(var1.indexOf("interface"), var1.length());
            var1.append("@interface ");
        }
        var1.append(curClass.getSimpleName());

        //получение родителей, если есть
        var1.append(getParentsAsString(curClass) + "\n");

        var1.append("свои методы: \n");
        var1.append(getConstructorsAsString(curClass.getDeclaredConstructors()));
        var1.append(getMethodsAsString(curClass.getDeclaredMethods()));

        var1.append("все методы: \n");
        var1.append(getConstructorsAsString(curClass.getConstructors()));
        var1.append(getMethodsAsString(curClass.getMethods()));

        var1.append("свои поля: \n");
        var1.append(getFieldsAsString(curClass.getFields()));
        var1.append("все поля: \n");
        var1.append(getFieldsAsString(curClass.getDeclaredFields()));


        System.out.println(var1);
        System.out.println("-------------");
    }

    public String getAnnotationsAsString(Annotation[] curAnnotations){
        StringBuilder result = new StringBuilder();
        for (Annotation anno : curAnnotations){
            if (anno.annotationType().getDeclaredMethods().length == 0)
                result.append("@" + anno.annotationType().getSimpleName() + "\n");
            else
                result.append(anno + "\n");
//            result.append(
//                    "@" + curAnnotations[i].annotationType().getSimpleName()
//                    + findAnnotationParameters2(curAnnotations[i])
//                    + "\n"
//            );
//            findAnnotationParameters3(curAnnotations[i]);
        }
        return result.toString();
    }

    private String findAnnotationParameters(Method[] curAnMethods){
        StringBuilder result = new StringBuilder();
        if (curAnMethods.length > 0)
            result.append("( ");
        for (int i = 0; i < curAnMethods.length; i++){
            result.append(curAnMethods[i].getReturnType().getSimpleName() + " " + curAnMethods[i].getDefaultValue());
        }
        result.append(" )");
        return result.toString();
    }

    private String findAnnotationParameters2(Annotation curAnno) {
        StringBuilder result = new StringBuilder();

        Class<Annotation> type = (Class<Annotation>) curAnno.annotationType();
        result.append(curAnno);
//        for (Method curMethod : type.getDeclaredMethods()) {
//            result.append(curMethod.getName() + " " + curAnno.annotationType());

//            try {
//                curMethod.invoke(curAnno, null);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.getCause();
//            }
//            System.out.println(",ekm");
//        }
        return result.toString();
    }

    private void findAnnotationParameters3(Annotation curAnno) {
        Class<Annotation> type = (Class<Annotation>) curAnno.annotationType();
        System.out.println("Values of " + type.getName());

        for (Method method : type.getDeclaredMethods()) {
            try {
                System.out.println(" " + method.getName() + ": " +
                        method.invoke(curAnno, null));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public String getFieldsAsString(Field[] curFields){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < curFields.length; i++){
            result.append(
                    getAnnotationsAsString(curFields[i].getAnnotations()) + " "
                    + Modifier.toString(curFields[i].getModifiers()) + " "
                    + curFields[i].getType() + " "
                    + curFields[i].getName() + "\n"
            );
        }
        return result.toString();
    }

    public String getMethodsAsString(Method[] curMethods){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < curMethods.length; i++){
            result.append(
                    getAnnotationsAsString(curMethods[i].getAnnotations()) + " "
                    + Modifier.toString(curMethods[i].getModifiers()) + " "
                    + curMethods[i].getReturnType().getSimpleName() + " "
                    + curMethods[i].getName() + " ("
                    + getParametersAsString(curMethods[i].getParameterTypes()) + " )\n"
            );
        }
        return result.toString();
    }

    public String getParametersAsString(Class[] curParameters){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < curParameters.length; i++){
            if (i > 0) result.append(", ");
            else  result.append(" ");
            result.append(curParameters[i].getSimpleName());
        }
        return result.toString();
    }

    public String getParentsAsString(Class curClass){
        StringBuilder result = new StringBuilder();

        if (curClass.getSuperclass() != null && curClass.getSuperclass() != Object.class ) //если расширяет класс
            result.append(" extends " + curClass.getSuperclass().getSimpleName());

        if (curClass.getInterfaces() != null && curClass.getInterfaces().length != 0) {    //если включает интерфейс
            if (curClass.getInterfaces()[0] != Annotation.class) {                         //исключение для аннотаций
                result.append(" implements ");
                for (int i = 0; i < curClass.getInterfaces().length; i++) {
                    if (i > 0) result.append(", ");
                    result.append(curClass.getInterfaces()[i].getSimpleName());
                }
            }
        }
        return result.toString();
    }

    public String getConstructorsAsString(Constructor[] curConstructors){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < curConstructors.length; i++){
            result.append(
                    getAnnotationsAsString(curConstructors[i].getAnnotations()) + " "
                            + Modifier.toString(curConstructors[i].getModifiers()) + " "
                            + curConstructors[i].getClass().getSimpleName() + " ("
                            + getParametersAsString(curConstructors[i].getParameterTypes()) + " )\n"
            );
        }
        return result.toString();
    }
}
