import java.util.Scanner;
public class Rearrange
{
    int a[][];
    int b[];
    int n;
    void input()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter order of elements(between 3 and 10)");
        n=sc.nextInt();
        int r,c;
        if(n>3 && n<10)
        {
            a=new int[n][n];
            for(r=0;r<a.length;r++)
            {
                for(c=0;c<a[r].length;c++)
                {
                    a[r][c]=sc.nextInt();
                }
            }
        }
        else
            System.out.println("Enter order between 3 and 10");
    }

    void display()
    {
        int r,c;
        System.out.println("Original matrix:");
        for(r=0;r<a.length;r++)
        {
            for(c=0;c<a[r].length;c++)
            {
                System.out.print(a[r][c]+"\t");
            }
            System.out.println();
        }
    }

    void sort()
    {
        //2n+2(n-2)
        int r,c;
        int k=0;
        int m=0;
        m=2*n+2*(n-2);
        b=new int[m];
        for(r=0;r<a.length;r++)
        {
            for(c=0;c<a[r].length;c++)
            {
                if(r==0||c==0||r==a.length-1||c==a.length-1)
                {
                    b[k]=a[r][c];
                    k++;
                }
            }
        }
        int i,j,p,t;
        for(i=0;i<b.length;i++)
        {
            p=i;
            for(j=i+1;j<b.length;j++)
            {
                if(b[j]<b[p])
                    p=j;
            }
            t=b[p];
            b[p]=b[i];
            b[i]=t;
        }
    }

    void boundary()
    {
        int r,c;
        int i=0,k=0;
        for(r=0,c=0;c<a.length;c++)
        {
            a[r][c]=b[k];
            k++;
        }
        for(r=1,c=a.length-1;r<a.length;r++)
        {
            a[r][c]=b[k];
            k++;
        }
        for(r=a.length-1,c=a.length-2;c>=0;c--)
        {
            a[r][c]=b[k];
            k++;
        }
        for(r=a.length-2,c=0;r>0;r--)
        {
            a[r][c]=b[k];
            k++;
        }
        System.out.println("Sorted boundary elements:");
        for(r=0;r<a.length;r++)
        {
            for(c=0;c<a[r].length;c++)
            {
                System.out.print(a[r][c]+"\t");
            }
            System.out.println();
        }
    }

    void non_boundary()
    {
        int r,c,p=1;
        for(r=0;r<a.length;r++)
        {
            for(c=0;c<a[r].length;c++)
            {
                if(r!=0 && c!=0 && r!=a.length-1 && c!=a.length-1)
                    p*=a[r][c];
            }
        }
        System.out.println("Product of non-boundary elements="+p);
    }

    public static void main(String[] args)
    {
        Rearrange obj=new Rearrange();
        obj.input();
        obj.display();
        obj.sort();
        obj.boundary();
        obj.non_boundary();
    }
}