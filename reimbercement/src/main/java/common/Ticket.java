package common;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Ticket implements Serializable{
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
		@SequenceGenerator(name = "id_generator", sequenceName = "menu_id_seq", allocationSize = 1)
		private int employeeID;
		
		@Column
		private String reason;
		private int ticketNum;
		private double ticketVal;
		private String comment;
		
		public Ticket() {
			super();
		}
		public Ticket(int employeeID, String reason, int ticketNum, double ticketVal, String comment) {
			super();
			this.employeeID = employeeID;
			this.reason = reason;
			this.ticketNum = ticketNum;
			this.ticketVal = ticketVal;
			this.comment = comment;
		}
		public int getEmployeeID() {
			return employeeID;
		}
		public void setEmployeeID(int employeeID) {
			this.employeeID = employeeID;
		}
		public String getReason() {
			return reason;
		}
		public void setReason(String reason) {
			this.reason = reason;
		}
		public int getTicketNum() {
			return ticketNum;
		}
		public void setTicketNum(int ticketNum) {
			this.ticketNum = ticketNum;
		}
		public double getTicketVal() {
			return ticketVal;
		}
		public void setTicketVal(double ticketVal) {
			this.ticketVal = ticketVal;
		}
		public String getComment() {
			return comment;
		}
		public void setComment(String comment) {
			this.comment = comment;
		}
		@Override
		public String toString() {
			return "{" + this.employeeID+","+this.reason+","+this.ticketNum+","+this.ticketVal+","+this.comment+"}";
		}
		
}
