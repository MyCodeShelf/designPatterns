package designPatternsPack;

class EmployeeExpense
{
	private String name;
	private int reimbursAmt;
	public EmployeeExpense(String name, int reimbursAmt) {
		super();
		this.name = name;
		this.reimbursAmt = reimbursAmt;
	}
	public String getName() {
		return name;
	}
	public int getReimbursAmt() {
		return reimbursAmt;
	}
	
	
}
 abstract class ExpenseHandler
{
		protected ExpenseHandler nextHandler;
		protected int approvalLimit;
	
		public void setNextHandler(ExpenseHandler nextHandler)
		{
			this.nextHandler = nextHandler;
			
			
		}
	public void handleExpense(EmployeeExpense expenseinfo)
	{
		if (expenseinfo.getReimbursAmt() <= approvalLimit) {
            approveExpense(expenseinfo);
        } else if (nextHandler != null) {
            nextHandler.handleExpense(expenseinfo);
        } else {
            System.out.println("Expense report exceeds approval limit.");
        }
	}
	public abstract void approveExpense(EmployeeExpense ex);
}
  class Supervisor extends ExpenseHandler {
	    public Supervisor() {
	        approvalLimit = 1000;
	    }
	    @Override
	    public void approveExpense(EmployeeExpense expenseReport) {
	        System.out.println("Expense report for " + expenseReport.getName() + " approved by supervisor.");
	    }
	}
  class Manager extends ExpenseHandler {
	    public Manager() {
	        approvalLimit = 5000;
	    }
	    
	    public void approveExpense(EmployeeExpense expenseReport) {
	        System.out.println("Expense report for " + expenseReport.getName() + " approved by manager.");
	    }
	}
  class Director extends ExpenseHandler {
	    public Director() {
  approvalLimit = 10000;
}

public void approveExpense(EmployeeExpense expenseReport) {
    System.out.println("Expense report for " + expenseReport.getName() + " approved by director.");
}
  }
public class ChainOfResponsibility {
	public static void main(String[] args) {
	 ExpenseHandler supervisor = new Supervisor();
     ExpenseHandler manager = new Manager();
     ExpenseHandler director = new Director();
     
     supervisor.setNextHandler(manager);
     manager.setNextHandler(director);
     
     EmployeeExpense report1 = new EmployeeExpense("John Doe", 500);
     supervisor.handleExpense(report1);
     
     EmployeeExpense report2 = new EmployeeExpense("Jane Smith", 5000);
     supervisor.handleExpense(report2);
     
     EmployeeExpense report3 = new EmployeeExpense("Bob Johnson", 15000);
     supervisor.handleExpense(report3);
}
}
