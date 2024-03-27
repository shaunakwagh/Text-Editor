package Problem_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;
import java.io.File;


/*



 */
public class TextEditor extends JFrame implements ActionListener {
 private JTextArea txt = new JTextArea("",0,0);


    public TextEditor() {





        this.setSize(600, 400);

        this.setTitle("Notepad");

        this.txt.setFont(new Font("Century Gothic", Font.BOLD, 12));
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(txt);


        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem menu1 = new JMenuItem("New");
        menu1.addActionListener(this);
        JMenuItem menu2 = new JMenuItem("Open");
        menu2.addActionListener(this);
        JMenuItem menu3 = new JMenuItem("Save");
        menu3.addActionListener(this);
        JMenuItem menu4 = new JMenuItem("Exit");
        menu4.addActionListener(this);

        menu.add(menu1);
        menu.add(menu2);
        menu.add(menu3);
        menu.add(menu4);
        menuBar.add(menu);
        setJMenuBar(menuBar);

    }

    public static void main(String[] args) {
     TextEditor test = new TextEditor();
     test.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        switch (e.getActionCommand().toLowerCase()) {
            case "new":
                this.txt.setText("");

                break;
            case "open":
                JFileChooser open = new JFileChooser();
                int option = open.showOpenDialog(this);
                if (option == JFileChooser.APPROVE_OPTION) {

                    this.txt.setText("");
                    try {
                        //Scanner scan = new Scanner(new FileReader(open.getSelectedFile().getPath()));
                         String filname=open.getSelectedFile().getPath();
                        Scanner scan = new Scanner(new FileReader(filname));
                        while (scan.hasNext())
                            this.txt.append(scan.nextLine() + "\n");
                         this.setTitle(filname+" - Notepad");


                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }


                    break;
            case "save":

                    JFileChooser save = new JFileChooser();
                    int option2 = save.showSaveDialog(this);

                    if (option2 == JFileChooser.APPROVE_OPTION) {
                        try {
                            BufferedWriter out = new BufferedWriter(new FileWriter(save.getSelectedFile().getPath()));

                            out.write(this.txt.getText());
                            out.close();


                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }



                break;
            case "exit":
              System.exit(0);
                break;
        }

    }
}



