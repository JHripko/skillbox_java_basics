import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;

public class MainForm {
    private JPanel mainPanel;           //родительская панель
    private JPanel expandPanel;         //панель с разделенными инпутами
    private JPanel collapsePanel;       //панель с объединенным инпутом
    private JTextField firstNameTextField;  //инпут имени
    private JTextField secondNameTextField; //инпут отчества
    private JTextField lastNameTextField;   //инпут фамилии
    private JButton collapseButton;         //кнопка объедидения инпутов
    private JTextField fioTextField;        //объединенный инпут ФИО
    private JButton expandButton;           //кнопка разделения инпута

    public MainForm() {
        //объединение инпутов
        collapseButton.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                //проверяем что поля не пусты
                if (!Objects.equals(firstNameTextField.getText(), "")
                        && !Objects.equals(lastNameTextField.getText(), "")) {
                    String firstName = firstNameTextField.getText();
                    String secondName = secondNameTextField.getText();
                    String lastName = lastNameTextField.getText();

                    //собираем строку в объединенном инпуте с ФИО
                    fioTextField.setText(lastName + " " + firstName + " " + secondName);

                    //очищаем инпуты
                    firstNameTextField.setText("");
                    secondNameTextField.setText("");
                    lastNameTextField.setText("");

                    //заменяем панель с раздельными инпутами на панель с объединенным инпутом
                    expandPanel.setVisible(false);
                    collapsePanel.setVisible(true);
                } else {
                    //если хотябы одно поле пустое, то выдаем ошибку
                    JOptionPane.showMessageDialog(
                            mainPanel,
                            "Поля \"Фамилия\" и \"Имя\" не должны быть пусты!",
                            "Ошибка",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        //разделение на инпуты
        expandButton.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                //проверяем что инпут содержит текст
                if (!Objects.equals(fioTextField.getText(), "")) {
                    //разделяем строку по пробелам на подстроки
                    String[] name = fioTextField.getText().trim().split(" ");
                    //если массив состоит из 2 или 3 подстрок то считаем что это Фамилия Имя и Отчество (если из 3х)
                    if (name.length == 2) {
                        lastNameTextField.setText(name[0]);     //фамилия
                        firstNameTextField.setText(name[1]);    //имя

                        //очищаем объединенный инпут
                        fioTextField.setText("");

                        //заменяем панель с объединенным инпутом на панель с раздельными
                        collapsePanel.setVisible(false);
                        expandPanel.setVisible(true);
                    } else if (name.length == 3) {
                        lastNameTextField.setText(name[0]);     //фамилия
                        firstNameTextField.setText(name[1]);    //имя
                        secondNameTextField.setText(name[2]);   //отчество

                        //очищаем объединенный инпут
                        fioTextField.setText("");

                        //заменяем панель с объединенным инпутом на панель с раздельными
                        collapsePanel.setVisible(false);
                        expandPanel.setVisible(true);
                    } else {
                        //если массив содержит меньше или больше 3 подстрок то выдаем ошибку
                        JOptionPane.showMessageDialog(
                                mainPanel,
                                "Введите Фамилию Имя и Отчество через пробел!",
                                "Ошибка",
                                JOptionPane.ERROR_MESSAGE
                        );
                    }
                } else {
                    //если поле инпуто пустое то выдаем ошибку
                    JOptionPane.showMessageDialog(
                            mainPanel,
                            "Поля не должны быть пустыми!",
                            "Ошибка",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
    }
    public JPanel getExpandPanel() {
        return mainPanel;
    }


}
