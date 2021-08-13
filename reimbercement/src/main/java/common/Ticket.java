package common;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tickets")
public class Ticket implements Serializable{

		
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
		@SequenceGenerator(name = "id_generator", sequenceName = "tickets_ticketnumber_seq", allocationSize = 1)
		@Column (name = "ticketNumber")
		private int ticketNum;
		@Column
		private int employeeID;
		@Column (name = "tickettype")
		private String ticketType;
		@Column (name = "ticketamount")
		private double ticketVal;
		@Column
		private String comment;
		


		
		
		public Ticket() {
			super();
		}
		public Ticket(int employeeID, String reason, String tickettype, double ticketVal, String comment) {
			super();
			this.employeeID = employeeID;
			this.ticketType = tickettype;
			this.ticketVal = ticketVal;
			this.comment = comment;
		}
		public int getEmployeeID() {
			return employeeID;
		}
		public void setEmployeeID(int employeeID) {
			this.employeeID = employeeID;
		}
		public String getTicketType() {
			return ticketType;
		}
		public void setTicketType(String ticketType) {
			this.ticketType = ticketType;
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
			return "{" + this.employeeID+","+this.ticketType+","+this.ticketNum+","+this.ticketVal+","+this.comment+"}";
		}
		
}
