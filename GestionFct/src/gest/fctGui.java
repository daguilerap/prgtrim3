package gest;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class fctGui extends JFrame  {



    public void imagen() {

        JFrame marco = new JFrame("Safa - Ntra. Sra. del los Reyes");
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
        //panelSecu3.add(etiqPS3);
        //////asignacion de imagenes a las laminas
        ImageIcon logo= new ImageIcon("src/images/nuevo_logo_SAFA_H.png");
        ImageIcon transfe= new ImageIcon("src/images/img_2.png");
        JLabel imagen1= new JLabel();
        imagen1.setIcon(logo);
        JLabel titlePanel1 = new JLabel("                    GESTIÓN SAFA FCT");
        panelSecu1.add(titlePanel1);
        panelSecu1.add(imagen1);


        JLabel imagen2= new JLabel();
        imagen2.setIcon(transfe);
        panelSecu4.setLayout(new BorderLayout(5,10));
        JPanel panelter= new JPanel();
        JPanel panelter2= new JPanel();
        JPanel panelter3= new JPanel();
        JPanel panelter4= new JPanel();
        JPanel panelter5= new JPanel();
        JPanel panelter6= new JPanel();
        panelter4.setLayout(new BorderLayout(5,10));

        panelSecu4.add(panelter,BorderLayout.NORTH);
        panelSecu4.add(panelter2,BorderLayout.CENTER);
        panelSecu4.add(panelter3,BorderLayout.SOUTH);


            panelter3.add(panelter4);
        panelter4.add(panelter5,BorderLayout.CENTER);
        panelter4.add(panelter6,BorderLayout.SOUTH);





        JLabel titlePanel4 = new JLabel("ALUMNOS Y TUTORES A TABLA");
        JButton insertarFicheros = new JButton("Pasar datos a tablas");
        JButton borrarDatos = new JButton("Borrar datos de tablas");
        JLabel resultadoFicheros = new JLabel(" ");
        imagen2.setIcon(transfe);
        panelter.add(titlePanel4);
        panelter2.add(imagen2);
        panelter5.add(insertarFicheros);
        panelter5.add(borrarDatos);
        panelter6.add(resultadoFicheros);

        //////pantalla gestion
        JPanel gestiontras= new JPanel();
        JPanel gestiontras1= new JPanel();
        JPanel gestiontras2= new JPanel();
        JPanel gestiontras3= new JPanel();
        JPanel gestionBotonera=new JPanel();

        JPanel gestionBotonera2=new JPanel();
        JPanel gestionDatos1=new JPanel();
        JPanel gestionDatos2=new JPanel();
        gestionDatos2.setLayout(new BorderLayout(5,10));
        JPanel gestionDatos3=new JPanel();
        JPanel gestionDatos4=new JPanel();
        JPanel gestionDatos5=new JPanel();
        JPanel gestionDatos6=new JPanel();
        JPanel gestionTabla=new JPanel();

        /////////creacion elementos pantalla 1
        JLabel codigoEmpresa= new JLabel("Código de empresa: ");
        JTextField codigoEmpresaText =new JTextField(5);
        JLabel nombreEmpresa= new JLabel("Nombre de la empresa: ");
        JTextField nombreEmpresaText =new JTextField(13);
        JLabel cif= new JLabel("CIF");
        JTextField cifText =new JTextField(13);
        JLabel direccion= new JLabel("Direccion");
        JTextField direcciontext =new JTextField(13);
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

        JLabel dni =new JLabel("DNI Resp.");
        JTextField dniText= new JTextField(9);

        JLabel nombreResp =new JLabel("Nombre del Resp.:");
        JTextField nombreRespText= new JTextField(10);
        JLabel apellidoResp =new JLabel("Apellido del Resp.:");
        JTextField apellidoRespText= new JTextField(13);

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
        JLabel titulo1= new JLabel("GESTIÓN DE LAS EMPRESAS DEL PROGRAMA FCT");


/////////////////////////Colocación de los elementos de la pantalla 1
        panelSecu2.add(gestiontras3,BorderLayout.NORTH);
        panelSecu2.add(gestiontras,BorderLayout.CENTER);
        panelSecu2.add(gestiontras1,BorderLayout.SOUTH);
        gestiontras.setLayout(new BorderLayout(5,10));
        gestiontras3.add(titulo1);

        gestionDatos1.setLayout( new FlowLayout( FlowLayout.LEFT,5,30));
        gestionBotonera.setLayout( new FlowLayout( FlowLayout.CENTER,5,10));
        gestiontras.add(gestionDatos1,BorderLayout.CENTER);
        gestionDatos1.add(codigoEmpresa);
        gestionDatos1.add(codigoEmpresaText);
        gestionDatos1.add(nombreEmpresa);
        gestionDatos1.add(nombreEmpresaText);
        gestionDatos1.add(cif);
        gestionDatos1.add(cifText);
        gestionDatos1.add(direccion);
        gestionDatos1.add(direcciontext);
        gestionDatos1.add(localidad);
        gestionDatos1.add(localidadText);
        gestionDatos1.add(cp);
        gestionDatos1.add(cpText);
        gestionDatos1.add(tipoJornada);
        gestionDatos1.add(TipoJorComb);
        gestionDatos1.add(dni);
        gestionDatos1.add(dniText);
        gestionDatos1.add(nombreResp);
        gestionDatos1.add(nombreRespText);
        gestionDatos1.add(apellidoResp);
        gestionDatos1.add(apellidoRespText);
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
        JTable tablaM= new JTable();
        tablaM.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        DefaultTableModel model = new DefaultTableModel();
        tablaM.setModel(model);

        JScrollPane pane = new JScrollPane(tablaM);


        pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);


        gestiontras1.add(gestionDatos2);
        gestionDatos2.setLayout(new BorderLayout(5, 10));

        JLabel resultadoConsulta= new JLabel(" ");
        gestionDatos2.add(gestionDatos3,BorderLayout.NORTH);
        gestionDatos3.add(resultadoConsulta);

        gestionDatos2.add(pane,BorderLayout.CENTER);
        pane.setPreferredSize(new Dimension(500, 150));


        Object[] columnsName = new Object[15];

        columnsName[0] = "COD_EMPRESA";
        columnsName[1] = "NOM_EMPRESA";
        columnsName[2] = "CIF";
        columnsName[3]= "DIREC";
        columnsName[4] = "LOCALI";
        columnsName[5] = "CP";
        columnsName[6] = "TIP_JORNADA";
        columnsName[7]="DNI_RESP";
        columnsName[8]="NOMBRE_RESP";
        columnsName[9]="APELLIDO_RESP";
        columnsName[10] = "DNI_TUTOR";
        columnsName[11] = "NOM_TUTOR";
        columnsName[12] = "APE_TUTOR";
        columnsName[13] = "MAIL_TUTOR";
        columnsName[14] = "TLF_TUTOR";

        model.setColumnIdentifiers(columnsName);


        fctImp con =new fctImp();
        Object[] rowData = new Object[15];
        try {
            ArrayList<emp>lista =con.consulta();
            for (int i=0; i<lista.size(); i++) {
                rowData[0]=Integer.parseInt(lista.get(i).getCodigo());
                rowData[1]= lista.get(i).getNom_emp();
                rowData[2]=lista.get(i).getCif();
                rowData[3]=lista.get(i).getDireccion();
                rowData[4]=lista.get(i).getLocali();
                rowData[5]=lista.get(i).getCp();
                rowData[6]=lista.get(i).getTip_jonada();
                rowData[7]=lista.get(i).getDni_resp();
                rowData[8]=lista.get(i).getNom_resp();
                rowData[9]=lista.get(i).getDni_resp();
                rowData[10]=lista.get(i).getDni_tutor();
                rowData[11]=lista.get(i).getNom_tutor();
                rowData[12]=lista.get(i).getApe_tutor();
                rowData[13]=lista.get(i).getMail_tutor();
                rowData[14]=lista.get(i).getTlf_tutor();

                model.addRow(rowData);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
 ////////////////////////////////////////////////////////////////////////////////COMBOS
        //////////////////////////añadidos combos////////////////////////////////////////////

        JLabel eti = new JLabel("ASIGNACIÓN DE ALUMNOS A EMPRESAS");
        JPanel panel = new JPanel();
        JPanel panel2 =new JPanel();
        JPanel panel3 =new JPanel();
        JPanel panel4 =new JPanel();
        JPanel panel5 =new JPanel();
        JPanel subpanel0= new JPanel();
        JPanel subpanel1= new JPanel();
        JPanel subpanel2= new JPanel();
        JPanel subpanel3= new JPanel();
        JPanel subpanel4= new JPanel();
        panelSecu3.setLayout(new BorderLayout(5,10));
        //subpanel1.setLayout(new BorderLayout(5,10));
        //subpanel2.setLayout(new BorderLayout(5,10));
        panel2.setLayout(new BorderLayout(5,80));
        panel3.setLayout(new BorderLayout(5,80));
        panel4.setLayout(new BorderLayout(5,10));


        subpanel0.setLayout( new FlowLayout( FlowLayout.CENTER,5,10));
        subpanel4.setLayout( new FlowLayout( FlowLayout.RIGHT,5,10));




        //panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
       // panel.setBorder(new EmptyBorder(0,10,0,10));
        panelSecu3.add(panel2,BorderLayout.NORTH);
        panelSecu3.add(panel3,BorderLayout.CENTER);
        panelSecu3.add(panel4,BorderLayout.SOUTH);

        panel2.add(subpanel0,BorderLayout.NORTH);
        panel2.add(subpanel1,BorderLayout.CENTER);
        panel3.add(subpanel2,BorderLayout.NORTH);

        panel4.add(subpanel3,BorderLayout.NORTH);
        panel4.add(subpanel4,BorderLayout.CENTER);



        //Jlabel
        JLabel P3Alumno=new JLabel("Elección de Alumno: ");
        JLabel P3Empresa=new JLabel("Elección de Empresa: ");
        JLabel P3Tutor=new JLabel("Elección de Tutor: ");

        //JCombo

        JComboBox ComboAlumno = new JComboBox();
        JComboBox ComboEmpresa = new JComboBox();
        JComboBox ComboTutor = new JComboBox();


        //TextField
        JTextArea Resultado = new JTextArea();
        Resultado.setEditable(false);
        Resultado.setOpaque(false);
        Resultado.setBorder(null);
        Resultado.setPreferredSize(new Dimension(500,340));
        Resultado.setLineWrap(true);


        //Boton
        JButton Insertar = new JButton("Insertar");
        subpanel0.add(eti);
        subpanel1.add(P3Alumno);
        subpanel1.add(ComboAlumno);
        subpanel2.add(P3Empresa);
        subpanel2.add(ComboEmpresa);
        subpanel3.add(P3Tutor);
        subpanel3.add(ComboTutor);
        subpanel3.add(Insertar);
        subpanel4.add(Resultado);
/////////////////////////////////////////BOTON INSERTAR DEL COMBO
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fctImp con = new fctImp();
                try {
                    //Recogemos Los datos seleccionados del JcomboBox
                    String Nombrealum = (String) ComboAlumno.getSelectedItem();
                    String Nombreempre = (String) ComboEmpresa.getSelectedItem();
                    String Nombretutor = (String) ComboTutor.getSelectedItem();

                    Resultado.setText(con.texto(Nombrealum, Nombreempre, Nombretutor));

                } catch (NullPointerException g) {
                    Resultado.setText("\t  Combo vacio");
                }
            }
        };
        Insertar.addActionListener(actionListener);
//////////////////////////////////////////////////////////////////////////////////////////////




//////////////////////////////////////////////////////////////////////////////////BOTONES


        gestionE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                laminas.show(panelPrincipal, "2");


            }
        });

        asignacionA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                laminas.show(panelPrincipal, "3");

                try {
                    ComboAlumno.removeAllItems();
                    for (int i=0; i<con.rellenaCombalum().size();i++) {
                        ComboAlumno.addItem(con.rellenaCombalum().get(i));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }catch(NullPointerException e){
                    System.out.println("Combo vacio");
                }

                try {
                    ComboEmpresa.removeAllItems();
                    for (int i=0; i<con.rellenaCombempre().size();i++) {
                        ComboEmpresa.addItem(con.rellenaCombempre().get(i));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }catch(NullPointerException e){
                    System.out.println("Combo vacio");
                }

                try {
                    ComboTutor.removeAllItems();
                    for (int i=0; i<con.rellenaCombtut().size();i++) {
                        ComboTutor.addItem(con.rellenaCombtut().get(i));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }catch(NullPointerException e){
                    System.out.println("Combo vacio");
                }


            }

        });

        ficherosT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                laminas.show(panelPrincipal, "4");
