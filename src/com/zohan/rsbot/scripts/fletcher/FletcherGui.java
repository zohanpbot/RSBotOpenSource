package com.zohan.rsbot.scripts.fletcher;

import com.zohan.rsbot.scripts.fletcher.actions.FletchPrioritySequence;
import com.zohan.rsbot.scripts.fletcher.actions.cutting.Cutting;
import com.zohan.rsbot.scripts.fletcher.context.FletchContext;
import com.zohan.rsbot.scripts.fletcher.data.CutItem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FletcherGui extends JFrame {

    private final FletchContext ctx;
    private final Container contentPane;

    //    Bottom Components
    private JButton btnStart;

    //    Left Components
    private JList<FletchPrioritySequence> list;

    //    Center Components
    private JPanel mainPanel;
    private JLabel lblMode, lblItem, lblAmount;
    private JComboBox selectMode, selectItem;
    private JTextField txtAmount;
    private JButton btnAdd;

    public FletcherGui(final FletchContext ctx) {
        this.ctx = ctx;
        setTitle("ZohanFletcher GUI");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        contentPane = getContentPane();
        createGui();
        pack();
        setVisible(true);
    }

    private void createGui() {

//        Bottom Components
        btnStart = new JButton("Begin");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        contentPane.add(btnStart, BorderLayout.PAGE_END);

//        Left Components
        list = new JList<FletchPrioritySequence>();
        list.setBorder(new TitledBorder(BorderFactory.createDashedBorder(Color.GRAY), "Queue"));
        list.setPreferredSize(new Dimension(150, 80));

        contentPane.add(list, BorderLayout.LINE_START);

//        Center Components
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(8, 8, 8, 8));

        lblMode = new JLabel("Mode: ");
        lblMode.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainPanel.add(lblMode);

        selectMode = new JComboBox();
        selectMode.setAlignmentX(Component.LEFT_ALIGNMENT);
        selectMode.setModel(new DefaultComboBoxModel(new String[]{"Headless Arrows"}));
        mainPanel.add(selectMode);
        mainPanel.add(Box.createVerticalStrut(15));

        lblItem = new JLabel("Item: ");
        lblItem.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainPanel.add(lblItem);

        selectItem = new JComboBox();
        selectItem.setAlignmentX(Component.LEFT_ALIGNMENT);
        selectItem.setModel(new DefaultComboBoxModel(CutItem.values()));
        mainPanel.add(selectItem);
        selectItem.setPrototypeDisplayValue("Zohaaaaaaaaaaaaaaaaaaan!");
        mainPanel.add(Box.createVerticalStrut(15));

        lblAmount = new JLabel("Amount: ");
        lblAmount.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainPanel.add(lblAmount);

        txtAmount = new JTextField("10000");
        txtAmount.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainPanel.add(txtAmount);
        mainPanel.add(Box.createVerticalStrut(15));

        btnAdd = new JButton("Add");
        btnAdd.addActionListener(new BtnAddAction());
        mainPanel.add(btnAdd);

        contentPane.add(mainPanel, BorderLayout.CENTER);

    }

    private void refreshList() {
        DefaultListModel<FletchPrioritySequence> dlm = new DefaultListModel<FletchPrioritySequence>();
        for (FletchPrioritySequence item : ctx.queue.queue()) {
            dlm.addElement(item);
        }
        list.setModel(dlm);
        validate();
    }

    private class BtnAddAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int amount;
            try {
                amount = Integer.parseInt(txtAmount.getText());
            } catch (Exception ex) {
                amount = 1000;
            }
            switch (selectMode.getSelectedIndex()) {
                case 0:
                    ctx.queue.add(new Cutting(ctx, (CutItem) selectItem.getSelectedItem(), amount));
                    break;
            }
            refreshList();
        }
    }

}
