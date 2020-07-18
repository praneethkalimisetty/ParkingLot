package com.parking;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import java.util.Comparator;

public class ParkingLot{

	Scanner sc = new Scanner(System.in);
	Map<Integer,String> parkingDetails = new HashMap<Integer,String>();
	Map<Integer,String> carDetails = new HashMap<Integer,String>();
	int lotNumber = 0;
	Set<Integer> set = new TreeSet<>();
	
	void create() throws InterruptedException {
		int num = 0;
		try {
			num = sc.nextInt();
		}catch(InputMismatchException ex) {
			System.out.println("Kindly enter only numbers");
			sc.next();
		}finally {
			if(num != 0) {
				start();
			}else {
				create();
			}
		}
	}
	void start() throws InterruptedException {
		int num = 0;
		System.out.println("Enter choice to perform on parking lot\n1.Park\n2.Print\n3.Leave\n4.Quit");
		try {
			num = sc.nextInt();
			if(num == 1) {
				carDetails();
			}else if(num == 2) {
				print();
			}else if(num == 3) {
				leave();
			}else if(num == 4) {
				quit();
			}else {
				invalid();
			}
		}catch(InputMismatchException ex){
			System.out.println("Kindly enter only numbers");
			sc.next();
		}finally {
			if(num == 0) {
				invalid();
			}else {
				start();
			}
		}
	}
	
	void add(String vehicleNum, String vehicleColor) throws InterruptedException {
		int size = parkingDetails.size();
		if(size == 0) {
			lotNumber = size+1;
			parkingDetails.put(lotNumber, vehicleNum);
			carDetails.put(lotNumber, vehicleColor);
			System.out.println("Parking Lot Number : "+lotNumber);
			System.out.println("==============================================================");
			start();
		}else {
			lotNumber = size+1;
			parkingDetails.put(lotNumber, vehicleNum);
			carDetails.put(lotNumber, vehicleColor);
			System.out.println("Parking Lot Number : "+lotNumber);
			System.out.println("==============================================================");
			start();
		}
	}
	
	void carDetails() throws InterruptedException {
		System.out.println("Enter your car registration number");
		String vehicleNum = sc.next();
		if(!parkingDetails.containsValue(vehicleNum)) {
			System.out.println("Enter your car color");
			String vehicleColor = sc.next();
			add(vehicleNum, vehicleColor);
		}else {
			System.out.println("Provided registration number already parked in the lot");
			start();
		}
		
	}
	
	void print() throws InterruptedException {
		Iterator<Entry<Integer, String>> it = parkingDetails.entrySet().iterator();
		if(it.hasNext()) {
			while (it.hasNext()) {
		        @SuppressWarnings("rawtypes")
				Map.Entry pair = (Map.Entry)it.next();
		        System.out.println(pair.getKey() + "  " + pair.getValue() + " " + carDetails.get(pair.getKey()));
		    }
		}else {
			System.out.println("There is no data to display");
		}
	    System.out.println("==============================================================");
	    start();
	}
	
	void leave() throws InterruptedException {
		int num = 0;
		try {
			System.out.println("Kindly enter your parking slot number to leave");
			num = sc.nextInt();
			carDetails.remove(num);
			parkingDetails.remove(num);
			System.out.println("Slot number " + num + " is free");
		}catch(InputMismatchException ex) {
			System.out.println("Kindly enter only numbers");
			sc.next();
		}finally {
			if(num == 0) {
				invalid();
			}else {
				start();
			}
		}
	}
	
	void invalid() throws InterruptedException {
		System.out.println("Invalid choice!!!\n1.Continue\n2.Quit");
		int num = 0;
		try {
			num = sc.nextInt();
			if(num == 1) {
				start();
			}else if(num==2) {
				quit();
			}else {
				invalid();
			}
		}catch(InputMismatchException ex) {
			System.out.println("Kindly enter only numbers");
			sc.next();
		}finally {
			if(num == 0) {
				invalid();
			}else {
				start();
			}
		}
	}
	
	void quit() throws InterruptedException {
		System.out.println("close");
//		Thread.sleep(3000);
		sc.close();
	}
	
	public static void main(String[] args) throws InterruptedException {
		ParkingLot park = new ParkingLot();
		park.start();
	}

	
	
}
