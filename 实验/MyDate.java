package hbw;

public class MyDate {
	 private int year,month,day;                  
	    private static int thisYear;          
	    static                                       
	    {
  thisYear=2012;
	     
	    }
	  
	    public MyDate(int year, int month, int day)  
	    {
	        this.set(year, month, day);             
	    } 
	    public MyDate()                              
	    {
	        this(1970,1,1);                         
	    } 
	    public MyDate(MyDate d)                      
	    {
	        this.set(d);
	    }
	  
	    public void set(int y, int m, int d)         
	    {
	        this.year = y;                           
	        this.month = ((m>=1) & (m<=12)) ? m : 1;
	        this.day = ((d>=1) & (d<=31)) ? d : 1;
	    } 
	    public void set(MyDate d)                   
	    {
	        set(d.year, d.month, d.day);             
	    } 

	    public int getYear()                         
	    {
	        return this.year;
	    }
	    public int getMonth()                        
	    {
	        return this.month;
	    }
	    public int getDay()                          
	    {
	        return this.day;
	    }
	  
	    public String toString()                     
	    {
	        return this.year+"年"+this.month+"月"+this.day+"日";
	    }

	    public static int getThisYear()             
	    {
	        return thisYear;                         
	    }

	    public static boolean isLeapYear(int year)   
	    {
	        return year%400==0 || year%100!=0 && year%4==0;
	    }
	    public boolean isLeapYear()                  
	    {
	        return isLeapYear(this.year);            
	    }        

	    public boolean equals(MyDate d)             
	    {                                            
	        return this==d || d!=null && this.year==d.year && this.month==d.month && this.day==d.day;
	    } 
	    public boolean equals(Object obj)            
	    {
	        if (this==obj)                           
	            return true;
	        if (obj instanceof MyDate)               
	        {
	            MyDate d = (MyDate)obj;              
	            return this.year==d.year && this.month==d.month && this.day==d.day;
	        }
	        return false;
	    }    
	    public static int daysOfMonth(int year, int month) 
	    {
	        switch (month)                           
	        {
	            case 1: case 3: case 5: case 7: case 8: case 10: case 12:  return 31; 
	            case 4: case 6: case 9: case 11:  return 30;
	            case 2:  return isLeapYear(year)?29:28;
	            default: return 0;
	        }
	    }
	    public int daysOfMonth()                     
	    {
	        return daysOfMonth(this.year, this.month);
	    } 
	    
	    public void tomorrow()                    
	    {
	        this.day++;                              
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
	    public MyDate yestoday()                     
	    {
	        MyDate yes=new MyDate(this);             
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
	        return yes;                           
	    }
	    public String getWeek()
	    {
	        int total = year-1980+(year-1980+3)/4;   
	        switch (month-1)                         
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
	            case  0: total+=day;                 
	        }
	        int week =1;                             
	        week = (week+total) % 7;                 
	        return "星期"+"日一二三四五六".substring(week, week+1);
	    }    

	    public boolean before(MyDate d){
	    	
	    	return d.year<this.year||d.month<this.month||d.day<this.day;
	    	}
	    	public int daysBetween(MyDate d)
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
	