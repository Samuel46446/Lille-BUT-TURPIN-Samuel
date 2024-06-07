package tp04;

import tpOO.tp04.PendingCase;

public class UsePendingCaseQueue {
    public static void main(String[] args) {
        PendingCase pc1 = new PendingCase("Alice", "AAA", 1234.56);
	    PendingCase pc2 = new PendingCase("Bruno", "BBB", 0.42);
	    PendingCase pc3 = new PendingCase("Chloé", "CCC", 745.99); 
	    PendingCase pc4 = new PendingCase("Denis", "DDD", 125.0); 
		PendingCaseQueue.CAPACITY = 3;
        PendingCaseQueue pcq = new PendingCaseQueue();
        System.out.println("Before anything: " + pcq);
        System.out.println("Empty? " + pcq.isEmpty() + "\tFull? " + pcq.isFull());
        pcq.addOne(pc1);
        pcq.addOne(pc2);
        System.out.println("After addition of pc1 and pc2: " + pcq);
        System.out.println("Empty? " + pcq.isEmpty() + "\tFull? " + pcq.isFull());
        pcq.addOne(pc3);
        System.out.println("After addition of pc3: " + pcq);
        System.out.println("Empty? " + pcq.isEmpty() + "\tFull? " + pcq.isFull());
		pcq.addOne(pc4);
        System.out.println("After addition of pc4: \t" + pcq);
        pcq.removeOne();
        System.out.println("After a removal: " + pcq);
        pcq.addOne(pc1);
        System.out.println("After addition of pc1: " + pcq);
        pcq.clear();
        System.out.println("After clearing: " + pcq);
        pcq.addOne(pc1);
		pcq.addOne(pc4);
        pcq.addOne(pc3);
        System.out.println("Ajout: " + pcq);
        pcq.removeOne();
        System.out.println("Delete: " + pcq);
        pcq.cheating(pc3, 0);
        System.out.println("Cheat: " + pcq);
        System.out.println("Total Amount: " + pcq.getTotalAmount());
    }
}
