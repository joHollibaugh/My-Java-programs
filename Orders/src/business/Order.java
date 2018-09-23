package business;

import java.text.NumberFormat;

public class Order {

	
		String Lname;
		String Fname;
		String Email;
		Long CCN;
		double total;
		
		public Order () {
			Lname = "";
			Fname = "";
			Email = "";
			CCN = 0L;
			total = 0L;
		}
		public Order (String Lname, String Fname, String Email, Long CCN, double total) {
			this.Lname = Lname;
			this.Fname = Fname;
			this.Email = Email;
			this.CCN = CCN;
			this.total = total;
		}
		
		public void setLname(String Lname) {
			this.Lname = Lname;
		}
		public String getLname() {
			return Lname;
		}
		public void setFname(String Fname) {
			this.Fname = Fname;
		}
		public String getFname()
		{
			return Fname;
		}
		public void setEmail(String Email) {
			this.Email = Email;
		}
		public String getEmail() {
			return Email;
		}
		public void setCCN(Long CCN) {
			this.CCN=CCN;
		}
		public Long getCCN() {
			return CCN;
		}
		public void setTotal(double total) {
			this.total=total;
		}
		public double getTotal() {
			return total;
		}

		
		public String formatTotal() {
			NumberFormat currency = NumberFormat.getCurrencyInstance();
			return currency.format(total);
		}
	}
