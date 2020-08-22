interface IComputeEmpWage
{
	public void addCompany(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursInMonth);
	public void computeEmpWage();
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
	}
	public void setTotalEmpWage(int totalEmpWage)
	{
		this.totalEmpWage=totalEmpWage;
	}

}
public class EmpWageOop implements IComputeEmpWage
{
	public static final int IS_FULL_TIME=1;
	public static final int IS_PART_TIME=2;

	public CompanyEmpWage[] compEmpWageArr;
	public int numOfCompany=0;
	public EmpWageOop()
	{
		compEmpWageArr=new CompanyEmpWage[2];
	}
	public void addCompany(String company, int empRatePerHr, int numOfWorkingDays, int maxHrs)
	{
		compEmpWageArr[numOfCompany]=new CompanyEmpWage(company,empRatePerHr,numOfWorkingDays,maxHrs);
		numOfCompany++;
	}
	public void computeEmpWage()
	{
		for(int i=0;i<numOfCompany;i++)
			compEmpWageArr[i].setTotalEmpWage(this.computeEmpWage(compEmpWageArr[i]));
	}
	public static void main(String[] args)
	{
		EmpWageOop empWageArr=new EmpWageOop();
		empWageArr.addCompany("Deloitte",20,2,5);
		empWageArr.addCompany("Microsoft",30,5,30);
		empWageArr.computeEmpWage();
	}
	public int computeEmpWage(CompanyEmpWage companyempwage)
	{
		int empHrs;
		int empWage;
		int totalMaxEmpHrs=12;
		int totalEmpHours=0;
		int totalWorkingDays=0;
		System.out.println("For company "+companyempwage.company);
		while (totalEmpHours<companyempwage.maxHrs && totalWorkingDays<companyempwage.numOfWorkingDays)
		{
			totalWorkingDays++;
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
			System.out.println("Employee Hrs:"+empHrs);
		}
		int totalEmpWage=totalEmpHours*companyempwage.empRatePerHr;
		System.out.println("Total emp hours :"+totalEmpHours);
		System.out.println("Total employee wage :"+totalEmpWage);
		return totalEmpWage;
	}
}
