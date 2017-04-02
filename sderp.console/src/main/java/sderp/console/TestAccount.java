package sderp.console;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Account;
import services.interfaces.AccountServiceRemote;

public class TestAccount {
	public static void main(String[] args) {
		Context context;
		try {
			context = new InitialContext();
			AccountServiceRemote service = (AccountServiceRemote) context
					.lookup("sderp-ear/sderp-ejb/AccountService!services.interfaces.AccountServiceRemote");
			System.out.println("JNDI OK !!!");

			List<Account> list = new ArrayList<>();
			list = service.findWithNamedQuery("Account.findAll");

			for (Account a : list) {
				System.out.println(" Account : " + a.getName());
			}

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
