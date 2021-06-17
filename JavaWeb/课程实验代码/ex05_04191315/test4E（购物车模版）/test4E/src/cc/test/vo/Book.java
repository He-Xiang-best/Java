package cc.test.vo;

public class Book {
	private String bookId;	//书号
	private String bookName;//书名
	String bookImg;			//书封面所在地址
	private int bookNum;	//购书本数

	public Book(String bookId, String bookName, String bookImg, int bookNum) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookImg = bookImg;
		this.bookNum = 0;
	}

	public String getBookId() {
		return bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public String getBookImg() {
		return bookImg;
	}

	public int getBookNum() {
		return bookNum;
	}

}
