/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import Controlador.ConcesionarioDAO;
import Controlador.Conexion;
import Controlador.MotoDAO;
import Controlador.ProformaDAO;
import Controlador.ProformaDetalleDAO;
import Modelo.Concesionario;
import Modelo.Detalle_Proforma;
import Modelo.Moto;
import Modelo.Proforma;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Erick
 */
public class JFProforma extends javax.swing.JFrame {

    /**
     * Creates new form Proforma
     */
    Detalle_Proforma detpro=new Detalle_Proforma();
    ProformaDetalleDAO detprodao=new ProformaDetalleDAO();
    Proforma pro=new Proforma();
    ProformaDAO prodao=new ProformaDAO();
    Concesionario conc=new Concesionario();
    ConcesionarioDAO concdao=new ConcesionarioDAO();
    Moto moto=new Moto();
    MotoDAO motodao= new MotoDAO();
    
    public JFProforma() {
        initComponents();
        ListaComboConcecionario();
        mostrarListaMotos();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMotos = new javax.swing.JTable();
        btnInsertar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaMotos = new javax.swing.JList<>();
        ComboBoxConcesionario = new javax.swing.JComboBox<>();
        txtCantidad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel8.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        jLabel8.setText("Registro de Proforma");

        jLabel9.setText("Id");

        jLabel10.setText("Fecha");

        jLabel11.setText("Estado");

        tblMotos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Apellido", "Direccion"
            }
        ));
        jScrollPane2.setViewportView(tblMotos);

        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar tabla");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        jLabel12.setText("Concesionario");

        jLabel13.setText("Moto");

        jLabel14.setText("Color");

        jLabel15.setText("Cantidad");

        ListaMotos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(ListaMotos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addGap(177, 177, 177)
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCantidad))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addGap(128, 128, 128)
                                        .addComponent(jLabel8))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11))
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtEstado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtColor, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1)
                                    .addComponent(ComboBoxConcesionario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 75, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActualizar)
                        .addGap(184, 184, 184)
                        .addComponent(btnCerrar))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(ComboBoxConcesionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel14)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertar)
                    .addComponent(btnBuscar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnCancelar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar)
                    .addComponent(btnActualizar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed

    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        mostrarDatos("");
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        //pro.setIdConcesionario(txtId.getText());
        prodao.eliminarProforma(txtId.getText());
        detprodao.eliminarProforma(txtId.getText());
        mostrarDatos("");
        reset();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        setDatosDetalle();
        setDatos();
        prodao.modificarProforma(txtId.getText(), pro);
        detprodao.modificarProforma(txtId.getText(), detpro);
        mostrarDatos("");
        reset();
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String idProducto;
        idProducto = prodao.buscarProforma(txtId.getText());
        mostrarDatos(idProducto);
        reset();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        setDatos();setDatosDetalle();
        prodao.registrarProforma(pro);
        detprodao.registrarDetalleProforma(detpro);
        int i=0;
        mostrarDatos("");
        reset();
    }//GEN-LAST:event_btnInsertarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFProforma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFProforma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFProforma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFProforma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFProforma().setVisible(true);
            }
        });
    }
    void mostrarDatos(String valor){
        //JOptionPane.showMessageDialog(null, ComboBoxConcesionario.getSelectedItem());
        Conexion con = new Conexion();       
        String sql="";   
        DefaultTableModel modelo1 = new DefaultTableModel();
        modelo1.addColumn("Id Proforma");
        modelo1.addColumn("Fecha recepcion");
        modelo1.addColumn("Estado");
        modelo1.addColumn("Id Concesionario");
        modelo1.addColumn("Id Moto");
        modelo1.addColumn("Id Cantidad");
        modelo1.addColumn("Id Color");
        tblMotos.setModel(modelo1);
        if (valor.equals(""))
        {
            sql="SELECT proforma.id_proforma,proforma.fecha_recepcion,proforma.estado,proforma.id_concesionario,detalle_proforma.id_moto,detalle_proforma.cantidad,detalle_proforma.color FROM `proforma`,`detalle_proforma` WHERE proforma.id_proforma=detalle_proforma.id_proforma";
            //sql="SELECT * FROM proforma";
        }
        else{
            sql="SELECT proforma.id_proforma,proforma.fecha_recepcion,proforma.estado,proforma.id_concesionario,detalle_proforma.id_moto,detalle_proforma.cantidad,detalle_proforma.color FROM `proforma`,`detalle_proforma` WHERE proforma.id_proforma=detalle_proforma.id_proforma and proforma.id_proforma="+valor;
            //sql="SELECT * FROM proforma WHERE (id_proforma='" + valor + "')";
        }          
        String []datos = new String[8];
        try{
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                modelo1.addRow(datos);
            }
            //jfmotoadmin.tblMotos.setModel(modelo1);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void ListaComboConcecionario()
    {
        Conexion con = new Conexion();       
        String sql="SELECT id_concesionario FROM concesionario";
        //String []datos = new String[10];;   
        try{
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                ComboBoxConcesionario.addItem(rs.getString(1));
                               
            }
            //jfmotoadmin.tblMotos.setModel(modelo1);
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public void mostrarListaMotos()
    {
        Conexion con = new Conexion();       
        int i=0;
        String sql="SELECT id_moto FROM moto";
        String []datos = new String[10];  
        ArrayList<String> motos = new ArrayList<String>();
        try{
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                motos.add(rs.getString(1));
                datos[i++]=rs.getString(1);
                              
            }
            ListaMotos.setListData(datos);
            //jfmotoadmin.tblMotos.setModel(modelo1);
        }catch(SQLException e){
            System.out.println(e);
        }
        
    }
    public void setDatos() // obtiene los datos de la moto cuando se selecciona una
    {
        try{
            //Date fecha;
            //fecha=SimpleDateFormat.parse();
            pro.setId_proforma(txtId.getText());
            pro.setEstado(txtEstado.getText());
            pro.setFecha_recepcion(ParseFecha(txtFecha.getText()));
            pro.setTotal(20);
            pro.setIdConcesionario(ComboBoxConcesionario.getSelectedItem()+"");
       //pro.setDetalle(txtEstado.getText());
       //pro.set(txtTelefono.getText());
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void setDatosDetalle() // obtiene los datos de la moto cuando se selecciona una
    {
        try{
            detpro.setIdDetalleProforma("1");
            detpro.setIdProforma(txtId.getText());
            detpro.setIdmoto(ListaMotos.getSelectedValue());
            detpro.setCantidad(Integer.parseInt(txtCantidad.getText()));
            detpro.setColor(txtColor.getText());
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public static Date ParseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }
    public void reset()
    {
//        txtId.setText("");
//        txtNombre.setText("");
//        txtDireccion.setText("");
//        txtTelefono.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxConcesionario;
    private javax.swing.JList<String> ListaMotos;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblMotos;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
