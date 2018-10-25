package algorithms;


public class P008_StringToInteger {

	public static void main(String[] args) {

		System.out.println("结果："+myAtoi("   -42"));
		System.out.println("结果："+myAtoi("42"));
		System.out.println("结果："+myAtoi("4193 with words"));
		System.out.println("结果："+myAtoi("words and 987"));
		
		System.out.println("结果："+myAtoi(" +987 sdfas"));
		System.out.println("结果："+myAtoi("-91283472332"));
		System.out.println("结果："+myAtoi("+"));
		System.out.println("结果："+myAtoi("-"));
		System.out.println("结果："+myAtoi("+-2"));
		System.out.println("结果："+myAtoi("  0000000000012345678"));
	}

	public static int myAtoi(String str) {
		System.out.println("输入："+str);
		str = str.trim();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i< str.length(); i++){
			if(str.charAt(i)=='+' || str.charAt(i)=='-' || str.charAt(i)>='0' && str.charAt(i)<='9' ){
				sb.append(str.charAt(i));
			}else{
				break;
			}
		}
		//remove zero 
		int i=0;
		for(i=0;i<sb.length(); i++){
			if(sb.charAt(i)!='0' && sb.charAt(i) !='-'&& sb.charAt(i) !='+'){
				break;
			}
		}
		String result=sb.toString();
		if(i>0){
			result = sb.substring(i);
		}
		if(sb.length()>0 && sb.charAt(0)=='-'){
			result = '-'+result;
		}
		System.out.println("sb:"+sb);
		int value = 0;
		try{
			value =Integer.parseInt(result);
		}catch(Exception ee){
		}
		System.out.println("value:"+value);
		if(result.length()==0 || result.equals("-") || result.equals("+")){
			return 0;
		}else if(result.equals(value+"")){
			return value;
		}else if(result.charAt(0)=='-'){
			return Integer.MIN_VALUE;
		}else{
			return Integer.MAX_VALUE;
		}
	}
}
