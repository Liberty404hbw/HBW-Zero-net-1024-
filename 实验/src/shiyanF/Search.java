package shiyanF;
import java.util.Arrays;
public class Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] keys = {"assert", "byte","ctrl","double","event"};
              
        Arrays.sort(keys);
        System.out.println("输出按字母排序额的关键字：");
        for (String key : keys)
        {
        	System.out.println(key);
        }
            String chuan="student";
            int b=0;
            for(int i=0;i<keys.length;i++)
            {
            	if(chuan==keys[i])
            	{
            		b=1;
            		break;
            	}
            }
            if(b==1)
            {
            	System.out.println("存在");
            	
            }
            else if(b!=1)
            	System.out.println("不存在");
        
        System.out.println(Arrays.binarySearch(keys, "static"));
       
        
	}

}
