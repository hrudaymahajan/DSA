import java.util.*;

class Data
{

    int limit;
	int Arr[]=new int[10];
	Scanner z=new Scanner(System.in);
	void getdata(int num)
	{
		System.out.println("Enter the numbers");

		for(int i=0 ;i<num;i++)
		{
			Arr[i]=z.nextInt();
			System.out.println("Record susessfuly saved");
		}
	}

	void display(int num)
	{
		System.out.println("Data Before hashing");
		for(int i=0;i<num;i++)
		{
			if(Arr[i] != -1)
			{
				System.out.println("telephone no "+ i +"-"+ Arr[i]);
			}
		}
	}
	int Arr2[]={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
	int Arr3[]={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};

   void Hashdata(int num)
   {
	   
	   	int result=0;
	   	for (int i=0;i<num;i++)
	   	{
	   		result=Arr[i]%10;
	   		if(Arr2[result]== -1)
	   		{
	   			Arr2[result] = Arr[i];
	   		}
	   	
	   		else
	   		{
	   			for(int j=result;j<10;j++)
	   			{
	   				
	   				if (Arr2[j]== -1)
	   				{
	   					Arr3[result]=j;
	   					Arr2[j] = Arr[i];
	   					break;
	   				}

	   				else if(j==9 && Arr2[9]!= -1)
	   				{
	   					for (int k=0;k<10;k++)
	   					{
	   						if(Arr2[k] == -1)
	   						{
	 							Arr2[k] = Arr[i];
	 							Arr3[result]=k;
	   							break;
	   						}
	   					}		
	   				}
	   			}
	   		}

	   	}
	   	System.out.println("Hashing susessfuly done");
   }

   void display()
   {  
   	    System.out.println("Data After hashing");
	   	 for(int i=0; i<10;i++)
	   	 { 
	   	 	if(Arr2[i] != -1)
	   	 	{
	   	 		System.out.println(i+"-"+Arr2[i]);	
	   	 	}
	   	 }
   }

}

class hash_table
{
	public static void main(String ab[])
	{
		
		int num,ch;
		String ans="y";
		Scanner z=new Scanner(System.in);		
		Data x=new Data();
		System.out.println("Enter the how much entres you want");
		num=z.nextInt();
		
		do 
		{

			System.out.println("Enter the choice");
			System.out.println("1. Enter the data");
			System.out.println("2. Display Data");
			System.out.println("3. Start Hashing ");
			System.out.println("4. Display Hashing ");
			// System.out.println("5. do all");
			ch=z.nextInt();
			switch(ch)
			{
					case 1:	x.getdata(num);
							break;

					case 2: x.display(num);
							break;

					case 3: x.Hashdata(num);
							break;

					case 4: x.display();
							break;	

					// case 5: x.getdata(num);
					// 		x.display(num);
					// 		x.Hashdata(num);
					// 		x.display();
					// 		break;

					default: System.out.println("Invaild Input");												 
			}
			System.out.println("Do you want to continue y/n");
			Scanner zz=new Scanner(System.in);
			ans=zz.nextLine();
		}
		while(ans.equals("y")||ans.equals("Y"));
		
	}
}
