package GrapichalUI;

import javax.swing.*;
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

    public FilkomTravel() {
        frame = this;
        setTitle("Filkom Travel");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

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

        add(mainPanel);
        add(panel1);
        add(panelCreateMember);
        add(panelCreateGuest);
        add(panel2);
        add(panelTopUp);
        add(panelCreatePromo);
        add(panelCreateMenu);
        add(panel3);
        add(panelApplyPromo);
        add(panelAddToCart);
        add(panelRemoveFromCart);
        add(panelCheckOut);
        add(panelCetak);
        add(panelPrintHistory);

        // Show the main panel first
        switchPanel(mainPanel);
    }

    private void initializeMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(0, 0, 600, 400);

        JLabel title = new JLabel("Filkom Travel");
        title.setBounds(250, 50, 100, 30);
        mainPanel.add(title);

        JButton startButton = new JButton("Start");
        startButton.setBounds(250, 150, 100, 30);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panel1);
            }
        });
        mainPanel.add(startButton);
    }

    private void initializePanel1() {
        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(0, 0, 600, 400);

        JLabel panel1Label = new JLabel("Panel 1");
        panel1Label.setBounds(250, 20, 100, 30);
        panel1.add(panel1Label);

        JButton createMemberButton = new JButton("Create Member");
        createMemberButton.setBounds(50, 300, 150, 30);
        createMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panelCreateMember);
            }
        });
        panel1.add(createMemberButton);

        JButton createGuestButton = new JButton("Create Guest");
        createGuestButton.setBounds(220, 300, 150, 30);
        createGuestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panelCreateGuest);
            }
        });
        panel1.add(createGuestButton);

        JButton nextButton = new JButton("Next");
        nextButton.setBounds(390, 300, 150, 30);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panel2);
            }
        });
        panel1.add(nextButton);

        JList<String> guestList = new JList<>(new String[] { "Guest 1", "Guest 2", "Guest 3" });
        JScrollPane guestScrollPane = new JScrollPane(guestList);
        guestScrollPane.setBounds(50, 50, 200, 200);
        panel1.add(guestScrollPane);

        JList<String> memberList = new JList<>(new String[] { "Member 1", "Member 2", "Member 3" });
        JScrollPane memberScrollPane = new JScrollPane(memberList);
        memberScrollPane.setBounds(300, 50, 200, 200);
        panel1.add(memberScrollPane);
    }

    private void initializePanelCreateMember() {
        panelCreateMember = new JPanel();
        panelCreateMember.setLayout(null);
        panelCreateMember.setBounds(0, 0, 600, 400);

        JLabel panelCreateMemberLabel = new JLabel("Panel Create Member");
        panelCreateMemberLabel.setBounds(200, 20, 200, 30);
        panelCreateMember.add(panelCreateMemberLabel);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(50, 70, 100, 30);
        panelCreateMember.add(idLabel);

        JTextField idField = new JTextField();
        idField.setBounds(200, 70, 300, 30);
        panelCreateMember.add(idField);

        JLabel namaLabel = new JLabel("Nama:");
        namaLabel.setBounds(50, 110, 100, 30);
        panelCreateMember.add(namaLabel);

        JTextField namaField = new JTextField();
        namaField.setBounds(200, 110, 300, 30);
        panelCreateMember.add(namaField);

        JLabel tanggalLabel = new JLabel("Tanggal Daftar:");
        tanggalLabel.setBounds(50, 150, 100, 30);
        panelCreateMember.add(tanggalLabel);

        JComboBox<String> tanggalComboBox = new JComboBox<>(getDates());
        tanggalComboBox.setBounds(200, 150, 80, 30);
        panelCreateMember.add(tanggalComboBox);

        JComboBox<String> bulanComboBox = new JComboBox<>(getMonths());
        bulanComboBox.setBounds(290, 150, 80, 30);
        panelCreateMember.add(bulanComboBox);

        JComboBox<String> tahunComboBox = new JComboBox<>(getYears());
        tahunComboBox.setBounds(380, 150, 120, 30);
        panelCreateMember.add(tahunComboBox);

        JLabel saldoLabel = new JLabel("Saldo Awal:");
        saldoLabel.setBounds(50, 190, 100, 30);
        panelCreateMember.add(saldoLabel);

        JTextField saldoField = new JTextField();
        saldoField.setBounds(200, 190, 300, 30);
        panelCreateMember.add(saldoField);

        JButton simpanButton = new JButton("Simpan");
        simpanButton.setBounds(200, 250, 100, 30);
        panelCreateMember.add(simpanButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(320, 250, 100, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panel1);
            }
        });
        panelCreateMember.add(backButton);
    }

    private void initializePanelCreateGuest() {
        panelCreateGuest = new JPanel();
        panelCreateGuest.setLayout(null);
        panelCreateGuest.setBounds(0, 0, 600, 400);

        JLabel panelCreateGuestLabel = new JLabel("Panel Create Guest");
        panelCreateGuestLabel.setBounds(200, 20, 200, 30);
        panelCreateGuest.add(panelCreateGuestLabel);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(50, 70, 100, 30);
        panelCreateGuest.add(idLabel);

        JTextField idField = new JTextField();
        idField.setBounds(200, 70, 300, 30);
        panelCreateGuest.add(idField);

        JLabel saldoLabel = new JLabel("Saldo Awal:");
        saldoLabel.setBounds(50, 110, 100, 30);
        panelCreateGuest.add(saldoLabel);

        JTextField saldoField = new JTextField();
        saldoField.setBounds(200, 110, 300, 30);
        panelCreateGuest.add(saldoField);

        JButton simpanButton = new JButton("Simpan");
        simpanButton.setBounds(200, 170, 100, 30);
        panelCreateGuest.add(simpanButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(320, 170, 100, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panel1);
            }
        });
        panelCreateGuest.add(backButton);
    }

    private void initializePanel2() {
        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(0, 0, 600, 400);

        JLabel panel2Label = new JLabel("Panel 2");
        panel2Label.setBounds(250, 20, 100, 30);
        panel2.add(panel2Label);

        JList<String> promoList = new JList<>(new String[] { "Promo 1", "Promo 2", "Promo 3" });
        JScrollPane promoScrollPane = new JScrollPane(promoList);
        promoScrollPane.setBounds(50, 50, 200, 200);
        panel2.add(promoScrollPane);

        JList<String> menuList = new JList<>(new String[] { "Menu 1", "Menu 2", "Menu 3" });
        JScrollPane menuScrollPane = new JScrollPane(menuList);
        menuScrollPane.setBounds(300, 50, 200, 200);
        panel2.add(menuScrollPane);

        JButton topUpButton = new JButton("Top Up");
        topUpButton.setBounds(50, 300, 100, 30);
        topUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panelTopUp);
            }
        });
        panel2.add(topUpButton);

        JButton createPromoButton = new JButton("Create Promo");
        createPromoButton.setBounds(170, 300, 120, 30);
        createPromoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panelCreatePromo);
            }
        });
        panel2.add(createPromoButton);

        JButton createMenuButton = new JButton("Create Menu");
        createMenuButton.setBounds(310, 300, 120, 30);
        createMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panelCreateMenu);
            }
        });
        panel2.add(createMenuButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(50, 350, 100, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panel1);
            }
        });
        panel2.add(backButton);

        JButton nextButton = new JButton("Next");
        nextButton.setBounds(470, 350, 100, 30);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panel3);
            }
        });
        panel2.add(nextButton);
    }

    private void initializePanelTopUp() {
        panelTopUp = new JPanel();
        panelTopUp.setLayout(null);
        panelTopUp.setBounds(0, 0, 600, 400);

        JLabel panelTopUpLabel = new JLabel("Panel Top Up");
        panelTopUpLabel.setBounds(250, 20, 100, 30);
        panelTopUp.add(panelTopUpLabel);

        JLabel idPemesanLabel = new JLabel("ID Pemesan:");
        idPemesanLabel.setBounds(50, 70, 100, 30);
        panelTopUp.add(idPemesanLabel);

        JTextField idPemesanField = new JTextField();
        idPemesanField.setBounds(200, 70, 300, 30);
        panelTopUp.add(idPemesanField);

        JLabel nominalTopUpLabel = new JLabel("Nominal Top Up:");
        nominalTopUpLabel.setBounds(50, 110, 100, 30);
        panelTopUp.add(nominalTopUpLabel);

        JTextField nominalTopUpField = new JTextField();
        nominalTopUpField.setBounds(200, 110, 300, 30);
        panelTopUp.add(nominalTopUpField);

        JButton simpanButton = new JButton("Simpan");
        simpanButton.setBounds(200, 170, 100, 30);
        panelTopUp.add(simpanButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(320, 170, 100, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panel2);
            }
        });
        panelTopUp.add(backButton);
    }

    private void initializePanelCreatePromo() {
        panelCreatePromo = new JPanel();
        panelCreatePromo.setLayout(null);
        panelCreatePromo.setBounds(0, 0, 600, 400);

        JLabel panelCreatePromoLabel = new JLabel("Panel Create Promo");
        panelCreatePromoLabel.setBounds(200, 20, 200, 30);
        panelCreatePromo.add(panelCreatePromoLabel);

        JLabel jenisPromoLabel = new JLabel("Jenis Promo:");
        jenisPromoLabel.setBounds(50, 70, 100, 30);
        panelCreatePromo.add(jenisPromoLabel);

        JTextField jenisPromoField = new JTextField();
        jenisPromoField.setBounds(200, 70, 300, 30);
        panelCreatePromo.add(jenisPromoField);

        JLabel tanggalAwalLabel = new JLabel("Tanggal Awal:");
        tanggalAwalLabel.setBounds(50, 110, 100, 30);
        panelCreatePromo.add(tanggalAwalLabel);

        JComboBox<String> tanggalAwalComboBox = new JComboBox<>(getDates());
        tanggalAwalComboBox.setBounds(200, 110, 80, 30);
        panelCreatePromo.add(tanggalAwalComboBox);

        JComboBox<String> bulanAwalComboBox = new JComboBox<>(getMonths());
        bulanAwalComboBox.setBounds(290, 110, 80, 30);
        panelCreatePromo.add(bulanAwalComboBox);

        JComboBox<String> tahunAwalComboBox = new JComboBox<>(getYears());
        tahunAwalComboBox.setBounds(380, 110, 120, 30);
        panelCreatePromo.add(tahunAwalComboBox);

        JLabel tanggalAkhirLabel = new JLabel("Tanggal Akhir:");
        tanggalAkhirLabel.setBounds(50, 150, 100, 30);
        panelCreatePromo.add(tanggalAkhirLabel);

        JComboBox<String> tanggalAkhirComboBox = new JComboBox<>(getDates());
        tanggalAkhirComboBox.setBounds(200, 150, 80, 30);
        panelCreatePromo.add(tanggalAkhirComboBox);

        JComboBox<String> bulanAkhirComboBox = new JComboBox<>(getMonths());
        bulanAkhirComboBox.setBounds(290, 150, 80, 30);
        panelCreatePromo.add(bulanAkhirComboBox);

        JComboBox<String> tahunAkhirComboBox = new JComboBox<>(getYears());
        tahunAkhirComboBox.setBounds(380, 150, 120, 30);
        panelCreatePromo.add(tahunAkhirComboBox);

        JLabel maksPotonganLabel = new JLabel("Maks Potongan:");
        maksPotonganLabel.setBounds(50, 190, 100, 30);
        panelCreatePromo.add(maksPotonganLabel);

        JTextField maksPotonganField = new JTextField();
        maksPotonganField.setBounds(200, 190, 300, 30);
        panelCreatePromo.add(maksPotonganField);

        JLabel minPotonganLabel = new JLabel("Min Potongan:");
        minPotonganLabel.setBounds(50, 230, 100, 30);
        panelCreatePromo.add(minPotonganLabel);

        JTextField minPotonganField = new JTextField();
        minPotonganField.setBounds(200, 230, 300, 30);
        panelCreatePromo.add(minPotonganField);

        JButton simpanButton = new JButton("Simpan");
        simpanButton.setBounds(200, 290, 100, 30);
        panelCreatePromo.add(simpanButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(320, 290, 100, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panel2);
            }
        });
        panelCreatePromo.add(backButton);
    }

    private void initializePanelCreateMenu() {
        panelCreateMenu = new JPanel();
        panelCreateMenu.setLayout(null);
        panelCreateMenu.setBounds(0, 0, 600, 400);

        JLabel panelCreateMenuLabel = new JLabel("Panel Create Menu");
        panelCreateMenuLabel.setBounds(200, 20, 200, 30);
        panelCreateMenu.add(panelCreateMenuLabel);

        JLabel idMenuLabel = new JLabel("ID Menu:");
        idMenuLabel.setBounds(50, 70, 100, 30);
        panelCreateMenu.add(idMenuLabel);

        JTextField idMenuField = new JTextField();
        idMenuField.setBounds(200, 70, 300, 30);
        panelCreateMenu.add(idMenuField);

        JLabel namaMenuLabel = new JLabel("Nama Menu:");
        namaMenuLabel.setBounds(50, 110, 100, 30);
        panelCreateMenu.add(namaMenuLabel);

        JTextField namaMenuField = new JTextField();
        namaMenuField.setBounds(200, 110, 300, 30);
        panelCreateMenu.add(namaMenuField);

        JLabel platNomorLabel = new JLabel("Plat Nomor:");
        platNomorLabel.setBounds(50, 150, 100, 30);
        panelCreateMenu.add(platNomorLabel);

        JTextField platNomorField = new JTextField();
        platNomorField.setBounds(200, 150, 300, 30);
        panelCreateMenu.add(platNomorField);

        JLabel hargaLabel = new JLabel("Harga:");
        hargaLabel.setBounds(50, 190, 100, 30);
        panelCreateMenu.add(hargaLabel);

        JTextField hargaField = new JTextField();
        hargaField.setBounds(200, 190, 300, 30);
        panelCreateMenu.add(hargaField);

        JLabel customTypeLabel = new JLabel("Custom Type:");
        customTypeLabel.setBounds(50, 230, 100, 30);
        panelCreateMenu.add(customTypeLabel);

        JTextField customTypeField = new JTextField();
        customTypeField.setBounds(200, 230, 300, 30);
        panelCreateMenu.add(customTypeField);

        JButton simpanButton = new JButton("Simpan");
        simpanButton.setBounds(200, 290, 100, 30);
        panelCreateMenu.add(simpanButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(320, 290, 100, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panel2);
            }
        });
        panelCreateMenu.add(backButton);
    }

    private void initializePanel3() {
        panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBounds(0, 0, 600, 400);

        JLabel panel3Label = new JLabel("Panel 3");
        panel3Label.setBounds(250, 20, 100, 30);
        panel3.add(panel3Label);

        JList<String> cartList = new JList<>(new String[] { "Cart Item 1", "Cart Item 2", "Cart Item 3" });
        JScrollPane cartScrollPane = new JScrollPane(cartList);
        cartScrollPane.setBounds(50, 50, 200, 200);
        panel3.add(cartScrollPane);

        JList<String> appliedPromoList = new JList<>(
                new String[] { "Applied Promo 1", "Applied Promo 2", "Applied Promo 3" });
        JScrollPane appliedPromoScrollPane = new JScrollPane(appliedPromoList);
        appliedPromoScrollPane.setBounds(300, 50, 200, 200);
        panel3.add(appliedPromoScrollPane);

        JButton addToCartButton = new JButton("Add to Cart");
        addToCartButton.setBounds(50, 300, 100, 30);
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panelAddToCart);
            }
        });
        panel3.add(addToCartButton);

        JButton removeFromCartButton = new JButton("Remove from Cart");
        removeFromCartButton.setBounds(170, 300, 150, 30);
        removeFromCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panelRemoveFromCart);
            }
        });
        panel3.add(removeFromCartButton);

        JButton applyPromoButton = new JButton("Apply Promo");
        applyPromoButton.setBounds(340, 300, 120, 30);
        applyPromoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panelApplyPromo);
            }
        });
        panel3.add(applyPromoButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(50, 350, 100, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panel2);
            }
        });
        panel3.add(backButton);

        JButton nextButton = new JButton("Next");
        nextButton.setBounds(470, 350, 100, 30);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panelCheckOut);
            }
        });
        panel3.add(nextButton);
    }

    private void initializePanelAddToCart() {
        panelAddToCart = new JPanel();
        panelAddToCart.setLayout(null);
        panelAddToCart.setBounds(0, 0, 600, 400);

        JLabel panelAddToCartLabel = new JLabel("Panel Add To Cart");
        panelAddToCartLabel.setBounds(200, 20, 200, 30);
        panelAddToCart.add(panelAddToCartLabel);

        JLabel idPemesanLabel = new JLabel("ID Pemesan:");
        idPemesanLabel.setBounds(50, 70, 100, 30);
        panelAddToCart.add(idPemesanLabel);

        JTextField idPemesanField = new JTextField();
        idPemesanField.setBounds(200, 70, 300, 30);
        panelAddToCart.add(idPemesanField);

        JLabel idMenuLabel = new JLabel("ID Menu:");
        idMenuLabel.setBounds(50, 110, 100, 30);
        panelAddToCart.add(idMenuLabel);

        JTextField idMenuField = new JTextField();
        idMenuField.setBounds(200, 110, 300, 30);
        panelAddToCart.add(idMenuField);

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setBounds(50, 150, 100, 30);
        panelAddToCart.add(quantityLabel);

        JTextField quantityField = new JTextField();
        quantityField.setBounds(200, 150, 300, 30);
        panelAddToCart.add(quantityField);

        JButton simpanButton = new JButton("Simpan");
        simpanButton.setBounds(200, 210, 100, 30);
        panelAddToCart.add(simpanButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(320, 210, 100, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panel3);
            }
        });
        panelAddToCart.add(backButton);
    }

    private void initializePanelRemoveFromCart() {
        panelRemoveFromCart = new JPanel();
        panelRemoveFromCart.setLayout(null);
        panelRemoveFromCart.setBounds(0, 0, 600, 400);

        JLabel panelRemoveFromCartLabel = new JLabel("Panel Remove From Cart");
        panelRemoveFromCartLabel.setBounds(200, 20, 200, 30);
        panelRemoveFromCart.add(panelRemoveFromCartLabel);

        JLabel idPemesanLabel = new JLabel("ID Pemesan:");
        idPemesanLabel.setBounds(50, 70, 100, 30);
        panelRemoveFromCart.add(idPemesanLabel);

        JTextField idPemesanField = new JTextField();
        idPemesanField.setBounds(200, 70, 300, 30);
        panelRemoveFromCart.add(idPemesanField);

        JLabel idMenuLabel = new JLabel("ID Menu:");
        idMenuLabel.setBounds(50, 110, 100, 30);
        panelRemoveFromCart.add(idMenuLabel);

        JTextField idMenuField = new JTextField();
        idMenuField.setBounds(200, 110, 300, 30);
        panelRemoveFromCart.add(idMenuField);

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setBounds(50, 150, 100, 30);
        panelRemoveFromCart.add(quantityLabel);

        JTextField quantityField = new JTextField();
        quantityField.setBounds(200, 150, 300, 30);
        panelRemoveFromCart.add(quantityField);

        JButton simpanButton = new JButton("Simpan");
        simpanButton.setBounds(200, 210, 100, 30);
        panelRemoveFromCart.add(simpanButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(320, 210, 100, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panel3);
            }
        });
        panelRemoveFromCart.add(backButton);
    }

    private void initializePanelApplyPromo() {
        panelApplyPromo = new JPanel();
        panelApplyPromo.setLayout(null);
        panelApplyPromo.setBounds(0, 0, 600, 400);

        JLabel panelApplyPromoLabel = new JLabel("Panel Apply Promo");
        panelApplyPromoLabel.setBounds(200, 20, 200, 30);
        panelApplyPromo.add(panelApplyPromoLabel);

        JLabel idPemesanLabel = new JLabel("ID Pemesan:");
        idPemesanLabel.setBounds(50, 70, 100, 30);
        panelApplyPromo.add(idPemesanLabel);

        JTextField idPemesanField = new JTextField();
        idPemesanField.setBounds(200, 70, 300, 30);
        panelApplyPromo.add(idPemesanField);

        JLabel kodePromoLabel = new JLabel("Kode Promo:");
        kodePromoLabel.setBounds(50, 110, 100, 30);
        panelApplyPromo.add(kodePromoLabel);

        JTextField kodePromoField = new JTextField();
        kodePromoField.setBounds(200, 110, 300, 30);
        panelApplyPromo.add(kodePromoField);

        JList<String> promoList = new JList<>(new String[] { "Promo 1", "Promo 2", "Promo 3" });
        JScrollPane promoScrollPane = new JScrollPane(promoList);
        promoScrollPane.setBounds(50, 150, 450, 100);
        panelApplyPromo.add(promoScrollPane);

        JButton simpanButton = new JButton("Simpan");
        simpanButton.setBounds(200, 270, 100, 30);
        panelApplyPromo.add(simpanButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(320, 270, 100, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panel3);
            }
        });
        panelApplyPromo.add(backButton);
    }

    private void initializePanelCheckOut() {
        panelCheckOut = new JPanel();
        panelCheckOut.setLayout(null);
        panelCheckOut.setBounds(0, 0, 600, 400);

        JLabel panelCheckOutLabel = new JLabel("Panel Check Out");
        panelCheckOutLabel.setBounds(200, 20, 200, 30);
        panelCheckOut.add(panelCheckOutLabel);

        JLabel idPemesananLabel = new JLabel("ID Pemesanan:");
        idPemesananLabel.setBounds(50, 70, 100, 30);
        panelCheckOut.add(idPemesananLabel);

        JTextField idPemesananField = new JTextField();
        idPemesananField.setBounds(200, 70, 300, 30);
        panelCheckOut.add(idPemesananField);

        JButton cetakPesananButton = new JButton("Cetak Pesanan");
        cetakPesananButton.setBounds(200, 120, 150, 30);
        cetakPesananButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panelCetak);
            }
        });
        panelCheckOut.add(cetakPesananButton);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(370, 120, 100, 30);
        panelCheckOut.add(submitButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(50, 120, 100, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panel3);
            }
        });
        panelCheckOut.add(backButton);
    }

    private void initializePanelCetak() {
        panelCetak = new JPanel();
        panelCetak.setLayout(null);
        panelCetak.setBounds(0, 0, 600, 400);

        JLabel panelCetakLabel = new JLabel("Panel Cetak");
        panelCetakLabel.setBounds(200, 20, 200, 30);
        panelCetak.add(panelCetakLabel);

        JButton backToMenuButton = new JButton("Back To Menu");
        backToMenuButton.setBounds(150, 120, 150, 30);
        backToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panel2);
            }
        });
        panelCetak.add(backToMenuButton);

        JButton finishButton = new JButton("Finish");
        finishButton.setBounds(320, 120, 100, 30);
        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panelPrintHistory);
            }
        });
        panelCetak.add(finishButton);
    }

    private void initializePanelPrintHistory() {
        panelPrintHistory = new JPanel();
        panelPrintHistory.setLayout(null);
        panelPrintHistory.setBounds(0, 0, 600, 400);

        JLabel panelPrintHistoryLabel = new JLabel("Panel Print History");
        panelPrintHistoryLabel.setBounds(200, 20, 200, 30);
        panelPrintHistory.add(panelPrintHistoryLabel);

        JButton closeButton = new JButton("Close");
        closeButton.setBounds(250, 120, 100, 30);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        panelPrintHistory.add(closeButton);
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
        frame.repaint();
        frame.revalidate();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FilkomTravel().setVisible(true);
            }
        });
    }
}
