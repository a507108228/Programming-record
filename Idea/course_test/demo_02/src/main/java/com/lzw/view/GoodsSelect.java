package com.lzw.view;

import com.lzw.dao.GoodsmanagementImp;

import java.awt.Font;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class GoodsSelect extends Index{

    private JTable table;
    int id;

    public GoodsSelect(String name){
        super(name);
        init();
    }

    public void init(){
        Font t = new Font("楷体", Font.BOLD, 24);
        final Font f = new Font("楷体", Font.BOLD, 15);
        JLabel title = new JLabel("商品信息");
        title.setFont(t);
        title.setBounds(230, 40, 100, 40);
        final Vector c = new Vector();
        //添加数据
        c.add("编号");
        c.add("商品名称");
        c.add("商品类型");
        c.add("商品数量");
        c.add("仓库编号");
        final GoodsmanagementImp g = new GoodsmanagementImp();
        //创建表格
        table = new JTable(g.vec, c);
        table.setFont(f);
        table.getTableHeader().setFont(f);
        //创建Jscrollpane
        final JScrollPane js = new JScrollPane(table);
        js.setBounds(100, 120, 400, 200);
        try {
            g.Query("select * from goods");
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        index.add(title);
        index.add(js);
    }
}
