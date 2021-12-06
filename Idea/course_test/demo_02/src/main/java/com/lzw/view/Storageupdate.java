package com.lzw.view;

import com.lzw.bean.Storage;
import com.lzw.dao.StoragemanagementImp;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class Storageupdate extends IndexAdmin{
	int id ;
	//声明表格
	private JTable table;
	JTextField name;
	JTextField style;
	JTextField s_id;

	public Storageupdate(String name) {
		super(name);
		init();
	}
	public void init() {
		Font t = new Font("楷体",Font.BOLD, 24);
		final Font f = new Font("楷体",Font.BOLD, 15);
		JLabel title = new JLabel("仓库信息");
		JLabel storagename = new JLabel("仓库名称：");
		storagename.setBounds(160, 220, 80, 30);
		storagename.setFont(f);
		name = new JTextField();
		name.setBounds(240, 220, 150, 30);
		name.setFont(f);
		JLabel storagestyle = new JLabel("仓库类型：");
		storagestyle.setBounds(160, 270, 80, 30);
		storagestyle.setFont(f);
		style = new JTextField();
		style.setBounds(240, 270, 150, 30);
		style.setFont(f);
		JLabel storageid = new JLabel("仓库编号：");
		storageid.setBounds(160, 320, 80, 30);
		storageid.setFont(f);
		s_id = new JTextField();
		s_id.setBounds(240, 320, 150, 30);
		s_id.setFont(f);
		title.setFont(t);
		title.setBounds(230, 30, 100, 30);
		final Vector c = new Vector();
		//添加数据
		c.add("编号");
		c.add("仓库名称");
		c.add("仓库类型");
		c.add("仓库编号");
		final StoragemanagementImp s = new StoragemanagementImp();
		try {
			s.Query("select * from storage");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//创建表格
		table = new JTable(s.vec,c);
		table.setFont(f);
		table.getTableHeader().setFont(f);
		//为表格添加鼠标单击事件
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 获取表格中的ID
				//获取每条记录所对应的id
				id = (int)table.getValueAt(table.getSelectedRow(), 0);
				//获取部门名称
				String sname = (String)table.getValueAt(table.getSelectedRow(), 1);
				//获取部门编号
				String sstyle =(String)table.getValueAt(table.getSelectedRow(), 2);
				//获取部门描述
				String sid=(String)table.getValueAt(table.getSelectedRow(), 3).toString();
				//将数据设置进文本框
				name.setText(sname);
				style.setText(sstyle);
				s_id.setText(sid);
				super.mouseClicked(e);
			}
		});
		//创建Jscrollpane
		final JScrollPane js = new JScrollPane(table);
		js.setBounds(100, 70, 400, 130);
		//创建删除按钮
		final JButton update = new JButton("修改");
		//为按钮创建监听事件
		update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//判断Id是否在列表内
				if(id == 0){
					JOptionPane.showMessageDialog(null, "修改失败请选择需要修改的记录！");
				}else{
					try {
						//给出提示
						//4个参数：1.null 2.提示内容 3.标题 4.按钮类型
						int mess = JOptionPane.showConfirmDialog(
								null,"确定修改记录？","友情提示：",
								JOptionPane.YES_NO_OPTION );
						//点击确定按钮之后的事件
						//0 == 确定 ，1 == 取消
						if(mess == 0){
							//调用删除方法
							Storage storage = new Storage();
							storage.setStoragename(name.getText());
							storage.setStoragestyle(style.getText());
							storage.setStorageID(Integer.parseInt(s_id.getText()));
							s.Update(storage,"update storage set storagename = ?,storagestyle=?,storageID=? where id = "+ id);
							//提示删除成功
							JOptionPane.showMessageDialog(null, "修改成功");
							s.Query("select * from storage");
							//原理：移除原组件，添加新组件
							//创建表格
							JTable new_table = new JTable(s.vec,c);
							new_table.setFont(f);
							new_table.getTableHeader().setFont(f);
							//创建Jscrollpane
							JScrollPane p = new JScrollPane(new_table);
							//设置新组建的大小
							p.setBounds(100, 70, 400, 130);
							//移除旧组件
							index.remove(js);
							//添加新组件
							index.add(p);
							//重绘组键
							index.repaint();
						}

					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		});
		//设置位置及大小
		update.setBounds(250, 380, 80,30);
		index.add(title);
		index.add(storagename);
		index.add(name);
		index.add(storagestyle);
		index.add(style);
		index.add(storageid);
		index.add(s_id);
		index.add(js);
		//添加按钮
		index.add(update);
	}
}
