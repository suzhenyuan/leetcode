package algorithms;

public class P007_ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(reverse(Integer.MAX_VALUE / 2));
		System.out.println(reverse(Integer.MIN_VALUE / 2));
	}

	/**
	 * @param x
	 * @return
	 * @toDo
	 */
	public static int reverse(int x) {
		int y = 0;
		while (x != 0) {
			if (y > Integer.MAX_VALUE / 10 || y == Integer.MAX_VALUE / 10 && x > 7) {
				return 0;
			} else if (y < Integer.MIN_VALUE / 10 || y == Integer.MIN_VALUE / 10 && x < -8) {
				return 0;
			}
			y = y * 10 + x % 10;
			x = x / 10;
		}
		return y;

	}
	
	/**
	 * 别人家的答案：先计算一个新的结果，然后判断这个结果是否溢出了
	 * @param x
	 * @return
	 */
	public int other_reverse(int x) {
        int result = 0;
        while(x!=0){
            int tail = x % 10;
            int newResult=result*10+tail;
            if((newResult-tail)/10!=result) return 0;
            result = newResult;
            x = x/10;
        }
        return result;
    }

}
