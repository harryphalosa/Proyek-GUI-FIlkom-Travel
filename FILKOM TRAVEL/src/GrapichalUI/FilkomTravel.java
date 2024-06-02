package GrapichalUI;

import core.*;
import core.customer.*;
import core.promotion.CashbackPromo;
import core.promotion.Discount;
import core.promotion.Promotion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FilkomTravel extends JFrame {
    JFrame frame;
    private JPanel mainPanel;
    private JPanel panel1;
    private JPanel panelCreateMember;
    private JPanel panelCreateGuest;
    private JPanel panel2;
    private JPanel panelTopUp;
    private JPanel panelCreatePromo;
    private JPanel panelCreateMenu;
    private JPanel panel3;
    private JPanel panelApplyPromo;
    private JPanel panelAddToCart;
    private JPanel panelRemoveFromCart;
    private JPanel panelCheckOut;
    private JPanel panelCetak;
    private JPanel panelPrintHistory;
    ArrayList<Customer> listCustomer = new ArrayList<>();
    ArrayList<Promotion> listPromotion = new ArrayList<>();
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FilkomTravel().setVisible(true);
            }
        });
    }
    public boolean isIDExist(ArrayList<Customer> listCustomer, String id){
        for(Customer customer : listCustomer){
            if(customer.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    public FilkomTravel() {
        frame = this;
        setTitle("Filkom Travel");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new CardLayout());

        // Initialize all panels and add them to the frame
        initializeMainPanel();
        initializePanel1();
        initializePanelCreateMember();
        initializePanelCreateGuest();
        initializePanel2();
        initializePanelTopUp();
        initializePanelCreatePromo();
        initializePanelCreateMenu();
        initializePanel3();
        initializePanelApplyPromo();
        initializePanelAddToCart();
        initializePanelRemoveFromCart();
        initializePanelCheckOut();
        initializePanelCetak();
        initializePanelPrintHistory();
        

        add(mainPanel, "MainPanel");
        add(panel1, "Panel1");
        add(panelCreateMember, "PanelCreateMember");
        add(panelCreateGuest, "PanelCreateGuest");
        add(panel2, "Panel2");
        add(panelTopUp, "PanelTopUp");
        add(panelCreatePromo, "PanelCreatePromo");
        add(panelCreateMenu, "PanelCreateMenu");
        add(panel3, "Panel3");
        add(panelApplyPromo, "PanelApplyPromo");
        add(panelAddToCart, "PanelAddToCart");
        add(panelRemoveFromCart, "PanelRemoveFromCart");
        add(panelCheckOut, "PanelCheckOut");
        add(panelCetak, "PanelCetak");
        add(panelPrintHistory, "PanelPrintHistory");

        // Show the main panel first
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "MainPanel");
    }

    private void initializeMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JLabel title = new JLabel("Filkom Travel", SwingConstants.CENTER);
        mainPanel.add(title, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "Panel1");
            }
        });
        centerPanel.add(startButton);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
    }

    private void initializePanel1() {
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel();
        GroupLayout layout = new GroupLayout(centerPanel);
        centerPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JLabel guestLabel = new JLabel("Guest List", SwingConstants.CENTER);
        JList<String> guestList = new JList<>(new String[] { "Guest 1", "Guest 2", "Guest 3" });
        JScrollPane guestScrollPane = new JScrollPane(guestList);

        JLabel memberLabel = new JLabel("Member List", SwingConstants.CENTER);
        JList<String> memberList = new JList<>(new String[] { "Member 1", "Member 2", "Member 3" });
        JScrollPane memberScrollPane = new JScrollPane(memberList);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(guestLabel)
                        .addComponent(guestScrollPane)
                        .addComponent(memberLabel)
                        .addComponent(memberScrollPane)));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(guestLabel)
                .addComponent(guestScrollPane)
                .addComponent(memberLabel)
                .addComponent(memberScrollPane));

        panel1.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton createGuestButton = new JButton("Create Guest");
        createGuestButton.setSize(50, 20);
        createGuestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "PanelCreateGuest");
            }
        });
        bottomPanel.add(createGuestButton);

        JButton createMemberButton = new JButton("Create Member");
        createMemberButton.setSize(50, 20);
        createMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "PanelCreateMember");
            }
        });
        bottomPanel.add(createMemberButton);

        JButton nextButton = new JButton("Next");
        nextButton.setSize(50, 20);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "Panel2");
            }
        });

        bottomPanel.add(nextButton);
        panel1.add(bottomPanel, BorderLayout.SOUTH);
    }

    private void initializePanelCreateMember() {
        panelCreateMember = new JPanel();
        panelCreateMember.setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel();
        GroupLayout layout = new GroupLayout(centerPanel);
        centerPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JLabel idLabel = new JLabel("ID:");
        JTextField idField = new JTextField();
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        // Membuat combo box untuk tanggal
        JLabel registerDateLabel = new JLabel("Register Date:");
        String[] days = new String[31];
        for (int i = 0; i < 31; i++) {
            days[i] = String.valueOf(i + 1);
        }
        JComboBox<String> dayComboBox = new JComboBox<>(days);
        // Membuat combo box untuk bulan
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        JComboBox<String> monthComboBox = new JComboBox<>(months);

        // Membuat combo box untuk tahun
        String[] years = new String[100];
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        for (int i = 0; i < 100; i++) {
            years[i] = String.valueOf(currentYear - i);
        }
        JComboBox<String> yearComboBox = new JComboBox<>(years);

        JLabel saldoLabel = new JLabel("Saldo:");
        JTextField saldoField = new JTextField();

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(idLabel)
                        .addComponent(nameLabel)
                        .addComponent(registerDateLabel)
                        .addComponent(saldoLabel)) // Menambahkan label saldo
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(idField)
                        .addComponent(nameField)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(dayComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(monthComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(yearComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addComponent(saldoField))); // Menambahkan field saldo

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(idLabel)
                        .addComponent(idField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(nameLabel)
                        .addComponent(nameField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(registerDateLabel) // Menambahkan label tanggal
                        .addComponent(dayComboBox) // Menambahkan combo box tanggal
                        .addComponent(monthComboBox) // Menambahkan combo box bulan
                        .addComponent(yearComboBox)) // Menambahkan combo box tahun
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(saldoLabel) // Menambahkan label saldo
                        .addComponent(saldoField))); // Menambahkan field saldo

        panelCreateMember.add(centerPanel, BorderLayout.CENTER);

                panelCreateMember.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "Panel1");
            }
        });
        JButton createButton = new JButton("Create");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            // Mengambil nilai ID, nama, tanggal daftar, dan saldo dari field
            String memberId = idField.getText();
            String memberName = nameField.getText();
            // Mengambil nilai dari combo box tanggal, bulan, dan tahun
            String day = (String) dayComboBox.getSelectedItem();
            String month = (String) monthComboBox.getSelectedItem();
            String year = (String) yearComboBox.getSelectedItem();

            // Mengonversi nilai tersebut menjadi objek LocalDate
            String dateString = day + " " + month + " " + year;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");
            LocalDate date = LocalDate.parse(dateString, formatter);
            int memberBudget = Integer.parseInt(saldoField.getText());

            // Mengecek apakah ID sudah ada dalam listCustomer
            boolean isExisting = isIDExist(listCustomer, memberId);

            // Jika ID sudah ada, tampilkan pop-up "CREATE MEMBER FAILED"
            if (isExisting) {
                JOptionPane.showMessageDialog(panelCreateMember, "CREATE MEMBER FAILED: " + memberId + " IS EXISTS");
            } else {
                // Jika ID belum ada, tambahkan anggota baru ke dalam listCustomer dan tampilkan pop-up "CREATE MEMBER SUCCESS"
                listCustomer.add(new Member(memberId, memberName, date, memberBudget));
                JOptionPane.showMessageDialog(panelCreateMember, "CREATE MEMBER SUCCESS: " + memberId);
            }
        }
    });
        
        bottomPanel.add(backButton);
        bottomPanel.add(createButton);
        panelCreateMember.add(bottomPanel, BorderLayout.SOUTH);
    }

    private void initializePanelCreateGuest() {
        panelCreateGuest = new JPanel();
        panelCreateGuest.setLayout(new BorderLayout());
    
        JPanel centerPanel = new JPanel();
        GroupLayout layout = new GroupLayout(centerPanel);
        centerPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
    
        JLabel idLabel = new JLabel("ID:");
        JTextField idField = new JTextField();
        JLabel saldoLabel = new JLabel("Saldo Awal:");
        JTextField saldoField = new JTextField();
    
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(idLabel)
                        .addComponent(saldoLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(idField)
                        .addComponent(saldoField)));
    
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(idLabel)
                        .addComponent(idField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(saldoLabel)
                        .addComponent(saldoField)));
    
        panelCreateGuest.add(centerPanel, BorderLayout.CENTER);
    
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mengambil nilai ID dan saldo dari field
                String id = idField.getText();
                int saldo = Integer.parseInt(saldoField.getText());
    
                // Mengecek apakah ID sudah ada dalam listCustomer
                boolean isExisting = isIDExist(listCustomer, id);
    
                // Jika ID sudah ada, tampilkan pop-up "CREATE GUEST FAILED"
                if (isExisting) {
                    JOptionPane.showMessageDialog(panelCreateGuest, "CREATE GUEST FAILED: " + id + " IS EXISTS");
                } else {
                    // Jika ID belum ada, tambahkan guest baru ke dalam listCustomer dan tampilkan pop-up "CREATE GUEST SUCCESS"
                    listCustomer.add(new Guest(id, saldo));
                    JOptionPane.showMessageDialog(panelCreateGuest, "CREATE GUEST SUCCESS: " + id);
                }
            }
        });
        bottomPanel.add(addButton);
    
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "Panel1");
            }
        });
        bottomPanel.add(backButton);
    
        panelCreateGuest.add(bottomPanel, BorderLayout.SOUTH);
    }
    

    private void initializePanel2() {
        panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());

        JLabel panel2Label = new JLabel("Panel 2", SwingConstants.CENTER);
        panel2.add(panel2Label, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton topUpButton = new JButton("Top Up");
        topUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "PanelTopUp");
            }
        });
        centerPanel.add(topUpButton);

        JButton createPromoButton = new JButton("Create Promo");
        createPromoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "PanelCreatePromo");
            }
        });
        centerPanel.add(createPromoButton);

        JButton createMenuButton = new JButton("Create Menu");
        createMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "PanelCreateMenu");
            }
        });
        centerPanel.add(createMenuButton);

        panel2.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "Panel1");
            }
        });
        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "Panel3");
            }
        });
        bottomPanel.add(backButton);
        bottomPanel.add(nextButton);
        panel2.add(bottomPanel, BorderLayout.SOUTH);
    }

    private void initializePanelTopUp() {
        panelTopUp = new JPanel();
        panelTopUp.setLayout(new BorderLayout());
    
        JLabel panelTopUpLabel = new JLabel("Panel Top Up", SwingConstants.CENTER);
        panelTopUp.add(panelTopUpLabel, BorderLayout.NORTH);
    
        JPanel centerPanel = new JPanel();
        GroupLayout layout = new GroupLayout(centerPanel);
        centerPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
    
        JLabel idPemesanLabel = new JLabel("ID Pemesan:");
        JTextField idPemesanField = new JTextField();
        JLabel nominalTopUpLabel = new JLabel("Nominal Top Up:");
        JTextField nominalTopUpField = new JTextField();
    
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(idPemesanLabel)
                        .addComponent(nominalTopUpLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(idPemesanField)
                        .addComponent(nominalTopUpField)));
    
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(idPemesanLabel)
                        .addComponent(idPemesanField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(nominalTopUpLabel)
                        .addComponent(nominalTopUpField)));
    
        panelTopUp.add(centerPanel, BorderLayout.CENTER);
    
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton simpanButton = new JButton("Simpan");
        simpanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String topUpOrderID = idPemesanField.getText();
                int topUpBudget = Integer.parseInt(nominalTopUpField.getText());
    
                // Logika untuk memeriksa apakah pelanggan ada dalam daftar
                boolean isCustomerExist = false;
                Customer foundCustomer = null;
                for (Customer customer : listCustomer) {
                    if (customer.getId().equals(topUpOrderID)) {
                        isCustomerExist = true;
                        foundCustomer = customer;
                        break;
                    }
                }
    
                if (isCustomerExist) {
                    // Logika untuk mengupdate saldo pelanggan
                    int initBalance = foundCustomer.getBalance();
                    foundCustomer.updateBalance(topUpBudget);
    
                    // Mencetak pesan keberhasilan top-up sebagai dialog popup
                    if (foundCustomer instanceof Member) {
                        Member member = (Member) foundCustomer;
                        JOptionPane.showMessageDialog(panelTopUp, String.format("TOPUP SUCCESS: %s %d => %d", member.getMemberName(), initBalance, member.getBalance()));
                    } else if (foundCustomer instanceof Guest) {
                        Guest guest = (Guest) foundCustomer;
                        JOptionPane.showMessageDialog(panelTopUp, String.format("TOPUP SUCCESS: GUEST %d => %d", initBalance, guest.getBalance()));
                    }
                } else {
                    JOptionPane.showMessageDialog(panelTopUp, "TOPUP FAILED: NON EXISTENT CUSTOMER");
                }
            }
        });
        bottomPanel.add(simpanButton);
    
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "Panel2");
            }
        });
        bottomPanel.add(backButton);
    
        panelTopUp.add(bottomPanel, BorderLayout.SOUTH);
    }

    private void initializePanelCreatePromo() {
        panelCreatePromo = new JPanel();
        panelCreatePromo.setLayout(new BorderLayout());

        JLabel panelCreatePromoLabel = new JLabel("Panel Create Promo", SwingConstants.CENTER);
        panelCreatePromo.add(panelCreatePromoLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        GroupLayout layout = new GroupLayout(centerPanel);
        centerPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Radio button untuk memilih jenis promo
        JRadioButton cashbackRadioButton = new JRadioButton("Cashback Promo");
        JRadioButton discountRadioButton = new JRadioButton("Discount Promo");

        
         // Promo name
         JLabel promoNameLabel = new JLabel("Promo Name:");
         JTextField promoNameField = new JTextField();

        // Persen Potongan
        JLabel persenPotonganLabel = new JLabel("Persen Potongan:");
        JTextField persenPotonganField = new JTextField();

        // Grupkan radio button agar hanya satu yang bisa dipilih
        ButtonGroup promoTypeGroup = new ButtonGroup();
        promoTypeGroup.add(cashbackRadioButton);
        promoTypeGroup.add(discountRadioButton);

        JLabel tanggalAwalLabel = new JLabel("Tanggal Awal:");
        JComboBox<String> tanggalAwalComboBox = new JComboBox<>(getDates());
        JComboBox<String> bulanAwalComboBox = new JComboBox<>(getMonths());
        JComboBox<String> tahunAwalComboBox = new JComboBox<>(getYears());
        JLabel tanggalAkhirLabel = new JLabel("Tanggal Akhir:");
        JComboBox<String> tanggalAkhirComboBox = new JComboBox<>(getDates());
        JComboBox<String> bulanAkhirComboBox = new JComboBox<>(getMonths());
        JComboBox<String> tahunAkhirComboBox = new JComboBox<>(getYears());
        JLabel maksPotonganLabel = new JLabel("Maks Potongan:");
        JTextField maksPotonganField = new JTextField();
        JLabel minPembelianLabel = new JLabel("Min Pembelian:");
        JTextField minPembelianField = new JTextField();

        layout.setHorizontalGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(cashbackRadioButton)
                .addComponent(discountRadioButton))
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(promoNameLabel)
                .addComponent(persenPotonganLabel)
                .addComponent(tanggalAwalLabel)
                .addComponent(tanggalAkhirLabel)
                .addComponent(maksPotonganLabel)
                .addComponent(minPembelianLabel))
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(promoNameField)
                .addComponent(persenPotonganField)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(tanggalAwalComboBox)
                        .addComponent(bulanAwalComboBox)
                        .addComponent(tahunAwalComboBox))
                .addGroup(layout.createSequentialGroup()
                        .addComponent(tanggalAkhirComboBox)
                        .addComponent(bulanAkhirComboBox)
                        .addComponent(tahunAkhirComboBox))
                .addComponent(maksPotonganField)
                .addComponent(minPembelianField)));

