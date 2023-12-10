/*
 * Copyright (C) 2017 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package api;
import java.io.*; 
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
class Result {

	/*
	 * Complete the 'Solve' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts INTEGER n as parameter.
	 *
	 */


	public static int Solve(int n) {
		// Write your code here
		int c=n;
		int[] num=new int[3];
		for(int i=2;i>=0;i--){
			num[i]=n%10;
			n/=10;
		}
		System.out.println("1st Iteration "+num);
		
		int[] arr=new int[6];
		arr[0]=c;
		for(int i=1;i<6;i++)
		{
			int res=0;
			for(int j=0;j<3;j++){
				if(j!=2){
					System.out.println("2nd Iteration "+num[j]);
					int temp=num[j];
					num[j]=num[j+1];
					num[j+1]=temp;
				}
			}
			String test="";
			for(int j=0;j<3;j++)
			{
				test= test+num[j];
			}
			System.out.println("2nd Iteration result"+test);
			for(int j=0;j<3;j++)
			{
				res=(res*10)+num[j];
				System.out.println("3rd Iteration "+num[j]+" "+res);
			}
			arr[i]=res;
		}
		int sum=0;
		for(int i=0;i<6;i++){
			sum+=arr[i];
		}
		return sum;


	}
}

public class Source {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine().trim());

		int result = Result.Solve(n);

		System.out.print(String.valueOf(result));

		bufferedReader.close(); }
}