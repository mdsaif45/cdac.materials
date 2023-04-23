package in.cdac.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Book {	
	private int bookid;	
	private String name;
	private String author;
	private float price;
	private int quantity;
}
