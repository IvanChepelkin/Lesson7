package TableFIO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableFIO extends JFrame {
    public TableFIO(){
        setTitle("FIO window");
        setBounds(600,200,400,400); //задаем границы
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //закрываем окно и программу крестиком

        JButton btn1 = new JButton("btn1");//создаем кнопку
        JButton btn2 = new JButton("btn2");

        JTextField jTextField = new JTextField();

//        add(btn1,BorderLayout.NORTH); //Добавляем кнопку на поле
//        add(btn2,BorderLayout.SOUTH);//Указываем припомощи менеджера компоновки место, где будет стоять кнопка

        //setLayout(new BoxLayout(getContentPane(),BoxLayout.X_AXIS)); //менеджер компоновщика BoxLayout
        //setLayout(new FlowLayout()); //менеджер компоновщика BoxLayout

        //setLayout - устанавливаем менеджер компоновщика
        //new BoxLayout - экземпляр класса
        //getContentPane() - обращаемся к нашему окну
        // BoxLayout.X_AXIS - сортируем эл-ты по X

        JPanel jPanel = new JPanel(new GridLayout(1,2));
        //JPanel - панель, куда добавляе эле-ты
        //newGridLayout(1,2) - на панели есть сетка из 1 строки и 2 столбцов
        jPanel.add(btn1);
        jPanel.add(btn2);
        add(jTextField,BorderLayout.NORTH);

        add(jPanel,BorderLayout.SOUTH);//добаляем панель при помощи BorderLayout.SOUTH

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField.setText("Кнопка 1 нажата");
            }
        });

        //addActionListener - анонимный класс
        //new ActionListener() - интерфейс
        // public void actionPerformed - метод интерфейса
        //ActionEvent e - слушатель

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField.setText("Кнопка 2 нажата");
            }
        });


       // add(btn1); //добавляем кнопки на layout
       // add(btn2);


        setResizable(false);//запрещаем изменение размера
        setVisible(true); //

    }
}
class MainClassSwing{
    public static void main(String[] args) {

        TableFIO tableFIO = new TableFIO();


    }
}