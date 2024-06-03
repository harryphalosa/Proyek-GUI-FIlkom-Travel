package GrapichalUI;

import core.*;
import core.customer.*;
import core.promotion.CashbackPromo;
import core.promotion.Discount;
import core.promotion.Promotion;
import core.vehicle.Car;
import core.vehicle.Vehicle;

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
    ArrayList<Customer> arrayListCustomer = new ArrayList<>();
    ArrayList<Order> arrayListMenu = new ArrayList<>();
    ArrayList<Promotion> arrayListPromotion = new ArrayList<>();
    ArrayList<Order> arrayListCart = new ArrayList<>();
    JList<String> guestList = new JList<>(new String[] { "No guests registered yet" });
    JList<String> memberList = new JList<>(new String[] { "No members registered yet" });
    JList<String> promoList = new JList<>(new String[] { "No promo has been registered yet" });
    JList<String> menuList = new JList<>(new String[] { "No menu has been registered yet" });
    JList<String> cartList = new JList<>(new String[] { "No cart has been registered yet" });
    DefaultListModel listMember = new DefaultListModel<>();
    DefaultListModel listGuest = new DefaultListModel<>();
    DefaultListModel listMenu = new DefaultListModel<>();
    DefaultListModel listPromo = new DefaultListModel<>();
    DefaultListModel listCart = new DefaultListModel<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FilkomTravel().setVisible(true);
            }
        });
    }

    public boolean isIDExist(ArrayList<Customer> arrayListCustomer, String id) {
        for (Customer customer : arrayListCustomer) {
            if (customer.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMenuIDExist(ArrayList<Order> listOrder, String menuID) {
        if (listOrder != null && !listOrder.isEmpty()) {
            for (Order order : listOrder) {
                if (order.getMenuID().equals(menuID)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isPromoExist(ArrayList<Promotion> listPromotion, String promoName) {
        for (Promotion promo : listPromotion) {
            if (promo.getPromoCode().equals(promoName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNumberPlateExist(ArrayList<Order> listOrder, String numberPlate) {
        for (Order order : listOrder) {
            if (order.getVehicle().getvehicleNumber().equals(numberPlate)) {
                return true;
            }
        }
        return false;

    }

    public static boolean isCustomerExist(ArrayList<Customer> customers, String customerID) {
        for (Customer customer : customers) {
            if (customer.getId().equals(customerID)) {
                return true;
            }
        }
        return false;
    }

    public static Customer getCustomer(ArrayList<Customer> customers, String customerID) {
        for (Customer customer : customers) {
            if (customer.getId().equals(customerID)) {
                return customer;
            }
        }
        return null;
    }

    public static Order getOrder(ArrayList<Order> listOrder, String menuID) {
        for (Order order : listOrder) {
            if (order.getMenuID().equals(menuID)) {
                return order;
            }
        }
        return null;
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
        mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel title = new JLabel("Filkom Travel", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 48)); // Atur ukuran font menjadi 48px

        mainPanel.add(title, gbc);

        gbc.gridy = 1; // Posisi tombol di bawah label
        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "Panel1");
            }
        });

        mainPanel.add(startButton, gbc);
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
        JScrollPane guestScrollPane = new JScrollPane(guestList);
        JButton createGuestButton = new JButton("Create Guest");
        createGuestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "PanelCreateGuest");
            }
        });

        JLabel memberLabel = new JLabel("Member List", SwingConstants.CENTER);
        JScrollPane memberScrollPane = new JScrollPane(memberList);
        JButton createMemberButton = new JButton("Create Member");
        createMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "PanelCreateMember");
            }
        });

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(guestLabel)
                                .addComponent(guestScrollPane, 150, 200, Short.MAX_VALUE)
                                .addComponent(createGuestButton))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(memberLabel)
                                .addComponent(memberScrollPane, 150, 200, Short.MAX_VALUE)
                                .addComponent(createMemberButton))));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(guestLabel)
                        .addComponent(memberLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(guestScrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addComponent(memberScrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(createGuestButton)
                        .addComponent(createMemberButton)));

        panel1.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Mengubah posisi tombol "Next" ke kanan
                                                                           // bawah
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
        JLabel registerDateLabel = new JLabel("Register Date:");
        String[] days = new String[31];
        for (int i = 0; i < 31; i++) {
            days[i] = String.valueOf(i + 1);
        }
        JComboBox<String> dayComboBox = new JComboBox<>(days);
        String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        JComboBox<String> monthComboBox = new JComboBox<>(months);
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
                        .addComponent(saldoLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(idField)
                        .addComponent(nameField)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(dayComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(monthComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(yearComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE))
                        .addComponent(saldoField)));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(idLabel)
                        .addComponent(idField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(nameLabel)
                        .addComponent(nameField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(registerDateLabel)
                        .addComponent(dayComboBox)
                        .addComponent(monthComboBox)
                        .addComponent(yearComboBox))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(saldoLabel)
                        .addComponent(saldoField)));

        panelCreateMember.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "Panel1");
            }
        });
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                idField.setText("");
                nameField.setText("");
                dayComboBox.setSelectedIndex(0);
                monthComboBox.setSelectedIndex(0);
                yearComboBox.setSelectedIndex(0);
                saldoField.setText("");
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
                boolean isExisting = isIDExist(arrayListCustomer, memberId);

                // Jika ID sudah ada, tampilkan pop-up "CREATE MEMBER FAILED"
                if (isExisting) {
                    JOptionPane.showMessageDialog(panelCreateMember,
                            "CREATE MEMBER FAILED: " + memberId + " IS EXISTS");
                } else {
                    // Jika ID belum ada, tambahkan anggota baru ke dalam listCustomer dan tampilkan
                    // pop-up "CREATE MEMBER SUCCESS"
                    Member newMember = new Member(memberId, memberName, date, memberBudget);
                    arrayListCustomer.add(newMember);
                    addNameToString(newMember, memberName);
                    listMember.addElement(newMember);
                    memberList.setModel(listMember);
                    JOptionPane.showMessageDialog(panelCreateMember, "CREATE MEMBER SUCCESS: " + memberId);
                }
            }
        });

        bottomPanel.add(backButton);
        bottomPanel.add(clearButton);
        bottomPanel.add(createButton);
        panelCreateMember.add(bottomPanel, BorderLayout.SOUTH);
    }

    private static void addNameToString(Customer customer, String name) {
        customer.addNameToString(name);
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
        bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton createButton = new JButton("Create");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Your create guest logic here
            }
        });
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                idField.setText("");
                saldoField.setText("");
            }
        });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "Panel1");
            }
        });
        bottomPanel.add(backButton);
        bottomPanel.add(clearButton);
        bottomPanel.add(createButton);

        panelCreateGuest.add(bottomPanel, BorderLayout.SOUTH);
    }

    private void initializePanel2() {
        panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());

        JLabel panel2Label = new JLabel("Panel 2", SwingConstants.CENTER);
        panel2.add(panel2Label, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        GroupLayout layout = new GroupLayout(centerPanel);
        centerPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JButton topUpButton = new JButton("Top Up");
        topUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "PanelTopUp");
            }
        });

        JButton createPromoButton = new JButton("Create Promo");
        createPromoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "PanelCreatePromo");
            }
        });

        JButton createMenuButton = new JButton("Create Menu");
        createMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "PanelCreateMenu");
            }
        });

        JLabel promoLabel = new JLabel("Promo List", SwingConstants.CENTER);
        JScrollPane promoScrollPane = new JScrollPane(promoList);

        JLabel menuLabel = new JLabel("Menu List", SwingConstants.CENTER);
        JScrollPane menuScrollPane = new JScrollPane(menuList);

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(topUpButton)
                        .addComponent(createPromoButton)
                        .addComponent(createMenuButton))
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(promoLabel)
                                .addComponent(promoScrollPane, 150, 200, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(menuLabel)
                                .addComponent(menuScrollPane, 150, 200, Short.MAX_VALUE))));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(topUpButton)
                        .addComponent(createPromoButton)
                        .addComponent(createMenuButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(promoLabel)
                        .addComponent(menuLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(promoScrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addComponent(menuScrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)));

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
        JButton topUpButton = new JButton("Top up");
        topUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String topUpOrderID = idPemesanField.getText();
                int topUpBudget = Integer.parseInt(nominalTopUpField.getText());

                // Logika untuk memeriksa apakah pelanggan ada dalam daftar
                boolean isCustomerExist = false;
                Customer foundCustomer = null;
                for (Customer customer : arrayListCustomer) {
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
                        JOptionPane.showMessageDialog(panelTopUp, String.format("TOPUP SUCCESS: %s %d => %d",
                                member.getMemberName(), initBalance, member.getBalance()));
                    } else if (foundCustomer instanceof Guest) {
                        Guest guest = (Guest) foundCustomer;
                        JOptionPane.showMessageDialog(panelTopUp,
                                String.format("TOPUP SUCCESS: GUEST %d => %d", initBalance, guest.getBalance()));
                    }
                } else {
                    JOptionPane.showMessageDialog(panelTopUp, "TOPUP FAILED: NON EXISTENT CUSTOMER");
                }
            }
        });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "Panel2");
            }
        });

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                idPemesanField.setText("");
                nominalTopUpField.setText("");
            }
        });
        bottomPanel.add(backButton);
        bottomPanel.add(clearButton);
        bottomPanel.add(topUpButton);

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
        JButton createButton = new JButton("Create");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mendapatkan nilai dari JTextField langsung
                String promoName = promoNameField.getText();
                LocalDate tanggalAwal = LocalDate.of(
                        Integer.parseInt((String) tahunAwalComboBox.getSelectedItem()),
                        bulanAwalComboBox.getSelectedIndex() + 1,
                        Integer.parseInt((String) tanggalAwalComboBox.getSelectedItem()));
                LocalDate tanggalAkhir = LocalDate.of(
                        Integer.parseInt((String) tahunAkhirComboBox.getSelectedItem()),
                        bulanAkhirComboBox.getSelectedIndex() + 1,
                        Integer.parseInt((String) tanggalAkhirComboBox.getSelectedItem()));
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
                if (!isPromoExist(arrayListPromotion, promoName)) {
                    Promotion newPromo = null;
                    if (selectedPromoType.equals("CASHBACK")) {
                        newPromo = new CashbackPromo(promoName, tanggalAwal, tanggalAkhir, persenPotongan,
                                maksPotongan, minPembelian);
                        JOptionPane.showMessageDialog(panelCreatePromo, "CREATE PROMO CASHBACK SUCCESS: " + promoName);
                    } else if (selectedPromoType.equals("DISCOUNT")) {
                        newPromo = new Discount(promoName, tanggalAwal, tanggalAkhir, persenPotongan,
                                maksPotongan, minPembelian);
                        JOptionPane.showMessageDialog(panelCreatePromo, "CREATE PROMO DISCOUNT SUCCESS: " + promoName);
                    }
                    arrayListPromotion.add(newPromo);
                    listPromo.addElement(newPromo);
                    promoList.setModel(listPromo);
                } else {
                    if (selectedPromoType.equals("CASHBACK")) {
                        JOptionPane.showMessageDialog(panelCreatePromo,
                                "CREATE PROMO CASHBACK FAILED: " + promoName + " IS EXISTS");
                    } else if (selectedPromoType.equals("DISCOUNT")) {
                        JOptionPane.showMessageDialog(panelCreatePromo,
                                "CREATE PROMO DISCOUNT FAILED: " + promoName + " IS EXISTS");
                    }
                }
            }
        });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "Panel2");
            }
        });
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                promoTypeGroup.clearSelection();
                promoNameField.setText("");
                persenPotonganField.setText("");
                tanggalAwalComboBox.setSelectedIndex(0);
                bulanAwalComboBox.setSelectedIndex(0);
                tahunAwalComboBox.setSelectedIndex(0);
                tanggalAkhirComboBox.setSelectedIndex(0);
                bulanAkhirComboBox.setSelectedIndex(0);
                tahunAkhirComboBox.setSelectedIndex(0);
                maksPotonganField.setText("");
                minPembelianField.setText("");
            }
        });
        bottomPanel.add(backButton);
        bottomPanel.add(clearButton);
        bottomPanel.add(createButton);

        panelCreatePromo.add(bottomPanel, BorderLayout.SOUTH);
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

        JRadioButton MobilRadioButton = new JRadioButton("Mobil(Car)");
        JRadioButton MotorRadioButton = new JRadioButton("Motor(Motorcycle)");
        ButtonGroup promoTypeGroup = new ButtonGroup();
        promoTypeGroup.add(MobilRadioButton);
        promoTypeGroup.add(MotorRadioButton);

        JLabel idMenuLabel = new JLabel("ID Menu:");
        JTextField idMenuField = new JTextField();
        JLabel menuNameLabel = new JLabel("Nama Menu:");
        JTextField menuNameField = new JTextField();
        JLabel numberPlateLabel = new JLabel("Plat Nomor:");
        JTextField numberPlateField = new JTextField();
        JLabel priceLabel = new JLabel("Price per day:");
        JTextField priceField = new JTextField();
        JLabel customTypeLabel = new JLabel("Custom Type:");
        JTextField customTypeField = new JTextField();

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(MobilRadioButton)
                        .addComponent(MotorRadioButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(idMenuLabel)
                        .addComponent(menuNameLabel)
                        .addComponent(numberPlateLabel)
                        .addComponent(priceLabel)
                        .addComponent(customTypeLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(idMenuField)
                        .addComponent(menuNameField)
                        .addComponent(numberPlateField)
                        .addComponent(priceField)
                        .addComponent(customTypeField)));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(MobilRadioButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(MotorRadioButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(idMenuLabel)
                        .addComponent(idMenuField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(menuNameLabel)
                        .addComponent(menuNameField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(numberPlateLabel)
                        .addComponent(numberPlateField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(priceLabel)
                        .addComponent(priceField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(customTypeLabel)
                        .addComponent(customTypeField)));

        panelCreateMenu.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton createButton = new JButton("Create");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // text field
                String idMenu = idMenuField.getText();
                String menuName = menuNameField.getText();
                String numberPlate = numberPlateField.getText();
                int price = Integer.parseInt(priceField.getText());
                String customType = customTypeField.getText();

                // radio button
                String selectedVehicleType;
                if (MobilRadioButton.isSelected()) {
                    selectedVehicleType = "MOBIL";
                } else if (MotorRadioButton.isSelected()) {
                    selectedVehicleType = "MOTOR";
                } else {
                    // Tidak ada radio button yang dipilih
                    JOptionPane.showMessageDialog(panelCreatePromo, "Pilih jenis kendaraan terlebih dahulu!");
                    return;
                }

                if (isMenuIDExist(arrayListMenu, idMenu)) {
                    JOptionPane.showMessageDialog(panelCreateMenu, "CREATE MENU FAILED: " + idMenu + " IS EXISTS");
                } else if (isNumberPlateExist(arrayListMenu, numberPlate)) {
                    JOptionPane.showMessageDialog(panelCreateMenu, "CREATE MENU FAILED: " + numberPlate + " IS EXISTS");
                } else {
                    Order newOrder = null;
                    if (selectedVehicleType.equals("MOBIL")) {
                        if (!isMenuIDExist(arrayListMenu, idMenu) || isNumberPlateExist(arrayListMenu, numberPlate)) {
                            newOrder = new Order(idMenu, menuName, numberPlate, price, customType);
                        }
                    } else if (selectedVehicleType.equals("MOTOR")) {
                        if (!isMenuIDExist(arrayListMenu, idMenu)
                                || isNumberPlateExist(arrayListMenu, numberPlate)) {
                            newOrder = new Order(idMenu, menuName, numberPlate, price);
                        }
                    }
                    arrayListMenu.add(newOrder);
                    listMenu.addElement(newOrder);
                    menuList.setModel(listMenu);
                    JOptionPane.showMessageDialog(panelCreateMenu,
                            "CREATE MENU SUCCESS " + idMenu + " " + menuName + " " + numberPlate);
                }

            }
        });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "Panel2");
            }
        });

        bottomPanel.add(backButton);
        bottomPanel.add(createButton);
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

        JLabel cartListLabel = new JLabel("Cart List", SwingConstants.CENTER);
        JScrollPane cartScrollPane = new JScrollPane(cartList);

        JLabel appliedPromoListLabel = new JLabel("Applied Promo List:");
        JList<String> appliedPromoList = new JList<>(
                new String[] { "Applied Promo 1", "Applied Promo 2", "Applied Promo 3" });
        JScrollPane appliedPromoScrollPane = new JScrollPane(appliedPromoList);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(cartListLabel)
                        .addComponent(cartScrollPane, 150, 200, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(appliedPromoListLabel)
                        .addComponent(appliedPromoScrollPane, 150, 200, Short.MAX_VALUE)));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(cartListLabel)
                        .addComponent(appliedPromoListLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(cartScrollPane)
                        .addComponent(appliedPromoScrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)));

        panel3.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "Panel2");
            }
        });
        bottomPanel.add(backButton);

        JButton addToCartButton = new JButton("Add to Cart");
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "PanelAddToCart");
            }
        });
        bottomPanel.add(addToCartButton);

        JButton removeFromCartButton = new JButton("Remove from Cart");
        removeFromCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "PanelRemoveFromCart");
            }
        });
        bottomPanel.add(removeFromCartButton);

        JButton applyPromoButton = new JButton("Apply Promo");
        applyPromoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "PanelApplyPromo");
            }
        });
        bottomPanel.add(applyPromoButton);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "PanelCheckOut");
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

        JLabel customerIDLabel = new JLabel("Customer ID:");
        JTextField customerIDField = new JTextField();
        JLabel addMenuIDLabel = new JLabel("Menu ID:");
        JTextField addMenuIDField = new JTextField();
        JLabel addQuantityLabel = new JLabel("Quantity:");
        JTextField addQuantityField = new JTextField();
        JLabel addStartLoanDateLabel = new JLabel("Start Loan Date:");

        // Combo box for date
        String[] dates = new String[31];
        for (int i = 0; i < 31; i++) {
            dates[i] = String.valueOf(i + 1);
        }
        JComboBox<String> dayComboBox = new JComboBox<>(dates);
        JComboBox<String> monthComboBox = new JComboBox<>(new String[] { "January", "February", "March", "April", "May",
                "June", "July", "August", "September", "October", "November", "December" });
        String[] years = new String[10]; // Change this value to adjust the range of years
        for (int i = 0; i < 10; i++) {
            years[i] = String.valueOf(LocalDate.now().getYear() + i);
        }
        JComboBox<String> yearComboBox = new JComboBox<>(years);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(customerIDLabel)
                        .addComponent(addMenuIDLabel)
                        .addComponent(addQuantityLabel)
                        .addComponent(addStartLoanDateLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(customerIDField)
                        .addComponent(addMenuIDField)
                        .addComponent(addQuantityField)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(dayComboBox)
                                .addComponent(monthComboBox)
                                .addComponent(yearComboBox))));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(customerIDLabel)
                        .addComponent(customerIDField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(addMenuIDLabel)
                        .addComponent(addMenuIDField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(addQuantityLabel)
                        .addComponent(addQuantityField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(addStartLoanDateLabel)
                        .addComponent(dayComboBox)
                        .addComponent(monthComboBox)
                        .addComponent(yearComboBox)));

        panelAddToCart.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Ambil input dari field
                String customerID = customerIDField.getText();
                String addMenuID = addMenuIDField.getText();
                int addQuantity = Integer.parseInt(addQuantityField.getText());
                LocalDate addStartLoanDate = LocalDate.of(Integer.parseInt((String) yearComboBox.getSelectedItem()),
                        monthComboBox.getSelectedIndex() + 1, Integer.parseInt((String) dayComboBox.getSelectedItem()));

                // Cek apakah pelanggan dan menu tersedia
                if (isCustomerExist(arrayListCustomer, customerID) && isMenuIDExist(arrayListMenu, addMenuID)) {
                    Customer customer = getCustomer(arrayListCustomer, customerID);
                    if (customer != null) {
                        arrayListCustomer.remove(customer);
                        Order newOrder = getOrder(arrayListMenu, addMenuID);
                        boolean isUpdated = false;
                        Order prevOrder = null;
                        if (customer.isOrderExist(addMenuID)) {
                            Order order = customer.getOrder(addMenuID);
                            if (order != null) {
                                isUpdated = true;
                                prevOrder = getOrder(arrayListCart, addMenuID);
                                customer.updateTotalPurchase(addQuantity * order.getPricePerDuration());
                            }
                        } else {
                            newOrder.setBookingDate(addStartLoanDate);
                            newOrder.setDuration(addQuantity);
                            customer.addToCart(newOrder);
                        }
                        arrayListCustomer.add(customer);
                        // Tampilkan pesan menggunakan dialog popup tanpa persentase
                        String message = "ADD_TO_CART SUCCESS: " + addQuantity + " day(s) " + newOrder.getMenuName()
                                + " " + newOrder.getNumberPlate();
                        if (isUpdated) {
                            arrayListCart.remove(prevOrder);
                            message += " (UPDATED)";
                        } else {
                            message += " (NEW)";
                        }
                        arrayListCart.add(newOrder);
                        listCart.addElement(
                                "Customer ID : " + customer.getId() + " -- Menu ID : " + newOrder.getMenuID()
                                        + " -- Duration : " + newOrder.getDuration() + " -- Total Price: "
                                        + (newOrder.getPricePerDuration() * newOrder.getDuration()));
                        cartList.setModel(listCart);
                        JOptionPane.showMessageDialog(panelAddToCart, message);
                    } else {
                        // Tampilkan pesan menggunakan dialog popup jika pelanggan tidak ditemukan
                        JOptionPane.showMessageDialog(panelAddToCart,
                                "ADD_TO_CART FAILED: NON EXISTENT CUSTOMER OR MENU");
                    }
                } else {
                    // Tampilkan pesan menggunakan dialog popup jika pelanggan atau menu tidak
                    // ditemukan
                    JOptionPane.showMessageDialog(panelAddToCart,
                            "ADD_TO_CART FAILED: NON EXISTENT CUSTOMER OR MENU");
                }
            }
        });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "Panel3");
            }
        });
        bottomPanel.add(backButton);
        bottomPanel.add(addButton);

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

        JLabel removeCustomerIDLabel = new JLabel("Customer ID:");
        JTextField removeCustomerIDField = new JTextField();
        JLabel removeMenuIDLabel = new JLabel("Menu ID:");
        JTextField removeMenuIDField = new JTextField();
        JLabel removeQuantityLabel = new JLabel("Quantity:");
        JTextField removeQuantityField = new JTextField();

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(removeCustomerIDLabel)
                        .addComponent(removeMenuIDLabel)
                        .addComponent(removeQuantityLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(removeCustomerIDField)
                        .addComponent(removeMenuIDField)
                        .addComponent(removeQuantityField)));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(removeCustomerIDLabel)
                        .addComponent(removeCustomerIDField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(removeMenuIDLabel)
                        .addComponent(removeMenuIDField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(removeQuantityLabel)
                        .addComponent(removeQuantityField)));

        panelRemoveFromCart.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ambil input dari field
                String removeCustomerID = removeCustomerIDField.getText();
                String removeMenuID = removeMenuIDField.getText();
                int removeQuantity = Integer.parseInt(removeQuantityField.getText());

                // Cek apakah pelanggan dan menu tersedia
                if (isCustomerExist(arrayListCustomer, removeCustomerID)) {
                    Customer customer = getCustomer(arrayListCustomer, removeCustomerID);
                    if (customer.isOrderExist(removeMenuID)) {
                        arrayListCustomer.remove(customer);

                        Order temp = null;
                        if (isMenuIDExist(arrayListMenu, removeMenuID)) {
                            for (Order order : arrayListMenu) {
                                if (order.getMenuID().equals(removeMenuID)) {
                                    temp = order;
                                    break;
                                }
                            }
                            if (temp != null) {
                                temp.updateDuration(-removeQuantity);
                                customer.totalPurchase -= temp.getPricePerDuration() * removeQuantity;
                                if (temp.getDuration() <= 0) {
                                    arrayListMenu.remove(temp);
                                    System.out.println("REMOVE_FROM_CART SUCCESS: " + temp.getMenuName() + " "
                                            + temp.getNumberPlate()
                                            + " IS REMOVED");
                                    if (arrayListMenu.isEmpty()) {
                                        customer.setOrdering(false);
                                        customer.setCurrentOrderNumber(0);
                                        ;
                                    }
                                } else {
                                    System.out.println("REMOVE_FROM_CART SUCCESS: " + temp.getMenuName() + " "
                                            + temp.getNumberPlate()
                                            + " DURATION IS DECREMENTED");
                                }
                            }
                        } else {
                            System.out.println("REMOVE_FROM_CART FAILED: NON EXISTENT CUSTOMER OR MENU");
                        }
                        arrayListCustomer.add(customer);
                        JOptionPane.showMessageDialog(panelRemoveFromCart, "REMOVE_FROM_CART SUCCESS");
                    } else {
                        JOptionPane.showMessageDialog(panelRemoveFromCart,
                                "REMOVE_FROM_CART FAILED: NON EXISTENT CUSTOMER OR MENU");
                    }
                } else {
                    JOptionPane.showMessageDialog(panelRemoveFromCart,
                            "REMOVE_FROM_CART FAILED: NON EXISTENT CUSTOMER OR MENU");
                }
            }
        });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "Panel3");
            }
        });
        bottomPanel.add(backButton);
        bottomPanel.add(removeButton);

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
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "Panel3");
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
        GroupLayout layout = new GroupLayout(centerPanel);
        centerPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JLabel idPemesananLabel = new JLabel("ID Pemesanan:");
        JTextField idPemesananField = new JTextField();

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(idPemesananLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(idPemesananField)));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(idPemesananLabel)
                        .addComponent(idPemesananField)));

        panelCheckOut.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton cetakPesananButton = new JButton("Cetak Pesanan");
        cetakPesananButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "PanelCetak");
            }
        });
        bottomPanel.add(cetakPesananButton);

        JButton submitButton = new JButton("Submit");
        bottomPanel.add(submitButton);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "Panel3");
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
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "Panel2");
            }
        });
        centerPanel.add(backToMenuButton);

        JButton finishButton = new JButton("Finish");
        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "PanelPrintHistory");
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
}