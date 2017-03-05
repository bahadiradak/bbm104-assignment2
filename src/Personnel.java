/**
 * Personnel
 * @author Bahadir
 */
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Personnel 
{
	/**
	 * These are personel's informations
	 */
	String name,surname,personelregistration,position,startDuty,BaseSalary,w1,w2,w3,w4;
	Object start;
	float totalSalary;
	public PrintWriter writer;
	
	/**
	 * @return the baseSalary
	 */
	public String getBaseSalary() {
		return BaseSalary;
	}
	/**
	 * @param baseSalary the personnel's base salary if it exists to set
	 * @return the baseSalary
	 */
	public Object setBaseSalary(String baseSalary) {
		return BaseSalary = baseSalary;
	}
	/**
	 * @return the personnel's work began time
	 */
	public String getStartDuty() {
		return startDuty;
	}
	/**
	 * @param startDuty when the personnel's work began in year format to set
	 * @return the personnel's work began time
	 */
	public Object setStartDuty(String startDuty) {
		return this.startDuty = startDuty;
	}
	/**
	 * @return the Personnel's name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the Personnel's name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the Personnel's surname
	 */
	public String getSurname() {
		return surname;
	}
	/**
	 * @param surname the Personnel's surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**
	 * @return the personelregistration
	 */
	public String getPersonelregistration() {
		return personelregistration;
	}
	/**
	 * @param personelregistration the Personnel's registrarion number
	 */
	public void setPersonelregistration(String personelregistration) {
		this.personelregistration = personelregistration;
	}
	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}
	/**
	 * @param position the Personnel's work position
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	/**
	 * @return the start
	 */
	public Object getStart() {
		return start;
	}
	/**
	 * @param f when the personnel's work began in year format to set
	 * @return the time
	 */
	public Object setStart(Object f) {
		return this.start = f;
	}
	/**
	 * @return the totalSalary
	 */
	public float getTotalSalary() {
		return totalSalary;
	}
	/**
	 * @param g the personnel's total salary
	 * @return the totalSalary
	 */
	public Object setTotalSalary(Object g) {
		return this.totalSalary = (float) g;
	}
	/**
	 * @return the week 1
	 */
	public String getw1() {
		return w1;
	}
	/**
	 * @param w1 the personnel's how much time work in week 1
	 * @return the w1
	 */
	public Object setw1(String w1) {
		return this.w1 = w1;
	}
	/**
	 * @return the week 2
	 */
	public String getw2() {
		return w2;
	}
	/**
	 * @param w2 the personnel's how much time work in week 2
	 * @return the w2
	 */
	public Object setw2(String w2) {
		return this.w2 = w2;
	}
	/**
	 * @return the week 3
	 */
	public String getw3() {
		return w3;
	}
	/**
	 * @param w3 the personnel's how much time work in week 3
	 * @return the w3
	 */
	public Object setw3(String w3) {
		return this.w3 = w3;
	}
	/**
	 * @return the week 4
	 */
	public String getw4() {
		return w4;
	}
	/**
	 * @param w4 the personnel's how much time work in week 4
	 * @return the w4
	 */
	public Object setw4(String w4) {
		return this.w4 = w4;
	}
	/**
	 * @param v1 the personnel's registration number which will be text file name
	 * @throws FileNotFoundException if file not found
	 * @throws UnsupportedEncodingException if the character encoding is not supported
	 */
	public void finalSums(String v1) throws FileNotFoundException, UnsupportedEncodingException
	{
		writer = new PrintWriter(v1+".txt", "UTF-8");
		writer.println("Name : " + name.replace("﻿", ""));
		writer.println("Surname : " + surname);
		writer.println("Registration Number : " + personelregistration);
		writer.println("Position : " + position);
		writer.println("Year of Start : " + start);
		writer.printf("Total Salary : ");writer.printf (String.format(Locale.ENGLISH,"%.2f",totalSalary));writer.println(" TL");
		writer.close();
	}
	/**
	 * @param m6 when the personnel's work began in year format
	 * @return the severancePay after calculations
	 */
	public Float severancePay(Object m6)
	{
		this.startDuty = (String) m6;
		int d1 = 2016 - Integer.parseInt((String) m6);
		Float severancePay = (float) (d1*20*0.8);
		return severancePay;
	}
	/**
	 * @param a the personnel's base salary if it exists
	 * @return the ssBenefit which means special service benefits after calculations
	 */
	public Float ssBenefit(Object a)
	{
		this.BaseSalary = (String) a;
		int a6 = Integer.parseInt((String) a);
		
		float ssB = (a6*135)/100;
		return (float) ssB;
	}
	/**
	 * @param b the personnel's how much time work in week 1
	 * @param c the personnel's how much time work in week 2
	 * @param d the personnel's how much time work in week 3
	 * @param e the personnel's how much time work in week 4
	 * @return the overWorkSalary after calculations
	 */
	public Float overWorkSalary (Object b,Object c, Object d, Object e)
	{
		this.w1 = (String) b;
		this.w2 = (String) c;
		this.w3 = (String) d;
		this.w4 = (String) e;
				
		float a1 = Float.parseFloat((String) b);
		float a2 = Float.parseFloat((String) c);
		float a3 = Float.parseFloat((String) d);
		float a4 = Float.parseFloat((String) e);
		
		float sum = a1 + a2 + a3 + a4 ;
		float over = (sum-160);
		
		Float oWs = null;
		if(over >= 32)
		{
			oWs =(float) (32*5);
			
		}
		else if(over<32)
		{
			oWs = (float) (over * 5);
			
		}
		return oWs;
	}
	/**
	 * @param b the personnel's how much time work in week 1
	 * @param c the personnel's how much time work in week 2
	 * @param d the personnel's how much time work in week 3
	 * @param e the personnel's how much time work in week 4
	 * @return the hourofWork after calculations
	 */
	public Float hourOfWork (Object b,Object c, Object d, Object e)
	{
		this.w1 = (String) b;
		this.w2 = (String) c;
		this.w3 = (String) d;
		this.w4 = (String) e;
		
		float a1 = Float.parseFloat((String) b);
		float a2 = Float.parseFloat((String) c);
		float a3 = Float.parseFloat((String) d);
		float a4 = Float.parseFloat((String) e);
		
		List<Float> total=new ArrayList<Float>();
		
		float week1 = a1;
		if (30 <= week1 && week1 <=54)
		{
			total.add((float) ((Float) week1*6.5));
		}
		else if(week1>54)
		{
			total.add((float) ((float) 54*6.5));
		}
		
		
		float week2 = a2;
		if (30 <= week2 && week2 <=54)
		{
			total.add((float) ((Float) week2*6.5));
		}
		else if(week2>54)
		{
			total.add((float) ((float) 54*6.5));
		}
		
		
		float week3 = a3;
		if (30 <= week3 && week3 <=54)
		{
			total.add((float) ((Float) week3*6.5));
		}
		else if(week3>54)
		{
			total.add((float) ((float) 54*6.5));
		}
		
		
		float week4 = a4;
		if (30 <= week4 && week4 <=54)
		{
			total.add((float) ((Float) week4*6.5));
		}
		else if(week4>54)
		{
			total.add((float) ((float) 54*6.5));
		}
		
		
		Float sum = (float) 0;
		for (Float x : total)
		{
			sum+=x;
		}

		Float totalSalary = (float) (sum);
		
		return totalSalary;
	}
}
