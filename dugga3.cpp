#include <cmath>
#include <iostream>
using namespace std;

struct point
{
    double x=0;
    double y=0;
};

struct line
{
    double m=0;
    double b=0;
};















void get_line (line &i);
void get_point (int &n);
void read_points (point cord, point A[], int n);
void classify_point(point A, line k);
void display_point (point A[],int n, line k);

int main ()
{
    line k;
    point P;
    int const SIZE=100;
    point A[SIZE];

    int n=0;
//Enter line
    get_line (k);
//Amount of points
    get_point (n);

    read_points (P,A,n);

    display_point(A, n, k);

}
void classify_point(point A, line k)
{
    if ((k.m*A.x)+k.b == A.y)
    {
        cout<<" on the line!"<<endl;
    }
    else if (k.m*A.x+k.b < A.y)
    {
        cout<<" above the line!"<<endl;
    }
    else
    {
        cout<<" below the line!"<<endl;
    }

}

void display_point(point A[], int n, line k)
{
    point temp;
    double alt=0;
    int flag=1;

    for (int i =0 ; (i <= n) && flag; i++)
    {
        flag=0;
        for (int j=0; j < (n-1); j++)
        {
            alt=sqrt(pow(A[j].x,2)+pow(A[j].y,2));
            if (sqrt(pow(A[j+1].x,2)+pow(A[j+1].y,2))< alt)
            {
                temp=A[j];
                A[j]=A[j+1];
                A[j+1]=temp;
                flag = 1;

            }
        }
    }
    for (int b=0; b < n ; b++)
    {

        cout << "("<< A[b].x <<" , "<<A[b].y<<")";
        classify_point(A[b],k);
    }
}

void read_points (point cord, point A[], int n)
{
    for (int i=0; i < n; i++)
    {

        cout<<"Enter x-cord:";
        cin>>cord.x;
        cout<<"Enter y-cord:";
        cin>>cord.y;
        cout<<endl;
        A[i]=cord;

    }
}
void get_point (int &n)
{
    int const MAX=100;

    do
    {
        cout << "Enter number of points:";
        cin>>n;
        if (n > MAX || n <= 0 )
        {
            cout << "Invalid try again!"<<endl;


        }
    }
    while ( n >MAX || n <= 0 );
}

void get_line (line &i)
{
    cout << "Enter m:";
    cin >> i.m;
    cout << "Enter b:";
    cin >> i.b;
}



