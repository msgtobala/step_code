package org.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Solution {
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("1.Create new user\n2.Sign in");
		int status=Integer.parseInt(br.readLine());
		if(status==1){
			Newuser newuser=new Newuser();
			System.out.println("Enter New Username: ");
			String Nname=br.readLine();
			System.out.println("Enter the New User password: ");
			String Npassword=br.readLine();
			newuser.setNew_username(Nname);
			newuser.setNew_password(Npassword);
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();
			session.save(newuser);
			session.getTransaction().commit();
			session.close();
			operation();
		}
		else if(status==2){
			System.out.println("Enter the username: ");
			String username=br.readLine();
			System.out.println("Enter the password: ");
			String password=br.readLine();
			User user=new User(username,password);
			try {
				if(Authentictaion.check(user)){
					System.out.println("Login success");
				}
			} 
			catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			operation();
		}
		
	}

	private static void operation() throws NumberFormatException, IOException {
		System.out.println("1.Insert Items\n2.Update Item\n3.Delete Item\n4.View All");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int check=Integer.parseInt(br.readLine());
		if(check==1){
			Items items=new Items();
			System.out.println("Enter the Item Name: ");
			String name=br.readLine();
			items.setItemName(name);
			System.out.println("Enter the Item price: ");
			int price=Integer.parseInt(br.readLine());
			items.setItemPrice(price);
			System.out.println("Enter the Manufacturing date");
			String mfd=br.readLine();
			items.setManufacturingDate(mfd);
			System.out.println("Enter the Item quantity: ");
			int qty=Integer.parseInt(br.readLine());
			items.setItemQty(qty);
			double total=qty*price;
			items.setTotalprice(total);
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();
			session.save(items);
			session.getTransaction().commit();
			session.close();
			System.out.println("Item Inserted");
		}
		else if (check==2){
			Items items=new Items();
			System.out.println("1.Update Item Name\n2.Update price\n3.Update MFD\n4.Update QTY");
			int state=Integer.parseInt(br.readLine());
			if(state==1){
				System.out.println("Enter the item id to updated: ");
				int upd=Integer.parseInt(br.readLine());
				items.setItemId(upd);
				System.out.println("Enter the item name: ");
				String upname=br.readLine();
				SessionFactory sf = new Configuration().configure().buildSessionFactory();
				Session session = sf.openSession();
				session.beginTransaction();
				Items itemupdate=session.get(Items.class,upd);
				itemupdate.setItemName(upname);
				session.update(itemupdate);
				session.getTransaction().commit();
				session.close();
			}
			else if(state==2){
				System.out.println("Enter the item id to updated: ");
				int upd=Integer.parseInt(br.readLine());
				items.setItemPrice(upd);
				System.out.println("Enter the item price: ");
				int upprice=Integer.parseInt(br.readLine());
				SessionFactory sf = new Configuration().configure().buildSessionFactory();
				Session session = sf.openSession();
				session.beginTransaction();
				Items itemupdate=session.get(Items.class,upd);
				itemupdate.setItemPrice(upprice);
				session.update(itemupdate);
				session.getTransaction().commit();
				session.close();
			}
			else if(state==3) {
				System.out.println("Enter the item id to updated: ");
				int upd=Integer.parseInt(br.readLine());
				items.setItemPrice(upd);
				System.out.println("Enter the item mfd: ");
				String mfd=br.readLine();
				SessionFactory sf = new Configuration().configure().buildSessionFactory();
				Session session = sf.openSession();
				session.beginTransaction();
				Items itemupdate=session.get(Items.class,upd);
				itemupdate.setManufacturingDate(mfd);
				session.update(itemupdate);
				session.getTransaction().commit();
				session.close();
			}
			else if(state==4){
				System.out.println("Enter the item id to updated: ");
				int upd=Integer.parseInt(br.readLine());
				items.setItemPrice(upd);
				System.out.println("Enter the item qty: ");
				int qty=Integer.parseInt(br.readLine());
				SessionFactory sf = new Configuration().configure().buildSessionFactory();
				Session session = sf.openSession();
				session.beginTransaction();
				Items itemupdate=session.get(Items.class,upd);
				itemupdate.setItemQty(qty);
				session.update(itemupdate);
				session.getTransaction().commit();
				session.close();	
			}
		}
		else if(check==3) {
			Items items=new Items();
			System.out.println("Enter the Id to delete");
			int del=Integer.parseInt(br.readLine());
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();
			items.setItemId(del);
			session.delete(items);
			session.save(items);
			session.getTransaction().commit();
			session.close();
			
		}
		else {
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			Session session = sf.openSession();
			//session.save(items);
			session.getTransaction().commit();
			Query query=session.createQuery("from Items");
			session.beginTransaction();
			session.getTransaction().commit();
			session.close();
		}
		
	}

}
