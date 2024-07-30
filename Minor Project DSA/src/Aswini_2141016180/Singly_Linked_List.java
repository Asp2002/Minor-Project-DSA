package Aswini_2141016180;

import java.util.Scanner;

class Node{
	int info; 
    Node link; 
}
public class Singly_Linked_List {
	static Node start=null;
	static Scanner scn=new Scanner(System.in);
	
	void create() {
		
		Node p=new Node();
		System.out.println("Enter the Node's info: ");
		p.info=scn.nextInt();
		p.link=null;
		Node q=p;
		char ch='y';

		while(ch=='y') {
			if(start==null) {
				start=p;
			}
			else {
				p=new Node();
				System.out.println("Enter the info");
				p.info=scn.nextInt();
				p.link=null;
				q.link=p;
				q=p;
			}
			System.out.println("Do you want to create more nodes(y/n):");
			ch=scn.next().charAt(0);
		}		
	}
	
	void display() {
		System.out.println("Display of the Singly Linked List: ");
		Node curr=start;
		if(curr==null)
			System.out.println("Linked list is empty. ");
		while(curr!=null) {
			if(curr.link!=null)
				System.out.print(curr.info+"-->");
			else
				System.out.println(curr.info);
			curr=curr.link;
		}
	}
	
	int listsize(Node size)
    {
        int c=0;
        while(size!=null)
        {
            c++;
            size=size.link;
        }
        return c;
    }
    void find2ndmax(Node start)
    {
        int first, second;
        int s=listsize(start);
        if(s<2)
        System.out.println("There should be atleast two element");
        else
        {
            first=second=Integer.MIN_VALUE;
            Node temp=start;
            while(temp!=null)
            {
                if(temp.info>first)
                {
                    second=first;
                    first=temp.info;
                }
                else if(temp.info>second && temp.info!= first)
                    second=temp.info;
                    temp=temp.link;
            }
            if(second== Integer.MIN_VALUE)
            System.out.println("There is no second largest element");
            else
            System.out.println("The second largest element is "+second);
        }
    }
	
	void search(int key) {
		{
	        Node temp=start;
	        int flag=0;
	        while(temp!= null)
	        {
	            if(temp.info==key)
	            {
	             flag=1;
	               System.out.println("["+temp.info+"]-->["+temp+"]");
	            }
	           temp=temp.link;
	        }
	        if(flag==0)
	        System.out.println("Not present "+key);
	    }
	}
	
	void removeDuplicate() {
		Node curr = start, temp1 = null, temp2 = null;      
        if(start == null) {  
            return;  
        }  
        else {  
            while(curr != null){  
                temp2 = curr;    
                temp1 = curr.link;  
                  
                while(temp1 != null) {  
                    if(curr.info == temp1.info) {  
                        temp2.link = temp1.link;  
                    }  
                    else 
                        temp2 = temp1;  
                    temp1 = temp1.link;  
                }  
                curr = curr.link;  
            }          
        }  
		System.out.println("Displaying after removing duplicate info: ");
		display();
	}
	
	int countUnique() {
		 Node temp=start,temp1=null;
	        int count=0,c=0;
	        while(temp!=null)
	        {
	            temp1=start;
	            while(temp1!=null)
	            {
	                if(temp!=temp1 && temp.info==temp1.info)
	                count++;
	                temp1=temp1.link;
	            }
	            if(count==0)
	            c++;
	            count=0;
	            temp=temp.link;
	        }
	        return c;
	    }
	
	public static void main(String[] args) {
		Singly_Linked_List s1=new Singly_Linked_List();
		while(true) 
		{ 
		System.out.println("****MENU****"); 
		System.out.println("0:Exit"); 
		System.out.println("1:creation"); 
		System.out.println("2:Display"); 
		System.out.println("3:print the second largest element"); 
		System.out.println("4:Enter element u want to search");  
		System.out.println("5:Remove duplicate element"); 
		System.out.println("6:Count the no of unique elements"); 
		int choice=scn.nextInt();
		switch(choice) 
		{ 
		case 0->System.exit(0); 
		case 1->s1.create();
		case 2->s1.display(); 
		case 3->s1.find2ndmax(start);
		case 4->s1.search(scn.nextInt());  
		case 5->s1.removeDuplicate(); 
		case 6->System.out.println("The no of unique elements are = "+s1.countUnique()); 
		default->System.out.println("Wrong choice"); 		 
		}
		}
	}
}
