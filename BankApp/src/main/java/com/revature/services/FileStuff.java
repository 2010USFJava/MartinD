package com.revature.services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.AccountInfo;

public class FileStuff {
	
	
	public static final String accountsFile = "accountsList.txt";
	public static final String customerAccountsFile = "customerAccountsList.txt";

	// write method
	public static void writeAccountsFile(List<Transactions> aList) {
		try {
			ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(accountsFile));
			objectOut.writeObject(aList);
			objectOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// read method
	@SuppressWarnings("unchecked")
	public static void readAccountsFile() {
		try {
			ObjectInputStream objectIn= new ObjectInputStream(new FileInputStream(accountsFile));
			Transactions.accounts=(ArrayList<Transactions>)objectIn.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// write method
		public static void writeCustomerAccountsFile(List<AccountInfo> bList) {
			try {
				ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(customerAccountsFile));
				objectOut.writeObject(bList);
				objectOut.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// read method
		@SuppressWarnings("unchecked")
		public static void readCustomerAccountsFile() {
			try {
				ObjectInputStream objectIn= new ObjectInputStream(new FileInputStream(customerAccountsFile));
				AccountInfo.customerAccounts=(ArrayList<AccountInfo>)objectIn.readObject();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	

}
