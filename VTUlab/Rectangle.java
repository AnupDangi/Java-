package labprog;

public class Rectangle implements Resizable {
	
	private int width;
	private int height;
	public Rectangle(int width, int height)
	{
		this.width=width;
		this.height=height;
	}
	@Override
	public void resizeWidth(int width) {
		// TODO Auto-generated method stub
		this.width=width;
	}

	@Override
	public void resizeHeight(int height) {
		// TODO Auto-generated method stub
		this.height=height;

	}
	@Override
	public String toString() {
		return "Rectangle(width:"+width+"height:"+height+")";
	}

	
	public static void main(String[] args) {
		Rectangle rect=new Rectangle(2,3);
		System.out.println("This is actual rectangle"+rect);
		
		//Resize the rectangle
		rect.resizeWidth(3);
		rect.resizeHeight(4);
		System.out.println("Resized Rectangle is "+rect);
	}

}
