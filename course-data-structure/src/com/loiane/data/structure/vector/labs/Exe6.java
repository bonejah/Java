package com.loiane.data.structure.vector.labs;

import java.util.Scanner;

import com.loiane.data.structure.vector.Contact;
import com.loiane.data.structure.vector.Lista;

public class Exe6 {
	
	public static void main(String[] args) {

		// creating variables
		Scanner scan = new Scanner(System.in);

		// creating vector with 20 of capacity
		Lista<Contact> list = new Lista<Contact>(20);

		// create and add 30 contacts
		createContactsDynamic(30, list);

		// create a menu for the user choose your option
		int option = 1;

		while (option != 0) {
			option = getOptionMenu(scan);

			switch (option) {
			case 1:
				addContactOnVectorFinal(scan, list);
				break;
			case 2:
				addContactOnSpecificPosition(scan, list);
				break;
			case 3:
				getContactOnSpecificPosition(scan, list);
				break;
			case 4:
				getContact(scan, list);
				break;
			case 5:
				searchLastIndex(scan, list);
				break;
			case 6:
				searchingExistContact(scan, list);
				break;
			case 7:
				deleteContactForPosition(scan, list);
				break;
			case 8:
				deleteContact(scan, list);
				break;
			case 9:
				printVectorSize(list);
				break;
			case 10:
				cleanVector(list);
				break;
			case 11:
				printVector(list);
				break;
			default:
				break;
			}
		}

		System.out.println("User typed 0, finished program, BYE!");
	}

	private static void printVector(Lista<Contact> list) {
		System.out.println(list);
	}

	private static void cleanVector(Lista<Contact> list) {
		list.clear();
		System.out.println("All contacts on vector was deleted.");
	}

	private static void printVectorSize(Lista<Contact> list) {
		System.out.println("Size vector is: " + list.length());
	}

	private static void deleteContact(Scanner scan, Lista<Contact> list) {
		int position = readInputPositionOnVector("Enter the position to be removed", scan);

		try {
			Contact contact = list.find(position);
			list.remove(contact);
			System.out.println("Contact removed");
		} catch (Exception e) {
			System.out.println("Invalid Position");
		}
	}

	private static void deleteContactForPosition(Scanner scan, Lista<Contact> list) {
		int position = readInputPositionOnVector("Enter the position to be removed", scan);

		try {
			list.remove(position);
			System.out.println("Contact removed");
		} catch (Exception e) {
			System.out.println("Invalid Position");
		}
	}

	private static void searchingExistContact(Scanner scan, Lista<Contact> list) {
		int position = readInputPositionOnVector("Enter the position to be searched", scan);

		try {
			Contact contact = list.find(position);

			if (list.contains(contact)) {
				System.out.println("Contact searched with success!");
				System.out.println(contact);
			} else {
				System.out.println("Contact doesn't exist!!!");
			}

		} catch (Exception e) {
			System.out.println("Invalid Position");
		}
	}

	private static void searchLastIndex(Scanner scan, Lista<Contact> list) {
		int position = readInputPositionOnVector("Enter the position to be searched", scan);

		try {
			Contact contact = list.find(position);
			System.out.println("Contact searched with success!!");
			System.out.println(contact);

			System.out.println("Searching the last index of the contact found.");
			position = list.lastIndexOf(contact);
			System.out.println("Contact found at position:: " + position);

		} catch (Exception e) {
			System.out.println("Invalid Position");
		}
	}

	private static void getContact(Scanner scan, Lista<Contact> list) {
		int position = readInputPositionOnVector("Enter the position to be searched", scan);

		try {
			Contact contact = list.find(position);
			System.out.println("Contact searched with success!!");
			System.out.println(contact);

			System.out.println("Fazendo pesquisa do contato encontrado.");
			position = list.find(contact);
			System.out.println("Contact found at position:: " + position);

		} catch (Exception e) {
			System.out.println("Invalid Position");
		}
	}

	private static void getContactOnSpecificPosition(Scanner scan, Lista<Contact> list) {
		int position = readInputPositionOnVector("Enter the position to be searched", scan);

		try {
			Contact contact = list.find(position);
			System.out.println("Contact searched with success!!");
			System.out.println(contact);
		} catch (Exception e) {
			System.out.println("Invalid Position");
		}
	}

	private static void addContactOnSpecificPosition(Scanner scan, Lista<Contact> list) {
		System.out.println("Creating a contact, enter the information: ");
		String name = readInput("Enter the name: ", scan);
		String phone = readInput("Enter the phone: ", scan);
		String email = readInput("Enter with email:", scan);

		Contact contact = new Contact(name, phone, email);
		int position = readInputPositionOnVector("Enter a location to add contact", scan);

		try {
			list.addElement(position, contact);
			System.out.println("Contact add with success!");
			System.out.println(contact);
		} catch (Exception e) {
			System.out.println("Invalid Position, contato não adicionado");
		}
	}

	private static void addContactOnVectorFinal(Scanner scan, Lista<Contact> list) {
		System.out.println("Criando um contato, entre com as informações: ");
		String name = readInput("Entre com o nome", scan);
		String phone = readInput("Entre com o telefone", scan);
		String email = readInput("Entre com o email", scan);

		Contact contact = new Contact(name, phone, email);
		list.addElement(contact);
		System.out.println("Contact add with success!");
		System.out.println(contact);
	}

	protected static String readInput(String message, Scanner scan) {
		System.out.println(message);
		String input = scan.nextLine();
		return input;
	}

	protected static int readInputPositionOnVector(String message, Scanner scan) {
		boolean inputValid = false;
		int positionChoosed = 0;
		String input;

		while (!inputValid) {
			try {
				System.out.println(message);
				input = scan.nextLine();
				positionChoosed = Integer.parseInt(input);
				inputValid = true;
			} catch (Exception e) {
				System.out.println("Invalid entry, re-enter");
			}
		}

		return positionChoosed;
	}

	protected static int getOptionMenu(Scanner scan) {
		boolean inputValid = false;
		int option = 0;
		String input;

		while (!inputValid) {
			System.out.println("Enter the desired option: ");
			System.out.println("1: Adds contact at the end of the vector");
			System.out.println("2: Add contact in a specific position");
			System.out.println("3: Gets in a specific position");
			System.out.println("4: Get contact");
			System.out.println("5: Last contact query index");
			System.out.println("6: Checks if contact exists");
			System.out.println("7: Delete by position");
			System.out.println("8: Delete contact");
			System.out.println("9: Checks vector size");
			System.out.println("10: Delete all contacts from the vector");
			System.out.println("11: Print vector");
			System.out.println("0: Exit");

			try {
				input = scan.nextLine();
				option = Integer.parseInt(input);

				if (option >= 0 && option <= 11) {
					inputValid = true;
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("Invalid entry, re-enter:\n\n");
			}
		}

		return option;
	}

	protected static void createContactsDynamic(int quantity, Lista<Contact> list) {
		Contact contact;
		for (int i = 0; i <= quantity; i++) {
			contact = new Contact();
			contact.setName("Contact " + i);
			contact.setPhone("11111" + i);
			contact.setEmail("contact" + i + "@email.com");
			list.addElement(contact);
		}
	}

}
