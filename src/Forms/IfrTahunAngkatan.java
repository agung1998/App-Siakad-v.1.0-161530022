
package Forms;

import Comp.AutoFitTableColumns;
import Entities.TahunAngkatan;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author user
 */
public class IfrTahunAngkatan extends javax.swing.JInternalFrame {

    TahunAngkatan ta = new TahunAngkatan();
    
    /**
     * Creates new form IfrUser
     */
    public IfrTahunAngkatan() {
        initComponents();
        
       clearInput(); disableInput(); showDataTA();
    }

    private void clearInput(){
        txtIdTA.setText("");
        txtTA.setText("");
        btnTambah.setText("Tambah");
        btnSimpan.setText("Simpan");
        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().
                getResource("/Icons/trans-add.png")));
    }
    
    private void disableInput(){
        txtIdTA.setEnabled(false);
        txtTA.setEnabled(false);
        btnSimpan.setEnabled(false);
        btnHapus.setEnabled(false);
    }
    
    private void enableInput(){
        txtIdTA.setEnabled(true);
        txtTA.setEnabled(true);
        btnSimpan.setEnabled(true);
        //btnHapus.setEnabled(true);
    }
    
    private void setTabelTA(){
        
    }
    
    private void clearTabelTA(){
        
    }
    
    private void showDataTA(){
        tbDataTA.setModel(ta.tblthangkatan);
        int row = ta.tblthangkatan.getRowCount();
        for(int i=0; i<row; i++){
            ta.tblthangkatan.removeRow(0);
        }
        ta.select();
        for(Object obj : ta.list){
            ta.tblthangkatan.addRow((Object[]) obj);
        }
        tbDataTA.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        AutoFitTableColumns tca = new AutoFitTableColumns(tbDataTA);
        tca.adjustColumns();
        lblRecord.setText("Record : " + tbDataTA.getRowCount());
        
    }
    
    private void aksiSimpan(){
        if(txtIdTA.getText().equals("") || txtTA.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Mohon lengkapi data", 
                    "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }else{
            ta.isUpdate = !btnSimpan.getText().equals("Simpan");
            ta.id_ta = Integer.parseInt(txtIdTA.getText());
            ta.tahun_angkatan = Integer.parseInt(txtTA.getText());
            ta.insert_update();
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan", 
                    "Informasi", JOptionPane.INFORMATION_MESSAGE);
            clearInput();disableInput();showDataTA();
        }
    }
    
    private void aksiHapus(){
        if(txtIdTA.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Anda belum memilih data yang akan dihapus !", 
                    "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }else{
            int jawab = JOptionPane.showConfirmDialog(this, "Apakah Anda akan menghapus data ini? Kode : "+ta.id_ta, 
                    "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if(jawab == JOptionPane.YES_OPTION);
            ta.delete(ta.id_ta);
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus", 
                    "Informasi", JOptionPane.INFORMATION_MESSAGE);
            clearInput(); disableInput(); showDataTA();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtIdTA = new javax.swing.JTextField();
        txtTA = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnTambah = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDataTA = new javax.swing.JTable();
        lblRecord = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setTitle(".: Form Tahun Angkatan");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Admin-Schoolar-Icon.png"))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Input Data"));
        jPanel1.setOpaque(false);

        txtIdTA.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Kode TA :"));
        txtIdTA.setOpaque(false);

        txtTA.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Tahun Angkatan :"));
        txtTA.setOpaque(false);
        txtTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTAActionPerformed(evt);
            }
        });
        txtTA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTAKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtIdTA, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTA)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdTA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Navigasi"));
        jPanel2.setOpaque(false);

        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/trans-add.png"))); // NOI18N
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/save-black.png"))); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/trans-hapus.png"))); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Tabel Data Tahun Angkatan : Klik 2x untuk mengubah/menghapus data"));

        tbDataTA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Kode TA", "Tahun Angkatan"
            }
        ));
        tbDataTA.setRowHeight(23);
        tbDataTA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDataTAMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbDataTA);

        lblRecord.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRecord.setText("Record : 0");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/logo.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Form Tahun Angkatan");

        jLabel4.setText("Form ini digunakan untuk mengolah data tahun angkatan");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(352, Short.MAX_VALUE)
                .addComponent(lblRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblRecord)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        if(btnTambah.getText().equals("Tambah")){
            clearInput();
            enableInput();
            btnTambah.setText("Batal");
            ta.createAutoID();
            txtIdTA.setText(Integer.toString(ta.id_ta));
            txtTA.requestFocus(true);
            btnTambah.setIcon(new javax.swing.ImageIcon(getClass().
                getResource("/Icons/btn_delete.png")));
        }else if(btnTambah.getText().equals("Batal")){
            clearInput();
            disableInput();
            btnTambah.setIcon(new javax.swing.ImageIcon(getClass().
                getResource("/Icons/trans-add.png")));
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        aksiSimpan();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        aksiHapus();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tbDataTAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDataTAMouseClicked
        if(evt.getClickCount() == 2){
            int row = tbDataTA.getSelectedRow();
            ta.id_ta = Integer.parseInt(tbDataTA.getValueAt(row, 0).toString());
            ta.tahun_angkatan = Integer.parseInt(tbDataTA.getValueAt(row, 1).toString());
            
            txtIdTA.setText(Integer.toString(ta.id_ta));
            txtTA.setText(Integer.toString(ta.tahun_angkatan));
            enableInput();
            txtIdTA.setEnabled(false);
            btnHapus.setEnabled(true);
            btnSimpan.setText("Ubah");
        }
    }//GEN-LAST:event_tbDataTAMouseClicked

    private void txtTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTAActionPerformed
       aksiSimpan();
    }//GEN-LAST:event_txtTAActionPerformed

    private void txtTAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTAKeyTyped
    if(txtTA.getText().length()==4){
        evt.consume();
        }
    }//GEN-LAST:event_txtTAKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRecord;
    private javax.swing.JTable tbDataTA;
    private javax.swing.JTextField txtIdTA;
    private javax.swing.JTextField txtTA;
    // End of variables declaration//GEN-END:variables
}
