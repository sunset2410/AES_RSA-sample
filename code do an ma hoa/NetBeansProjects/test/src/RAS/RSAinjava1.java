/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RAS;
    //thuat toan ma hoa RSA ket hop voi ma hoa co dien he dich vong
import test.*;
import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
class nhapdulieu
/**
 *
 * @author admin
 */


{ 
public static String nhapxau()
{
DataInputStream str = new DataInputStream(System.in);
String st="";
try { st = str.readLine(); }
catch(IOException e){System.out.print("loi "+e);}
return st;
}
public static int nhapnguyen()
{ 
DataInputStream str = new DataInputStream(System.in);
String st="";int n=0;
try{st = str.readLine();
n = Integer.valueOf(st).intValue();}
catch(IOException e){System.out.print("loi"+e);}
return n;
}
}

class  RSAinjava1
{

String z;
int p,q,e,n,o;
RSAinjava1(){}
RSAinjava1(int p,int q)
{
this.p=p;
this.q=q;
}
public int ktngto(int x)
{
int k;
k=0;
if(x==1)
k=k+1;
else	
for(int i=1;i<x;i++)
if((x%i==0))
k=k+1;
return k;	
}
public int UCLN(int a,int b)
{
if(a<0)
a=-a;
while(a!=b)
if(a>b)
a=a-b;
else b=b-a;
return a; 
}
public void nhap()
{
System.out.print("moi ban nhap so nguyen to p :");
do
{	
p=nhapdulieu.nhapnguyen();
if(ktngto(p)!=1)
{
System.out.println("so ban nhap ko phai la so ngto");
System.out.print("moi ban nhap so nguyen to p :");
}
}
while (ktngto(p)!=1) ; 
System.out.print("moi ban nhap so nguyen to q :");
do
{
q=nhapdulieu.nhapnguyen();
if((ktngto(q)!=1) || (q==p))
{
System.out.println("nhap sai:");
System.out.print("moi ban nhap so nguyen to q :");
}	
}
while((ktngto(q)!=1) || (q==p));
n=p*q;
o=(p-1)*(q-1);
System.out.print("moi ban nhap so e bat ky thoa man :");
do
{
e=nhapdulieu.nhapnguyen();
if((e<0)|| (e>o)||(UCLN(e,o)!=1))
{
System.out.println("nhap sai:");
System.out.print("moi ban nhap so e :");	
}	
}
while((e<0)|| (e>o)||(UCLN(e,o)!=1));
}
public int mod(int a,int b)
{
int [] x,y,u,v;
int i,d;
d=0;
x = new int[100];
y = new int[100];
u = new int[100];
v = new int[100];
x[0]=a;
x[1]=b;
u[0]=1;
u[1]=0;
v[0]=0;
v[1]=1;
i=1;
while(x[i]!=0)
{
y[i]=x[i-1]/x[i];
i++;
x[i]=x[i-2]%x[i-1];
u[i]=u[i-2]-(u[i-1]*y[i-1]);
v[i]=v[i-2]-(v[i-1]*y[i-1]);	
}
if(x[i-1]==1)
{ if (v[i-1]>0)
d=v[i-1];
else d=(o+v[i-1]);
} 
return d; 
}
public int model(int a ,int x)
{
int l,j;
j=1;
while(x!=0)
{
if(x%2==1)
j=(j*a) % n;
x=x/2;
a=(a*a)%n;
}	
return j;	
}
public void rsa1(int l)
{

char [] b,str;
int [] c;
String x;
//qua trinh ma hoa	
System.out.println();
System.out.println(" moi ban nhap noi dung can gui(ban ro) :");
x=nhapdulieu.nhapxau();	
b =x.toCharArray();
c=new int[b.length];
for(int i=0;i<b.length;i++)
c[i]=(int)b[i]; 
/* System.out.println("dang so ban ro :");
for(int i=0;i<c.length;i++)
System.out.print(c[i]+" ");*/
int k;
for(int i=0;i<c.length;i++)
{
k=c[i]+l-32;
c[i]=(k%96)+32;
}
/* System.out.println();
System.out.println("dang so 2 ban ma :");
for(int i=0;i<c.length;i++)
System.out.print(c[i]+" ");*/
str=new char[c.length];	
for(int i=0;i<c.length;i++)
str[i]=(char)c[i]; 
z=String.valueOf(str); 
}
public void gaima(int a)
{	
char [] b,str;
int [] c;
String h;
//qua trinh gia ma	
b =z.toCharArray();
c=new int[b.length];
for(int i=0;i<b.length;i++)
c[i]=(int)b[i]; 
/* System.out.println(); 
System.out.println("dang so ban ma :");
for(int i=0;i<c.length;i++)
System.out.print(c[i]+" ");*/
int k;
for(int i=0;i<c.length;i++)
{
k=c[i]-a-32;
if(k<0)
k=96+k;
c[i]=(k%96)+32;
} 

/* System.out.println();
System.out.println("dang so 2 ban ro:");
for(int i=0;i<c.length;i++)
System.out.print(c[i]+" ");*/
str=new char[c.length];	
for(int i=0;i<c.length;i++)
str[i]=(char)c[i]; 
h=String.valueOf(str); 
System.out.println();
System.out.print(" ban ro sau khi gia ma :"+h); 
}	
} 
class thuattoan
{
public static void main(String args[])
{
int a;
RSAinjava1 tt = new RSAinjava1();
System.out.println("****************************** *****************************************");
System.out.println(" moi ban nhap du lieu can thiet gui");
tt.nhap();
System.out.println("-----------------------------------------------------------------------");
System.out.println();
System.out.println("=>nguoi A chuan bi gui du lieu cho nguoi B ");
System.out.println();
tt.mod(tt.o,tt.e);
System.out.print("=>A nhan khoa cong khai cua B (n,e) la :"+"("+tt.n+","+tt.e+")"); 
System.out.println();
System.out.print("=>A nhap khoa k : ");
a=nhapdulieu.nhapnguyen();
tt.rsa1(a);
System.out.println("=>A gui 2 ban ma sang cho B ");
System.out.println();
System.out.print(" ban ma khoa:"+tt.model(a,tt.e)); 
System.out.println();
System.out.print(" ban ma du lieu :"+tt.z); 
System.out.println();	
System.out.print("--------------------------------------------------------------------------");	
System.out.println();
System.out.print("=>B nhan cac ban ma cua A tien hanh gia ma ");
System.out.println();	
System.out.print(" khoa bi mat cua B la:"+tt.mod(tt.o,tt.e)); 
System.out.println();
System.out.print(" ban ro khoa :"+tt.model(tt.model(a,tt.e),tt.mod(tt.o,tt.e)) ); 
tt.gaima(tt.model(tt.model(a,tt.e),tt.mod(tt.o,tt. e)));	
}
}

