package gest;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class fctImp {
////////////// Conexion BBDD
    private static final String ADD_DRIVER = "org.mariadb.jdbc.Driver";
    private static final String URL_CONEXION = "jdbc:mariadb://localhost:3306/fct";
    final String usuario = "root";
    final String contrasenia = "";
    Connection conexBd = null;
    PreparedStatement encapsulaCons = null;

    public String inserta(String COD_EMPRESA, String NOM_EMPRESA, String CIF, String LOCALI,String CP,String TIP_JORNADA, String DNI_TUTOR,
                          String NOM_TUTOR,String APE_TUTOR,String MAIL_TUTOR,String TLF_TUTOR ) throws SQLException {

        String mensaje = "";
        try {

            Class.forName(ADD_DRIVER);
            conexBd = DriverManager.getConnection(URL_CONEXION, usuario, contrasenia);
            String inser = "INSERT INTO empresa VALUES(" + COD_EMPRESA + ",'" + NOM_EMPRESA + "','" + CIF + "','"+ LOCALI +"','"+CP+"','"+TIP_JORNADA+"','"+DNI_TUTOR+"','"+NOM_TUTOR+"'" +
                    ",'"+APE_TUTOR+"','"+MAIL_TUTOR+"','"+TLF_TUTOR+"');";
            encapsulaCons = conexBd.prepareStatement(inser);
            conexBd.setAutoCommit(false);
            encapsulaCons.executeQuery();
            conexBd.commit();
            mensaje = "registro insertado";
        } catch (SQLException se) {
            System.out.println(se.getMessage());
            mensaje = "error, no has insertado los datos correctamente";
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
            mensaje = "error";
        } finally {
            if (encapsulaCons != null) {
                encapsulaCons.close();

            }
        }
        if (conexBd != null) {
            conexBd.close();
        }

        return mensaje;
    }

    //////////////////////////////////////////////////////////////

    public String modfica(String COD_EMPRESA, String NOM_EMPRESA, String CIF, String LOCALI,String CP,String TIP_JORNADA, String DNI_TUTOR,
                          String NOM_TUTOR,String APE_TUTOR,String MAIL_TUTOR,String TLF_TUTOR ) throws SQLException{

        String mensaje = "";
        try {

            Class.forName(ADD_DRIVER);
            conexBd = DriverManager.getConnection(URL_CONEXION, usuario, contrasenia);

            String mod1 = "update empresa set NOM_EMPRESA='" + NOM_EMPRESA + "',CIF='" + CIF + "',LOCALI='" + LOCALI + "',CP='" + CP + "',TIP_JORNADA='" + TIP_JORNADA + "',DNI_TUTOR='" + DNI_TUTOR + "'" +
                    ",NOM_TUTOR='" + NOM_TUTOR + "',APE_TUTOR='" + APE_TUTOR + "',MAIL_TUTOR='" + MAIL_TUTOR + "',TLF_TUTOR='" + TLF_TUTOR + "' where COD_EMPRESA=" + COD_EMPRESA;

            encapsulaCons = conexBd.prepareStatement(mod1);
            conexBd.setAutoCommit(false);
            encapsulaCons.executeQuery();
            conexBd.commit();
            mensaje = "Registro Modificado";
        } catch (SQLException se) {
            System.out.println(se.getMessage());
            mensaje = "error, no has insertado los datos correctamente";
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        } finally {
            if (encapsulaCons != null) {
                encapsulaCons.close();
            }
        }
        if (conexBd != null) {
            conexBd.close();
        }
        return mensaje;
    }
    //////////////////////////////////////////////////////////
    public String borra(String COD_EMPRESA) throws SQLException {

        String mensaje = "";
        try {

            Class.forName(ADD_DRIVER);
            conexBd = DriverManager.getConnection(URL_CONEXION, usuario, contrasenia);

            String mod1 = "delete from empresa where COD_EMPRESA=" + COD_EMPRESA;

            encapsulaCons = conexBd.prepareStatement(mod1);
            conexBd.setAutoCommit(false);
            encapsulaCons.executeQuery();
            conexBd.commit();
            mensaje = "Registro borrado";
        } catch (SQLException se) {
            System.out.println(se.getMessage());
            mensaje = "error, no has insertado los datos correctamente";
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        } finally {
            if (encapsulaCons != null) {
                encapsulaCons.close();
            }
        }
        if (conexBd != null) {
            conexBd.close();
        }
        return mensaje;
    }

    /////////////////////////////////////////////////
    public ArrayList<emp> consulta() throws SQLException {
        ArrayList<emp> lista =new ArrayList<>();;
        try {

            Class.forName(ADD_DRIVER);
            conexBd = DriverManager.getConnection(URL_CONEXION, usuario, contrasenia);
            String mod1 = "SELECT * FROM empresa";
            encapsulaCons = conexBd.prepareStatement(mod1);
            ResultSet consul = encapsulaCons.executeQuery();

            emp empresa;

            while (consul.next()) {
                empresa = new emp(consul.getString("COD_EMPRESA"), consul.getString("NOM_EMPRESA"), consul.getString("CIF"),
                        consul.getString("LOCALI"), consul.getString("CP"), consul.getString("TIP_JORNADA"), consul.getString("DNI_TUTOR"),
                        consul.getString("NOM_TUTOR"), consul.getString("APE_TUTOR"), consul.getString("MAIL_TUTOR"), consul.getString("TLF_TUTOR"));

                lista.add(empresa);
            }

        } catch (SQLException se) {
            System.out.println(se.getMessage());

        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        } finally {
            if (encapsulaCons != null) {
                encapsulaCons.close();
            }
        }
        if (conexBd != null) {
            conexBd.close();
        }
        return lista;
    }

    public void muestra(){

        DefaultTableModel model = new DefaultTableModel();


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

    }


}
