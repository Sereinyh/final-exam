package ��ĩ;

public class ��Ʊ {
	public static void main(String[]args) {
		Runnable r=new TicketThread();
		Thread t1=new Thread(r,"������");
		Thread t2=new Thread(r,"������");
		t1.start();
		t2.start();
	}
 
}   
      class TicketThread implements Runnable{
    	  int fiveCount=2;
    	  int twentyCount=0;
    	  @Override
    	  public void run() {
    		  if(Thread.currentThread().getName().indexOf("������")>=0) {
    			  SaleTickle(20);
    		  }else if(Thread.currentThread().getName().indexOf("������")>=0) {
    			  SaleTickle(5);
    		  }
    	  }
    	  synchronized void SaleTickle(int money) {
    		  if(money==5) {
    			  System.out.println(Thread.currentThread().getName()+",����Ʊ");
    			  fiveCount++;
    		  }else if(money==20){
    			  while(fiveCount<3) {
    				  System.out.println(Thread.currentThread().getName()+",������Ǯ���������Ե�");
    				  try {
    					  wait();
    				  }catch (InterruptedException e) {
    				  }
    			  }
    			  System.out.println(Thread.currentThread().getName()+"����15Ԫ������Ʊ");
    			  fiveCount-=3;
    			  twentyCount++;
    	  }
    		  notifyAll();//֪ͨ�ȴ�
      }
}