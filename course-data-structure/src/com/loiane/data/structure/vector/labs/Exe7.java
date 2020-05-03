package com.loiane.data.structure.vector.labs;

import java.util.ArrayList;
import java.util.Scanner;

import com.loiane.data.structure.vector.Contact;

public class Exe7 extends Exe6 {

	public static void main(String[] args) {
		// creating variables
		Scanner scan = new Scanner(System.in);

		// creating vector with 20 of capacity
		ArrayList<Contact> list = new ArrayList<Contact>(20);

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

	private static void printVector(ArrayList<Contact> list) {
		System.out.println(list);
	}

	private static void cleanVector(ArrayList<Contact> list) {
		list.clear();
		System.out.println("All contacts on vector was deleted.");
	}

	private static void printVectorSize(ArrayList<Contact> list) {
		System.out.println("Size vector is: " + list.size());
	}

	private static void deleteContact(Scanner scan, ArrayList<Contact> list) {
		int position = readInputPositionOnVector("Enter the position to be removed", scan);

		try {
			Contact contact = list.get(position);
			list.remove(contact);
			System.out.println("Contact removed");
		} catch (Exception e) {
			System.out.println("Invalid Position");
		}
	}

	private static void deleteContactForPosition(Scanner scan, ArrayList<Contact> list) {
		int position = readInputPositionOnVector("Enter the position to be removed", scan);

		try {
			list.remove(position);
			System.out.println("Contact removed");
		} catch (Exception e) {
			System.out.println("Invalid Position");
		}
	}

	private static void searchingExistContact(Scanner scan, ArrayList<Contact> list) {
		int position = readInputPositionOnVector("Enter the position to be searched", scan);

		try {
			Contact contact = list.get(position);

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

	private static void searchLastIndex(Scanner scan, ArrayList<Contact> list) {
		int position = readInputPositionOnVector("Enter the position to be searched", scan);

		try {
			Contact contact = list.get(position);
			System.out.println("Contact searched with success!!");
			System.out.println(contact);

			System.out.println("Searching the last index of the contact found.");
			position = list.lastIndexOf(contact);
			System.out.println("Contact found at position:: " + position);

		} catch (Exception e) {
			System.out.println("Invalid Position");
		}
	}

	private static void getContact(Scanner scan, ArrayList<Contact> list) {
		int position = readInputPositionOnVector("Enter the position to be searched", scan);

		try {
			Contact contact = list.get(position);
			System.out.println("Contact searched with success!!");
			System.out.println(contact);

			System.out.println("Fazendo pesquisa do contato encontrado.");
			position = list.indexOf(contact);
			System.out.println("Contact found at position:: " + position);

		} catch (Exception e) {
			System.out.println("Invalid Position");
		}
	}

	private static void getContactOnSpecificPosition(Scanner scan, ArrayList<Contact> list) {
		int position = readInputPositionOnVector("Enter the position to be searched", scan);

		try {
			Contact contact = list.get(position);
			System.out.println("Contact searched with success!!");
			System.out.println(contact);
		} catch (Exception e) {
			System.out.println("Invalid Position");
		}
	}

	private static void addContactOnSpecificPosition(Scanner scan, ArrayList<Contact> list) {
		System.out.println("Creating a contact, enter the information: ");
		String name = readInput("Enter the name: ", scan);
		String phone = readInput("Enter the phone: ", scan);
		String email = readInput("Enter with email:", scan);

		Contact contact = new Contact(name, phone, email);
		int position = readInputPositionOnVector("Enter a location to add contact", scan);

		try {
			list.add(position, contact);
			System.out.println("Contact add with success!");
			System.out.println(contact);
		} catch (Exception e) {
			System.out.println("Invalid Position, contato não adicionado");
		}
	}

	private static void addContactOnVectorFinal(Scanner scan, ArrayList<Contact> list) {
		System.out.println("Criando um contato, entre com as informações: ");
		String name = readInput("Entre com o nome", scan);
		String phone = readInput("Entre com o telefone", scan);
		String email = readInput("Entre com o email", scan);

		Contact contact = new Contact(name, phone, email);
		list.add(contact);
		System.out.println("Contact add with success!");
		System.out.println(contact);
	}
	
	private static void createContactsDynamic(int quantity, ArrayList<Contact> list) {
		Contact contact;
		for (int i = 0; i <= quantity; i++) {
			contact = new Contact();
			contact.setName("Contact " + i);
			contact.setPhone("11111" + i);
			contact.setEmail("contact" + i + "@email.com");
			list.add(contact);
		}
	}

}
