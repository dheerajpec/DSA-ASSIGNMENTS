import java.io.*;
class Node
{
    String Name="";
    int Age=0;
    Node next=null;
    Node prev=null;
    Node(String name,int age1)
    {
        Name=name;
        Age=age1;
    }
}
class Dll
{
    Node head;
    Node tail;
    public void insert(String name, int age){
        Node node= new Node(name,age);
        if (head==null){
            head=node;
            tail=node;
        }
        else
        {
            node.prev=tail;
            tail.next=node;
            tail=node;
        }
    }
}
public class family
{
    public static void main(String args[]) throws IOException
    {
        InputStreamReader obj= new InputStreamReader(System.in);
        BufferedReader inp= new BufferedReader(obj);
        System.out.println("Enter the no. of members: ");
        int n= Integer.parseInt(inp.readLine());
        String name[]= new String[n];
        int age[]= new int[n];
        for(int i=0;i<n;i++)
        {
          System.out.println("Enter the family members name: ");
          name[i]=inp.readLine();
          System.out.println("Enter the family members age: ");
          age[i]=Integer.parseInt(inp.readLine());;
          
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(age[j]<age[j+1])
                {
                    int temp= age[j];
                    String nam=name[j];
                    age[j]=age[j+1];
                    name[j]=name[j+1];
                    age[j+1]=temp;
                    name[j+1]=nam;
                }
            }
        }
        Dll familyList= new Dll();
        for(int i=0;i<n;i++)
        {
            familyList.insert(name[i],age[i]);
        }
        Node temp= familyList.head;
        for(int i=0;i<n;i++)
        {
            System.out.print("|Name: "+temp.Name+" age: "+temp.Age+"|------><------ ");
            temp=temp.next;
        }
        System.out.print("Tail");
        temp=familyList.tail;
        for(int i=0;i<n;i++)//reverse traversal which is property of doubly linked list
        {
            System.out.print("|Name: "+temp.Name+" age: "+temp.Age+"|------><------ ");
            temp=temp.prev;
        }
        System.out.print("Head");
    }
}
        
    