/*
                ///Funcionalidad
                fctImp funciones =new fctImp();
                try {
                    funciones.FicherosATabla();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }

 */
            }

        });


        insertarFicheros.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ///Funcionalidad
                fctImp funciones =new fctImp();
                try {
                    String result = funciones.FicherosATabla();
                    resultadoFicheros.setText(result);
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
        borrarDatos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ///Funcionalidad
                fctImp funciones =new fctImp();
                try {

                    resultadoFicheros.setText(funciones.borraTut());
                    resultadoFicheros.setText(funciones.borraAlum());
                } catch (SQLException en) {
                    resultadoFicheros.setText("Error");
                }
            }

        });

        insertar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                try{
                    fctImp tabla =new fctImp();
                    String COD_EMPRESA= codigoEmpresaText.getText();
                    String NOM_EMPRESA= nombreEmpresaText.getText();
                    String CIF= cifText.getText();
                    String DIREC=direcciontext.getText();
                    String LOCALI= localidadText.getText();
                    String CP= cpText.getText();
                    String TIP_JORNADA= (String) TipoJorComb.getSelectedItem();
                    String DNI_RESP=dniText.getText();
                    String NOM_RESP=nombreRespText.getText();
                    String APELLIDO_RESP=apellidoRespText.getText();
                    String DNI_TUTOR= dniRespText.getText();
                    String NOM_TUTOR= nombreTutorText.getText();
                    String APE_TUTOR= apellidoTutorText.getText();
                    String MAIL_TUTOR= mailText.getText();
                    String TLF_TUTOR= telefonoText.getText();

                   resultadoConsulta.setText(tabla.inserta(COD_EMPRESA,NOM_EMPRESA,CIF,DIREC,LOCALI,CP,TIP_JORNADA,DNI_RESP,NOM_RESP,APELLIDO_RESP,DNI_TUTOR,NOM_TUTOR,APE_TUTOR,MAIL_TUTOR,TLF_TUTOR));






                } catch(NumberFormatException | SQLException ex){
                    codigoEmpresaText.setText("Solo puedes escribir numeros");


                }

                model.setRowCount(0);
                try {
                    ArrayList<emp>lista =con.consulta();
                    for (int i=0; i<lista.size(); i++) {
                        rowData[0]=Integer.parseInt(lista.get(i).getCodigo());
                        rowData[1]= lista.get(i).getNom_emp();
                        rowData[2]=lista.get(i).getCif();
                        rowData[3]=lista.get(i).getDireccion();
                        rowData[4]=lista.get(i).getLocali();
                        rowData[5]=lista.get(i).getCp();
                        rowData[6]=lista.get(i).getTip_jonada();
                        rowData[7]=lista.get(i).getDni_resp();
                        rowData[8]=lista.get(i).getNom_resp();
                        rowData[9]=lista.get(i).getDni_resp();
                        rowData[10]=lista.get(i).getDni_tutor();
                        rowData[11]=lista.get(i).getNom_tutor();
                        rowData[12]=lista.get(i).getApe_tutor();
                        rowData[13]=lista.get(i).getMail_tutor();
                        rowData[14]=lista.get(i).getTlf_tutor();

                        model.addRow(rowData);

                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }



            }

        });

        modificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                try{
                    fctImp tabla =new fctImp();
                    String COD_EMPRESA= codigoEmpresaText.getText();
                    String NOM_EMPRESA= nombreEmpresaText.getText();
                    String CIF= cifText.getText();
                    String DIREC=direcciontext.getText();
                    String LOCALI= localidadText.getText();
                    String CP= cpText.getText();
                    String TIP_JORNADA= (String) TipoJorComb.getSelectedItem();
                    String DNI_RESP=dniText.getText();
                    String NOM_RESP=nombreRespText.getText();
                    String APELLIDO_RESP=apellidoRespText.getText();
                    String DNI_TUTOR= dniRespText.getText();
                    String NOM_TUTOR= nombreTutorText.getText();
                    String APE_TUTOR= apellidoTutorText.getText();
                    String MAIL_TUTOR= mailText.getText();
                    String TLF_TUTOR= telefonoText.getText();
                    resultadoConsulta.setText(tabla.modfica(COD_EMPRESA, NOM_EMPRESA, CIF, DIREC,LOCALI, CP, TIP_JORNADA, DNI_RESP, NOM_RESP, APELLIDO_RESP, DNI_TUTOR,
                             NOM_TUTOR,APE_TUTOR, MAIL_TUTOR,TLF_TUTOR));


                } catch(NumberFormatException | SQLException ex){
                    codigoEmpresaText.setText("solo puedes escribir numeros");


                }

                model.setRowCount(0);

                try {
                    ArrayList<emp>lista =con.consulta();
                    for (int i=0; i<lista.size(); i++) {
                        rowData[0]=Integer.parseInt(lista.get(i).getCodigo());
                        rowData[1]= lista.get(i).getNom_emp();
                        rowData[2]=lista.get(i).getCif();
                        rowData[3]=lista.get(i).getDireccion();
                        rowData[4]=lista.get(i).getLocali();
                        rowData[5]=lista.get(i).getCp();
                        rowData[6]=lista.get(i).getTip_jonada();
                        rowData[7]=lista.get(i).getDni_resp();
                        rowData[8]=lista.get(i).getNom_resp();
                        rowData[9]=lista.get(i).getDni_resp();
                        rowData[10]=lista.get(i).getDni_tutor();
                        rowData[11]=lista.get(i).getNom_tutor();
                        rowData[12]=lista.get(i).getApe_tutor();
                        rowData[13]=lista.get(i).getMail_tutor();
                        rowData[14]=lista.get(i).getTlf_tutor();

                        model.addRow(rowData);


                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }



            }

        });
        borrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                try{
                    fctImp tabla =new fctImp();
                    String COD_EMPRESA= codigoEmpresaText.getText();

                    resultadoConsulta.setText(tabla.borra(COD_EMPRESA));


                } catch(NumberFormatException | SQLException ex){
                    codigoEmpresaText.setText("solo puedes escribir numeros");

                }

                model.setRowCount(0);

                try {
                    ArrayList<emp>lista =con.consulta();
                    for (int i=0; i<lista.size(); i++) {
                        rowData[0]=Integer.parseInt(lista.get(i).getCodigo());
                        rowData[1]= lista.get(i).getNom_emp();
                        rowData[2]=lista.get(i).getCif();
                        rowData[3]=lista.get(i).getDireccion();
                        rowData[4]=lista.get(i).getLocali();
                        rowData[5]=lista.get(i).getCp();
                        rowData[6]=lista.get(i).getTip_jonada();
                        rowData[7]=lista.get(i).getDni_resp();
                        rowData[8]=lista.get(i).getNom_resp();
                        rowData[9]=lista.get(i).getDni_resp();
                        rowData[10]=lista.get(i).getDni_tutor();
                        rowData[11]=lista.get(i).getNom_tutor();
                        rowData[12]=lista.get(i).getApe_tutor();
                        rowData[13]=lista.get(i).getMail_tutor();
                        rowData[14]=lista.get(i).getTlf_tutor();

                        model.addRow(rowData);


                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        });



        marco.setVisible(true);
        marco.setSize(720, 700);
        marco.setResizable(false);



    }
}