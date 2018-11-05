package shiyanF;

public class MyDate {
	 private int year,month,day;                  //私有成员变量
	    private static int thisYear;            //当前年份，私有静态成员变量
	    static                                       //静态成员变量初始化
	    {
   thisYear=2012;
	     
	    }
	  
	    public MyDate(int year, int month, int day)  //构造方法，指定日期
	    {
	        this.set(year, month, day);              //调用本类的成员方法
	    } 
	    public MyDate()                              //默认构造方法，缺省日期，重载
	    {
	        this(1970,1,1);                          //调用本类已声明的其他构造方法
	    } 
	    public MyDate(MyDate d)                      //拷贝构造方法，日期同参数，重载
	    {
	        this.set(d);
	    }
	  
	    public void set(int y, int m, int d)         //公有成员方法，设置日期值，算法不全
	    {
	        this.year = y;                           //对成员变量赋值
	        this.month = ((m>=1) & (m<=12)) ? m : 1;
	        this.day = ((d>=1) & (d<=31)) ? d : 1;
	    } 
	    public void set(MyDate d)                    //设置日期值，重载
	    {
	        set(d.year, d.month, d.day);             //调用同名成员方法，不能使用this()
	    } 

	    public int getYear()                         //获得年份
	    {
	        return this.year;
	    }
	    public int getMonth()                        //获得月份
	    {
	        return this.month;
	    }
	    public int getDay()                          //获得当月日期
	    {
	        return this.day;
	    }
	  
	    public String toString()                     //返回中文日期字符串
	    {
	        return this.year+"年"+this.month+"月"+this.day+"日";
	    }

	    public static int getThisYear()              //获得今年年份，静态方法
	    {
	        return thisYear;                         //访问静态成员变量
	    }

	    public static boolean isLeapYear(int year)   //判断指定年份是否闰年，静态方法
	    {
	        return year%400==0 || year%100!=0 && year%4==0;
	    }
	    public boolean isLeapYear()                  //判断当前日期的年份是否闰年，重载
	    {
	        return isLeapYear(this.year);            //调用静态方法
	    }        

	    public boolean equals(MyDate d)              //比较当前日期值与d是否相等
	    {                                            //this指代调用本方法的当前对象
	        return this==d || d!=null && this.year==d.year && this.month==d.month && this.day==d.day;
	    } 
	    public boolean equals(Object obj)            //覆盖Object类的equals()方法
	    {
	        if (this==obj)                           //this指代调用当前方法的对象
	            return true;
	        if (obj instanceof MyDate)               //判断当前对象是否属于MyDate类
	        {
	            MyDate d = (MyDate)obj;              //类型强制转换
	            return this.year==d.year && this.month==d.month && this.day==d.day;
	        }
	        return false;
	    }    
	    public static int daysOfMonth(int year, int month) //返回指定年月的天数，静态方法
	    {
	        switch (month)                           //计算每月的天数
	        {
	            case 1: case 3: case 5: case 7: case 8: case 10: case 12:  return 31; 
	            case 4: case 6: case 9: case 11:  return 30;
	            case 2:  return isLeapYear(year)?29:28;
	            default: return 0;
	        }
	    }
	    public int daysOfMonth()                     //返回当月天数
	    {
	        return daysOfMonth(this.year, this.month);
	    } 
	    
	    public void tomorrow()                       //当前日期改为第二天日期
	    {
	        this.day++;                              //通过this改变当前对象的值，没有返回值
	        if (day>this.daysOfMonth())
	        {
	            day=1;
	            month++;
	            if (month>12)
	            {
	                month=1;
	                year++;
	            }
	        }
	    }
	    public MyDate yestoday()                     //返回当前日期的前一天日期
	    {
	        MyDate yes=new MyDate(this);             //执行拷贝构造方法，创建新实例，没有改变当前对象this
	        yes.day--;
	        if (yes.day==0)
	        {
	            yes.month--;
	            if (yes.month==0)
	            {
	                yes.month=12;
	                yes.year--;
	            }
	            yes.day = daysOfMonth(yes.year, yes.month);
	        }
	        return yes;                              //返回对象引用
	    }
	    public String getWeek()
	    {
	        int total = year-1980+(year-1980+3)/4;   //求平(闰)年累计的总天数
	        switch (month-1)                         //当年的累计天数
	        {
	            case 11: total+=30;
	            case 10: total+=31;
	            case  9: total+=30;
	            case  8: total+=31;
	            case  7: total+=31;
	            case  6: total+=30;
	            case  5: total+=31; 
	            case  4: total+=30;
	            case  3: total+=31;
	            case  2: total+= this.isLeapYear() ? 29 : 28;
	            case  1: total+=31;
	            case  0: total+=day;                 //当月的天数
	        }
	        int week =1;                             //起始日 1979-12-31是星期一
	        week = (week+total) % 7;                 //求得星期几
	        return "星期"+"日一二三四五六".substring(week, week+1);
	    }    

	    public boolean before(MyDate d){
	    	
	    	return d.year<this.year||d.month<this.month||d.day<this.day;
	    	}
	    	public int daysBetween(MyDate d)//先判断两个日期中间相差几年，再比较月份
	    	{
	    	int i,t=0,sum=0;
	    	if(this.before(d)){
	    	for(i=d.year;i<this.year;i++){
	    	if(isLeapYear(i))
	    	sum+=366;
	    	else
	    	sum+=365;}
	    	if(d.month<this.month)
	    	for(i=d.month;i<this.month;i++)
	    	sum+=daysOfMonth(this.year,i);
	    	else{
	    	for(i=this.month;i<d.month;i++)
	    	t+=daysOfMonth(this.year,i);
	    	sum-=t;}
	    	return sum;}
	    	for(i=this.year;i<d.year;i++){
	    	if(isLeapYear(i))
	    	sum+=366;
	    	else
	    	sum+=365;}
	    	if(this.month<d.month)
	    	for(i=this.month;i<d.month;i++)
	    	sum+=daysOfMonth(d.year,i);
	    	else{
	    	for(i=d.month;i<this.month;i++)
	    	t+=daysOfMonth(d.year,i);
	    	sum-=t;}
	    	return sum;}
	public static void main(String[] args) {
	
		System.out.println("今年是"+MyDate.getThisYear()+"，是否是闰年？"+MyDate.isLeapYear(MyDate.getThisYear()));
    MyDate d1 = new MyDate(2018,10,17);  
    MyDate d2 = new MyDate(d1);   
    MyDate d3=new MyDate(2013,12,31);
    System.out.println(d2+"，是否是闰年？"+d2.isLeapYear());
    System.out.println("d1："+d1+"，d2："+d2+"，d1==d2？"+(d1==d2)+"，d1.equals(d2)？ "+(d1.equals(d2)));
    System.out.print(d2+" 的昨天是 "+d2.yestoday()+"\n"+d2+" 的明天是 ");  
   d2.tomorrow();
   System.out.println(d2);
    System.out.println(d1+"对应的星期是"+d1.getWeek() );
    if(d1.before(d3))
 	   System.out.println(d3+"在"+d1+"之前");
    else
 	   System.out.println(d1+"在"+d3+"之前");
    System.out.println(d1+"与"+d3+"相差"+d1.daysBetween( d3)+"天");

	}

}
	