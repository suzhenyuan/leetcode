package algorithms;

public class P011_Container_With_Most_Water {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
	}

	public static int maxArea(int[] height) {
		int max=0;
		for(int i=0; i< height.length;i++){
			for(int j=i+1; j<height.length; j++){
				int minHeight = height[i]<height[j]?height[i]:height[j];
				int v = minHeight* (j-i);
				max = max>v?max:v;
			}
		}
		return max;
	}

}
