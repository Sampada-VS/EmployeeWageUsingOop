public class EmpWageOop
{
	public static final int IS_FULL_TIME=1;
	public static final int IS_PART_TIME=2;

	public final String company;
	public final int empRatePerHr;
	public final int numOfWorkingDays;
	public final int maxHrs;

	public EmpWageOop(String company, int empRatePerHr, int numOfWorkingDays, int maxHrs)
	{
		this.company=company;
		this.empRatePerHr=empRatePerHr;
		this.numOfWorkingDays=numOfWorkingDays;
		this.maxHrs=maxHrs;
	}

	public static void main(String[] args)
	{
		EmpWageOop deloitte=new EmpWageOop("Deloitte",20,2,10);
		EmpWageOop microsoft=new EmpWageOop("Microsoft",30,5,30);
		deloitte.calculate20Wage();
		microsoft.calculate20Wage();

	}
	public void calculate20Wage()
	{
		int empHrs;
		int empWage;
		int totalMaxEmpHrs=12;
		int totalEmpHours=0;
		int totalWorkingDays=0;
		System.out.println("For company "+company);
		while (totalEmpHours<maxHrs && totalWorkingDays<numOfWorkingDays)
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
			if (totalEmpHours>maxHrs)
			{
				totalEmpHours=totalEmpHours-empHrs;
				totalWorkingDays--;
				break;
			}
			else
			{
				empWage=empHrs*empRatePerHr;
				System.out.println("Employee daily wage :"+empWage+" Total Employee Hours : "+totalEmpHours);
			}
		}
		int totalEmpWage=totalEmpHours*empRatePerHr;
		System.out.println("Total employee wage :"+totalEmpWage);
		System.out.println("Total emp hours :"+totalEmpHours);
		System.out.println("Total working days :"+totalWorkingDays);
	}
}
