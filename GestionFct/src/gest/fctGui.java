package gest;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class fctGui extends JFrame  {



    public void imagen() {

        JFrame marco = new JFrame();
        marco.setLayout(new BorderLayout(5, 10));
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout(5, 10));
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel etiqPS1 = new JLabel("Pantalla 1");
        JLabel etiqPS2= new JLabel("Pantalla 2");
        JLabel etiqPS3 = new JLabel("Pantalla 3");
        CardLayout laminas = new CardLayout();

//designacion de paneles
        JPanel botonprinci = new JPanel();
        JPanel panelSecu1 = new JPanel();
        JPanel panelSecu2 = new JPanel();
        JPanel panelSecu3 = new JPanel();
        JPanel panelSecu4 = new JPanel();
        /////////////////////////////////////////////////asignacion de laminas
        panelPrincipal.setLayout(laminas);

        panelPrincipal.add(panelSecu1,"1");/////panel logo safa
        panelPrincipal.add(panelSecu2,"2");/////panel gestion empresa
        panelPrincipal.add(panelSecu3,"3");/////panel combo
        panelPrincipal.add(panelSecu4,"4");/////panel datos a tabla

        ///////asignacion de botones al panel de botones
        JButton gestionE = new JButton("Gestión Empresas");
        JButton asignacionA = new JButton("Asignación Alumnos");
        JButton ficherosT = new JButton("Ficheros a tabla");
        JButton insertar = new JButton("Insertar");
        JButton modificar = new JButton("Modificar");
        JButton borrar = new JButton("Borrar");


        //////////colocacion del panel principal y la botonera principal
        //marco.add(panelPrincipal);
        marco.add(panelPrincipal,BorderLayout.CENTER);
        marco.add(botonprinci,BorderLayout.SOUTH);
        botonprinci.add(gestionE);
        botonprinci.add(asignacionA);
        botonprinci.add(ficherosT);


        //panelSecu1.add(etiqPS1);
        panelSecu2.add(etiqPS2);
        panelSecu3.add(etiqPS3);
        //////asignacion de imagenes a las laminas
        ImageIcon logo= new ImageIcon("images/nuevo_logo_SAFA_H.png");
        ImageIcon transfe= new ImageIcon("images/img_2.png");
        JLabel imagen1= new JLabel();
        imagen1.setIcon(logo);
        panelSecu1.add(imagen1);

        JLabel imagen2= new JLabel();
        imagen2.setIcon(transfe);
        panelSecu4.add(imagen2);

        //////pantalla gestion
        JPanel gestiontras= new JPanel();
        JPanel gestiontras1= new JPanel();
        JPanel gestiontras2= new JPanel();
        JPanel gestiontras3= new JPanel();
        JPanel gestionBotonera=new JPanel();

        JPanel gestionBotonera2=new JPanel();
        JPanel gestionDatos1=new JPanel();
        JPanel gestionDatos2=new JPanel();
        JPanel gestionDatos3=new JPanel();
        JPanel gestionDatos4=new JPanel();
        JPanel gestionDatos5=new JPanel();
        JPanel gestionDatos6=new JPanel();


        JPanel gestionTabla=new JPanel();

        JLabel codigoEmpresa= new JLabel("Código de empresa: ");
        JTextField codigoEmpresaText =new JTextField(5);
        JLabel nombreEmpresa= new JLabel("Nombre de la empresa: ");
        JTextField nombreEmpresaText =new JTextField(13);
        JLabel cif= new JLabel("CIF");
        JTextField cifText =new JTextField(13);
        JLabel localidad= new JLabel("Localidad");
        JTextField localidadText =new JTextField(13);
        JLabel cp= new JLabel("CP");
        JTextField cpText =new JTextField(5);
        JLabel tipoJornada= new JLabel("Tipo de jornada");
        //////////combo
        JComboBox TipoJorComb =new JComboBox();
        TipoJorComb.addItem("Continua");
        TipoJorComb.addItem("Partida");
        ////////////////////////
        JLabel dniRes =new JLabel("DNI tutor");
        JTextField dniRespText= new JTextField(9);

        JLabel nombreTutor =new JLabel("Nombre del tutor:");
        JTextField nombreTutorText= new JTextField(10);
        JLabel apellidoTutor =new JLabel("Apellido del tutor:");
        JTextField apellidoTutorText= new JTextField(13);
        JLabel mail =new JLabel("Mail del tutor");
        JTextField mailText= new JTextField(10);
        JLabel telefono =new JLabel("Telefono del tutor");
        JTextField telefonoText= new JTextField(9);
        panelSecu2.setLayout(new BorderLayout(5,10));
        panelSecu2.setSize(700,800);
/////////////////////////
        panelSecu2.add(gestiontras3,BorderLayout.NORTH);
        panelSecu2.add(gestiontras,BorderLayout.CENTER);
        panelSecu2.add(gestiontras1,BorderLayout.SOUTH);

        gestiontras.setLayout(new BorderLayout(5,10));
       // gestiontras1.setLayout(new BorderLayout(5,10));

        gestionDatos1.setLayout( new FlowLayout( FlowLayout.LEFT,5,30));

        gestionBotonera.setLayout( new FlowLayout( FlowLayout.CENTER,5,10));



        gestiontras.add(gestionDatos1,BorderLayout.CENTER);

        gestionDatos1.add(codigoEmpresa);
        gestionDatos1.add(codigoEmpresaText);
        gestionDatos1.add(nombreEmpresa);
        gestionDatos1.add(nombreEmpresaText);
        gestionDatos1.add(cif);
        gestionDatos1.add(cifText);
        gestionDatos1.add(localidad);
        gestionDatos1.add(localidadText);
        gestionDatos1.add(cp);
        gestionDatos1.add(cpText);
        gestionDatos1.add(tipoJornada);
        gestionDatos1.add(TipoJorComb);
        gestionDatos1.add(dniRes);
        gestionDatos1.add(dniRespText);
        gestionDatos1.add(dniRespText);
        gestionDatos1.add(nombreTutor);
        gestionDatos1.add(nombreTutorText);
        gestionDatos1.add(apellidoTutor);
        gestionDatos1.add(apellidoTutorText);
        gestionDatos1.add(mail);
        gestionDatos1.add(mailText);
        gestionDatos1.add(telefono);
        gestionDatos1.add(telefonoText);

        gestiontras.add(gestionBotonera,BorderLayout.SOUTH);
        gestionBotonera.add(insertar);
        gestionBotonera.add(modificar);
        gestionBotonera.add(borrar);


        //////// colocar la tabla
        JTable tablaM= new JTable(5,5);
        tablaM.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        DefaultTableModel model = new DefaultTableModel();

        JScrollPane pane = new JScrollPane(tablaM);

        pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        //  pane.setSize(500,150);


        tablaM.setModel(model);

        gestiontras1.add(gestionDatos2);
        gestionDatos2.setLayout(new BorderLayout(5, 10));
        gestionDatos2.add(pane,BorderLayout.CENTER);
        pane.setPreferredSize(new java.awt.Dimension(500, 150));


        Object[] columnsName = new Object[11];

        columnsName[0] = "COD_EMPRESA";
        columnsName[1] = "NOM_EMPRESA";
        columnsName[2] = "CIF";
        columnsName[3] = "LOCALI";
        columnsName[4] = "CP";
        columnsName[5] = "TIP_JORNADA";
        columnsName[6] = "DNI_TUTOR";
        columnsName[7] = "NOM_TUTOR";
        columnsName[8] = "APE_TUTOR";
        columnsName[9] = "MAIL_TUTOR";
        columnsName[10] = "TLF_TUTOR";

        model.setColumnIdentifiers(columnsName);


        fctImp con =new fctImp();
        Object[] rowData = new Object[11];
        try {
            ArrayList<emp>lista =con.consulta();
            for (int i=0; i<lista.size(); i++) {
                rowData[0]=Integer.parseInt(lista.get(i).getCodigo());
                rowData[1]= lista.get(i).getNom_emp();
                rowData[2]=lista.get(i).getCif();
                rowData[3]=lista.get(i).getLocali();
                rowData[4]=lista.get(i).getCp();
                rowData[5]=lista.get(i).getTip_jonada();
                rowData[6]=lista.get(i).getDni_tutor();
                rowData[7]=lista.get(i).getNom_tutor();
                rowData[8]=lista.get(i).getApe_tutor();
                rowData[9]=lista.get(i).getMail_tutor();
                rowData[10]=lista.get(i).getTlf_tutor();

                model.addRow(rowData);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }









//////////////////////////////////////////////////////////////////////////////////


        gestionE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                laminas.show(panelPrincipal, "2");

            }
        });

        asignacionA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                laminas.show(panelPrincipal, "3");
            }
        });

        ficherosT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                laminas.show(panelPrincipal, "4");
            }
        });

        insertar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                try{
                    fctImp tabla =new fctImp();
                    String COD_EMPRESA= codigoEmpresaText.getText();
                    String NOM_EMPRESA= nombreEmpresaText.getText();
                    String CIF= cifText.getText();
                    String LOCALI= localidadText.getText();
                    String CP= cpText.getText();
                    String TIP_JORNADA= (String) TipoJorComb.getSelectedItem();
                    String DNI_TUTOR= dniRespText.getText();
                    String NOM_TUTOR= nombreTutorText.getText();
                    String APE_TUTOR= apellidoTutorText.getText();
                    String MAIL_TUTOR= mailText.getText();
                    String TLF_TUTOR= telefonoText.getText();
                    tabla.inserta(COD_EMPRESA,NOM_EMPRESA,CIF,LOCALI,CP,TIP_JORNADA,DNI_TUTOR,NOM_TUTOR,APE_TUTOR,MAIL_TUTOR,TLF_TUTOR);


                } catch(NumberFormatException | SQLException ex){
                    codigoEmpresaText.setText("solo puedes escribir numeros");


                }
                /*
                fctImp con =new fctImp();
                Object[] rowData = new Object[11];
                try {
                    ArrayList<emp>lista =con.consulta();
                    for (int i=0; i<lista.size(); i++) {
                        rowData[0]=Integer.parseInt(lista.get(i).getCodigo());
                        rowData[1]= lista.get(i).getNom_emp();
                        rowData[2]=lista.get(i).getCif();
                        rowData[3]=lista.get(i).getLocali();
                        rowData[4]=lista.get(i).getCp();
                        rowData[5]=lista.get(i).getTip_jonada();
                        rowData[6]=lista.get(i).getDni_tutor();
                        rowData[7]=lista.get(i).getNom_tutor();
                        rowData[8]=lista.get(i).getApe_tutor();
                        rowData[9]=lista.get(i).getMail_tutor();
                        rowData[10]=lista.get(i).getTlf_tutor();

                        model.addRow(rowData);

                    }


                } catch (SQLException e) {
                    e.printStackTrace();
                }

*/

            }

        });

        modificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                try{
                    fctImp tabla =new fctImp();
                    String COD_EMPRESA= codigoEmpresaText.getText();
                    String NOM_EMPRESA= nombreEmpresaText.getText();
                    String CIF= cifText.getText();
                    String LOCALI= localidadText.getText();
                    String CP= cpText.getText();
                    String TIP_JORNADA= (String) TipoJorComb.getSelectedItem();
                    String DNI_TUTOR= dniRespText.getText();
                    String NOM_TUTOR= nombreTutorText.getText();
                    String APE_TUTOR= apellidoTutorText.getText();
                    String MAIL_TUTOR= mailText.getText();
                    String TLF_TUTOR= telefonoText.getText();
                    tabla.modfica(COD_EMPRESA,NOM_EMPRESA,CIF,LOCALI,CP,TIP_JORNADA,DNI_TUTOR,NOM_TUTOR,APE_TUTOR,MAIL_TUTOR,TLF_TUTOR);


                } catch(NumberFormatException | SQLException ex){
                    codigoEmpresaText.setText("solo puedes escribir numeros");


                }

            }

        });
        borrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                try{
                    fctImp tabla =new fctImp();
                    String COD_EMPRESA= codigoEmpresaText.getText();

                    tabla.borra(COD_EMPRESA);


                } catch(NumberFormatException | SQLException ex){
                    codigoEmpresaText.setText("solo puedes escribir numeros");

                }

            }

        });


        marco.setVisible(true);
        marco.setSize(720, 600);






    }
}