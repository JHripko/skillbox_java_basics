import java.util.ArrayList;

public class TodoList {
    //создаем список
    static ArrayList<String> myTodoList = new ArrayList<>();

    //добавление по-умолчанию в конец списка
    public void add(String todo) {
        myTodoList.add(todo);
        System.out.println("Добавлено дело \"" + todo + "\"");
    }

    //добавление вместо указанного пункта
    public void add(int index, String todo) {

        //проверка на наличие соответствие существующему пункту списка
        if (index < 0) {
            System.out.println("Такого пункта не существует!");
        } else if (index > myTodoList.size()){
            myTodoList.add(todo);
            System.out.println("Дело \"" + todo + "\" успешно добавлено на пункт " + myTodoList.size());
        } else {
            myTodoList.add(index, todo);
            System.out.println("Дело \"" + todo + "\" успешно добавлено на пункт " + index);
        }
    }

    //редактирование пункта
    public void edit(String todo, int index) {

        //проверка на соответствие существующему пункту списка
        if (!isIndex(index)) {
            System.out.println("Такого пункта не существует!");
        } else {
            //извлечение старой записи для уведомления
            String oldTask = myTodoList.get(index);
            //замена записи
            myTodoList.set(index, todo);
            System.out.println("Дело \"" + oldTask + "\" успешно изменено на \"" + todo + "\"");
        }
    }

    //удаление пункта
    public void delete(int index) {
        if (!isIndex(index)) {
            System.out.println("Такого пункта не существует!");
        } else {
            String removedTodo = myTodoList.get(index);
            myTodoList.remove(index);
            System.out.println("Дело \"" + removedTodo + "\" успешно удалено!");
        }
    }

    public ArrayList<String> getTodos() {

        return myTodoList;
    }


    //дополнительные методы
    //метод проверки соответствия существующему пункту списка
    public static boolean isIndex(int index) {
        if (index < 0 || index >= myTodoList.size()) {
            return false;
        }
        return true;
    }
}