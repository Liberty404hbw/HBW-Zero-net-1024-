package shiyanF;
public class Cone implements Shape
{
private double radius,length,height;
	
	public Cone(double radius,double height,double length)
	{
		this.radius =radius;
		this.length=length;
		this.height=height;
	}
	public Cone()
	{
		this(0,0,0);
	}
public double area()
{
	return Math.PI *this.radius *this.length +Math.PI *this.radius *this.radius ;
	}
public double volume()
{
	return Math.PI *this.radius *this.height /3;
	}
public String toString()
{
	return "圆锥体: 半径:"+this.radius + ",高:"+this.height +",斜边:"+this.length +"\n表面积为:"+this.area()+"\n体积为:"+this.volume(); 
}
	

public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	System.out.println(new Cone(5,7,9).toString());
}

}

