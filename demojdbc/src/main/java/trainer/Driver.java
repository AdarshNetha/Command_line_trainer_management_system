package trainer;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		TrainerDao trdao=new TrainerDao();
		Scanner sc=new Scanner(System.in);
		boolean flag=true;
		while(flag)
		{
			System.out.println("enter your choise");
			System.out.println("1.insert \n 2.update \n 3.delete \n 4.find \n 5.All data \n 6.exit");
			int key=sc.nextInt();
			switch (key) {
			case 1:{
				System.out.println("enter the id");
				int id=sc.nextInt();
				System.out.println("enter the name");
				String name=sc.next();
				System.out.println("enter the subject");
				String sub=sc.next();
				Trainer t=new Trainer(id, name, sub);
				TrainerDao.saveTrainer(t);
			}
				break;

			case 2:{
				System.out.println("enter id to update name");
				int id=sc.nextInt();
				System.out.println("enter the new name to be updated");
				String name=sc.next();
				TrainerDao.updateName(id, name);
				
			}
				break;
			case 3:{
				System.out.println("enter the id to delet");
				int id=sc.nextInt();
				TrainerDao.delete(id);
			}
				break;
			case 4:{
				boolean find=true;				
				while(find)
				{
					System.out.println("choose to find by 1.name \n 2. id \n 3.main menu");
					int choose=sc.nextInt();
					switch(choose)
					{
						case 1:
						{
							System.out.println("enter the name to find the trainee");
							String name=sc.next();
							TrainerDao.findTrainerByNmae(name);
						}
						break;
						case 2:
						{
							System.out.println("enter id to find the traine");
							int id=sc.nextInt();
							Trainer t= TrainerDao.findTrainerById(id);
							if(t!=null)
							 System.out.println(t);
							else
								System.out.println("no one with that id");
						}
						break;
						case 3:
						{
							find=false;
						}
						break;
					}
				}
			}
				break;
				
			case 5:{
				TrainerDao.allData();
			}
			break;
				
			case 6:{
				flag=false;
				System.out.println("thank you");
			}
				break;
			default:
			{
				System.out.println("enter the valid inpot");
			}
				break;
			}
		}
	}

}