layout.setVerticalGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(cashbackRadioButton))
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(discountRadioButton))
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(promoNameLabel)
                .addComponent(promoNameField))
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(persenPotonganLabel)
                .addComponent(persenPotonganField))
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(tanggalAwalLabel)
                .addComponent(tanggalAwalComboBox)
                .addComponent(bulanAwalComboBox)
                .addComponent(tahunAwalComboBox))
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(tanggalAkhirLabel)
                .addComponent(tanggalAkhirComboBox)
                .addComponent(bulanAkhirComboBox)
                .addComponent(tahunAkhirComboBox))
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(maksPotonganLabel)
                .addComponent(maksPotonganField))
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(minPembelianLabel)
                .addComponent(minPembelianField)));

panelCreatePromo.add(centerPanel, BorderLayout.CENTER);


        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton simpanButton = new JButton("Simpan");
        simpanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    // Mendapatkan nilai dari JTextField langsung
                    String promoName = promoNameField.getText();
                    LocalDate tanggalAwal = LocalDate.of(
                            Integer.parseInt((String) tahunAwalComboBox.getSelectedItem()),
                            bulanAwalComboBox.getSelectedIndex() + 1,
                            Integer.parseInt((String) tanggalAwalComboBox.getSelectedItem())
                    );
                    LocalDate tanggalAkhir = LocalDate.of(
                            Integer.parseInt((String) tahunAkhirComboBox.getSelectedItem()),
                            bulanAkhirComboBox.getSelectedIndex() + 1,
                            Integer.parseInt((String) tanggalAkhirComboBox.getSelectedItem())
                    );
                    int maksPotongan = Integer.parseInt(maksPotonganField.getText());
                    int minPembelian = Integer.parseInt(minPembelianField.getText());
                    int persenPotongan = Integer.parseInt(persenPotonganField.getText());
    
                    // Menentukan jenis promo berdasarkan radio button yang dipilih
                    String selectedPromoType;
                    if (cashbackRadioButton.isSelected()) {
                        selectedPromoType = "CASHBACK";
                    } else if (discountRadioButton.isSelected()) {
                        selectedPromoType = "DISCOUNT";
                    } else {
                        // Tidak ada radio button yang dipilih
                        JOptionPane.showMessageDialog(panelCreatePromo, "Pilih jenis promo terlebih dahulu!");
                        return;
                    }
    
                    // Logika untuk menyimpan informasi promo
                    if (!isPromoExist(listPromotion, promoName)) {
                        if (selectedPromoType.equals("CASHBACK")) {
                            listPromotion.add(new CashbackPromo(promoName, tanggalAwal, tanggalAkhir, persenPotongan, maksPotongan, minPembelian));
                            JOptionPane.showMessageDialog(panelCreatePromo, "CREATE PROMO CASHBACK SUCCESS: " + promoName);
                        } else if (selectedPromoType.equals("DISCOUNT")) {
                            listPromotion.add(new Discount(promoName, tanggalAwal, tanggalAkhir, persenPotongan, maksPotongan, minPembelian));
                            JOptionPane.showMessageDialog(panelCreatePromo, "CREATE PROMO DISCOUNT SUCCESS: " + promoName);
                        }
                    } else {
                        if (selectedPromoType.equals("CASHBACK")) {
                            JOptionPane.showMessageDialog(panelCreatePromo, "CREATE PROMO CASHBACK FAILED: " + promoName + " IS EXISTS");
                        } else if (selectedPromoType.equals("DISCOUNT")) {
                            JOptionPane.showMessageDialog(panelCreatePromo, "CREATE PROMO DISCOUNT FAILED: " + promoName + " IS EXISTS");
                        }
                }
            }
        });
        bottomPanel.add(simpanButton);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "Panel2");
            }
        });
        bottomPanel.add(backButton);

        panelCreatePromo.add(bottomPanel, BorderLayout.SOUTH);
    }

    private boolean isPromoExist(ArrayList<Promotion> listPromotion, String promoName) {
        for (Promotion promo : listPromotion) {
            if (promo.getPromoCode().equals(promoName)) {
                return true;
            }
        }
        return false;
    }


    private void initializePanelCreateMenu() {
        panelCreateMenu = new JPanel();
        panelCreateMenu.setLayout(new BorderLayout());

        JLabel panelCreateMenuLabel = new JLabel("Panel Create Menu", SwingConstants.CENTER);
        panelCreateMenu.add(panelCreateMenuLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        GroupLayout layout = new GroupLayout(centerPanel);
        centerPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JLabel idMenuLabel = new JLabel("ID Menu:");
        JTextField idMenuField = new JTextField();
        JLabel namaMenuLabel = new JLabel("Nama Menu:");
        JTextField namaMenuField = new JTextField();
        JLabel platNomorLabel = new JLabel("Plat Nomor:");
        JTextField platNomorField = new JTextField();
        JLabel hargaLabel = new JLabel("Harga:");
        JTextField hargaField = new JTextField();
        JLabel customTypeLabel = new JLabel("Custom Type:");
        JTextField customTypeField = new JTextField();

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(idMenuLabel)
                        .addComponent(namaMenuLabel)
                        .addComponent(platNomorLabel)
                        .addComponent(hargaLabel)
                        .addComponent(customTypeLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(idMenuField)
                        .addComponent(namaMenuField)
                        .addComponent(platNomorField)
                        .addComponent(hargaField)
                        .addComponent(customTypeField)));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(idMenuLabel)
                        .addComponent(idMenuField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(namaMenuLabel)
                        .addComponent(namaMenuField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(platNomorLabel)
                        .addComponent(platNomorField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(hargaLabel)
                        .addComponent(hargaField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(customTypeLabel)
                        .addComponent(customTypeField)));

        panelCreateMenu.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton simpanButton = new JButton("Simpan");
        simpanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic for saving menu information
            }
        });
        bottomPanel.add(simpanButton);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "Panel2");
            }
        });
        bottomPanel.add(backButton);

        panelCreateMenu.add(bottomPanel, BorderLayout.SOUTH);
    }

    private void initializePanel3() {
        panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());

        JLabel panel3Label = new JLabel("Panel 3", SwingConstants.CENTER);
        panel3.add(panel3Label, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        GroupLayout layout = new GroupLayout(centerPanel);
        centerPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JLabel cartListLabel = new JLabel("Cart List:");
        JList<String> cartList = new JList<>(new String[] { "Cart Item 1", "Cart Item 2", "Cart Item 3" });
        JScrollPane cartScrollPane = new JScrollPane(cartList);
        cartScrollPane.setPreferredSize(new Dimension(150, 200));

        JLabel appliedPromoListLabel = new JLabel("Applied Promo List:");
        JList<String> appliedPromoList = new JList<>(
                new String[] { "Applied Promo 1", "Applied Promo 2", "Applied Promo 3" });
        JScrollPane appliedPromoScrollPane = new JScrollPane(appliedPromoList);
        appliedPromoScrollPane.setPreferredSize(new Dimension(150, 200));

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(cartListLabel)
                        .addComponent(cartScrollPane))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(appliedPromoListLabel)
                        .addComponent(appliedPromoScrollPane)));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(cartListLabel)
                        .addComponent(appliedPromoListLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(cartScrollPane)
                        .addComponent(appliedPromoScrollPane)));

        panel3.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
                cardLayout.show(frame.getContentPane(), "Panel2");
            }
        });
        bottomPanel.add(backButton);

        JButton addToCartButton = new JButton("Add to Cart");
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panelAddToCart);
            }
        });
        bottomPanel.add(addToCartButton);

        JButton removeFromCartButton = new JButton("Remove from Cart");
        removeFromCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panelRemoveFromCart);
            }
        });
        bottomPanel.add(removeFromCartButton);

        JButton applyPromoButton = new JButton("Apply Promo");
        applyPromoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panelApplyPromo);
            }
        });
        bottomPanel.add(applyPromoButton);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
                cardLayout.show(frame.getContentPane(), "PanelCheckOut");
            }
        });
        bottomPanel.add(nextButton);

        panel3.add(bottomPanel, BorderLayout.SOUTH);
    }

    private void initializePanelAddToCart() {
        panelAddToCart = new JPanel();
        panelAddToCart.setLayout(new BorderLayout());

        JLabel panelAddToCartLabel = new JLabel("Panel Add To Cart", SwingConstants.CENTER);
        panelAddToCart.add(panelAddToCartLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        GroupLayout layout = new GroupLayout(centerPanel);
        centerPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JLabel idPemesanLabel = new JLabel("ID Pemesan:");
        JTextField idPemesanField = new JTextField();
        JLabel idMenuLabel = new JLabel("ID Menu:");
        JTextField idMenuField = new JTextField();
        JLabel quantityLabel = new JLabel("Quantity:");
        JTextField quantityField = new JTextField();

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(idPemesanLabel)
                        .addComponent(idMenuLabel)
                        .addComponent(quantityLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(idPemesanField)
                        .addComponent(idMenuField)
                        .addComponent(quantityField)));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(idPemesanLabel)
                        .addComponent(idPemesanField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(idMenuLabel)
                        .addComponent(idMenuField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(quantityLabel)
                        .addComponent(quantityField)));

        panelAddToCart.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton simpanButton = new JButton("Simpan");
        simpanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic for saving item to cart
            }
        });
        bottomPanel.add(simpanButton);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panel3);
            }
        });
        bottomPanel.add(backButton);

        panelAddToCart.add(bottomPanel, BorderLayout.SOUTH);
    }

    private void initializePanelRemoveFromCart() {
        panelRemoveFromCart = new JPanel();
        panelRemoveFromCart.setLayout(new BorderLayout());

        JLabel panelRemoveFromCartLabel = new JLabel("Panel Remove From Cart", SwingConstants.CENTER);
        panelRemoveFromCart.add(panelRemoveFromCartLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        GroupLayout layout = new GroupLayout(centerPanel);
        centerPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JLabel idPemesanLabel = new JLabel("ID Pemesan:");
        JTextField idPemesanField = new JTextField();
        JLabel idMenuLabel = new JLabel("ID Menu:");
        JTextField idMenuField = new JTextField();
        JLabel quantityLabel = new JLabel("Quantity:");
        JTextField quantityField = new JTextField();

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(idPemesanLabel)
                        .addComponent(idMenuLabel)
                        .addComponent(quantityLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(idPemesanField)
                        .addComponent(idMenuField)
                        .addComponent(quantityField)));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(idPemesanLabel)
                        .addComponent(idPemesanField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(idMenuLabel)
                        .addComponent(idMenuField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(quantityLabel)
                        .addComponent(quantityField)));

        panelRemoveFromCart.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton simpanButton = new JButton("Simpan");
        simpanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic for removing item from cart
            }
        });
        bottomPanel.add(simpanButton);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panel3);
            }
        });
        bottomPanel.add(backButton);

        panelRemoveFromCart.add(bottomPanel, BorderLayout.SOUTH);
    }

    private void initializePanelApplyPromo() {
        panelApplyPromo = new JPanel();
        panelApplyPromo.setLayout(new BorderLayout());

        JLabel panelApplyPromoLabel = new JLabel("Panel Apply Promo", SwingConstants.CENTER);
        panelApplyPromo.add(panelApplyPromoLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        GroupLayout layout = new GroupLayout(centerPanel);
        centerPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JLabel idPemesanLabel = new JLabel("ID Pemesan:");
        JTextField idPemesanField = new JTextField();
        JLabel kodePromoLabel = new JLabel("Kode Promo:");
        JTextField kodePromoField = new JTextField();
        JLabel promoListLabel = new JLabel("Promo List:");
        JList<String> promoList = new JList<>(new String[] { "Promo 1", "Promo 2", "Promo 3" });
        JScrollPane promoScrollPane = new JScrollPane(promoList);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(idPemesanLabel)
                        .addComponent(kodePromoLabel)
                        .addComponent(promoListLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(idPemesanField)
                        .addComponent(kodePromoField)
                        .addComponent(promoScrollPane)));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(idPemesanLabel)
                        .addComponent(idPemesanField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(kodePromoLabel)
                        .addComponent(kodePromoField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(promoListLabel)
                        .addComponent(promoScrollPane)));

        panelApplyPromo.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton simpanButton = new JButton("Simpan");
        simpanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic for applying promo
            }
        });
        bottomPanel.add(simpanButton);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panel3);
            }
        });
        bottomPanel.add(backButton);

        panelApplyPromo.add(bottomPanel, BorderLayout.SOUTH);
    }

    private void initializePanelCheckOut() {
        panelCheckOut = new JPanel();
        panelCheckOut.setLayout(new BorderLayout());

        JLabel panelCheckOutLabel = new JLabel("Panel Check Out", SwingConstants.CENTER);
        panelCheckOut.add(panelCheckOutLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 2));

        JLabel idPemesananLabel = new JLabel("ID Pemesanan:");
        centerPanel.add(idPemesananLabel);

        JTextField idPemesananField = new JTextField();
        centerPanel.add(idPemesananField);

        panelCheckOut.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton cetakPesananButton = new JButton("Cetak Pesanan");
        cetakPesananButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panelCetak);
            }
        });
        bottomPanel.add(cetakPesananButton);

        JButton submitButton = new JButton("Submit");
        bottomPanel.add(submitButton);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
                cardLayout.show(frame.getContentPane(), "Panel3");
            }
        });
        bottomPanel.add(backButton);

        panelCheckOut.add(bottomPanel, BorderLayout.SOUTH);
    }

    private void initializePanelCetak() {
        panelCetak = new JPanel();
        panelCetak.setLayout(new BorderLayout());

        JLabel panelCetakLabel = new JLabel("Panel Cetak", SwingConstants.CENTER);
        panelCetak.add(panelCetakLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton backToMenuButton = new JButton("Back To Menu");
        backToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panel2);
            }
        });
        centerPanel.add(backToMenuButton);

        JButton finishButton = new JButton("Finish");
        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panelPrintHistory);
            }
        });
        centerPanel.add(finishButton);

        panelCetak.add(centerPanel, BorderLayout.CENTER);
    }

    private void initializePanelPrintHistory() {
        panelPrintHistory = new JPanel();
        panelPrintHistory.setLayout(new BorderLayout());

        JLabel panelPrintHistoryLabel = new JLabel("Panel Print History", SwingConstants.CENTER);
        panelPrintHistory.add(panelPrintHistoryLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        centerPanel.add(closeButton);

        panelPrintHistory.add(centerPanel, BorderLayout.CENTER);
    }

    private String[] getDates() {
        String[] dates = new String[31];
        for (int i = 1; i <= 31; i++) {
            dates[i - 1] = String.valueOf(i);
        }
        return dates;
    }

    private String[] getMonths() {
        String[] months = new String[12];
        for (int i = 1; i <= 12; i++) {
            months[i - 1] = String.valueOf(i);
        }
        return months;
    }

    private String[] getYears() {
        String[] years = new String[100];
        int startYear = 2000;
        for (int i = 0; i < 100; i++) {
            years[i] = String.valueOf(startYear + i);
        }
        return years;
    }

    private void switchPanel(JPanel panel) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}