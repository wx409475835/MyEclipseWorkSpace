package com.nyist.generic;

public class Demo1 {
	
	//编写一个泛型方法,接收一个数组,并颠倒数组中的所有的元素
	public <T> void reverse(T arr[]){
		int startindex = 0;
		int endindex = arr.length-1;
		while(true){
			if(startindex >= endindex){
				break;
			}
			T temp = arr[startindex];
			arr[startindex] = arr[endindex];
			arr[endindex] = temp;
			startindex++;
			endindex--;
		}
	}
}
