import java.util.*;
interface IComputeEmpWage
{
	public void addCompany(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursInMonth);
	public void computeEmpWage();
	public int getTotalWage(String company);
}
class CompanyEmpWage
{
	public final String company;
	public final int empRatePerHr;
	public final int numOfWorkingDays;
	public final int maxHrs;
	public int totalEmpWage;

	public CompanyEmpWage(String company, int empRatePerHr, int numOfWorkingDays, int maxHrs)
	{
		this.company=company;
		this.empRatePerHr=empRatePerHr;
		this.numOfWorkingDays=numOfWorkingDays;
		this.maxHrs=maxHrs;
		totalEmpWage=0;
	}
	public void setTotalEmpWage(int totalEmpWage)
	{
		this.totalEmpWage=totalEmpWage;
	}
	public String toString()
	{
		return "Total employee wage for company : "+company+" is : "+totalEmpWage;
	}
}
public class EmpWageOop implements IComputeEmpWage
{
	public static final int IS_FULL_TIME=1;
	public static final int IS_PART_TIME=2;

	private int numOfCompany=0;
	private LinkedList<CompanyEmpWage> compEmpWageList;
	private Map<String,CompanyEmpWage> companyEmpWageMap;
	public EmpWageOop()
	{
		compEmpWageList=new LinkedList<>();
		companyEmpWageMap=new HashMap<>();
	}
	public void addCompany(String company, int empRatePerHr, int numOfWorkingDays, int maxHrs)
	{
		CompanyEmpWage companyempwage= new CompanyEmpWage(company,empRatePerHr,numOfWorkingDays,maxHrs);
		compEmpWageList.add(companyempwage);
		companyEmpWageMap.put(company,companyempwage);
	}
	public void computeEmpWage()
	{
		for(int i=0;i<compEmpWageList.size();i++) {
			CompanyEmpWage companyempwage=compEmpWageList.get(i);
			companyempwage.setTotalEmpWage(this.computeEmpWage(companyempwage));
			System.out.println(companyempwage);
		}
	}
	public int getTotalWage(String company)
	{
		return companyEmpWageMap.get(company).totalEmpWage;
	}
	public int computeEmpWage(CompanyEmpWage companyempwage)
	{
		int totalEmpHours=0;
		int totalWorkingDays=0;
		int totalEmpWage=0;
		System.out.println("For company "+companyempwage.company);
		while (totalEmpHours<=companyempwage.maxHrs && totalWorkingDays<companyempwage.numOfWorkingDays)
		{
			totalWorkingDays++;
			int empHrs=0;
			int empWage=0;

			int empCheck = (int)((Math.random()*10)%3);
			switch (empCheck)
			{
				case IS_FULL_TIME :
					empHrs=8;
					break;
				case IS_PART_TIME :
					empHrs=4;
					break;
				default :
					empHrs=0;
			}

			totalEmpHours=totalEmpHours+empHrs;
			empWage=empHrs*companyempwage.empRatePerHr;
			totalEmpWage=totalEmpWage+empWage;
			System.out.println("Employee wage:"+empWage);
		}

		System.out.println("Total employee wage :"+totalEmpWage);
		return totalEmpHours*companyempwage.empRatePerHr;
	}
	public static void main(String[] args)
	{
		IComputeEmpWage empwageoop=new EmpWageOop();
		empwageoop.addCompany("Deloitte",20,2,5);
		empwageoop.addCompany("Microsoft",30,5,30);
		empwageoop.computeEmpWage();
		System.out.println("Total wage for Microsoft company : "+empwageoop.getTotalWage("Microsoft"));
	}

}
