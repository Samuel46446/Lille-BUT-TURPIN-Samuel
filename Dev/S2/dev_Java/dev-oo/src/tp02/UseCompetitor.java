package tp02;

public class UseCompetitor {
	public static void main(String[] args)
	{
		/*Competitor alice = new Competitor(1, 45, 15, 20);
		Competitor bruno = new Competitor(1, 45, 15, 20);
		Competitor clement = new Competitor(2, 32, 12, 45);
		Competitor dora = new Competitor(2, 34, 12, 45);
		System.out.println("Alice:" + alice.display() + " Bruno:" + bruno.display() + "->" + alice.equals(bruno));
		System.out.println("Alice:" + alice + " null:" + null + "->" + alice.equals(null));
		System.out.println("Alice:" + alice + " Alice:" + alice + "->" + alice.equals(alice));
		System.out.println("Alice:" + alice + " Clement:" + clement + "->" + alice.equals(clement));
		System.out.println("Clement:" + clement + " Dora:" + dora + "->" + clement.equals(dora));
		System.out.println(alice.isFaster(dora));*/

		Competitor[] compet = new Competitor[100];
		compet[0] = new Competitor(1,45,15,20);
		compet[1] = new Competitor(2,32,12,45);
		compet[4] = new Competitor(5,12,13,59);
		compet[11] = new Competitor(12,12,15,70);
		compet[31] = new Competitor(32,75,15,20);

		for (int index = 0; index < compet.length; index++)
		{
			if(!(compet[index] == null))
			{ 
				System.out.println(compet[index].display());
			}
		}
	}
}
