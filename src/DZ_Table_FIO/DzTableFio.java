package DZ_Table_FIO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DzTableFio extends JFrame {

    AddFio addFio;
    JTextField jTextField; //создаем переменную JTextField, так
    //мы сможем вызвать ее из методов класса DzTableFio

    public DzTableFio() {
        setTitle("FIO window");
        setBounds(600, 200, 400, 400); //задаем границы
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //закрываем окно и программу крестиком

        JButton btn1 = new JButton("Задать ФИО");//создаем кнопку

        AddFio addFio = new AddFio(this); //создаем экземпляр класса  AddFio с
        // ссылкой на класс DzTableFio.Так мы передаем в конструктор AddFio экземпляр
        // класса DzTableFio и получаем доступ ко всем хар-кам DzTableFio

        addFio.setVisible(false);

        jTextField = new JTextField(); //сюда будет вписываться ФИО

        JPanel jPanel = new JPanel(new GridLayout(1, 2));
        JPanel jPanel1 = new JPanel(new GridLayout(3, 1));

        jPanel.add(btn1);

        jPanel1.add(jTextField);

        add(jPanel, BorderLayout.SOUTH);//добаляем панель при помощи BorderLayout.SOUTH
        add(jPanel1, BorderLayout.NORTH);


        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setEnabled(false); //по клику первое окно становится неактивно

                addFio.setVisible(true); //второе окно становится видимым

            }
        });

        setResizable(false);//запрещаем изменение размера
        setVisible(true); //Окно видимо
    }

    void setFIO(String surname, String name, String patronymic) {
        jTextField.setText(surname + " " + name + " " + patronymic);

    }
}

class AddFio extends JFrame {

    DzTableFio dzTableFio;

    public AddFio(final DzTableFio dzTableFio) { //отдаем конструктору экземпляр класса DzTableFio
        this.dzTableFio = dzTableFio;

        setTitle("Set window");
        setBounds(600, 200, 400, 400); //задаем границы
        // setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //закрываем окно и программу крестиком

        JButton btn1 = new JButton("ОК");//создаем кнопку
        JTextField surname = new JTextField();//Фамилия
        JTextField name = new JTextField();//имя
        JTextField patronymic = new JTextField();//отчетсво

        JPanel fio = new JPanel(new GridLayout(3, 1));
        JPanel ok = new JPanel(new GridLayout(1, 1));

        fio.add(surname); //добавляем на панель окна ввода ФИО
        fio.add(name);
        fio.add(patronymic);

        ok.add(btn1); //Добавляем на панель окно с кнопкой "ОК"

        add(fio, BorderLayout.NORTH);
        add(ok, BorderLayout.SOUTH);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dzTableFio.setFIO(surname.getText(), name.getText(), patronymic.getText());

                dzTableFio.setEnabled(true);//окно dzTableFio становится активным
                setVisible(false); //окно addFio становится невидимым
            }
        });

        setResizable(false);//запрещаем изменение размера
        setVisible(false); //
    }

}

class MainClassSwing {
    public static void main(String[] args) {

        new DzTableFio();

    }
}
