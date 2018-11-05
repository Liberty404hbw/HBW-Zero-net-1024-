package shiyanF;

public class BFS3 {
	 public static boolean isBSF3(String str)         
	    {
	        if (str!=null && str.length()>0)                   
	        {
	            char ch = str.charAt(0);                       
	            if (ch>='A' && ch<='Z' || ch>='a' && ch<='z' || ch=='_' || ch=='$')  
	            {
	                for (int i=1; i<str.length(); i++)
	                {
	                    ch = str.charAt(i);
	                    if (!(ch>='A' && ch<='Z' || ch>='a' && ch<='z' || ch=='_' || ch=='$' || ch>='0' && ch<='9'))
	                        return false;
	                }
	                return true;
	            }
	        }
	        return false;
	    }

	public static void main(String[] args) {
		
		 String str = "students";
	        String s1="5201314";
	        String s2=s1;
	        s2+="ijk";
	        if (args.length>0)
	            str=args[0];                        
	        System.out.println("\""+str+"\"  «∑Òœ‡Õ¨? "+isBSF3(str));
	        
	        
	        System.out.println("5201314==5201314? "+("5201314"=="5201314"));          
	        System.out.println("5201314!=aij? "+("5201314"!="aij"));       
	        System.out.println("str==students? "+(str=="student"));
	        System.out.println("str.equals(study)? "+str.equals("study"));
	        System.out.println("abc.compareTo(dcba)? "+"abc".compareTo("dcba"));
	        System.out.println("abcd.compareTo(ab)? "+"abcd".compareTo("ab"));

	        
	        System.out.println("abc==abc? "+("abc"=="abc"));
	        System.out.println(String.format("%s%S",s1,s2));  

	}

}
