package GrapichalUI;

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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FilkomTravel().setVisible(true);
            }
        });
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
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        JLabel phoneLabel = new JLabel("Phone:");
        JTextField phoneField = new JTextField();

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(idLabel)
                        .addComponent(nameLabel)
                        .addComponent(emailLabel)
                        .addComponent(phoneLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(idField)
                        .addComponent(nameField)
                        .addComponent(emailField)
                        .addComponent(phoneField)));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(idLabel)
                        .addComponent(idField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(nameLabel)
                        .addComponent(nameField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(emailLabel)
                        .addComponent(emailField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(phoneLabel)
                        .addComponent(phoneField)));

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
                // Logic for creating member
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
                // Logic for creating guest
            }
        });
        bottomPanel.add(backButton);
        bottomPanel.add(createButton);
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
        centerPanel.setLayout(new GridLayout(3, 2));

        JLabel idPemesanLabel = new JLabel("ID Pemesan:");
        JTextField idPemesanField = new JTextField();
        JLabel nominalTopUpLabel = new JLabel("Nominal Top Up:");
        JTextField nominalTopUpField = new JTextField();

        centerPanel.add(idPemesanLabel);
        centerPanel.add(idPemesanField);
        centerPanel.add(nominalTopUpLabel);
        centerPanel.add(nominalTopUpField);

        panelTopUp.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton simpanButton = new JButton("Simpan");
        simpanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic for saving top-up information
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
        centerPanel.setLayout(new GridLayout(5, 2));

        JLabel jenisPromoLabel = new JLabel("Jenis Promo:");
        JTextField jenisPromoField = new JTextField();
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
        JLabel minPotonganLabel = new JLabel("Min Potongan:");
        JTextField minPotonganField = new JTextField();

        centerPanel.add(jenisPromoLabel);
        centerPanel.add(jenisPromoField);
        centerPanel.add(tanggalAwalLabel);
        centerPanel.add(tanggalAwalComboBox);
        centerPanel.add(bulanAwalComboBox);
        centerPanel.add(tahunAwalComboBox);
        centerPanel.add(tanggalAkhirLabel);
        centerPanel.add(tanggalAkhirComboBox);
        centerPanel.add(bulanAkhirComboBox);
        centerPanel.add(tahunAkhirComboBox);
        centerPanel.add(maksPotonganLabel);
        centerPanel.add(maksPotonganField);
        centerPanel.add(minPotonganLabel);
        centerPanel.add(minPotonganField);

        panelCreatePromo.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton simpanButton = new JButton("Simpan");
        simpanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic for saving promo information
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

    private void initializePanelCreateMenu() {
        panelCreateMenu = new JPanel();
        panelCreateMenu.setLayout(new BorderLayout());

        JLabel panelCreateMenuLabel = new JLabel("Panel Create Menu", SwingConstants.CENTER);
        panelCreateMenu.add(panelCreateMenuLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(5, 2));

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

        centerPanel.add(idMenuLabel);
        centerPanel.add(idMenuField);
        centerPanel.add(namaMenuLabel);
        centerPanel.add(namaMenuField);
        centerPanel.add(platNomorLabel);
        centerPanel.add(platNomorField);
        centerPanel.add(hargaLabel);
        centerPanel.add(hargaField);
        centerPanel.add(customTypeLabel);
        centerPanel.add(customTypeField);

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
        centerPanel.setLayout(new GridLayout(2, 2));

        JList<String> cartList = new JList<>(new String[] { "Cart Item 1", "Cart Item 2", "Cart Item 3" });
        JScrollPane cartScrollPane = new JScrollPane(cartList);
        centerPanel.add(cartScrollPane);

        JList<String> appliedPromoList = new JList<>(
                new String[] { "Applied Promo 1", "Applied Promo 2", "Applied Promo 3" });
        JScrollPane appliedPromoScrollPane = new JScrollPane(appliedPromoList);
        centerPanel.add(appliedPromoScrollPane);

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
        centerPanel.setLayout(new GridLayout(3, 2));

        JLabel idPemesanLabel = new JLabel("ID Pemesan:");
        centerPanel.add(idPemesanLabel);

        JTextField idPemesanField = new JTextField();
        centerPanel.add(idPemesanField);

        JLabel idMenuLabel = new JLabel("ID Menu:");
        centerPanel.add(idMenuLabel);

        JTextField idMenuField = new JTextField();
        centerPanel.add(idMenuField);

        JLabel quantityLabel = new JLabel("Quantity:");
        centerPanel.add(quantityLabel);

        JTextField quantityField = new JTextField();
        centerPanel.add(quantityField);

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
        centerPanel.setLayout(new GridLayout(3, 2));

        JLabel idPemesanLabel = new JLabel("ID Pemesan:");
        centerPanel.add(idPemesanLabel);

        JTextField idPemesanField = new JTextField();
        centerPanel.add(idPemesanField);

        JLabel idMenuLabel = new JLabel("ID Menu:");
        centerPanel.add(idMenuLabel);

        JTextField idMenuField = new JTextField();
        centerPanel.add(idMenuField);

        JLabel quantityLabel = new JLabel("Quantity:");
        centerPanel.add(quantityLabel);

        JTextField quantityField = new JTextField();
        centerPanel.add(quantityField);

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
        centerPanel.setLayout(new GridLayout(3, 2));

        JLabel idPemesanLabel = new JLabel("ID Pemesan:");
        centerPanel.add(idPemesanLabel);

        JTextField idPemesanField = new JTextField();
        centerPanel.add(idPemesanField);

        JLabel kodePromoLabel = new JLabel("Kode Promo:");
        centerPanel.add(kodePromoLabel);

        JTextField kodePromoField = new JTextField();
        centerPanel.add(kodePromoField);

        JLabel promoListLabel = new JLabel("Promo List:");
        centerPanel.add(promoListLabel);

        JList<String> promoList = new JList<>(new String[] { "Promo 1", "Promo 2", "Promo 3" });
        JScrollPane promoScrollPane = new JScrollPane(promoList);
        centerPanel.add(promoScrollPane);

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
                switchPanel(panel3);
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